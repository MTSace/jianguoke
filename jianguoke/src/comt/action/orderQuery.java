package comt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;

import comt.model.orderInfo;
import comt.model.recruitInfo;
import comt.model.sellInfo;
import comt.service.orderInfoDaoImpl;
import comt.service.recruitInfoDaoImpl;
import comt.service.sellInfoDaoImpl;

public class orderQuery {
	HttpServletRequest request = ServletActionContext.getRequest(); 
    HttpServletResponse response=ServletActionContext.getResponse();
    PrintWriter out;
    String param="{\"fail\":\"查无此订单\"}";
//根据ID查找订单
public void getorderInfo() throws IOException{
    String name = request.getParameter("data"); 
    int id = Integer.parseInt(name);
    System.out.println(name);
	orderInfoDaoImpl dao =new orderInfoDaoImpl();
	orderInfo order =new orderInfo();
	try {
		order=dao.findById(id);
		if(null==order){
			System.out.println(objectTojson(param));
			printInfo(objectTojson(param));
			}else{
				JSONObject info =JSONObject.fromObject(order);
				System.out.println(info);
				printInfo(info.toString());
			}
		
		/*JSONObject json=new JSONObject(); 
		json.accumulate("orderinfo_id", order);
		json.accumulate("success",true);
		out.println(json.toString());*/
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
//根据订单ID、招聘信息ID、联系方式模糊查询
public void queryOrders() throws SQLException, IOException{
	String info_id=request.getParameter("data");
	System.out.println(info_id);
	orderInfoDaoImpl dao= new orderInfoDaoImpl();
	List<orderInfo> info=new ArrayList<orderInfo>();
	prt("50");
	info = dao.findByOther(info_id);
	System.out.println(info);
	if(null==info){
		System.out.println("没有符合该条件的记录");
	}
	else{
		String str=JSON.toJSONString(info);
		System.out.println(str);
		printInfo(str);
	
	}
	
}
//订单详情查找
public void orderDetails() throws SQLException, IOException{
	String rec_id=request.getParameter("rec_id");
	String sell_id=request.getParameter("sell_id");
	 int re_id = Integer.parseInt(rec_id);
	 int se_id = Integer.parseInt(sell_id);
	prt(rec_id);
	prt(sell_id);
	recruitInfoDaoImpl rec=new recruitInfoDaoImpl();
	sellInfoDaoImpl sell=new sellInfoDaoImpl();
	sellInfo sell_details=new sellInfo();
	recruitInfo rec_details=new recruitInfo();
	
	rec_details=rec.findById(re_id);//根据招聘信息id查找
	sell_details=sell.findById(se_id);//根据商家id查找
	Map<String, Object> map = new HashMap<String, Object>();
	if(null==rec_details||null==sell_details){
		map.put("failed",1005);
	}else{
		String order_details[]={rec_details.getRec_type(),rec_details.getRec_salary()+"",rec_details.getRec_num()+"",rec_details.getRec_content(),sell_details.getSell_name(),sell_details.getSell_phone1(),sell_details.getSell_addr()};
		prt(order_details[0]);
		map.put("order_details",order_details);
		map.put("success",true);	
	}
	String str=JSON.toJSONString(map);	
	prt(str);
	 printInfo(str);
}
//根据薪酬筛选查询
public void salaryQuery() throws SQLException, IOException{
	String min_sal=request.getParameter("min-salary");
	String max_sal=request.getParameter("max-salary");
	float min= Float.parseFloat(min_sal);
	float max=Float.parseFloat(max_sal);
	prt(min_sal);
	prt(max_sal);
	orderInfoDaoImpl dao =new orderInfoDaoImpl();
	List<orderInfo> all =new ArrayList<orderInfo>();
	all=dao.findBySalary(min, max);
	Map<String, Object> map = new HashMap<String, Object>();
	if(all.isEmpty()){
		prt("数据库中没有符合条件的记录！");
		map.put("failed", 1006);
	}else{
		map.put("success", true);
		map.put("salaryquery", all);
	}
	String str=JSON.toJSONString(map);
	prt(str);
	printInfo(str);
}
//获取所有订单信息
public void getorderInfoAll() throws SQLException, IOException{
	orderInfoDaoImpl dao =new orderInfoDaoImpl();
	List<orderInfo> all_info =new ArrayList<orderInfo>();
	all_info  =dao.findAll();
	if(null==all_info){
		System.out.println("全部订单列表为空");
	}else{
		String str=JSON.toJSONString(all_info);	
		 printInfo(str);
	}
	
}
//获取已完成，未完成，已取消订单信息
public void othersOrderInfo() throws SQLException, IOException{
	String state=request.getParameter("type");
	
	orderInfoDaoImpl dao=new orderInfoDaoImpl();
	List<orderInfo> info=new ArrayList<orderInfo>();
	switch(state){
	case "已完成订单":
		System.out.println(state);
		info=dao.findBystate(22);
		if(info.isEmpty()){
			System.out.println("已完成订单列表为空");
		}
		else{
			String str=JSON.toJSONString(info);
			System.out.println(str);
			printInfo(str);
		}
		break;
	case "未完成订单":
		info=dao.findBystate(21);
		if(null==info){
			System.out.println("未完成订单列表为空");
		}
		else{
			String str=JSON.toJSONString(info);
			printInfo(str);
		}
		break;
	case "已取消订单":
		info=dao.findBystate(20);
		if(null==info){
			System.out.println("已取消的订单列表为空");
		}
		else{
			String str=JSON.toJSONString(info);
			printInfo(str);
		}
		break;
		default:break;
	}
}
public void prt(String str){
	System.out.println(str);
}
public void printInfo(String str) throws IOException{
	response.setCharacterEncoding("UTF-8"); 
	out =response.getWriter();
	out.println(str);
	out.flush();
	out.close();
}
public String objectTojson(Object obj){
	JSONObject json =JSONObject.fromObject(obj);
	String str = json.toString();
	return str;
}
public String listTojson(List<orderInfo> all_info){
	JSONArray json =JSONArray.fromObject(all_info);
	String array_str =json.toString();
	return array_str;
}
}
