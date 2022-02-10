package com.ajz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajz.dao.IProductDao;
import com.ajz.model.Product;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
    private IProductDao productDao;
	
	
	
	public IProductDao getProductDao() {
		return productDao;
	}

	@Autowired
	public void setProductDao(IProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	@Transactional
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDao.getProducts();
	}

	@Override
	@Transactional
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.saveProduct(product);
	}

	@Override
	@Transactional
	public Product getProduct(long id) {
		// TODO Auto-generated method stub
		return productDao.getProduct(id);
	}

	@Override
	@Transactional
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		productDao.deleteProduct(id);
	}
	
}
