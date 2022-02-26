package com.lnt.bank.dao;

import java.util.List;

import com.lnt.bank.model.Customer;
import com.lnt.bank.model.Payee;

public interface IPayeeDao {
	
	public Payee addPayee(Payee payee);
	public List<Payee> getPayee(Long accountNo);
	public Payee getPayeeByAccountNo(Long accountNo,Long payeeAccountNo);

}
