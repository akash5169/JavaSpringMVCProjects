package com.lnt.bank.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lnt.bank.model.Account;
import com.lnt.bank.model.AccountTransaction;
import com.lnt.bank.model.Payee;
import com.lnt.bank.service.IAccountService;
import com.lnt.bank.service.IFundTransferService;
import com.lnt.bank.service.IIfscService;
import com.lnt.bank.service.IPayeeService;

@Controller
public class FundTransferController {

	private IFundTransferService fundTransferService;
	private IPayeeService payeeService;
	private IIfscService ifscService;
	private IAccountService accountService;

	public IPayeeService getPayeeService() {
		return payeeService;
	}

	@Autowired
	public void setPayeeService(IPayeeService payeeService) {
		this.payeeService = payeeService;
	}

	public IFundTransferService getFundTransferService() {
		return fundTransferService;
	}

	@Autowired
	public void setFundTransferService(IFundTransferService fundTransferService) {
		this.fundTransferService = fundTransferService;
	}

	public IIfscService getIfscService() {
		return ifscService;
	}

	@Autowired
	public void setIfscService(IIfscService ifscService) {
		this.ifscService = ifscService;
	}

	public IAccountService getAccountService() {
		return accountService;
	}

	@Autowired
	public void setAccountService(IAccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping(value = "/tryFundTransfer", method = RequestMethod.GET)
	public String finalPageIntra(@Valid @ModelAttribute(value = "transaction") AccountTransaction accountTransaction,
			HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		System.out.println("session is:" + session);
		String viewName = performTransaction(accountTransaction, request, model, session);
		return viewName;
	}

	@RequestMapping(value = "/showIntraBankFundTransferPage")
	public String showFundTransferPage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("session is:" + session);
		String viewName = "redirect:/";
		if (session.getAttribute("accountNo") != null) {
			viewName = "intrabank";
			Long accountNo = (Long) session.getAttribute("accountNo");
			AccountTransaction accountTransaction = new AccountTransaction();
			List<Payee> payeeList = payeeService.getPayee(accountNo);
			ArrayList<String> payeeNames = getPayeeNames(payeeList);

			model.addAttribute("payeeNames", payeeNames);
			model.addAttribute("transaction", accountTransaction);

		}
		return viewName;
	}

	/*@RequestMapping(value = "/commonFundTransferPage")
	public String commonFundTransferPage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("session is:" + session);
		String viewName = "redirect:/";
		if (session.getAttribute("accountNo") != null) {
			viewName = "fundtransferhome";
		}
		return viewName;
	}*/

	public ArrayList<String> getPayeeNames(List<Payee> payeeList) {
		System.out.println("payeeList");
		ArrayList<String> payeeNames = new ArrayList<String>();
		for (Payee payee : payeeList) {
			payeeNames.add(payee.getPayeeName() + " " + payee.getPayeeAccountNo());
		}

		for (String string : payeeNames) {
			System.out.println(" " + string);
		}

		return payeeNames;
	}

	private String performTransaction(AccountTransaction accountTransaction, HttpServletRequest request, Model model,
			HttpSession session) {
		String viewName = "redirect:/";
		if (session.getAttribute("accountNo") != null) {
			viewName = "intrabank";
			Long accountNo = (Long) session.getAttribute("accountNo");
			Account senderaccount = accountService.getAccountDetails(accountNo);
			if (senderaccount.getAccountType().equals("savings")) {
				if (senderaccount.getAccountBalance() < 2000) {
					AccountTransaction t = new AccountTransaction();
					model.addAttribute("transaction", t);
					model.addAttribute("promptContent", "insufficientFunds");
					return viewName;
				} else {
					String name = accountTransaction.getReceiverName();
					String arr[] = name.split(" ");
					Long tempReceiverAccountNo = Long.parseLong(arr[1]);
					String tempReceiverName = arr[0];

					accountTransaction.setReceiverAccountNo(tempReceiverAccountNo);
					accountTransaction.setReceiverName(tempReceiverName);
					Double sendersBalance = senderaccount.getAccountBalance();
					Account receiverAccount = accountService
							.getAccountDetails(accountTransaction.getReceiverAccountNo());
					Double transactionAmount = accountTransaction.getTransactionAmount();
					Double temp = sendersBalance - transactionAmount;

					if (temp >= 2000) {
						accountTransaction.setAvailableBalance(temp);
						accountTransaction.setTransactionDateTime(new Date());
						accountTransaction.getAccount().setAccountNo(accountNo);
                        System.out.println("account transactions are:"+accountTransaction);
                        System.out.println("payee account no:"+accountTransaction.getReceiverAccountNo());
						AccountTransaction transaction2 = fundTransferService.doTransaction(transactionAmount,
								senderaccount, receiverAccount, accountTransaction);
						/*fundTransferService.doTransaction2(transaction2);*/
						transaction2.setAvailableBalance(senderaccount.getAccountBalance());
						model.addAttribute("transaction", transaction2);
						viewName = "transactionSuccess";
					} else {
						AccountTransaction t = new AccountTransaction();
						model.addAttribute("transaction", t);
						List<Payee> payeeList = payeeService.getPayee(accountNo);
						ArrayList<String> payeeNames = getPayeeNames(payeeList);
						model.addAttribute("payeeNames", payeeNames);
						model.addAttribute("promptContent",
								"Minimum Balance after transaction must be 2000...please enter amount accordingly");
						return viewName;
					}
				}
			} else {

				String name = accountTransaction.getReceiverName();
				String arr[] = name.split(" ");
				Long tempReceiverAccountNo = Long.parseLong(arr[1]);
				String tempReceiverName = arr[0];

				accountTransaction.setReceiverAccountNo(tempReceiverAccountNo);
				accountTransaction.setReceiverName(tempReceiverName);
				Double sendersBalance = senderaccount.getAccountBalance();
				Account receiverAccount = accountService.getAccountDetails(accountTransaction.getReceiverAccountNo());
				Double transactionAmount = accountTransaction.getTransactionAmount();
				Double temp = sendersBalance - transactionAmount;

				if (temp >=0) {
					accountTransaction.setAvailableBalance(temp);
					accountTransaction.setTransactionDateTime(new Date());
					accountTransaction.getAccount().setAccountNo(accountNo);
                   System.out.println("account transactions are:"+accountTransaction);
                   System.out.println("payee account no:"+accountTransaction.getReceiverAccountNo());
					AccountTransaction transaction2 = fundTransferService.doTransaction(transactionAmount,senderaccount, receiverAccount, accountTransaction);
					/*fundTransferService.doTransaction2(transaction2);*/
					transaction2.setAvailableBalance(senderaccount.getAccountBalance());
					model.addAttribute("transaction", transaction2);
					viewName = "transactionSuccess";
				} else {
					
                    AccountTransaction t = new AccountTransaction();
					model.addAttribute("transaction", t);
					List<Payee> payeeList = payeeService.getPayee(accountNo);
					ArrayList<String> payeeNames = getPayeeNames(payeeList);
					model.addAttribute("payeeNames", payeeNames);
					model.addAttribute("promptContent",
							"Minimum Balance after transaction must be 0...please enter amount accordingly");
				}
			}
		}
		return viewName;
	}

}
