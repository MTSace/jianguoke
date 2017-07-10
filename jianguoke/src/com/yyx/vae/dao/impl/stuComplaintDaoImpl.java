package com.yyx.vae.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.yyx.entity.stuComplaint;
import com.yyx.util.db.DBUtils;

public class stuComplaintDaoImpl {
	/**
	 * 实现添加方法
	 */ 
	public void add(stuComplaint p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps = null;
		String stuIdeaAddsql="insert into stu_complaint(order_id,stu_comtype) VALUES(?,?)";
		try{
			//System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(stuIdeaAddsql);
			ps.setInt(1, p.getOrder_id());
			ps.setString(2, p.getStu_comtype());

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
	public void delete(stuComplaint p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps = null;
		String stuideadeletesql="delete from stu_complaint where stu_comid=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(stuideadeletesql);
			ps.setInt(1, p.getStu_comid());
			ps.executeUpdate();
			System.out.println(p.getStu_comid());
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
		public void updatestuComplaintID(stuComplaint p) throws SQLException{
			Connection conn = null;
			PreparedStatement ps = null;
			String stuComplaintUpdateIDsql = "update stu_complaint set order_id=? where stu_comid=?";
			try{
				System.out.println(p.toString());
				conn=(Connection) DBUtils.getConnection();
				ps = (PreparedStatement) conn.prepareStatement(stuComplaintUpdateIDsql);
				ps.setInt(1, p.getOrder_id());
				ps.setInt(2, p.getStu_comid());
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
			public void updatestuComplainttype(stuComplaint p) throws SQLException{
				Connection conn = null;
				PreparedStatement ps = null;
				String updatestuComplainttypesql = "update stu_complaint set stu_comtype=? where stu_comid=?";
				try{
					System.out.println(p.toString());
					conn=(Connection) DBUtils.getConnection();
					ps = (PreparedStatement) conn.prepareStatement(updatestuComplainttypesql);
					ps.setString(1, p.getStu_comtype());
					ps.setInt(2, p.getStu_comid());
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
				public void updatestuComplaintstate(stuComplaint p) throws SQLException{
					Connection conn = null;
					PreparedStatement ps = null;
					String updatestuComplaintstatesql = "update stu_complaint set stu_comstate=? where stu_comid=?";
					try{
						System.out.println(p.toString());
						conn=(Connection) DBUtils.getConnection();
						ps = (PreparedStatement) conn.prepareStatement(updatestuComplaintstatesql);
						ps.setInt(1, p.getStu_comstate());
						ps.setInt(2, p.getStu_comid());
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
				public stuComplaint findById(int stu_comid)throws SQLException{
					Connection conn=null;
					PreparedStatement ps=null;
					ResultSet rs=null;
					stuComplaint p = null;

					try{
						conn=(Connection) DBUtils.getConnection();
						String sql="select order_id,stu_comtype,stu_comstarttime,stu_comendtime,stu_comstate from stu_complaint where stu_comid=?";
						ps=(PreparedStatement) conn.prepareStatement(sql);
						ps.setInt(1, stu_comid);
						rs=ps.executeQuery();
						while(rs.next()){
							p=new stuComplaint();
							//p.setOrder_id(order_id);
							p.setStu_comtype(rs.getString(2));
							p.setStu_comstarttime(rs.getString(3));
							p.setStu_comendtime(rs.getString(4));
							p.setStu_comstate(rs.getInt(5));
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
