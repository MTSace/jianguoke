package com.yyx.vae.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.yyx.entity.stuIdea;
import com.yyx.util.db.DBUtils;

public class stuIdeaDaoImpl {
	/**
	 * 实现添加方法
	 */ 
	public void add(stuIdea p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps = null;
		String stuIdeaAddsql="insert into stu_idea(stu_phone,stu_idea1,stu_idea2,stu_idea3,stu_idea4,stu_idea5,stu_idea6,stu_idea7,stu_idea8) VALUES(?,?,?,?,?,?,?,?,?)";
		try{
			//System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(stuIdeaAddsql);
			ps.setString(1, p.getStu_phone());
			ps.setString(2, p.getStu_idea1());
			ps.setString(3, p.getStu_idea2());
			ps.setString(4, p.getStu_idea3());
			ps.setString(5, p.getStu_idea4());
			ps.setString(6, p.getStu_idea5());
			ps.setString(7, p.getStu_idea6());
			ps.setString(8, p.getStu_idea7());
			ps.setString(9, p.getStu_idea8());
			ps.executeUpdate();
			System.out.println(p.getStu_phone());
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
	public void delete(stuIdea p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps = null;
		String stuideadeletesql="delete from stu_idea where stu_phone=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(stuideadeletesql);
			ps.setString(1, p.getStu_phone());
			ps.executeUpdate();
			System.out.println(p.getStu_phone());
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
	 * 修改idea1
	 */
		public void updateidea1(stuIdea p) throws SQLException{
			Connection conn = null;
			PreparedStatement ps = null;
			String stuIdeaUpdateIdea1sql = "update stu_idea set stu_idea1=? where stu_phone=?";
			try{
				System.out.println(p.toString());
				conn=(Connection) DBUtils.getConnection();
				ps = (PreparedStatement) conn.prepareStatement(stuIdeaUpdateIdea1sql);
				ps.setString(1, p.getStu_idea1());
				ps.setString(2, p.getStu_phone());
				ps.executeUpdate();
				System.out.println(p.getStu_phone());
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
		 * 修改idea2
		 */
			public void updateidea2(stuIdea p) throws SQLException{
				Connection conn = null;
				PreparedStatement ps = null;
				String stuIdeaUpdateIdea2sql = "update stu_idea set stu_idea2=? where stu_phone=?";
				try{
					System.out.println(p.toString());
					conn=(Connection) DBUtils.getConnection();
					ps = (PreparedStatement) conn.prepareStatement(stuIdeaUpdateIdea2sql);
					ps.setString(1, p.getStu_idea2());
					ps.setString(2, p.getStu_phone());
					ps.executeUpdate();
					System.out.println(p.getStu_phone());
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
	 * 修改idea3
	 */
		public void updateidea3(stuIdea p) throws SQLException{
			Connection conn = null;
			PreparedStatement ps = null;
			String stuIdeaUpdateIdea3sql = "update stu_idea set stu_idea3=? where stu_phone=?";
			try{
				System.out.println(p.toString());
				conn=(Connection) DBUtils.getConnection();
				ps = (PreparedStatement) conn.prepareStatement(stuIdeaUpdateIdea3sql);
				ps.setString(1, p.getStu_idea3());
				ps.setString(2, p.getStu_phone());
				ps.executeUpdate();
				System.out.println(p.getStu_phone());
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
		 * 修改idea4
		 */
	public void updateidea4(stuIdea p) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String stuIdeaUpdateIdea4sql = "update stu_idea set stu_idea4=? where stu_phone=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(stuIdeaUpdateIdea4sql);
			ps.setString(1, p.getStu_idea4());
			ps.setString(2, p.getStu_phone());
			ps.executeUpdate();
			System.out.println(p.getStu_phone());
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
 * 修改idea5
 */
	public void updateidea5(stuIdea p) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String stuIdeaUpdateIdea5sql = "update stu_idea set stu_idea5=? where stu_phone=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(stuIdeaUpdateIdea5sql);
			ps.setString(1, p.getStu_idea5());
			ps.setString(2, p.getStu_phone());
			ps.executeUpdate();
			System.out.println(p.getStu_phone());
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
 * 修改idea6
 */
	public void updateidea6(stuIdea p) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String stuIdeaUpdateIdea6sql = "update stu_idea set stu_idea6=? where stu_phone=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(stuIdeaUpdateIdea6sql);
			ps.setString(1, p.getStu_idea6());
			ps.setString(2, p.getStu_phone());
			ps.executeUpdate();
			System.out.println(p.getStu_phone());
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
 * 修改idea7
 */
	public void updateidea7(stuIdea p) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		String stuIdeaUpdateIdea7sql = "update stu_idea set stu_idea7=? where stu_phone=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(stuIdeaUpdateIdea7sql);
			ps.setString(1, p.getStu_idea7());
			ps.setString(2, p.getStu_phone());
			ps.executeUpdate();
			System.out.println(p.getStu_phone());
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
 * 修改idea8
*/
		public void updateidea8(stuIdea p) throws SQLException{
			Connection conn = null;
			PreparedStatement ps = null;
			String stuIdeaUpdateIdea8sql = "update stu_idea set stu_idea8=? where stu_phone=?";
		    try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(stuIdeaUpdateIdea8sql);
			ps.setString(1, p.getStu_idea8());
			ps.setString(2, p.getStu_phone());
			ps.executeUpdate();
			System.out.println(p.getStu_phone());
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
		 * 根据phone查询一个对象
		 * @return 
		 */
		public stuIdea findById(String stu_phone)throws SQLException{
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			stuIdea p = null;

			try{
				conn=(Connection) DBUtils.getConnection();
				String sql="select stu_idea1,stu_idea2,stu_idea3,stu_idea4,stu_idea5,stu_idea6,stu_idea7,stu_idea8 from stu_idea where stu_phone=?";
				ps=(PreparedStatement) conn.prepareStatement(sql);
				ps.setString(1, stu_phone);
				rs=ps.executeQuery();
				while(rs.next()){
					p=new stuIdea();
					p.setStu_phone(stu_phone);
					p.setStu_idea1(rs.getString(1));
					p.setStu_idea2(rs.getString(2));
					p.setStu_idea3(rs.getString(3));
					p.setStu_idea4(rs.getString(4));
					p.setStu_idea5(rs.getString(5));
					p.setStu_idea6(rs.getString(6));
					p.setStu_idea7(rs.getString(7));
					p.setStu_idea8(rs.getString(8));
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