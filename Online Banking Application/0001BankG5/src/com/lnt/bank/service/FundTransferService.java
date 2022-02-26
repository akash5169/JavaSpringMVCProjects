package com.lnt.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnt.bank.dao.IFundTransferDao;
import com.lnt.bank.model.Account;
import com.lnt.bank.model.AccountTransaction;

@Service
public class FundTransferService implements IFundTransferService{
	
	IFundTransferDao fundTransferDao;

	public IFundTransferDao getFundTransferDao() {
		return fundTransferDao;
	}

	@Autowired
	public void setFundTransferDao(IFundTransferDao fundTransferDao) {
		this.fundTransferDao = fundTransferDao;
	}

	@Override
	@Transactional
	public AccountTransaction doTransaction(Double transactionAmount, Account sendersAccount, Account receiversAccount,
			AccountTransaction accountTransaction) {
		// TODO Auto-generated method stub
		
		return fundTransferDao.doTransaction(transactionAmount, sendersAccount, receiversAccount, accountTransaction);
		
	}


}
