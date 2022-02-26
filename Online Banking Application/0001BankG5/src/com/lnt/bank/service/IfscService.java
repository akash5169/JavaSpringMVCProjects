package com.lnt.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lnt.bank.dao.IIfscDao;
import com.lnt.bank.model.Branch;

@Service
public class IfscService implements IIfscService {

	private IIfscDao ifscDao;

	public IIfscDao getIfscDao() {
		return ifscDao;
	}

	@Autowired
	public void setIfscDao(IIfscDao ifscDao) {
		this.ifscDao = ifscDao;
	}

	@Override
	@Transactional
	public List<Branch> getIFSC() {
		// TODO Auto-generated method stub
		return ifscDao.getIfsc();
	}

}
