package com.lnt.bank.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="images")
public class Images implements Serializable{
	

	private static final long serialVersionUID = 8357718910369787215L;

	@Id
	@Column(name="account_no")
	private Long AccountNo;
	
	@Column(name="pr_ima_filetype")
	private String proImageFiletype;
	
	@Column(name="pr_image_name")
	private String proImageName;
	
	@Column(name="sign_ima_filetype")
	private String signImageFiletype;

	@Column(name="sign_image_name")
	private String signImageName;
	
	public Long getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(Long accountNo) {
		AccountNo = accountNo;
	}

	public Images() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProImageFiletype() {
		return proImageFiletype;
	}

	public void setProImageFiletype(String proImageFiletype) {
		this.proImageFiletype = proImageFiletype;
	}

	public String getProImageName() {
		return proImageName;
	}

	public void setProImageName(String proImageName) {
		this.proImageName = proImageName;
	}

	public String getSignImageFiletype() {
		return signImageFiletype;
	}

	public void setSignImageFiletype(String signImageFiletype) {
		this.signImageFiletype = signImageFiletype;
	}

	public String getSignImageName() {
		return signImageName;
	}

	public void setSignImageName(String signImageName) {
		this.signImageName = signImageName;
	}

	public Images(Long accountNo, String proImageFiletype, String proImageName, String signImageFiletype,
			String signImageName) {
		super();
		AccountNo = accountNo;
		this.proImageFiletype = proImageFiletype;
		this.proImageName = proImageName;
		this.signImageFiletype = signImageFiletype;
		this.signImageName = signImageName;
	}	

}
