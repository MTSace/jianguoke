package com.yyx.vae.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.yyx.entity.stuInfo;
import com.yyx.entity.adminInfo;
import com.yyx.util.db.DBUtils;

public class stuInfoDaoImpl {
	/**
	 * 实现添加方法
	 */ 
	public static void add(stuInfo p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps = null;
		String admininsertsql="insert into stu_info(stu_phone,stu_password,stu_name,stu_sex,stu_school,stu_major1,stu_special,stu_grade) values(?,?,?,?,?,?,?,?)";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(admininsertsql);
			ps.setString(1, p.getStu_phone());
			ps.setString(2, p.getStu_password());
			ps.setString(3, p.getStu_name());
			ps.setString(4, p.getStu_sex());
			ps.setString(5, p.getStu_school());
			ps.setString(6, p.getStu_major1());
			ps.setString(7, p.getStu_special());
			ps.setString(8, p.getStu_grade());
			ps.executeUpdate();
			System.out.println(p.getStu_name());
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("添加数据失败");
		}
		finally{
			DBUtils.close(null,ps,conn);
		}
	}
	
	/**
	 * 更新方法
	 */
	/*
	 * 修改密码
	 */
	public void updatepassword(stuInfo p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="update stu_info set stu_password=? where stu_phone=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, p.getStu_password());
			ps.setString(2, p.getStu_phone());
			ps.executeUpdate();
			//System.out.println(p.getStu_name());
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		}
		finally{
			DBUtils.close(null, ps, conn);
		}
	}
	
	/*
	 * 修改名字
	 */
	public void updatename(stuInfo p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="update stu_info set stu_name=? where stu_phone=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, p.getStu_name());
			ps.setString(2, p.getStu_phone());
			ps.executeUpdate();
			//System.out.println(p.getStu_name());
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		}
		finally{
			DBUtils.close(null, ps, conn);
		}
	}
	/*
	 * 修改学校
	 */
	public void updateschool(stuInfo p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="update stu_info set stu_school=? where stu_phone=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, p.getStu_school());
			ps.setString(2, p.getStu_phone());
			ps.executeUpdate();
			//System.out.println(p.getStu_name());
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		}
		finally{
			DBUtils.close(null, ps, conn);
		}
	}
	
	/*
	 * 修改第一专业
	 */
	public void updatemajor1(stuInfo p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="update stu_info set stu_major1=? where stu_phone=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, p.getStu_major1());
			ps.setString(2, p.getStu_phone());
			ps.executeUpdate();
			//System.out.println(p.getStu_name());
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		}
		finally{
			DBUtils.close(null, ps, conn);
		}
	}
	
	/*
	 * 修改第二专业
	 */
	public void updatemajor2(stuInfo p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="update stu_info set stu_major2=? where stu_phone=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, p.getStu_major2());
			ps.setString(2, p.getStu_phone());
			ps.executeUpdate();
			//System.out.println(p.getStu_name());
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		}
		finally{
			DBUtils.close(null, ps, conn);
		}
	}
	
	/*
	 * 修改特长
	 */
	public void updatespecial(stuInfo p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="update stu_info set stu_special=? where stu_phone=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, p.getStu_special());
			ps.setString(2, p.getStu_phone());
			ps.executeUpdate();
			//System.out.println(p.getStu_name());
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		}
		finally{
			DBUtils.close(null, ps, conn);
		}
	}
	
	/*
	 * 修改年级
	 */
	public void updategrade(stuInfo p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="update stu_info set stu_grade=? where stu_phone=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, p.getStu_grade());
			ps.setString(2, p.getStu_phone());
			ps.executeUpdate();
			//System.out.println(p.getStu_name());
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		}
		finally{
			DBUtils.close(null, ps, conn);
		}
	}
	/*
	 * 修改信用评级
	 */
	public void updatelevel(stuInfo p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="update stu_info set stu_level=? where stu_phone=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, p.getStu_level());
			ps.setString(2, p.getStu_phone());
			ps.executeUpdate();
			//System.out.println(p.getStu_name());
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		}
		finally{
			DBUtils.close(null, ps, conn);
		}
	}
	
	/*
	 * 修改用户状态
	 */
	public void updateidentstate(stuInfo p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="update stu_info set stu_identstate=? where stu_phone=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, p.getStu_identstate());
			ps.setString(2, p.getStu_phone());
			ps.executeUpdate();
			//System.out.println(p.getStu_name());
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		}
		finally{
			DBUtils.close(null, ps, conn);
		}
	}
	/*
	 * 修改全部
	 */
	public void updateall(stuInfo p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="update stu_info set stu_password=?,stu_name=?,stu_sex=?,stu_school=?,stu_major1=?,stu_major2=?,stu_special=?,stu_grade=? where stu_phone=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, p.getStu_password());
			ps.setString(2, p.getStu_name());
			ps.setString(3, p.getStu_sex());
			ps.setString(4, p.getStu_school());
			ps.setString(5, p.getStu_major1());
			ps.setString(6, p.getStu_major2());
			ps.setString(7, p.getStu_special());
			ps.setString(8, p.getStu_grade());
			ps.setString(9, p.getStu_phone());
			ps.executeUpdate();
			//System.out.println(p.getStu_name());
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		}
		finally{
			DBUtils.close(null, ps, conn);
		}
	}
	
	/**
	 * 删除方法
	 */
	public void delete(String stu_phone) throws SQLException{
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="delete from stu_info where stu_phone=?";
		try{
			conn=(Connection) DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1,stu_phone);
			ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("删除数据失败");
		}
		finally{
			DBUtils.close(null,ps,conn);
		}
	}
	
		/**
	 * 根据phone查询一个对象
	 * @return 
	 */
	public stuInfo findById(String stu_phone)throws SQLException{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		stuInfo p = null;
		String sql="select * from stu_info where stu_phone=?";
		try{
			conn=(Connection) DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, stu_phone);
			rs=ps.executeQuery();
			if(rs.next()){
				p=new stuInfo();
				p.setStu_phone(rs.getString(1));
				p.setStu_password(rs.getString(2));
				p.setStu_name(rs.getString(3));
				p.setStu_sex(rs.getString(4));
				p.setStu_school(rs.getString(5));
				p.setStu_major1(rs.getString(6));
				p.setStu_major2(rs.getString(7));
				p.setStu_special(rs.getString(8));
				p.setStu_grade(rs.getString(9));
				p.setStu_level(rs.getInt(10));
				p.setStu_identstate(rs.getInt(11));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("根据ID查询数据失败");
		}
		finally{
			DBUtils.close(rs, ps, conn);
		}
		return p;
	}
	
	/**
	 * 查询所有数据
	 */
	public List<adminInfo> findAll() throws SQLException{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		adminInfo p = null;
		List<adminInfo> admin_infos = new ArrayList<adminInfo>();
		String sql = "select admin_phone,admin_password,admin_name from admin_info";
		try{
			conn=(Connection) DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				p = new adminInfo();
				p.setAdmin_phone(rs.getString(1));
				p.setAdmin_password(rs.getString(2));
				p.setAdmin_name(rs.getString(3));
				admin_infos.add(p);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("查询所有数据");
		}
		finally{
			DBUtils.close(rs, ps, conn);
		}
		 return  admin_infos;
	}
}
