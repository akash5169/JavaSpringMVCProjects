package com.lnt.bank.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*create table g5_branch(
		 IFSC varchar2(20) primary key,
		 branch_name varchar2(30)
		 );*/

@Entity
@Table(name = "g5_branch")
public class Branch implements Serializable {

	private static final long serialVersionUID = -7155945376955534865L;

	@Id
	@Column(name = "IFSC")
	private String Ifsc;

	@Column(name = "branch_name")
	private String bankName;

	public String getIfsc() {
		return Ifsc;
	}

	public void setIfsc(String ifsc) {
		Ifsc = ifsc;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Branch(String ifsc, String bankName) {
		super();
		Ifsc = ifsc;
		this.bankName = bankName;
	}

	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Branch [Ifsc=" + Ifsc + ", bankName=" + bankName + "]";
	}
}
