package com.lnt.bank.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/*create table transactions(
 * cust_account_no
 transaction_id NUMBER PRIMARY KEY,
 transaction_date_time DATE,
 sender_account_no NUMBER,
 reciever_account_no NUMBER,
 transaction_amount DECIMAL(11,3),
 transaction_type varchar2(30),
 available_balance decimal(11,3)
 FOREIGN KEY (cust_account_no) REFERENCES g5_accounth(account_no)
 );
*/

@Entity
@Table(name="transactions")
public class AccountTransaction implements Serializable{
	private static final long serialVersionUID = -2249416677906216548L;

	@Id
	@SequenceGenerator(name="seq2",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq2")
	@Column(name="transaction_id")
	private Long transactionId; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="transaction_date_time")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date transactionDateTime;
	
	@Column(name="receiver_name")
	private String receiverName;
	
	

	@Column(name="sender_account_no")
	private Long senderAccountNo;
	
	@Column(name="reciever_account_no")
	private Long receiverAccountNo;
	
	@Column(name="transaction_amount")
	private Double transactionAmount;
	
	@Column(name="transaction_type")
	private String transactionType;
	
	@Column(name="available_balance")
	private Double availableBalance;
	
	@ManyToOne
	@JoinColumn(name="account_no",updatable=false)
	private Account account;
	
	
	public AccountTransaction() {
	}

	

	public AccountTransaction(Long transactionId, Date transactionDateTime, String receiverName, Long senderAccountNo,
			Long receiverAccountNo, Double transactionAmount, String transactionType, Double availableBalance,
			Account account) {
		super();
		this.transactionId = transactionId;
		this.transactionDateTime = transactionDateTime;
		this.receiverName = receiverName;
		this.senderAccountNo = senderAccountNo;
		this.receiverAccountNo = receiverAccountNo;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.availableBalance = availableBalance;
		this.account = account;
	}



	@Override
	public String toString() {
		return "AccountTransaction [transactionId=" + transactionId + ", transactionDateTime=" + transactionDateTime
				+ ", receiverName=" + receiverName + ", senderAccountNo=" + senderAccountNo + ", receiverAccountNo="
				+ receiverAccountNo + ", transactionAmount=" + transactionAmount + ", transactionType="
				+ transactionType + ", availableBalance=" + availableBalance + "]";
	}



	public Account getAccount() {
		return account;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

	
	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(Date transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public Long getSenderAccountNo() {
		return senderAccountNo;
	}

	public void setSenderAccountNo(Long senderAccountNo) {
		this.senderAccountNo = senderAccountNo;
	}

	public Long getReceiverAccountNo() {
		return receiverAccountNo;
	}

	public void setReceiverAccountNo(Long receiverAccountNo) {
		this.receiverAccountNo = receiverAccountNo;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Account getAccountSummary() {
		return account;
	}

	public void setAccountSummary(Account account) {
		this.account = account;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof AccountTransaction) {
            return  transactionId== ((AccountTransaction) obj).transactionId;
        }
        return false;
		
	}


}
