package com.lnt.bank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lnt.bank.model.Account;
import com.lnt.bank.model.Customer;
import com.lnt.bank.model.Login;

@Repository
public class LoginDao implements ILoginDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Login> loginDetails() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Login> loginList = session.createQuery("from Login").list();
		
		return loginList;
	}

	@Override
	public Login customerLogin(Long accountNo) {
		// TODO Auto-generated method stub
		System.out.println("i reached here too");
		Session session = this.sessionFactory.getCurrentSession();
		String hql="from Login l where l.accountNo=:accountNo";
		Query query= session.createQuery(hql);
		query.setParameter("accountNo", accountNo);
		@SuppressWarnings("unchecked")
		List<Login> loginList=query.list();
		Login login= null;
		for (Login login2 : loginList) {
			login=login2;
		}
		//Login login = (Login) session.get(Login.class, accountNo);
		return login;
	}

	@Override
	public void updateLogin(Login login) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(login);
	}

}
