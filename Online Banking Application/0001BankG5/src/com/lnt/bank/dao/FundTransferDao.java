package com.lnt.bank.dao;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lnt.bank.model.Account;
import com.lnt.bank.model.AccountTransaction;

@Repository
public class FundTransferDao implements IFundTransferDao {

	private SessionFactory sessionFactory;

	@Autowired
	private AccountDao accountDao;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public AccountTransaction doTransaction(Double transactionAmount,Account sendersAccount, Account receiversAccount, AccountTransaction accountTransaction) {
		// TODO Auto-generated method stub
		
		Double sendersBalance=sendersAccount.getAccountBalance();
		Double receiversBalanace=receiversAccount.getAccountBalance();
		
		Double newSendersBalance=sendersBalance-transactionAmount;
		Double newReceiversBalance=receiversBalanace+transactionAmount;
		
		sendersAccount.setAccountBalance(newSendersBalance);
        receiversAccount.setAccountBalance(newReceiversBalance);
         
        accountDao.updateAccount(receiversAccount);
        accountDao.updateAccount(sendersAccount);
        
        AccountTransaction t1=accountTransaction;
        t1.setSenderAccountNo(sendersAccount.getAccountNo());
        Session session = this.sessionFactory.getCurrentSession();
	    session.merge(t1);
	    System.out.println(t1);
	    accountTransaction.getAccount().setAccountNo(receiversAccount.getAccountNo());
	    accountTransaction.setAvailableBalance(newReceiversBalance);
	    accountTransaction.setSenderAccountNo(sendersAccount.getAccountNo());
	    System.out.println("transaction 1 is"+accountTransaction);
	    accountTransaction.setTransactionId(null);
	    session.persist(accountTransaction);
		System.out.println("At Registration Dao addCustomer : "+accountTransaction.getAccount().getAccountNo());
		return accountTransaction;
         
	}
	
}
