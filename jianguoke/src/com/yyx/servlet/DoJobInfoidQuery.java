package com.yyx.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.yyx.entity.ResultRecInfo_query;
import com.yyx.entity.recruitInfo;
import com.yyx.vae.dao.impl.recruitInfoDaoImpl;

public class DoJobInfoidQuery extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			System.out.println(line);
			sb.append(line);
			// sb.append(URLDecoder.decode(line,"utf-8"));
		}
		// 将资料解码
		String reqBody = sb.toString();
		System.out.println(reqBody);
		JSONObject obj;
		int rec_infoid = 0;
		try {
			obj = new JSONObject(reqBody);
			System.out.println(obj.toString());
			for (int i = 0; i < obj.length(); i++) {
				rec_infoid = Integer.parseInt(obj.getString("rec_infoid"));
			}
			List<recruitInfo> rec_info1 = new ArrayList<recruitInfo>();
			recruitInfoDaoImpl rec_info_impl = new recruitInfoDaoImpl();
			recruitInfo rec_info = rec_info_impl.findById(rec_infoid);
			System.out.print(rec_info.getRec_type());
			rec_info1.add(rec_info);
			ResultRecInfo_query query = new ResultRecInfo_query();
			query.setResult(rec_infoid + "");
			query.setRec_query_data(rec_info1);
			JSONObject obj_query = new JSONObject(query);
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
}
