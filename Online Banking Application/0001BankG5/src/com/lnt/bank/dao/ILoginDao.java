package com.lnt.bank.dao;

import java.util.List;

import com.lnt.bank.model.Login;

public interface ILoginDao {
	
	public List<Login> loginDetails();
	public Login customerLogin(Long accountNo);
	public void updateLogin(Login login);

}
