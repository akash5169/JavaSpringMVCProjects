package com.lnt.bank.service;

import java.util.List;

import com.lnt.bank.model.Login;

public interface ILoginService {

	public List<Login> loginDetails();
	public Login customerLogin(Long accountNo);
	public void updateLogin(Login login);
}
