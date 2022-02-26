package com.lnt.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnt.bank.dao.IRegistrationDao;
import com.lnt.bank.model.Account;
import com.lnt.bank.model.Customer;
import com.lnt.bank.model.Login;

@Service
public class RegistrationService implements IRegistrationService {

	private IRegistrationDao registrationDao;
	
	public IRegistrationDao getRegistrationDao() {
		return registrationDao;
	}

	@Autowired
	public void setRegistrationDao(IRegistrationDao registrationDao) {
		this.registrationDao = registrationDao;
	}

	@Override
	@Transactional
	public Customer addCustomer(Customer customer,Login login,Account account) {
		// TODO Auto-generated method stub
		return registrationDao.addCustomer(customer, login, account);
	}


}
