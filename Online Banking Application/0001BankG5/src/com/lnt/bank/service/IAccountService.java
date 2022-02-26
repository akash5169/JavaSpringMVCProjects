package com.lnt.bank.service;

import java.util.Date;
import java.util.List;

import com.lnt.bank.model.Account;
import com.lnt.bank.model.AccountTransaction;

public interface IAccountService {

	public Account getAccountDetails(Long accountNo);

	public List<AccountTransaction> allTransactionTable();
	
	public void updateAccount(Account account);
	
	public List<String> trasactionDetails(Long accountNo,Date startDate, Date endDate);
	
	public List<AccountTransaction> customerTransactionTable(Long accountNo);
     
}
