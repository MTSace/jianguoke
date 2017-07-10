package com.kuan.bean;

import java.util.List;

public class PersonInfo {
	private int id;
	private String name;
	private String password;
	private List<PersonTel> personTel;
	
	public List<PersonTel> getPersonTel() {
		return personTel;
	}
	public void setPersonTel(List<PersonTel> personTel) {
		this.personTel = personTel;
	}
	/*private PersonInfo(int id,String name,String password){
		id=this.id;
		name=this.name;
		password=this.password;
		
	}*/
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
