package com.lnt.bank.dao;

import java.util.Date;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lnt.bank.model.Account;
import com.lnt.bank.model.Customer;
import com.lnt.bank.model.Login;
import com.lnt.bank.model.AccountTransaction;

@Repository
public class RegistrationDao implements IRegistrationDao {

	private SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(RegistrationDao.class);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Customer addCustomer(Customer customer,Login login,Account account) {
		// TODO Auto-generated method stub  
		
		Session session = sessionFactory.getCurrentSession();
		customer.setLogin(login);
		login.setCustomer(customer);
		customer.setAccount(account);
		account.setCustomer(customer);
		session.save(customer);
		System.out.println("At Registration Dao addCustomer : "+customer.getAccountNo());
		return customer;
	}

}
