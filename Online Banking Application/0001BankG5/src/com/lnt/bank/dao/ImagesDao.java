package com.lnt.bank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lnt.bank.model.Images;
import com.lnt.bank.model.Login;

@Repository
public class ImagesDao implements IImageDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Images addImage(Images images) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		 session.saveOrUpdate(images);
		return images;
	}

	@Override
	public Images getImage(Long accountNo) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		String hql="from Images I where I.AccountNo=:accountNo";
		
		Query query= session.createQuery(hql);
		query.setParameter("accountNo", accountNo);
		@SuppressWarnings("unchecked")
		List<Images> imageList=query.list();
		Images images2=null;
		
		System.out.println("i am here....");
		
		for (Images images : imageList) {
			images2=images;
		}
		System.out.println("i got the image here....");
		return images2;
	}

}
