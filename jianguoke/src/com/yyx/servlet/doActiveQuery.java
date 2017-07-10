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

import com.yyx.entity.activePush;
import com.yyx.vae.dao.impl.activePushDaoImpl;

public class doActiveQuery extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
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
		BufferedReader br = new BufferedReader(new InputStreamReader(
				request.getInputStream(), "utf-8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
			// sb.append(URLDecoder.decode(line,"utf-8"));
		}
		// 将资料解码
		String reqBody = sb.toString();
		System.out.println(reqBody);
		JSONObject obj;
		try {
			String title = null;	
			obj = new JSONObject(reqBody);
			System.out.println(obj.toString());
			for (int i = 0; i < obj.length(); i++) {
				title = obj.getString("type");
			}
				activePush act_info = new activePush();
				activePushDaoImpl ac_impl=new activePushDaoImpl();
				act_info=ac_impl.findBytitle(title);
				JSONObject obj_query = new JSONObject(act_info);
				out.print(obj_query.toString());
				System.out.println(obj_query.toString());			
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
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
