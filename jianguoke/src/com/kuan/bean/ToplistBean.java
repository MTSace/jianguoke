package com.kuan.bean;

public class ToplistBean {
	private int id;
	private String name;
	private int orderid;
	private int selected;
	public ToplistBean(int id,String name,int orderid,int selected){
		id=this.id;
		name=this.name;
		orderid=this.orderid;
		selected=this.selected;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getSelected() {
		return selected;
	}
	public void setSelected(int selected) {
		this.selected = selected;
	}

}
