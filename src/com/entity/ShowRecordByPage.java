package com.entity;

import java.util.ArrayList;
import java.util.List;



public class ShowRecordByPage {
	private int pageSize = 10;
	private int pageNow = 1;
	private List<User> datas = new ArrayList<User>();
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public List<User> getDatas() {
		return datas;
	}
	public void setDatas(List<User> datas) {
		this.datas = datas;
	}
	
	

}
