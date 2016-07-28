package com.entity;

import java.util.*;

public class Certificate {
	private String name;
	private String sex;
	private Integer age;
	private Date birthdate;
	private String cer_type;
	private String issue_office;
	private Date issue_date;
	private Date validity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getCer_type() {
		return cer_type;
	}
	public void setCer_type(String cer_type) {
		this.cer_type = cer_type;
	}
	public String getIssue_office() {
		return issue_office;
	}
	public void setIssue_office(String issue_office) {
		this.issue_office = issue_office;
	}
	public Date getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}
	public Date getValidity() {
		return validity;
	}
	public void setValidity(Date validity) {
		this.validity = validity;
	}
	
	

}
