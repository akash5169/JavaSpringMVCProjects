package com.lnt.bank.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;;

/*
 * create table g5_account( 
		 account_no NUMBER,
		 account_balance NUMBER(10,2),
		 account_type VARCHAR2(30),
		 IFSC  VARCHAR2(30),
		 FOREIGN KEY (account_no) REFERENCES g5_Cust(account_no)
		 );
 */
@Entity
@Table(name="g5_account1")
public class Account implements Serializable {

	private static final long serialVersionUID = 9079079297887887583L;
	@Id
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign",parameters = @Parameter(name = "property", value = "customer"))
	@Column(name = "account_no ")
	private Long accountNo;
	
	@Column(name="account_balance")
	private Double accountBalance;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="IFSC")
	private String IFSC;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Customer customer;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="account_no",updatable=false)
	private Set<AccountTransaction> accountTransaction;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<AccountTransaction> getTransactionTable() {
		return accountTransaction;
	}

	public void setTransactionTable(Set<AccountTransaction> accountTransaction) {
		this.accountTransaction = accountTransaction;
	}

	public Account() {
		super();
	}

	public Account(Long accountNo, Double accountBalance, String accountType, String iFSC) {
		super();
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
		this.accountType = accountType;
		this.IFSC = iFSC;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getIFSC() {
		return IFSC;
	}

	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}

	public Set<AccountTransaction> getTransaction() {
		return accountTransaction;
	}

	public void setTransaction(Set<AccountTransaction> accountTransaction) {
		this.accountTransaction = accountTransaction;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountBalance=" + accountBalance + ", accountType=" + accountType
				+ ", IFSC=" + IFSC + ", customer=" + customer + ", accountTransaction=" + accountTransaction + "]";
	}	

}
