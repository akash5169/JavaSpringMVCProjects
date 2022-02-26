package com.lnt.bank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="payee")
public class Payee implements Serializable{

	private static final long serialVersionUID = -8336290460095900903L;

	@Id
	@Column(name = "composite_account_no")
	private Long composite;
	
	@NotNull(message="Should not be empty")
	@Column(name = "payee_account_no")
	private Long payeeAccountNo;
	
	@Column(name="account_no")
	private Long accountNo;
	
	@Column(name = "IFSC")
	@NotEmpty(message = "Insert IFSC Code!!")
	private String IFSC;
	
	@Column(name = "account_type")
	@NotEmpty(message = "select atleast one type!!")
	private String accountType;
	
	@Column(name = "payee_name")
	@NotEmpty(message = "Insert Payee Name!")
	private String payeeName;

	
	public Long getComposite() {
		return composite;
	}


	public void setComposite(Long composite) {
		this.composite = composite;
	}
	public Long getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}


	public String getIFSC() {
		return IFSC;
	}


	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getPayeeName() {
		return payeeName;
	}


	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}


	public Payee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getPayeeAccountNo() {
		return payeeAccountNo;
	}


	public void setPayeeAccountNo(Long payeeAccountNo) {
		this.payeeAccountNo = payeeAccountNo;
	}


	public Payee(Long composite, Long payeeAccountNo, Long accountNo, String iFSC, String accountType,
			String payeeName) {
		super();
		this.composite = composite;
		this.payeeAccountNo = payeeAccountNo;
		this.accountNo = accountNo;
		IFSC = iFSC;
		this.accountType = accountType;
		this.payeeName = payeeName;
	}


	@Override
	public String toString() {
		return "Payee [composite=" + composite + ", payeeAccountNo=" + payeeAccountNo + ", accountNo=" + accountNo
				+ ", IFSC=" + IFSC + ", accountType=" + accountType + ", payeeName=" + payeeName + "]";
	}
	
}
