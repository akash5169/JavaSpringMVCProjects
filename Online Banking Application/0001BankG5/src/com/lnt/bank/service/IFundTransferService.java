package com.lnt.bank.service;


import com.lnt.bank.model.Account;
import com.lnt.bank.model.AccountTransaction;

public interface IFundTransferService {

	public AccountTransaction doTransaction(Double transactionAmount,Account sendersAccount,Account receiversAccount,AccountTransaction accountTransaction);
	
}
