package com.entity;

import java.util.*;

public class Signature {
   private String sig_name;
   private String sig_content;
   private Date   creation_date;
   private String creator;
   
   
public String getSig_name() {
	return sig_name;
}
public void setSig_name(String sig_name) {
	this.sig_name = sig_name;
}
public String getSig_content() {
	return sig_content;
}
public void setSig_content(String sig_content) {
	this.sig_content = sig_content;
}
public Date getCreation_date() {
	return creation_date;
}
public void setCreation_date(Date creation_date) {
	this.creation_date = creation_date;
}
public String getCreator() {
	return creator;
}
public void setCreator(String creator) {
	this.creator = creator;
}
   

}
