package com.kuan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;



import com.kuan.bean.ToplistBean;

public class ToplistDao extends BaseDao{
	public PreparedStatement prepStmt = null;
	public ResultSet rs = null;
	public ToplistBean getUserByName(String src){
		ToplistBean userBean = null;
		try {
			conn = super.openDB();
			if(conn!=null){
				String sql = "select * from tab_user where username = ?";
				prepStmt = conn.prepareStatement(sql);
				prepStmt.setString(1,src);
				rs = prepStmt.executeQuery();
				if(rs.next()){
					userBean = new ToplistBean(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)
					rs.close();
				if(prepStmt!=null)
					prepStmt.close();
				if(conn!=null)
					conn.close();
				super.closeDB();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userBean;
	}
	
}
