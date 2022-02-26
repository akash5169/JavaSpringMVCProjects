package com.lnt.bank.service;


import com.lnt.bank.model.Account;
import com.lnt.bank.model.Customer;
import com.lnt.bank.model.Login;

public interface IRegistrationService {
	public Customer addCustomer(Customer customer,Login login,Account acount);
	
}
