package com.ajz.controller;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ajz.model.Login;
import com.ajz.model.Product;
import com.ajz.service.IProductService;
import com.ajz.service.ProductServiceImpl;


@Controller
public class MyController {

	
	@Autowired
	IProductService productService=new ProductServiceImpl();
	
	@RequestMapping(value = "/")
	public String showIndex(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "index";
	}
	
	@RequestMapping(value = "/dologin")
	public String tryLogin(@ModelAttribute(value = "login") Login login, BindingResult results, Model model,
			HttpServletRequest request) {
		String viewName = "index";
		Boolean flag = false;
			
				if (login.getUsername().equals("ajzmart") && login.getPassword().equals("password")) {
	                viewName="redirect:/inventory";
	                /*List<Product> proList=productService.getProducts();
	        		model.addAttribute("proList",proList);*/
	                flag=true;
				}
			if (!flag) {
				model.addAttribute("promptContent", "invalid userId or password");
				//model.addAttribute("loginDetails", login);
			}

		return viewName;
	}
	
	@RequestMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("productId") long product_id,
									Model model,HttpServletRequest request) {
		Product product=productService.getProduct(product_id);	
		model.addAttribute("product", product);
		return "update-form";
	}
	
	@RequestMapping("/delete")
	public String deleteProduct(@RequestParam("productId") long theId,HttpServletRequest request) {
        System.out.println("i was in delete");
		productService.deleteProduct(theId);
		return "redirect:/inventory";
	}
	
	@RequestMapping("/saveProduct")
	public String saveProduct(@ModelAttribute(value = "product") Product product,BindingResult results,Model model,HttpServletRequest request)
	{
        System.out.println("i was in save");
        System.out.println(product);
		productService.saveProduct(product);
		return "redirect:/inventory";
	}
	
	@RequestMapping("/inventory")
	public String showInvetory(Model model,HttpServletRequest request) {
		
		System.out.println("I was in show inventory====");
		List<Product> proList=productService.getProducts();
		System.out.println(proList);
		model.addAttribute("proList",proList);
		return "inventory";
	}
	
	protected long productIdGenerator(){
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
        String datetime = ft.format(dNow);
        long id=Long.parseLong(datetime);
        return id;
    }
	
	@RequestMapping(value = "/addForm")
	public String addForm(Model model) {
		Product product = new Product();
		
		product.setProduct_id(productIdGenerator());
		model.addAttribute("product", product);
		return "add-form";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(Model model) {
		return "redirect:/";
	}
	
	@RequestMapping(value = "/aboutus")
	public String aboutus(Model model) {
		return "about-us";
	}
	
	@RequestMapping(value = "/offerpage")
	public String offers(Model model) {
		return "offers";
	}

}
