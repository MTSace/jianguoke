package com.yyx.vae.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.yyx.entity.mrecInfo;
import com.yyx.util.db.DBUtils;

public class mrecInfoDaoImpl {
	/**
	 * 实现添加方法
	 */
	public int add(mrecInfo p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String mrecInfoAddsql = "insert into mrec_info(mrec_sendid,mrec_receiveid,mrec_type,mrec_content) VALUES(?,?,?,?)";
		try {
			// System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(mrecInfoAddsql);
			ps.setString(1, p.getMrec_sendid());
			ps.setString(2, p.getMrec_receiveid());
			ps.setString(3, p.getMrec_type());
			ps.setString(4, p.getMrec_content());
			ps.executeUpdate();
			System.out.println(p.getMrec_sendid());
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("添加数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/*
	 * 删除方法
	 */
	public void delete(mrecInfo p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String deletesql = "delete from mrec_info where mrec_infoid=?";
		try {
			System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(deletesql);
			ps.setInt(1, p.getMrec_infoid());
			ps.executeUpdate();
			System.out.println(p.getMrec_infoid());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("删除数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/*
	 * 修改微招信息类型
	 */
	public void updatetype(mrecInfo p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String updatetypesql = "update mrec_info set mrec_type=? where mrec_infoid=?";
		try {
			System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(updatetypesql);
			ps.setString(1, p.getMrec_type());
			ps.setInt(2, p.getMrec_infoid());
			ps.executeUpdate();
			System.out.println(p.getMrec_infoid());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	public void updatecontent(mrecInfo p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String updatecontentsql = "update mrec_info set mrec_content=? where mrec_infoid=?";
		try {
			System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(updatecontentsql);
			ps.setString(1, p.getMrec_content());
			ps.setInt(2, p.getMrec_infoid());
			ps.executeUpdate();
			System.out.println(p.getMrec_infoid());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	public void updatestate(mrecInfo p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String updatestatesql = "update mrec_info set mrec_state=? where mrec_infoid=?";
		try {
			System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(updatestatesql);
			ps.setInt(1, p.getMrec_state());
			ps.setInt(2, p.getMrec_infoid());
			ps.executeUpdate();
			System.out.println(p.getMrec_infoid());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/**
	 * 根据mrec_infoid查询一个对象
	 * 
	 * @return
	 */
	public mrecInfo findById(int mrec_infoid) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		mrecInfo p = null;

		try {
			conn = (Connection) DBUtils.getConnection();
			String sql = "select mrec_infoid,mrec_sendid,mrec_receiveid,mrec_type,mrec_content,mrec_state,mrec_starttime,mrec_endtime from mrec_info where mrec_infoid=?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, mrec_infoid);
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new mrecInfo();
				p.setMrec_infoid(rs.getInt(1));
				p.setMrec_sendid(rs.getString(2));
				p.setMrec_receiveid(rs.getString(3));
				p.setMrec_type(rs.getString(4));
				p.setMrec_content(rs.getString(5));
				p.setMrec_state(rs.getInt(6));
				p.setMrec_starttime(rs.getString(7));
				p.setMrec_endtime(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("根据ID查询数据失败");
			// System.out.println("查询数据失败");
		} finally {
			// System.out.println("查询数据失败");
			DBUtils.close(rs, ps, conn);
		}
		return p;
	}
	/**
	 * 查询所有数据
	 */
	public List<mrecInfo> findAll(int a, int b) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		mrecInfo p = null;
		List<mrecInfo> mrec_infos = new ArrayList<mrecInfo>();
		String sql = "select * from mrec_info limit ?,?";
		try {
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, a);
			ps.setInt(2, 5);
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new mrecInfo();
				p.setMrec_infoid(rs.getInt(1));
				p.setMrec_sendid(rs.getString(2));
				p.setMrec_receiveid(rs.getString(3));
				p.setMrec_type(rs.getString(4));
				p.setMrec_content(rs.getString(5));
				p.setMrec_state(rs.getInt(6));
				p.setMrec_starttime(rs.getString(7));
				p.setMrec_endtime(rs.getString(8));
				mrec_infos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("查询所有数据");
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		return mrec_infos;
	}
	/**
	 * 查询某个人所有的微招数据
	 */
	public List<mrecInfo> findAll(int a, int b,String phone) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		mrecInfo p = null;
		List<mrecInfo> mrec_infos = new ArrayList<mrecInfo>();
		String sql = "select * from mrec_info where mrec_sendid= ? limit ?,?";
		try {
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1,phone);
			ps.setInt(2, a);
			ps.setInt(3, 5);
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new mrecInfo();
				p.setMrec_infoid(rs.getInt(1));
				p.setMrec_sendid(rs.getString(2));
				p.setMrec_receiveid(rs.getString(3));
				p.setMrec_type(rs.getString(4));
				p.setMrec_content(rs.getString(5));
				p.setMrec_state(rs.getInt(6));
				p.setMrec_starttime(rs.getString(7));
				p.setMrec_endtime(rs.getString(8));
				mrec_infos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("查询所有数据");
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		return mrec_infos;
	}

	/**
	 * 按照类型查询
	 */
	public List<mrecInfo> findtype() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		mrecInfo p = null;
		List<mrecInfo> mrec_infos = new ArrayList<mrecInfo>();
		String sql = "select * from mrec_info where mrec_type = ?";
		try {
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, p.getMrec_type());
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new mrecInfo();
				p.setMrec_infoid(rs.getInt(1));
				p.setMrec_sendid(rs.getString(2));
				p.setMrec_receiveid(rs.getString(3));
				p.setMrec_type(rs.getString(4));
				p.setMrec_content(rs.getString(5));
				p.setMrec_state(rs.getInt(6));
				p.setMrec_starttime(rs.getString(7));
				p.setMrec_endtime(rs.getString(8));
				mrec_infos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("查询所有数据");
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		return mrec_infos;
	}
}
