package com.lnt.bank.service;

import java.util.List;

import com.lnt.bank.model.Customer;

public interface ICustomerService {

	public List<Customer> getCustomers();
	public Customer getCustomerByAccountNo(Long accountNo);
	public void updateCustomer(Customer customer);
}
