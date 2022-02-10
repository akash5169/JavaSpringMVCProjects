package model;

import javafx.scene.control.CheckBox;

import java.text.SimpleDateFormat;
import java.util.Date;

//Product Data Structure
public class Product {
    protected CheckBox cbox; //check box
    protected long product_id; //Product ID
    protected String product_cate; //Product category
    protected String product_type; //Product type
    protected String borv; //Product brand or variety
    protected String place; //Place where the product is kept
    protected float weight; //weight of the product
    protected String weight_unit;  //unit of the weight
    protected Date Manufacture_date; //Date of manufacture
    protected Date Expiration_date; //Date of expiration
    protected float Price; //total price
    protected float tax; //taxed amount
    protected float discount; //discount offered
    protected String supplier_id; //ID of the supplier: "category + ID"


    public Product(CheckBox cBox, long product_id, String product_cate, String product_type, String borv, String place, float weight, String weight_unit, Date manufacture_date, Date expiration_date, float price, float tax, float discount, String supplier_id) {
        this.cbox = new CheckBox();
        this.product_id = productIdGenerator();
        this.product_cate = product_cate;
        this.product_type = product_type;
        this.borv = borv;
        this.place = place;
        this.weight = weight;
        this.weight_unit = weight_unit;
        Manufacture_date = manufacture_date;
        Expiration_date = expiration_date;
        Price = price;
        this.tax = tax;
        this.discount = discount;
        this.supplier_id = supplier_id;
    }


    public Product() {
        this.cbox=new CheckBox();
        this.product_id = productIdGenerator();
        this.product_cate = null;
        this.product_type = null;
        this.borv = null;
        this.place = null;
        this.weight = 0.0f;
        this.weight_unit = null;
        Manufacture_date = null;
        Expiration_date = null;
        this.Price = 0.0f;
        this.tax = 0.0f;
        this.discount = 0.0f;
        this.supplier_id = null;
    }

    public CheckBox getCbox() {
        return cbox;
    }

    public void setCbox(CheckBox cbox) {
        this.cbox = cbox;
    }

    public String getWeight_unit() {
        return weight_unit;
    }

    public void setWeight_unit(String weight_unit) {
        this.weight_unit = weight_unit;
    }

    //fetch the product ID
    public long getProduct_id()
    {
        return product_id;
    }

    //update/add a new product ID
    public void setBorv(String borv) {
        this.borv = borv;
    }

    //fetch the product ID
    public String getBorv()
    {
        return borv;
    }

    //update/add a new product ID
    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    //fetch the product category
    public String getProduct_cate() {
        return product_cate;
    }


    //update/add a new product category
    public void setProduct_cate(String product_cate) {
        this.product_cate = product_cate;
    }


    //fetch the product type
    public String getProduct_type() {
        return product_type;
    }


    //update/add a new product type
    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }


    //fetch the place
    public String getPlace() {
        return place;
    }


    //update/ add a new place
    public void setPlace(String place) {
        this.place = place;
    }


    //fetch the weight
    public float getWeight() {
        return weight;
    }


    //update/add a new product weight
    public void setWeight(float weight) {
        this.weight = weight;
    }




    //fetch the manufacturing date
    public Date getManufacture_date() {
        return Manufacture_date;
    }


    //update/ add a new manufacturing date
    public void setManufacture_date(Date manufacture_date) {
        Manufacture_date = manufacture_date;
    }


    //fetch the expiration date
    public Date getExpiration_date() {
        return Expiration_date;
    }

    //update or add a new expiration date
    public void setExpiration_date(Date expiration_date) {
        Expiration_date = expiration_date;
    }


    //fetch the price
    public float getPrice() {
        return Price;
    }


    //update or add a new price
    public void setPrice(float price) {
        Price = price;
    }


    //fetch the tax
    public float getTax() {
        return tax;
    }


    //update or add a new tax
    public void setTax(float tax) {
        this.tax = tax;
    }


    //fetch the discount
    public float getDiscount() {
        return discount;
    }


    //update or add a new discount
    public void setDiscount(float discount) {
        this.discount = discount;
    }


    //fetch the supplier ID
    public String getSupplier_id() {
        return supplier_id;
    }

    //update or add a new supplier ID
    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    //this is unique ID generator function. This uses current datetime to create unique ID.
    protected long productIdGenerator(){
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
        String datetime = ft.format(dNow);
        long id=Long.parseLong(datetime);
        return id;
    }
}
