package com.kuan.dao;

import java.util.ArrayList;
import java.util.List;



import com.google.gson.Gson;
import com.kuan.bean.PersonInfo;
import com.kuan.bean.PersonTel;

public class TestJon {
	public static void main(String[] args) {
		Result result=new Result();
		result.setResult(1);
		List<PersonInfo>list=new ArrayList<PersonInfo>();
		result.setPersonData(list);
		PersonInfo person1=new PersonInfo();
		person1.setId(1);
		person1.setName("样");
		person1.setPassword("test123456");
		PersonTel persontel1=new PersonTel();
		persontel1.setTel("13779177777");
		PersonTel persontel2=new PersonTel();
		persontel2.setTel("13779178888");
		List<PersonTel> persontel=new ArrayList<PersonTel>();
		persontel.add(persontel1);
		persontel.add(persontel2);
		person1.setPersonTel(persontel);
		list.add(person1);
		
		
		PersonInfo person2=new PersonInfo();
		person2.setId(2);
		person2.setName("就");
		person2.setPassword("test12345");
		PersonTel persontel3=new PersonTel();
		persontel3.setTel("13788877777");
		PersonTel persontel4=new PersonTel();
		persontel4.setTel("13779179988");
		List<PersonTel> persontel21=new ArrayList<PersonTel>();
		persontel21.add(persontel3);
		persontel21.add(persontel4);
		person2.setPersonTel(persontel21);
		list.add(person2);
		
		Gson gson=new Gson();
		System.out.println(gson.toJson(result));
	}
}
