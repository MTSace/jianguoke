package com.yyx.entity;

public class mrecInfo {
	private int mrec_infoid;
	private String mrec_sendid;
	private String mrec_receiveid;
	private String mrec_type;
	private String mrec_content;
	private int mrec_state;
	private String mrec_starttime;
	private String mrec_endtime;
	public int getMrec_infoid() {
		return mrec_infoid;
	}
	public void setMrec_infoid(int mrec_infoid) {
		this.mrec_infoid = mrec_infoid;
	}

	public String getMrec_sendid() {
		return mrec_sendid;
	}
	public void setMrec_sendid(String mrec_sendid) {
		this.mrec_sendid = mrec_sendid;
	}
	public String getMrec_receiveid() {
		return mrec_receiveid;
	}
	public void setMrec_receiveid(String mrec_receiveid) {
		this.mrec_receiveid = mrec_receiveid;
	}
	public String getMrec_type() {
		return mrec_type;
	}
	public void setMrec_type(String mrec_type) {
		this.mrec_type = mrec_type;
	}
	public String getMrec_content() {
		return mrec_content;
	}
	public void setMrec_content(String mrec_content) {
		this.mrec_content = mrec_content;
	}
	public int getMrec_state() {
		return mrec_state;
	}
	public void setMrec_state(int mrec_state) {
		this.mrec_state = mrec_state;
	}
	public String getMrec_starttime() {
		return mrec_starttime;
	}
	public void setMrec_starttime(String mrec_starttime) {
		this.mrec_starttime = mrec_starttime;
	}
	public String getMrec_endtime() {
		return mrec_endtime;
	}
	public void setMrec_endtime(String mrec_endtime) {
		this.mrec_endtime = mrec_endtime;
	}
	
	public mrecInfo(){
		super();
	}
	
	public mrecInfo(int mrec_sendinfo,String mrec_content){
		super();
		this.mrec_sendid = mrec_sendid ; 
		this.mrec_content = mrec_content ; 
	}
	
	public mrecInfo(int mrec_sendinfo,String mrec_type,String mrec_content){
		super();
		this.mrec_sendid = mrec_sendid ; 
		this.mrec_type = mrec_type ; 
		this.mrec_content = mrec_content ; 
	}
	
	public mrecInfo(int mrec_sendinfo,String mrec_type,String mrec_content,int mrec_received){
		super();
		this.mrec_sendid = mrec_sendid ; 
		this.mrec_type = mrec_type ; 
		this.mrec_content = mrec_content ; 
		this.mrec_receiveid = mrec_receiveid ;
	}
}
