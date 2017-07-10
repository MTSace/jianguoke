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

import com.yyx.entity.ResultOrder;
import com.yyx.entity.orderInfo;
import com.yyx.entity.stuInfo;
import com.yyx.vae.dao.impl.orderInfoDaoImpl;
import com.yyx.vae.dao.impl.stuInfoDaoImpl;

public class Orderservlet extends HttpServlet{

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
        while((line = br.readLine())!=null)
        {
            sb.append(line);
        }
         //将资料解码      
        String reqBody = sb.toString();
        System.out.println(reqBody);
        JSONObject obj = null;
        int a=0;
			String phone = null;
			int rec_infoid = 0;
				try {
					obj = new JSONObject(reqBody);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			System.out.println(obj.toString());	
			
			for(int i=0;i<obj.length();i++)
			{
				try {
					phone=obj.getString("phone");
					rec_infoid=Integer.parseInt(obj.getString("rec_infoid"));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//得到用户手机号码与已发布订单的id
			}
			stuInfoDaoImpl stuInfoDaoImpl = new stuInfoDaoImpl();
			stuInfo stuInfo = null;
			System.out.println("phone="+phone);
			System.out.println("rec_infoid="+rec_infoid);
			orderInfoDaoImpl orderInfoDaoImpl=new orderInfoDaoImpl();
			ResultOrder ResultOrder=new ResultOrder();
						try {
							if(orderInfoDaoImpl.checkOrder(phone, rec_infoid))
							{   //查找用户是否申请了此单
								System.out.println("此用户已申请了此单");
								ResultOrder.setResult("null");
							}
							else{
								ResultOrder.setResult("order");
								orderInfo orderInfo=new orderInfo();
								orderInfo.setRec_infoid(rec_infoid);
								orderInfo.setStu_id(phone);
								orderInfoDaoImpl.add(orderInfo);   //创建订单
								List<orderInfo> orderInfo_data=new ArrayList<orderInfo>();
								orderInfo_data = orderInfoDaoImpl.findByPhone(phone);
								ResultOrder.setOrderInfo_data(orderInfo_data);
								}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JSONObject JSONObject=new JSONObject(ResultOrder);
						out.print(JSONObject.toString());
						System.out.println(JSONObject.toString());
			}
						

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	}
