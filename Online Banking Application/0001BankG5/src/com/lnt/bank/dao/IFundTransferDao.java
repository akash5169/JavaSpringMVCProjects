package com.lnt.bank.dao;

import com.lnt.bank.model.Account;
import com.lnt.bank.model.AccountTransaction;

public interface IFundTransferDao {

	public AccountTransaction doTransaction(Double transactionAmount,Account sendersAccount,Account receiversAccount,AccountTransaction accountTransaction);
	
	
}
