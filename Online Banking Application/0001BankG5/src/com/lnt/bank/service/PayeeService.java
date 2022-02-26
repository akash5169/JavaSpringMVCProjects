package com.lnt.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnt.bank.dao.IPayeeDao;
import com.lnt.bank.model.Payee;

@Service
public class PayeeService implements IPayeeService {

	private IPayeeDao payeeDao;
	
	public IPayeeDao getPayeeDao() {
		return payeeDao;
	}

	@Autowired
	public void setPayeeDao(IPayeeDao payeeDao) {
		this.payeeDao = payeeDao;
	}

	@Override
	@Transactional
	public Payee addPayee(Payee payee) {
		// TODO Auto-generated method stub
		return payeeDao.addPayee(payee);
	}

	@Override
	@Transactional
	public List<Payee> getPayee(Long accountNo) {
		// TODO Auto-generated method stub
		return payeeDao.getPayee(accountNo);
	}

	@Override
	@Transactional
	public Payee getPayeeByAccountNo(Long accountNo, Long payeeAccountNo) {
		// TODO Auto-generated method stub
		return payeeDao.getPayeeByAccountNo(accountNo, payeeAccountNo);
	}

}
