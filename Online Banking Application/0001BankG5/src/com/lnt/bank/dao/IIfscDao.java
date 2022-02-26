package com.lnt.bank.dao;

import java.util.List;

import com.lnt.bank.model.Branch;
import com.lnt.bank.model.Customer;

public interface IIfscDao {
	public List<Branch> getIfsc();
}
