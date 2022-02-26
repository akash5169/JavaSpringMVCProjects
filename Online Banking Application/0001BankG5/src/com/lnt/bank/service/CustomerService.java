package com.lnt.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnt.bank.dao.ICustomersDao;
import com.lnt.bank.model.Customer;

@Service
public class CustomerService implements ICustomerService {
	
	private ICustomersDao customerDao;	
	
	public ICustomersDao getCustomerDao() {
		return customerDao;
	}
	@Autowired
	public void setCustomerDao(ICustomersDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getCustomers();
	}
	@Override
	@Transactional
	public Customer getCustomerByAccountNo(Long accountNo) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerByAccountNo(accountNo);
	}
	
	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.updateCustomer(customer);
	}

}
