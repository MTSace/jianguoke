package com.kuan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kuan.bean.PersonInfo;
import com.kuan.bean.PersonTel;
import com.kuan.dao.Result;

public class JsonServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		Result result=new Result();
		result.setResult(1);
		List<PersonInfo>list=new ArrayList<PersonInfo>();
		result.setPersonData(list);
		PersonInfo person1=new PersonInfo();
		person1.setId(1);
		person1.setName("wang");
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
		person2.setName("dhu");
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
		out.println(gson.toJson(result));
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doGet(request, response);
	}

}
