package com.lnt.bank.dao;

import java.io.IOException;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class BlobDao implements IBlobDao {

	SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public Blob blobFormer(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			return Hibernate.getLobCreator(this.sessionFactory.getCurrentSession()).createBlob(file.getBytes());
		} catch (HibernateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return null;
	}
}
