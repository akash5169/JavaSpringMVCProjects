package com.lnt.bank.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lnt.bank.model.Account;
import com.lnt.bank.model.Branch;
import com.lnt.bank.model.Customer;
import com.lnt.bank.model.Login;
import com.lnt.bank.service.ICustomerService;
import com.lnt.bank.service.IIfscService;
import com.lnt.bank.service.ILoginService;
import com.lnt.bank.service.IRegistrationService;

@Controller("RegisterAndLoginController")
public class RegisterAndLoginController {
	private IRegistrationService registrationService;
	private IIfscService ifscService;
	private ICustomerService customerService;
	private ILoginService loginService;
	

	public ILoginService getLoginService() {
		return loginService;
	}

	@Autowired
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	

	public IRegistrationService getRegistrationService() {
		return registrationService;
	}

	@Autowired
	public void setRegistrationService(IRegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	public IIfscService getIfscService() {
		return ifscService;
	}

	@Autowired
	public void setIfscService(IIfscService ifscService) {
		this.ifscService = ifscService;
	}

	public ICustomerService getCustomerService() {
		return customerService;
	}

	@Autowired
	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "/")
	public String showIndex(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "index";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registerPage(Model model) {
		Customer customer = new Customer();

		model.addAttribute("customer", customer);
		System.out.println("registerPage Customer Id : " + customer.getAccountNo());

		model.addAttribute("branchNames", getBranchNames());
		return "registration";
	}

	@RequestMapping(value = "/doRegister", method = RequestMethod.GET)
	public String doRegister(/*@RequestParam (value="custImageFile") MultipartFile file,@RequestParam(value="custSignFile")MultipartFile file2,*/@Valid @ModelAttribute(value = "customer") Customer customer, BindingResult results,
			Model model,HttpSession session) {
		String viewName = "registration";
		Customer customer2 = new Customer();
		if (!results.hasErrors()) {
			String userID = customer.getLogin().getUserId();
            boolean flag = checkUserIdExist(userID);
			
			if (!flag) {
				model.addAttribute("promptContent", "userId Already exist please enter another!!");
				model.addAttribute("branchNames",getBranchNames());
				return viewName;
			} 
			
			String branchName = customer.getCustBranch();
			String accountType = customer.getAccount().getAccountType();
			if (accountType.equals("savings")) {
				customer.getAccount().setAccountBalance(2000.00);
			}

			List<Branch> branchList = ifscService.getIFSC();
            	
			for (Branch branch : branchList) {
				if (branch.getBankName().equals(branchName)) {
						customer.getAccount().setIFSC(branch.getIfsc());
						break;
				}
			}
			
				Login login = new Login();
				Account account = new Account();
				login.setPassword(customer.getLogin().getPassword());
				login.setUserId(customer.getLogin().getUserId());
				account.setAccountBalance(customer.getAccount().getAccountBalance());
				account.setAccountType(customer.getAccount().getAccountType());
				account.setIFSC(customer.getAccount().getIFSC());
				customer2 = registrationService.addCustomer(customer, login, account);
				model.addAttribute("customer", customer2);
				viewName = "success";
		} else {
			model.addAttribute("branchNames", getBranchNames());
			System.out.println("I was here");
			return viewName;
		}
		return viewName;
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String registrationSuccess(Model model, HttpSession session) {
		String accountNo = (String) session.getAttribute("accountNo");
		String userId = (String) session.getAttribute("userId");

		System.out.println("session account No" + accountNo);
		System.out.println("session userId No" + userId);
		return "success";
	}

	@RequestMapping(value = "/dologin")
	public String tryLogin(@Valid @ModelAttribute(value = "login") Login login, BindingResult results, Model model,
			HttpServletRequest request) {
		String viewName = "index";
		HttpSession session = request.getSession();
		System.out.println("session " + session);
		if (!results.hasErrors()) {
			String userId = login.getUserId();
			String pass = login.getPassword();
			Boolean flag = false;

			List<Login> loginList = loginService.loginDetails();
			for (Login login2 : loginList) {
				if (login2.getUserId().equals(userId) && login2.getPassword().equals(pass)) {
					flag = true;
					session.setAttribute("accountNo", login2.getAccountNo());
					session.setAttribute("userId", login2.getUserId());
					viewName = "redirect:/customerhome";
					break;
				}
			}

			if (!flag) {
				model.addAttribute("promptContent", "invalid userId or password");
				model.addAttribute("loginDetails", login);
			}
		} else {
			return viewName;
		}
		return viewName;
	}
	
	@RequestMapping(value="/ForgotPassword")
	public void sendPassword()
	{
		
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	public List<String> getBranchNames() {
		List<Branch> branchList = ifscService.getIFSC();
		List<String> branchNames = new ArrayList<String>();
		for (Branch branch : branchList) {
			branchNames.add(branch.getBankName());
		}
		return branchNames;
	}

	public boolean checkUserIdExist(String userId) {
		boolean flag = true;
		List<Customer> listCustomers = customerService.getCustomers();

		for (Customer customer1 : listCustomers) {
			if (customer1.getLogin().getUserId().equals(userId)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

}
