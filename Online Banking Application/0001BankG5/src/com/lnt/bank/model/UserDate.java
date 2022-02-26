package com.lnt.bank.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;


/**
 * @author 10653179
 *
 */
@Entity
public class UserDate {
    private String chosenMonth;

	@NotEmpty(message="Please enter a startDate.")
	private Date startDate;
	
	@NotEmpty(message="Please enter a endDate.")
	private Date endDate;
    private Date intervalDate;
	

	public UserDate() {

	}

	public UserDate(Date startDate, Date endDate) {
		
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getChosenMonth() {
		return chosenMonth;
	}

	public void setChosenMonth(String chosenMonth) {
		this.chosenMonth = chosenMonth;
	}
	public Date getIntervalDate() {
		return intervalDate;
	}

	public void setIntervalDate(Date intervalDate) {
		this.intervalDate = intervalDate;
	}

	@Override
	public String toString() {
		return "UserDate [chosenMonth=" + chosenMonth + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", intervalDate=" + intervalDate + "]";
	}

    
}