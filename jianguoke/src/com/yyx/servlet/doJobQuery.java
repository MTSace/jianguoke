package com.yyx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.yyx.entity.ResultRecInfo_query;
import com.yyx.entity.recruitInfo;
import com.yyx.vae.dao.impl.recruitInfoDaoImpl;

public class doJobQuery extends HttpServlet {

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
		try {	
			String rec_type="all";		
			List<recruitInfo> rec_info=new ArrayList<recruitInfo>();
			recruitInfoDaoImpl rec_info_impl=new recruitInfoDaoImpl();
			rec_info=rec_info_impl.findAll(0);			
			ResultRecInfo_query query=new ResultRecInfo_query();
			query.setResult(rec_type);
			query.setRec_query_data(rec_info);
			JSONObject obj_query = new JSONObject(query); 
			out.print(obj_query.toString());
			System.out.println(obj_query.toString());			
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
