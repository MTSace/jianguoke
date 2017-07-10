package com.yyx.entity;

public class recruitInfo {
	private int rec_infoid;
	private int sell_id;
	private String rec_type;
	private float rec_salary;
	private int rec_num;
	private String rec_starttime;
	private String rec_endtime;
	private int rec_state;
	private String rec_content;
	public String getRec_content() {
		return rec_content;
	}
	public void setRec_content(String rec_content) {
		this.rec_content = rec_content;
	}
	public int getRec_infoid() {
		return rec_infoid;
	}
	public void setRec_infoid(int rec_infoid) {
		this.rec_infoid = rec_infoid;
	}
	public int getSell_id() {
		return sell_id;
	}
	public void setSell_id(int sell_id) {
		this.sell_id = sell_id;
	}
	public String getRec_type() {
		return rec_type;
	}
	public void setRec_type(String rec_type) {
		this.rec_type = rec_type;
	}
	public float getRec_salary() {
		return rec_salary;
	}
	public void setRec_salary(float rec_salary) {
		this.rec_salary = rec_salary;
	}
	public int getRec_num() {
		return rec_num;
	}
	public void setRec_num(int rec_num) {
		this.rec_num = rec_num;
	}
	public String getRec_starttime() {
		return rec_starttime;
	}
	public void setRec_starttime(String rec_starttime) {
		this.rec_starttime = rec_starttime;
	}
	public String getRec_endtime() {
		return rec_endtime;
	}
	public void setRec_endtime(String rec_endtime) {
		this.rec_endtime = rec_endtime;
	}
	public int getRec_state() {
		return rec_state;
	}
	public void setRec_state(int rec_state) {
		this.rec_state = rec_state;
	}
	
	public recruitInfo(){
		super();
	}

	public recruitInfo(int sell_id,String rec_type, float rec_salary,int rec_num){
		this.sell_id = sell_id;
		this.rec_type = rec_type;
		this.rec_salary = rec_salary;
		this.rec_num = rec_num;
	}
	
}
