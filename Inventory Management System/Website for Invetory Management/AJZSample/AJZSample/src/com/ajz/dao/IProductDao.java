package com.ajz.dao;

import java.util.List;

import com.ajz.model.Product;

public interface IProductDao {

	public List < Product > getProducts();

    public void saveProduct(Product product);

    public Product getProduct(long id);

    public void deleteProduct(long id);
}
