package com.lnt.bank.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lnt.bank.model.Account;
import com.lnt.bank.model.AccountTransaction;

/**
 * @author 10653179
 *
 */
@Repository
public class AccountDao implements IAccountDao {
	private static final Logger logger = LoggerFactory.getLogger(AccountDao.class);
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<AccountTransaction> allTransactionTable() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = (Query) session.createQuery("From AccountTransaction");
		List<AccountTransaction> transacionTableList=query.list();
		return transacionTableList;
	}
	@Override
	public Account getAccountDetails(Long accountNo) {
      
		Session session = this.sessionFactory.getCurrentSession();
		Account account=(Account) session.get(Account.class, accountNo);
		return account;
		}

	@Override
	public List<String> trasactionDetails(Long accountNo,Date startDate,Date endDate) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("From AccountTransaction t where t.account.accountNo=:accountNo1 and t.transactionDateTime between :startDate and :endDate");
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		query.setParameter("accountNo1", accountNo);
		List<String> transactionDetails=query.list();
		return transactionDetails;
	}

	@Override
	public List<AccountTransaction> customerTransactionTable(Long accountNo) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query=session.createQuery("From AccountTransaction t where t.account.accountNo=:accountNo1 order by t.transactionId");
		query.setParameter("accountNo1", accountNo);
		 List<AccountTransaction> transactionDetailsOfCustomer = query.list();	
				return transactionDetailsOfCustomer;
		}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(account);
		logger.info("Customer updated succesfully," + "account details = " + account);
	}
	}
