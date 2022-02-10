package com.ajz.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ajz.model.Product;

@Repository
public class ProductDaoImpl implements IProductDao{
	
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> productlist = session.createQuery("from Product").list();
		 
	        return productlist;
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println(product);
        currentSession.saveOrUpdate(product);
	}

	@Override
	public Product getProduct(long id) {
		
        Session session = this.sessionFactory.getCurrentSession();
		
		Product p=(Product)session.get(Product.class, id);
		return p;
	}

	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Product p=new Product();
		p.setProduct_id(id);
		session.delete(p);
	}

}
