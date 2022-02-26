package com.lnt.bank.dao;

import com.lnt.bank.model.Account;
import com.lnt.bank.model.Customer;
import com.lnt.bank.model.Login;

public interface IRegistrationDao {

	public Customer addCustomer(Customer customer, Login login, Account account);
}
