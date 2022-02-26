package com.lnt.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnt.bank.dao.ILoginDao;
import com.lnt.bank.model.Login;

@Service
public class LoginService implements ILoginService {

	ILoginDao loginDao;
	
	public ILoginDao getLoginDao() {
		return loginDao;
	}

	@Autowired
	public void setLoginDao(ILoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	@Transactional
	public List<Login> loginDetails() {
		// TODO Auto-generated method stub
		return loginDao.loginDetails();
	}

	@Override
	@Transactional
	public Login customerLogin(Long accountNo) {
		// TODO Auto-generated method stub
		return loginDao.customerLogin(accountNo);
	}

	@Override
	@Transactional
	public void updateLogin(Login login) {
		// TODO Auto-generated method stub
		loginDao.updateLogin(login);
	}

}
