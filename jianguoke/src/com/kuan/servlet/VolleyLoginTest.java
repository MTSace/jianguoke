package com.kuan.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import com.yyx.entity.stuInfo;
import com.yyx.vae.dao.stuLoginResult;
import com.yyx.vae.dao.impl.stuInfoDaoImpl;

public class VolleyLoginTest extends HttpServlet {

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
        //return URLDecoder.decode(reqBody, HTTP.UTF_8);
        System.out.println(reqBody);
        JSONObject obj;
		try {
			
			String phone = null;
			String password2 = null;
			obj = new JSONObject(reqBody);
			System.out.println(obj.toString());			
//			Gson gson=new Gson();
//			stuInfo stu=gson.fromJson(reqBody, stuInfo.class);
//			String name=stu.getStu_name();
//			String password=stu.getStu_password();
			for(int i=0;i<obj.length();i++){
				phone=obj.getString("username");
				password2=obj.getString("password");
			}
			System.out.println("phone="+phone);
			System.out.println("password="+password2);
			//获取实例
			stuInfo stu=new stuInfo();		
			stuInfoDaoImpl stuquery=new stuInfoDaoImpl();
			stu=stuquery.findById(phone);
			if(stu.getStu_phone()!=null){
				String p_password=stu.getStu_password();
				System.out.println("密码判断"+p_password);
				stuLoginResult result=new stuLoginResult();
				JSONObject p_loginJson;
				if(password2.equals(p_password)){
					result.setResult(1);
					result.setStuloginInfo(stu);					
				}else{
					result.setResult(0);
				}	
				p_loginJson=new JSONObject(result);
				out.println(p_loginJson.toString());
				System.out.println(p_loginJson.toString());
			}					
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.print("数据解析失败！");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("数据读取失败！");
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
