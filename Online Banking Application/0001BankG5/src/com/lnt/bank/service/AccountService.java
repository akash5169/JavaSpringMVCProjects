package com.lnt.bank.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnt.bank.dao.IAccountDao;
import com.lnt.bank.model.Account;
import com.lnt.bank.model.AccountTransaction;

@Service
public class AccountService implements IAccountService {
	
	private IAccountDao accountDao;
	
	public IAccountDao getAccountSummaryDao() {
		return accountDao;
	}
	
	@Autowired
	public void setAccountSummaryDao(IAccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	@Override
	@Transactional
	public List<AccountTransaction> allTransactionTable() {
		// TODO Auto-generated method stub
		return this.accountDao.allTransactionTable();
	}
	@Override
	@Transactional
	public Account getAccountDetails(Long accountNo) {
		return this.accountDao.getAccountDetails(accountNo);
	}

	@Override
	@Transactional
	public List<String> trasactionDetails(Long accountNo,Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return this.accountDao.trasactionDetails(accountNo,startDate, endDate);
	}

	@Override
	@Transactional
	public List<AccountTransaction> customerTransactionTable(Long accountNo) {
		// TODO Auto-generated method stub
		return this.accountDao.customerTransactionTable(accountNo);
	}

	@Override
	@Transactional
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		 this.accountDao.updateAccount(account);
	}

}
