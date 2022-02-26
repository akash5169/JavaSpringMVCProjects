package com.lnt.bank.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/*create table g5_Cust(
		 account_no NUMBER PRIMARY KEY,
		 cust_name VARCHAR2(30),
		 cust_mob_no VARCHAR2(13),
		 cust_gender VARCHAR2(6),
		 cust_email VARCHAR2(70),
		 cust_dob DATE,
		 cust_house_no_name varchar2(70),
		 cust_street_name varchar2(70),
		 cust_landmark varchar2(70),
		 cust_city varchar2(30),
		 cust_state varchar2(20),
		 cust_country varchar2(20),
		 cust_pincode varchar2(8),
		 cust_branch varchar2(30),
		 cust_aadhar_no varchar2(20),
		 cust_pan_no varchar2(30),
		 cust_image BLOB,
		 cust_signature BLOB
		  );*/
@Entity
@Table(name = "g5_Cust1")
public class Customer implements Serializable {

	private static final long serialVersionUID = -4676356864944852732L;

	@Id
	@Column(name = "account_no", unique = true, nullable = false)
	@SequenceGenerator(name="gen",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "gen")
	private Long accountNo;

	@Length(max = 20, min = 3, message = " Name entered is invalid. It must be between 3 and 20 characters.")
	@Column(name = "cust_name")
	private String customerName;

	@NotEmpty(message = "Enter valid phone no...(10 digits)")
	@Column(name = "cust_mob_no")
	private String mobNo;

	@NotEmpty(message = "Please select gender")
	@Column(name = "cust_gender")
	private String gender;

	@NotEmpty
	@Email(message = "Please Enter valid Email Id")
	@Column(name = "cust_email")
	private String email;

	@Column(name = "cust_dob")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull(message = "please select date of birth")
	@DateTimeFormat(pattern = "mm-DD-yyyy")
	private Date dob;

	@NotEmpty(message = "Field should not be empty")
	@Column(name = "cust_house_no_name")
	private String custHouseNoName;

	@NotEmpty(message = "Field should not be empty")
	@Column(name = "cust_street_name")
	private String custStreetName;

	@Column(name = "cust_landmark")
	@NotEmpty(message = "Field should not be empty")
	private String custLandmark;

	@Column(name = "cust_city")
	@NotEmpty(message = "city should not be empty")
	private String city;

	@NotEmpty(message = "state should not be empty")
	@Column(name = "cust_state")
	private String state;

	@NotEmpty(message = "country should not be empty")
	@Column(name = "cust_country")
	private String custCountry;

	@NotEmpty(message = "Field should not be empty")
	@Column(name = "cust_pincode")
	private String custPincode;

	@NotEmpty(message = "branch should not be empty")
	@Column(name = "cust_branch")
	private String custBranch;

	@NotEmpty(message = "aadhar no should not be empty")
	@Column(name = "cust_aadhar_no")
	private String aadharNo;

	@NotEmpty(message = "pan no should not be empty")
	@Column(name = "cust_pan_no")
	private String panNo;

	/*@NotEmpty
	 @Column(name = "image") 
	private String customerImage;
	 
	@NotEmpty
	@Column(name = "signature") 
	private String customerSignature;*/
	 

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private Account account;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private Login login;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}


	public Customer(Long accountNo, String customerName, String mobNo, String gender, String email, Date dob,
			String custHouseNoName, String custStreetName, String custLandmark, String city, String state,
			String custCountry, String custPincode, String custBranch, String aadharNo, String panNo, Account account,
			Login login) {
		super();
		this.accountNo = accountNo;
		this.customerName = customerName;
		this.mobNo = mobNo;
		this.gender = gender;
		this.email = email;
		this.dob = dob;
		this.custHouseNoName = custHouseNoName;
		this.custStreetName = custStreetName;
		this.custLandmark = custLandmark;
		this.city = city;
		this.state = state;
		this.custCountry = custCountry;
		this.custPincode = custPincode;
		this.custBranch = custBranch;
		this.aadharNo = aadharNo;
		this.panNo = panNo;
		this.account = account;
		this.login = login;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCustHouseNoName() {
		return custHouseNoName;
	}

	public void setCustHouseNoName(String custHouseNoName) {
		this.custHouseNoName = custHouseNoName;
	}

	public String getCustStreetName() {
		return custStreetName;
	}

	public void setCustStreetName(String custStreetName) {
		this.custStreetName = custStreetName;
	}

	public String getCustLandmark() {
		return custLandmark;
	}

	public void setCustLandmark(String custLandmark) {
		this.custLandmark = custLandmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCustCountry() {
		return custCountry;
	}

	public void setCustCountry(String custCountry) {
		this.custCountry = custCountry;
	}

	public String getCustPincode() {
		return custPincode;
	}

	public void setCustPincode(String custPincode) {
		this.custPincode = custPincode;
	}

	public String getCustBranch() {
		return custBranch;
	}

	public void setCustBranch(String custBranch) {
		this.custBranch = custBranch;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Customer [accountNo=" + accountNo + ", customerName=" + customerName + ", mobNo=" + mobNo + ", gender="
				+ gender + ", email=" + email + ", dob=" + dob + ", custHouseNoName=" + custHouseNoName
				+ ", custStreetName=" + custStreetName + ", custLandmark=" + custLandmark + ", city=" + city
				+ ", state=" + state + ", custCountry=" + custCountry + ", custPincode=" + custPincode + ", custBranch="
				+ custBranch + ", aadharNo=" + aadharNo + ", panNo=" + panNo + ", login=" + login + "]";
	}

}
