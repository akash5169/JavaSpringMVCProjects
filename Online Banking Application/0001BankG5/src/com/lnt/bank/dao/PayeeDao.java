package com.lnt.bank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lnt.bank.model.Customer;
import com.lnt.bank.model.Payee;

@Repository
public class PayeeDao implements IPayeeDao {
	
	private SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(PayeeDao.class);
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

	@Override
	public Payee addPayee(Payee payee) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(payee);
		return payee;
	}

	@Override
	public List<Payee> getPayee(Long accountNo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Payee where accountNo=:accountNo1");
		query.setParameter("accountNo1", accountNo);

		List<Payee> payeeList = query.list();

       System.out.println(payeeList);
		return payeeList;
	}
	
	@Override
	public Payee getPayeeByAccountNo(Long accountNo,Long payeeAccountNo) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
	Query query=session.createQuery("from Payee where accountNo=:accountNo1 and payeeAccountNo=:payeeAccountNo1");
	query.setParameter("accountNo1", accountNo);
	query.setParameter("payeeAccountNo1", payeeAccountNo);
		List <Payee> payeeList= (List<Payee>) query.list();
		Payee payee=null;
if(payeeList.isEmpty())
{payee=null;
	}
else {
	for (Payee payee2 : payeeList) {
		payee=payee2;
	}
}
		return payee;
	
	}

}
