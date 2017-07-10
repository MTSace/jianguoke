package com.yyx.entity;

public class stuComplaint {
	private int stu_comid;
	private int order_id;
	private String stu_comtype;
	private String stu_comstarttime;
	private String stu_comendtime;
	private int stu_comstate;
	
	public int getStu_comid() {
		return stu_comid;
	}
	public void setStu_comid(int stu_comid) {
		this.stu_comid = stu_comid;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getStu_comtype() {
		return stu_comtype;
	}
	public void setStu_comtype(String stu_comtype) {
		this.stu_comtype = stu_comtype;
	}
	public String getStu_comstarttime() {
		return stu_comstarttime;
	}
	public void setStu_comstarttime(String stu_comstarttime) {
		this.stu_comstarttime = stu_comstarttime;
	}
	public String getStu_comendtime() {
		return stu_comendtime;
	}
	public void setStu_comendtime(String stu_comendtime) {
		this.stu_comendtime = stu_comendtime;
	}
	public int getStu_comstate() {
		return stu_comstate;
	}
	public void setStu_comstate(int stu_comstate) {
		this.stu_comstate = stu_comstate;
	}
	
	public stuComplaint(){
		super();
	}
	public stuComplaint(int order_id){
		super();
		this.order_id = order_id;
	}
	public stuComplaint(int order_id,String stu_comtype){
		super();
		this.order_id = order_id;
		this.stu_comtype = stu_comtype;
	}
	public stuComplaint(int order_id,String stu_comtype,int stu_comstate){
		super();
		this.order_id = order_id;
		this.stu_comtype = stu_comtype ;
		this.stu_comstate = stu_comstate;
	}
}
