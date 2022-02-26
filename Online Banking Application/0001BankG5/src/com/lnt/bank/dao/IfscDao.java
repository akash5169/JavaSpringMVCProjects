package com.lnt.bank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lnt.bank.model.Branch;

import oracle.net.aso.b;

@Repository
public class IfscDao implements IIfscDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public static Logger getLogger() {
		return logger;
	}

	private static final Logger logger = LoggerFactory.getLogger(IfscDao.class);

	@Override
	public List<Branch> getIfsc() {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();
		List<Branch> branchList = session.createQuery("from Branch").list();

	/*	for (Branch branch : branchList) {
			//System.out.println(branch);
		//	logger.info(""+branch);
		}
		logger.info("branchList : "+branchList);*/
		return branchList;
	}

}
