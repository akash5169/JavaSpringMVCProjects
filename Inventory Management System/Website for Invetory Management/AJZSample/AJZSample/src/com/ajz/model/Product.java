package com.ajz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;


//Product Data Structure
@Entity
@Table(name = "product_clone")
public class Product {
	@Id
    @Column(name = "product_id")
    protected long product_id; //Product ID
	
	@Column(name = "product_cate")
    protected String product_cate; //Product category
	
	@Column(name = "product_type")
    protected String product_type; //Product type
	
	@Column(name = "borv")
    protected String borv; //Product brand or variety
	
	@Column(name = "place")
    protected String place; //Place where the product is kept
	
	@Column(name = "weight")
    protected float weight; //weight of the product
	
	@Column(name = "weight_unit")
    protected String weight_unit;  //unit of the weight
	
	@Column(name = "manufacture_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date manufacture_date; //Date of manufacture
	
	@Column(name = "expiration_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    protected Date expiration_date; //Date of expiration
	
	@Column(name = "price")
    protected float price; //total price
	
	@Column(name = "tax")
    protected float tax; //taxed amount
	
	@Column(name = "discount")
    protected float discount; //discount offered
	
	@Column(name = "supplier_id")
    protected String supplier_id; //ID of the supplier: "category + ID"
	
	

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(long product_id, String product_cate, String product_type, String borv, String place, float weight,
			String weight_unit, Date manufacture_date, Date expiration_date, float price, float tax, float discount,
			String supplier_id) {
		super();
		this.product_id = product_id;
		this.product_cate = product_cate;
		this.product_type = product_type;
		this.borv = borv;
		this.place = place;
		this.weight = weight;
		this.weight_unit = weight_unit;
		this.manufacture_date = manufacture_date;
		this.expiration_date = expiration_date;
		this.price = price;
		this.tax = tax;
		this.discount = discount;
		this.supplier_id = supplier_id;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_cate=" + product_cate + ", product_type=" + product_type
				+ ", borv=" + borv + ", place=" + place + ", weight=" + weight + ", weight_unit=" + weight_unit
				+ ", Manufacture_date=" + manufacture_date + ", Expiration_date=" + expiration_date + ", Price=" + price
				+ ", tax=" + tax + ", discount=" + discount + ", supplier_id=" + supplier_id + "]";
	}

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_cate() {
		return product_cate;
	}

	public void setProduct_cate(String product_cate) {
		this.product_cate = product_cate;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getBorv() {
		return borv;
	}

	public void setBorv(String borv) {
		this.borv = borv;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getWeight_unit() {
		return weight_unit;
	}

	public void setWeight_unit(String weight_unit) {
		this.weight_unit = weight_unit;
	}

	
	public Date getManufacture_date() {
		return manufacture_date;
	}

	public void setManufacture_date(Date manufacture_date) {
		this.manufacture_date = manufacture_date;
	}

	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	
}

