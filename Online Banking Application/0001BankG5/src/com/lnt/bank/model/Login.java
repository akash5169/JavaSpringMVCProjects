package com.lnt.bank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/*create table g5_cust_login( 
		 account_no NUMBER,
		 cust_user_id VARCHAR2(20) unique,
		 cust_password VARCHAR2(30),
		 FOREIGN KEY (account_no) REFERENCES g5_Cust(account_no)
		 );
		 */

@Entity
@Table(name = "g5_cust_login1")
public class Login implements Serializable {
	@Override
	public String toString() {
		return "Login [accountNo=" + accountNo + ", userId=" + userId + ", password=" + password + "]";
	}

	private static final long serialVersionUID = -5094858835250451187L;
	
	@Id
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", 
	parameters = @Parameter(name = "property", value = "customer"))
	@Column(name = "account_no", unique = true, nullable = false)
	private Long accountNo;

	@Length(max = 20, min = 3,message = "UserId too small!!")
	@NotEmpty(message = "UserId should not be empty!!")
	@Column(name = "cust_user_id")
	private String userId;

	@Length(max = 20, min = 3,message = "Password too small!!")
	@NotEmpty(message = "Password Should not be empty!!")
	@Column(name = "cust_password")
	private String password;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Customer customer;

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public Login(Long accountNo, String userId, String password) {
		super();
		this.accountNo = accountNo;
		this.userId = userId;
		this.password = password;
	}

	public Login() {
		super();
	}

}
