package com.yyx.entity;

public class stuInfo {
	private String stu_phone;
	private String stu_password;
	private String stu_name;
	private String stu_sex;
	private String stu_school;
	private String stu_major1;
	private String stu_major2;
	private String stu_special;
	private String stu_grade;
	private int stu_level;
	private int stu_identstate;
	
	public String getStu_phone() {
		return stu_phone;
	}
	public void setStu_phone(String stu_phone) {
		this.stu_phone = stu_phone;
	}
	public String getStu_password() {
		return stu_password;
	}
	public void setStu_password(String stu_password) {
		this.stu_password = stu_password;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}
	public String getStu_school() {
		return stu_school;
	}
	public void setStu_school(String stu_school) {
		this.stu_school = stu_school;
	}
	public String getStu_major1() {
		return stu_major1;
	}
	public void setStu_major1(String stu_major1) {
		this.stu_major1 = stu_major1;
	}
	public String getStu_major2() {
		return stu_major2;
	}
	public void setStu_major2(String stu_major2) {
		this.stu_major2 = stu_major2;
	}
	public String getStu_special() {
		return stu_special;
	}
	public void setStu_special(String stu_special) {
		this.stu_special = stu_special;
	}
	public String getStu_grade() {
		return stu_grade;
	}
	public void setStu_grade(String stu_grade) {
		this.stu_grade = stu_grade;
	}
	public int getStu_level() {
		return stu_level;
	}
	public void setStu_level(int stu_level) {
		this.stu_level = stu_level;
	}
	public int getStu_identstate() {
		return stu_identstate;
	}
	public void setStu_identstate(int stu_identstate) {
		this.stu_identstate = stu_identstate;
	}
	
	
	public stuInfo(){
		super();
	}
	
	public stuInfo(String stu_phone){
		super();
		this.stu_phone = stu_phone;
	}
	
	public stuInfo(String stu_phone,String stu_password){
		super();
		this.stu_phone = stu_phone;
		this.stu_password = stu_password;
	}
	
	public stuInfo(String stu_name,String stu_sex,String stu_school,String stu_major1,String stu_grade){
		super();
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_school = stu_school;
		this.stu_major1 = stu_major1;
		this.stu_grade = stu_grade;
	} 
	
	public stuInfo(String stu_name,String stu_sex,String stu_school,String stu_major1,String stu_special,String stu_grade){
		super();
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_school = stu_school;
		this.stu_major1 = stu_major1;
		this.stu_special = stu_special;
		this.stu_grade = stu_grade;
	} 
	
	public stuInfo(String stu_phone,String stu_password,String stu_name,String stu_sex,String stu_school,String stu_major1,String stu_grade){
		super();
		this.stu_phone = stu_phone;
		this.stu_password = stu_password;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_school = stu_school;
		this.stu_major1 = stu_major1;
		this.stu_grade = stu_grade;		
	}
	
	public stuInfo(String stu_phone,String stu_password,String stu_name,String stu_sex,String stu_school,String stu_major1,String stu_special,String stu_grade){
		super();
		this.stu_phone = stu_phone;
		this.stu_password = stu_password;
		this.stu_name = stu_name;
		this.stu_sex = stu_sex;
		this.stu_school = stu_school;
		this.stu_major1 = stu_major1;
		this.stu_special = stu_special;
		this.stu_grade = stu_grade;	
	}

}
