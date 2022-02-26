package com.lnt.bank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lnt.bank.model.Customer;

@Repository
public class CustomerDao implements ICustomersDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public static Logger getLogger() {
		return logger;
	}

	private static final Logger logger = LoggerFactory.getLogger(CustomerDao.class);

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customerList = session.createQuery("from Customer").list();
		return customerList;
	}

	@Override
	public Customer getCustomerByAccountNo(Long accountNo) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.load(Customer.class, accountNo);
		
		if (customer != null) {
			logger.info("Customer Found , " + "Customer Details" + customer);
		}

		else {
			logger.error("Customer not Found , with customerId =" + accountNo);
		}
		return customer;
	}
	
	@Override
	public void updateCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(customer);
		logger.info("Customer updated succesfully," + "customer details = " + customer);
	}
}
