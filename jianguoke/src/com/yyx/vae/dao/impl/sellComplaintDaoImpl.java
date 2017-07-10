package com.yyx.vae.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.yyx.entity.sellComplaint;
import com.yyx.util.db.DBUtils;

public class sellComplaintDaoImpl {
	/**
	 * 实现添加方法
	 */ 
	public void add(sellComplaint p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps = null;
		String stuIdeaAddsql="insert into sell_complaint(order_id,sell_comtype) VALUES(?,?)";
		try{
			//System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(stuIdeaAddsql);
			ps.setInt(1, p.getOrder_id());
			ps.setString(2, p.getSell_comtype());

			ps.executeUpdate();
			System.out.println(p.getOrder_id());
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("添加数据失败");
		}
		finally{
			DBUtils.close(null,ps,conn);
		}
	}
	/*
	 * 删除方法
	 */
	public void delete(sellComplaint p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps = null;
		String stuideadeletesql="delete from sell_complaint where order_id=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(stuideadeletesql);
			ps.setInt(1, p.getOrder_id());
			ps.executeUpdate();
			System.out.println(p.getOrder_id());
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("删除数据失败");
		}
		finally{
			DBUtils.close(null,ps,conn);
		}
	}
	/*
	 * 修改投诉订单ID
	 */
		public void updatesellComplaintID(sellComplaint p) throws SQLException{
			Connection conn = null;
			PreparedStatement ps = null;
			String sellComplaintUpdateIDsql = "update sell_complaint set order_id=? where sell_comid=?";
			try{
				System.out.println(p.toString());
				conn=(Connection) DBUtils.getConnection();
				ps = (PreparedStatement) conn.prepareStatement(sellComplaintUpdateIDsql);
				ps.setInt(1, p.getOrder_id());
				ps.setInt(2, p.getSell_comid());
				ps.executeUpdate();
				System.out.println(p.getOrder_id());
			}
			catch(SQLException e){
				e.printStackTrace();
				throw new SQLException("更新数据失败");
			}
			finally{
				DBUtils.close(null,ps,conn);
			}
 		}
		/*
		 * 修改投诉订单类型
		 */
			public void updatesellComplainttype(sellComplaint p) throws SQLException{
				Connection conn = null;
				PreparedStatement ps = null;
				String updatesellComplainttypesql = "update sell_complaint set sell_comtype=? where sell_comid=?";
				try{
					System.out.println(p.toString());
					conn=(Connection) DBUtils.getConnection();
					ps = (PreparedStatement) conn.prepareStatement(updatesellComplainttypesql);
					ps.setString(1, p.getSell_comtype());
					ps.setInt(2, p.getSell_comid());
					ps.executeUpdate();
					System.out.println(p.getOrder_id());
				}
				catch(SQLException e){
					e.printStackTrace();
					throw new SQLException("更新数据失败");
				}
				finally{
					DBUtils.close(null,ps,conn);
				}
	 		}
			/*
			 * 修改投诉订单投诉状态
			 */
				public void updatesellComplaintstate(sellComplaint p) throws SQLException{
					Connection conn = null;
					PreparedStatement ps = null;
					String updatesellComplaintstatesql = "update sell_complaint set sell_comstate=? where sell_comid=?";
					try{
						System.out.println(p.toString());
						conn=(Connection) DBUtils.getConnection();
						ps = (PreparedStatement) conn.prepareStatement(updatesellComplaintstatesql);
						ps.setInt(1, p.getSell_comstate());
						ps.setInt(2, p.getSell_comid());
						ps.executeUpdate();
						System.out.println(p.getOrder_id());
					}
					catch(SQLException e){
						e.printStackTrace();
						throw new SQLException("更新数据失败");
					}
					finally{
						DBUtils.close(null,ps,conn);
					}
		 		}
/**
 * 根据order_id查询一个对象
* @return 
 */
public sellComplaint findById(int order_id)throws SQLException{
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	sellComplaint p = null;

	try{
		conn=(Connection) DBUtils.getConnection();
		String sql="select order_id,sell_comtype,sell_comstarttime,sell_comendtime,sell_comstate from sell_complaint where order_id=?";
		ps=(PreparedStatement) conn.prepareStatement(sql);
		ps.setInt(1, order_id);
		rs=ps.executeQuery();
		while(rs.next()){
			p=new sellComplaint();
			p.setOrder_id(order_id);
			p.setSell_comtype(rs.getString(2));
			p.setSell_comstarttime(rs.getString(3));
			p.setSell_comendtime(rs.getString(4));
			p.setSell_comstate(rs.getInt(5));
		}
	}
	catch(SQLException e){
		e.printStackTrace();
		throw new SQLException("根据ID查询数据失败");
		//System.out.println("查询数据失败");
	}
	finally{
		//System.out.println("查询数据失败");
		DBUtils.close(rs, ps, conn);
	}
	return p;
	}
}