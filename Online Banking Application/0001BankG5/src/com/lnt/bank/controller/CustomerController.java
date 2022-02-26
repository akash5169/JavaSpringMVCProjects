package com.lnt.bank.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Blob;
import java.text.DateFormat;
import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lnt.bank.model.Account;
import com.lnt.bank.model.AccountTransaction;
import com.lnt.bank.model.Branch;
import com.lnt.bank.model.Customer;
import com.lnt.bank.model.Images;
import com.lnt.bank.model.Login;
import com.lnt.bank.model.Payee;
import com.lnt.bank.model.UserDate;
import com.lnt.bank.service.IAccountService;
import com.lnt.bank.service.IBlobService;
import com.lnt.bank.service.ICustomerService;
import com.lnt.bank.service.IIfscService;
import com.lnt.bank.service.IImageService;
import com.lnt.bank.service.ILoginService;
import com.lnt.bank.service.IPayeeService;

@Controller
public class CustomerController {
	private IPayeeService payeeService;
	private IIfscService ifscService;
	private ICustomerService customerService;
	private IAccountService accountService;
	private ILoginService loginService;
	private IBlobService blobService;
	public IBlobService getBlobService() {
		return blobService;
	}

	@Autowired
	public void setBlobService(IBlobService blobService) {
		this.blobService = blobService;
	}

	private IImageService imageService;

	

	public IImageService getImageService() {
		return imageService;
	}

	@Autowired
	public void setImageService(IImageService imageService) {
		this.imageService = imageService;
	}

	public IAccountService getAccountService() {
		return accountService;
	}

	@Autowired
	public void setAccountService(IAccountService accountService) {
		this.accountService = accountService;
	}

	public ILoginService getLoginService() {
		return loginService;
	}

	@Autowired
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public IAccountService getAccountSummaryService() {
		return accountService;
	}

	@Autowired
	public void setAccountSummaryService(IAccountService accountService) {
		this.accountService = accountService;
	}

	public ICustomerService getCustomerService() {
		return customerService;
	}

