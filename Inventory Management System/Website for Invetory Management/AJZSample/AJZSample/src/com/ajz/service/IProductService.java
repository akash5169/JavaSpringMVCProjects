package com.ajz.service;

import java.util.List;

import com.ajz.model.Product;

public interface IProductService {

	public List < Product > getProducts();

    public void saveProduct(Product product);

    public Product getProduct(long product_id);

    public void deleteProduct(long theId);
}
