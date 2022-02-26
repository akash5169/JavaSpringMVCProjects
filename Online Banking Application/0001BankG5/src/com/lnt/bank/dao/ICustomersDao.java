package com.lnt.bank.dao;

import java.util.List;

import com.lnt.bank.model.Customer;

public interface ICustomersDao {
	
	public List<Customer> getCustomers();
	public Customer getCustomerByAccountNo(Long accountNo);
	public void updateCustomer(Customer customer);

}