	@Autowired
	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}

	public IPayeeService getPayeeService() {
		return payeeService;
	}

	@Autowired
	public void setPayeeService(IPayeeService payeeService) {
		this.payeeService = payeeService;
	}

	public IIfscService getIfscService() {
		return ifscService;
	}

	@Autowired
	public void setIfscService(IIfscService ifscService) {
		this.ifscService = ifscService;
	}

	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public String accountStatementByDate(@RequestParam("proImage") MultipartFile file1,
			@RequestParam("signImage") MultipartFile file2, Model model, HttpServletRequest request)
			throws ParseException {
		HttpSession session = request.getSession();
		System.out.println("session is:" + session);
		String viewName = "redirect:/";
		if (session.getAttribute("accountNo") != null) {
			Long accountNo = (Long) session.getAttribute("accountNo");
			Images images = new Images();
			images.setAccountNo(accountNo);
			System.out.println("File:" + file1.getName());
			System.out.println("ContentType:" + file1.getContentType());

                System.out.println("i am here 1");
				String uploadsDir = "/WEB-INF/images/";
				System.out.println(request.getContextPath());
                String realPathtoUploads =  request.getServletContext().getRealPath(uploadsDir);
                /*try {
					URL resource = request.getServletContext().getResource("/WEB-INF/images");
					System.out.println(""+resource);
				} catch (MalformedURLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}*/
                /*
                String realPathtoUploads=request.getContextPath();
                realPathtoUploads=realPathtoUploads+"/WEB-INF/images/";
                */
                System.out.println("i am here 2");
                if(! new File(realPathtoUploads).exists())
                {
                    new File(realPathtoUploads).mkdir();
                }

                //log.info("realPathtoUploads = {}", realPathtoUploads);

                
                String orgName = file1.getOriginalFilename();
                
                String orgName1 = file2.getOriginalFilename();
                
                String arr[]=orgName.split(" ");
                String temp="";
                for (String string : arr) {
					temp=temp+string;
				}
                
                String arr1[]=orgName1.split(" ");
                String temp1="";
                for (String string : arr1) {
					temp1=temp1+string;
				}
                
                temp=accountNo+" "+"1"+temp;
                temp1=accountNo+" "+"2"+temp1;
                
                orgName=temp;
                orgName1=temp1;
                
                String filePath = realPathtoUploads + orgName;
                String filePath1 = realPathtoUploads + orgName1;
                
                System.out.println("i am here 2"+filePath);
                System.out.println("i am here 2"+filePath1);
          // String arr2[]=filePath.split(".metadata");
          // filePath=arr2[0];
                //File dest = new File(filePath);
                
                //File dest1 = new File(filePath1);
           
           File dest=new File("F:\\\\eclips projects\\\\0001BankG5\\\\WebContent\\\\WEB-INF\\\\images\\\\"+orgName);
                try {
					file1.transferTo(dest);
					//file2.transferTo(dest1);
					System.out.println("i did this");
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
				images.setProImageFiletype(file1.getContentType());
				images.setProImageName(accountNo+" "+"1"+file1.getOriginalFilename());

				images.setSignImageFiletype(file2.getContentType());
				images.setSignImageName(accountNo+" "+"2"+file2.getOriginalFilename());


			try {
                Images image2=imageService.addImage(images);
                viewName="customerhome";
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return viewName;
	}
	
	@RequestMapping(value="/imageUpload")
	public String imageUploadPage(Model Model ,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		System.out.println("session is:" + session);
		String viewName = "redirect:/";
		if (session.getAttribute("accountNo") != null) {
			Long accountNo = (Long) session.getAttribute("accountNo");
			Model.addAttribute("images",new Images());
			viewName="imageUpload";
			}
		return viewName;
	}
	

	@RequestMapping(value = "/accountStatementByDate", method = RequestMethod.GET)
	public String accountStatementByDate(@RequestParam("startDate") Date startDate,
			@RequestParam("endDate") Date endDate, Model model, HttpServletRequest request) throws ParseException {
		HttpSession session = request.getSession();
		System.out.println("session is:" + session);
		String viewName = "redirect:/";
		if (session.getAttribute("accountNo") != null) {
			Long accountNo = (Long) session.getAttribute("accountNo");
			viewName = "redirect:/accountStatement";
			String viewname = "accountStatement";
			DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
			Date dateobj = new Date();
			System.out.println(df.format(dateobj));
			System.out.println(df.format(startDate));
			System.out.println(df.format(endDate));

			System.out.println("start date is" + startDate);
			System.out.println("end date is" + endDate);
			System.out.println("system date is" + dateobj);
			System.out.println("condition is" + startDate.compareTo(endDate));

			if (endDate.compareTo(dateobj) > 0) {
				model.addAttribute("promptContent", "end should be lesser than or equal to todays date");
				model.addAttribute(new UserDate());
				return viewname;
			} else if (startDate.compareTo(endDate) > 0) {

				model.addAttribute("promptContent", "end should be greater than start date");
				model.addAttribute(new UserDate());
				return viewname;
			} else {
				List<String> transactionResult = accountService.trasactionDetails(accountNo, startDate, endDate);
				model.addAttribute("transactionList", transactionResult);

				System.out.println(startDate);
				System.out.println(endDate);
				viewname = "commonstatement";
				return viewname;
			}
		}
		return viewName;
	}

	@RequestMapping(value = "/showChangePasswordPage")
	public String showChangePasswordPage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("session is:" + session);
		String viewName = "redirect:/";
		Long accountNo = (Long) session.getAttribute("accountNo");
		if (accountNo != null) {
			viewName = "changepasswordform";
			System.out.println("I reached here");
			Login login = loginService.customerLogin(accountNo);
			System.out.println("Login is " + login);
			model.addAttribute("login", login);
		}
		return viewName;
	}

	@RequestMapping(value = "/tryChangePassword")
	public String changePassword(@Valid @ModelAttribute(value = "login") Login login, BindingResult results,
			Model model, HttpServletRequest request) {
		System.out.println(" login is:" + login);
		HttpSession session = request.getSession();
		System.out.println("session is:" + session);
		String viewName = "redirect:/";
		if (session.getAttribute("accountNo") != null) {

			if (!results.hasErrors()) {
				System.out.println("results " + results);
				loginService.updateLogin(login);
				System.out.println("updated login is:" + login);
				model.addAttribute("login", login);
				viewName = "changepasswordsuccess";
			}
		}
		return viewName;
	}

	@RequestMapping(value = "/accountStatementByMonth", method = RequestMethod.GET)
	public String accountStatementByMonth(@RequestParam("chosenMonth") String chosenMonth, HttpServletRequest request,
			Model model) throws ParseException {

		HttpSession session = request.getSession();
		System.out.println("session is:" + session);
		String viewName = "redirect:/";
		if (session.getAttribute("accountNo") != null) {
			Long accountNo = (Long) session.getAttribute("accountNo");
			int monthNumber = 0;
			String month = chosenMonth;
			monthNumber = getMonthNumber(month);
			String monthQuery = monthNumber + "-01-" + "2018";
			String monthQuery1 = (monthNumber + 1) + "-01-" + "2018";
			Date startDate = new SimpleDateFormat("MM-dd-yyyy").parse(monthQuery);
			Date endDate = new SimpleDateFormat("MM-dd-yyyy").parse(monthQuery1);

			List<String> transactionResult = accountService.trasactionDetails(accountNo, startDate, endDate);
			model.addAttribute("transactionList", transactionResult);
			return "commonstatement";
		}
		return viewName;

	}

	@RequestMapping(value = "/accountStatementByHalf", method = RequestMethod.GET)
	public String accountStatementByHalf(@RequestParam("intervalDate") Date intervalDate, HttpServletRequest request,
			Model model) {
		HttpSession session = request.getSession();
		System.out.println("session is:" + session);
		String viewName = "redirect:/";
		if (session.getAttribute("accountNo") != null) {
			Long accountNo = (Long) session.getAttribute("accountNo");
			Date beginDate = new Date();
			int day = intervalDate.getDate();
			int year = intervalDate.getYear();
			int monthsToSubtract = 6;
			int monthEndDate = intervalDate.getMonth();
			if (monthEndDate <= 6) {
				year--;
			}
			System.out.println(monthEndDate);
			int monthStartDate = monthEndDate - monthsToSubtract;
			beginDate.setMonth(monthStartDate);
			beginDate.setDate(day);
			beginDate.setYear(year);

			List<String> transactionResult = accountService.trasactionDetails(accountNo, beginDate, intervalDate);
			System.out.println(intervalDate);
			System.out.println(beginDate);
			model.addAttribute("transactionList", transactionResult);
			return "commonstatement";
		}
		return viewName;
	}

	@RequestMapping(value = "/viewAccountSummary")
	public String showAccountSummary(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("session is:" + session);
		String viewName = "redirect:/";
		if (session.getAttribute("accountNo") != null) {
			Long accountNo = (Long) session.getAttribute("accountNo");
			Account account = accountService.getAccountDetails(accountNo);
			model.addAttribute("account", account);
			System.out.println("Account Summary Account : " + account);

			List<AccountTransaction> transactionList = accountService.customerTransactionTable(accountNo);
			model.addAttribute("transactionList", transactionList);
			viewName = "accountSummary";
		}
		return viewName;
	}

	@RequestMapping(value = "/accountStatement", method = RequestMethod.GET)
	public String accountStatementPage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("session is:" + session);
		String viewName = "redirect:/";
		if (session.getAttribute("accountNo") != null) {
			Long accountNo = (Long) session.getAttribute("accountNo");
            System.out.println("account No is printed:"+accountNo);
			Account account = accountService.getAccountDetails(accountNo);
			model.addAttribute(account);
			List<AccountTransaction> transactionTable = accountService.customerTransactionTable(accountNo);
			model.addAttribute("transactionList", transactionTable);
			model.addAttribute("userDate", new UserDate());
			viewName = "accountStatement";
		}
		return viewName;
	}

	@RequestMapping(value = "/payee")
	public String payeePage(Model model) {
		String viewName = "payee";
		model.addAttribute("branchNames", getBranchNames());
		model.addAttribute("payee", new Payee());
		return viewName;
	}

	@RequestMapping(value = "/addPayee")
	public String addPayee(@Valid @ModelAttribute(value = "payee") Payee payee, BindingResult results, Model model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("session is:" + session);
		String viewName = "redirect:/";
		if (session.getAttribute("accountNo") != null) {
			viewName = "payee";
			if (!results.hasErrors()) {
				Long accountNo = (Long) session.getAttribute("accountNo");
				payee.setAccountNo(accountNo);
				List<Branch> branchList = ifscService.getIFSC();
				System.out.println(payee);

				String branch = payee.getIFSC();

				for (Branch branch1 : branchList) {
					if (branch1.getBankName().equals(branch)) {
						payee.setIFSC(branch1.getIfsc());
						break;

					}
				}

				Long payeeAccountNo = payee.getPayeeAccountNo();
				Payee payee1 = payeeService.getPayeeByAccountNo(accountNo, payeeAccountNo);

				if (payee1 != null || payee.getPayeeAccountNo() == accountNo) {
					model.addAttribute("branchNames", getBranchNames());
					model.addAttribute("promptContent", "Payee Already exist !!");
					model.addAttribute("payee", payee);
					return viewName;
				}
				Long composite = Long.parseLong(payee.getAccountNo().toString() + payee.getPayeeAccountNo().toString());
				payee.setComposite(composite);
				Payee payeeResult = payeeService.addPayee(payee);
				System.out.println(payeeResult);
				model.addAttribute("payee2", payeeResult);
				viewName = "payeesuccess";
			} else {
				model.addAttribute("branchNames", getBranchNames());
				return viewName;
			}
		}
		return viewName;
	}

	@RequestMapping(value = "/customerhome", method = RequestMethod.GET)
	public String loginSuccess(Model model, HttpServletRequest request) {
		System.out.println("you are not here");
		HttpSession session = request.getSession();
		System.out.println("session is:" + session);
		String viewName = "redirect:/";
		if (session.getAttribute("accountNo") != null) {
			Long accountNo = (Long) session.getAttribute("accountNo");
			String userId = (String) session.getAttribute("userId");
			System.out.println("session account No" + accountNo);
			System.out.println("session userId No" + userId);
			model.addAttribute("accountNo", accountNo);
			model.addAttribute("userId", userId);
			
			try {
				URL resource = request.getServletContext().getResource("/WEB-INF/images");
				System.out.println(""+resource);
			} catch (MalformedURLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			return "customerhome";
		} else {
			return viewName;
		}
	}

	@RequestMapping(value = "/viewProfile")
	public String viewProfile(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("session is:" + session);
		String viewName = "redirect:/";

		if (session.getAttribute("accountNo") != null) {
			Long accountNo = (Long) request.getSession().getAttribute("accountNo");
			viewName = "profile";
			Customer customer = customerService.getCustomerByAccountNo(accountNo);
			Images image=imageService.getImage(accountNo);
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String dateofbirth = dateFormat.format(customer.getDob());
			model.addAttribute("dateOfBirth", dateofbirth);
			model.addAttribute("customer", customer);
			String s=image.getProImageName();
			String s1=s.replaceAll("\\\\","/");
			System.out.println("new path is "+s1);
			System.out.println("this is the: "+request.getContextPath());
			System.out.println(image.getProImageName());
			model.addAttribute("image1",image.getProImageName());
			return viewName;
		} else {
			return viewName;
		}
	}

	@RequestMapping(value = "/trySaveAfterEdit")
	public String saveAfterEdit(@Valid @ModelAttribute("customer") Customer customer, BindingResult results,
			Model model, HttpServletRequest request) {
		String viewName = "redirect:/";
		HttpSession session = request.getSession();
		System.out.println("session is:" + session);
		Long accountNo = (Long) session.getAttribute("accountNo");
		if (session.getAttribute("accountNo") != null) {
			viewName = "editpage";
			if (!results.hasErrors()) {
				customerService.updateCustomer(customer);
				model.addAttribute("promptContent", "Updated Customer");
				Customer customer1 = customerService.getCustomerByAccountNo(accountNo);
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				String dateofbirth = dateFormat.format(customer.getDob());
				model.addAttribute("dateOfBirth", dateofbirth);
				model.addAttribute("customer", customer1);
	
				Images image=imageService.getImage(accountNo);
				System.out.println(image.getProImageName());
				model.addAttribute("image1",image.getProImageName());
				viewName = "profile";
			}
		}
		return viewName;
	}

	@RequestMapping(value = "/editProfilePage")
	public String editProfile(Model model, HttpServletRequest request) {
		String viewName = "redirect:/";
		HttpSession session = request.getSession();
		System.out.println("session is:" + session);
		if (session.getAttribute("accountNo") != null) {
			viewName = "editpage";
			System.out.println("I am here");
			Long accountNo = (Long) session.getAttribute("accountNo");
			Customer customer = customerService.getCustomerByAccountNo(accountNo);
			model.addAttribute("customer", customer);
		}
		return viewName;
	}

	@RequestMapping(value = "/doLogout")
	public String doLogout(Model model, HttpServletRequest request) {
		String viewName = "redirect:/";
		request.getSession().invalidate();
		return viewName;
	}

	public List<String> getBranchNames() {
		List<Branch> branchList = ifscService.getIFSC();
		List<String> branchNames = new ArrayList<String>();
		for (Branch branch : branchList) {
			branchNames.add(branch.getBankName());
		}
		return branchNames;
	}

	public int getMonthNumber(String month) {
		int monthNumber = 0;
		switch (month) {
		case "Jan":
			monthNumber = 1;
			break;
		case "Feb":
			monthNumber = 2;
			break;
		case "Mar":
			monthNumber = 3;
			break;
		case "Apr":
			monthNumber = 4;
			break;
		case "May":
			monthNumber = 5;
			break;
		case "Jun":
			monthNumber = 6;
			break;
		case "Jul":
			monthNumber = 7;
			break;
		case "Aug":
			monthNumber = 8;
			break;
		case "Sept":
			monthNumber = 9;
			break;
		case "Oct":
			monthNumber = 10;
			break;
		case "Nov":
			monthNumber = 11;
			break;
		case "Dec":
			monthNumber = 12;
			break;
		}
		return monthNumber;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

}
