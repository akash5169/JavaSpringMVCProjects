package com.lnt.bank.service;

import java.util.List;

import com.lnt.bank.model.Payee;

public interface IPayeeService {

	public Payee addPayee(Payee payee);
	public List<Payee> getPayee(Long accountNo);
	public Payee getPayeeByAccountNo(Long accountNo,Long payeeAccountNo);
}
