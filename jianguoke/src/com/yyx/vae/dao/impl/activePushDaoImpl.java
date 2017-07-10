package com.yyx.vae.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.yyx.entity.activePush;
import com.yyx.util.db.DBUtils;

public class activePushDaoImpl {
	/**
	 * 实现添加方法
	 */
	public void add(activePush p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String activePushAddsql = "insert into active_push(act_content,act_image,act_starttime,act_endtime,act_state) VALUES(?,?,?,?,?)";
		try {
			// System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(activePushAddsql);
			ps.setString(1, p.getAct_content());
			ps.setString(2, p.getAct_image());
			ps.setString(3, p.getAct_starttime());
			ps.setString(4, p.getAct_endtime());
			ps.setInt(5, p.getAct_state());
			ps.executeUpdate();
			System.out.println(p.getAct_content());
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
	public void delete(activePush p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String activePushdeletesql = "delete from active_Push where act_infoid=?";
		try {
			System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(activePushdeletesql);
			ps.setInt(1, p.getAct_infoid());
			ps.executeUpdate();
			System.out.println(p.getAct_infoid());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("删除数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/*
	 * 修改idea1
	 */
	public void updateactcontent(activePush p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String Updatesql = "update active_push set act_content=? where act_infoid=?";
		try {
			System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(Updatesql);
			ps.setString(1, p.getAct_content());
			ps.setInt(2, p.getAct_infoid());
			ps.executeUpdate();
			System.out.println(p.getAct_content());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/*
	 * 修改idea1
	 */
	public void updateactstate(activePush p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String Updatesql = "update active_push set act_state=? where act_infoid=?";
		try {
			System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(Updatesql);
			ps.setInt(1, p.getAct_state());
			ps.setInt(2, p.getAct_infoid());
			ps.executeUpdate();
			System.out.println(p.getAct_content());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/*
	 * 修改活动开始时间
	 */
	public void updateastarttime(activePush p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String Updatesql = "update active_push set act_starttime=? where act_infoid=?";
		try {
			System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(Updatesql);
			ps.setString(1, p.getAct_starttime());
			ps.setInt(2, p.getAct_infoid());
			ps.executeUpdate();
			System.out.println(p.getAct_content());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/*
	 * 修改活动结束时间
	 */
	public void updateendtime(activePush p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String Updatesql = "update active_push set act_endtime=? where act_infoid=?";
		try {
			System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(Updatesql);
			ps.setString(1, p.getAct_endtime());
			ps.setInt(2, p.getAct_infoid());
			ps.executeUpdate();
			System.out.println(p.getAct_content());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/**
	 * 根据title查询一个对象
	 * 
	 * @return
	 */
	public activePush findBytitle(String act_title) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		activePush p = null;
		try {
			conn = (Connection) DBUtils.getConnection();
			String sql = "select * from active_push where act_title=?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, act_title);
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new activePush();
				p.setAct_infoid(0);
				p.setAct_content(rs.getString(1));
				p.setAct_starttime(rs.getString(3));
				p.setAct_endtime(rs.getString(4));
				p.setAct_state(rs.getInt(8));
				p.setAct_title(rs.getString(9));
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
}
