package com.yyx.entity;

public class orderInfo {
	private int order_id;
	private int rec_infoid;
	private String stu_phone;
	private int sell_id;
	private String order_starttime;
	private String order_endtime;
	private float order_salary;
	private int order_state;
	private String order_access;
	
	
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getRec_infoid() {
		return rec_infoid;
	}
	public void setRec_infoid(int rec_infoid) {
		this.rec_infoid = rec_infoid;
	}
	public String getStu_id() {
		return stu_phone;
	}
	public void setStu_id(String i) {
		this.stu_phone = i;
	}
	public int getSell_id() {
		return sell_id;
	}
	public void setSell_id(int sell_id) {
		this.sell_id = sell_id;
	}
	public String getOrder_starttime() {
		return order_starttime;
	}
	public void setOrder_starttime(String order_starttime) {
		this.order_starttime = order_starttime;
	}
	public String getOrder_endtime() {
		return order_endtime;
	}
	public void setOrder_endtime(String order_endtime) {
		this.order_endtime = order_endtime;
	}
	public float getOrder_salary() {
		return order_salary;
	}
	public void setOrder_salary(float order_salary) {
		this.order_salary = order_salary;
	}
	public int getOrder_state() {
		return order_state;
	}
	public void setOrder_state(int order_state) {
		this.order_state = order_state;
	}
	public String getOrder_access() {
		return order_access;
	}
	public void setOrder_access(String order_access) {
		this.order_access = order_access;
	}
	
	public orderInfo(){
		super();
	}
	
	public orderInfo(int rec_infoid,String stu_id,int sell_id){
		super();
		this.rec_infoid = rec_infoid;
		this.stu_phone = stu_id;
		this.sell_id = sell_id;
	}
	
	public orderInfo(String order_access){
		super();
		this.order_access = order_access ;
	}
	
	public orderInfo(int rec_infoid,String stu_id,int sell_id,float order_salary){
		super();
		this.rec_infoid = rec_infoid;
		this.stu_phone = stu_id;
		this.sell_id = sell_id;
		this.order_salary = order_salary ; 
	}
}
