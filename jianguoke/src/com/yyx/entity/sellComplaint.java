package com.yyx.entity;

public class sellComplaint {
	private int sell_comid;
	private int order_id;
	private String sell_comtype;
	private int sell_comstate;
	private String sell_comstarttime;
	private String sell_comendtime;
	
	public int getSell_comid() {
		return sell_comid;
	}
	public void setSell_comid(int sell_comid) {
		this.sell_comid = sell_comid;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getSell_comtype() {
		return sell_comtype;
	}
	public void setSell_comtype(String sell_comtype) {
		this.sell_comtype = sell_comtype;
	}
	public int getSell_comstate() {
		return sell_comstate;
	}
	public void setSell_comstate(int sell_comstate) {
		this.sell_comstate = sell_comstate;
	}
	public String getSell_comstarttime() {
		return sell_comstarttime;
	}
	public void setSell_comstarttime(String sell_comstarttime) {
		this.sell_comstarttime = sell_comstarttime;
	}
	public String getSell_comendtime() {
		return sell_comendtime;
	}
	public void setSell_comendtime(String sell_comendtime) {
		this.sell_comendtime = sell_comendtime;
	}
	
	
	public sellComplaint(){
		super();
	}
	public sellComplaint(int order_id){
		super();
		this.order_id = order_id;
	}
	public sellComplaint(int order_id,String sell_comtype){
		super();
		this.order_id = order_id;
		this.sell_comtype = sell_comtype;
	}
	public sellComplaint(int order_id,String sell_comtype,int sell_comstate){
		super();
		this.order_id = order_id;
		this.sell_comtype = sell_comtype;
		this.sell_comstate = sell_comstate;
	}
}