package comt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import comt.model.adminInfo;
import comt.service.adminInfoDaoimpl;

public class adInfo {
	adminInfo admin = new adminInfo();
	String isUser = "用户不存在";
	

	public adminInfo getAdmin() {
		return admin;
	}

	public void setAdmin(adminInfo admin) {
		this.admin = admin;
	}
//登录检测
	public String Login() {
		adminInfo adminget = new adminInfo();
		adminInfoDaoimpl dao = new adminInfoDaoimpl();
		List<adminInfo> adlist = new ArrayList<adminInfo>();
		try {
			adlist = dao.findAll();
			for (int i = 0; i < adlist.size(); i++) {
				if (admin.getAdmin_phone().equals(adlist.get(i).getAdmin_phone())) {
					adminget = dao.findById(admin.getAdmin_phone());
					if (adminget.getAdmin_phone() != null) {
						if (adminget.getAdmin_password().equals(admin.getAdmin_password())) {
							isUser = "密码一致用户存在";
						} else {
							isUser = "密码不一致用户存在";
						}
					}
					break;
				}
			}
			System.out.println(isUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 写入session以便从前台获取参数
		putSession(admin, isUser);
		if (isUser.equals("密码一致用户存在")) {
			return Action.SUCCESS;
		} else {
			return Action.ERROR;
		}

	}
	//添加兼职信息
	public String addinfo(){
		
		return Action.SUCCESS;
	}
	//清除用户信息
	public String clearinfo(){
		adminInfo ad=new adminInfo(null,null,null);
		putSession(ad, isUser);
		return Action.SUCCESS;
		
	}
	//网页标记  刷新不退回
	public void markPage() throws IOException{
		//不推荐用这种方式，struts里面应该用getterandsetter
		//获取request，并且取到ajax中的值
		HttpServletRequest request = ServletActionContext.getRequest();
		String thishref=request.getParameter("thishref");
		String mark=request.getParameter("mark");
		//写入session，目的是为了嵌入的页面刷新后还是原来的页面
		putSession(mark, thishref,request);
		//获取responses，目的是为了向前台写入数据
		HttpServletResponse responses = ServletActionContext.getResponse();
		responses.setCharacterEncoding("utf-8");  
        PrintWriter out = responses.getWriter();
        adminInfo ad=new adminInfo("test","tczxczxcest","tes6666t");
        //序列化json
        JSONObject adjson=new JSONObject(ad);
        //输出到前台页面
        out.println(adjson.toString());
        System.out.println(adjson.toString());
	}
	//写入session
    public void putSession(String key,String value,HttpServletRequest request){
    	ActionContext.getContext().getSession().put(key, value);
    	ServletActionContext.getRequest().getSession()
		.setAttribute(key, value);
    	ActionContext.getContext().put(key, value);
    	Object loginuser =request.getSession().getAttribute(key);
    	System.out.println(loginuser);
    }
    //写入session
	public void putSession(adminInfo admin, String isUser) {
		// 通过ActionContext上下文写入session
		// 访问的是map，将httpsession打包成map，降低耦合
		ActionContext.getContext().getSession().put("admin", admin);
		ActionContext.getContext().getSession().put("adminphone", admin.getAdmin_phone());
		ActionContext.getContext().getSession().put("isUser", isUser);
		// 通过ServletActionContext写入session
		// 直接继承了ActionContext
		// 提供了直接访问Servlet的相关对象的功能
		ServletActionContext.getRequest().getSession()
				.setAttribute("admin", admin);
		ServletActionContext.getRequest().getSession().setAttribute("adminphone", admin.getAdmin_phone());
		ServletActionContext.getRequest().getSession()
				.setAttribute("isUser", isUser);
		ActionContext.getContext().put("admin", admin);
		ActionContext.getContext().put("adminphone", admin.getAdmin_phone());
		ActionContext.getContext().put("isUser", isUser);
	}

}
