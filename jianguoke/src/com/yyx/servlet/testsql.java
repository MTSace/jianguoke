package com.yyx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yyx.entity.stuInfo;
import com.yyx.vae.dao.impl.stuInfoDaoImpl;

public class testsql extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//adminInfoDaoImpl adm=new adminInfoDaoImpl();
		//adminInfo my=new adminInfo();
		
		//stuInfoDaoImpl adm=new stuInfoDaoImpl();
		//stuInfo my=new stuInfo();
		
//		sellInfoDaoImpl adm = new sellInfoDaoImpl();
//		sellInfo my = new sellInfo();
		stuInfoDaoImpl stuquery=new stuInfoDaoImpl();
		stuInfo stu=new stuInfo();
		String phone="18779108081";
	
	/*
	 * adminInfo测试	
	 */
		//my.setAdmin_phone("15879080190");
		//my.setAdmin_password("091223");
		//my.setAdmin_name("yang");
		
		//my.setAdmin_id(3);
		//try {
		//adm.add(my);
		//adm.delete("15879080189");
			//adm.findById(12);
		//adm.update(my);
			                   //List<adminInfo> admin_infos =adm.findAll();
	 	                       //for (adminInfo adminInfo : admin_infos) {
				
			                   //ResultSetMetaDate m=null;
			                   //}
		
		
	/*
	 * stuInfo测试
	 */
		
	/*
		my.setStu_phone("622675");
		my.setStu_password("7777777");
		my.setStu_name("abc");
		my.setStu_school("南昌大学");
		my.setStu_grade("5");
		my.setStu_major1("计算机");
		my.setStu_major2("computer");
		my.setStu_special("笛子");
		my.setStu_level(3);
		my.setStu_identstate(41);
		
		try {
		//adm.add(my);
		adm.updatename(my);
		adm.updatepassword(my);
		adm.updatemajor1(my);
		adm.updatemajor2(my);
		adm.updateschool(my);
		adm.updatespecial(my);
		adm.updategrade(my);
		adm.updatelevel(my);
		adm.updateidentstate(my);
		//adm.delete("622675");
*/
		
/*
 * sellInfo测试
 */
//		my.setSell_id(4);
//		my.setSell_password("340qwerwe826");
//		my.setSell_name("3408wer26");
//		my.setSell_type("3408wqerqwe26");
//		my.setSell_liceid("3rqwe40826");
//		my.setSell_addr("340rqwer826");
//		my.setSell_phone1("34qwer0826");
//		my.setSell_phone2("34qwerqwerqwe826");
//		my.setSell_level(10);
//		my.setSell_identstate(100);
		
		try{
//		    adm.add(my);
			//adm.delete(2);
//			adm.updatepassword(my);
//			adm.updatetype(my);
//			adm.updateaddr(my);
//			adm.updatephone1(my);
//			adm.updatephone2(my);
//			adm.updatelevel(my);
//			adm.updateidentstate(my);
//			out.println(my.toString());
			stu=stuquery.findById(phone);		
			System.out.println("电话"+stu.getStu_phone());
			System.out.println("名字"+stu.getStu_name());
			System.out.println("密码"+stu.getStu_password());
	    	out.println();
		    out.flush();
		    out.close();
	}	
		catch(SQLException e){
		e.printStackTrace();
		}
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
