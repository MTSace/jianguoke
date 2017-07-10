package com.yyx.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.yyx.entity.ResultLogin;
import com.yyx.entity.stuInfo;
import com.yyx.vae.dao.impl.stuInfoDaoImpl;

public class doResiger extends HttpServlet {

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
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// 读取请求内容
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = br.readLine())!=null){
            sb.append(line);
        }
         //将资料解码      
        String reqBody = sb.toString();
        System.out.println(reqBody);
        JSONObject obj;
		try {
			String phone = null;
			String password = null;
			obj = new JSONObject(reqBody);
			System.out.println(obj.toString());			
			for(int i=0;i<obj.length();i++){
				phone=obj.getString("phone");
				password=obj.getString("password");
			}
			System.out.println("name="+phone);
			System.out.println("password="+password);
			stuInfoDaoImpl stuInfoDaoImpl = new stuInfoDaoImpl();
			ResultLogin ResultLogin=new ResultLogin();
			if(stuInfoDaoImpl.findById(phone)!=null){
				System.out.println("该手机已被注册");
				ResultLogin.setResult("0");
			}
			else{
				stuInfo stu=new stuInfo();
				stu.setStu_phone(phone);
				stu.setStu_password(password);
				com.yyx.vae.dao.impl.stuInfoDaoImpl.add(stu);
				System.out.println("注册成功");
				ResultLogin.setResult("1");
			}
			JSONObject JSONObject=new JSONObject(ResultLogin);
			System.out.println(JSONObject.toString());
			out.println(JSONObject);		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.print("数据解析失败！");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("数据写入失败！");
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
