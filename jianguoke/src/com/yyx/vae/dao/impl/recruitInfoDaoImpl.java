package com.yyx.vae.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.yyx.entity.recruitInfo;
import com.yyx.util.db.DBUtils;

public class recruitInfoDaoImpl {
	/**
	 * 实现添加方法
	 */
	public void add(recruitInfo p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String stuIdeaAddsql = "insert into recruit_info(sell_id,rec_type,rec_salary,rec_num) VALUES(?,?,?,?)";
		try {
			// System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(stuIdeaAddsql);
			ps.setInt(1, p.getSell_id());
			ps.setString(2, p.getRec_type());
			ps.setFloat(3, p.getRec_salary());
			ps.setInt(4, p.getRec_num());
			ps.executeUpdate();
			System.out.println(p.getSell_id());
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
	public void delete(recruitInfo p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String recruitInfodeletesql = "delete from recruit_info where rec_infoid=?";
		try {
			System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn
					.prepareStatement(recruitInfodeletesql);
			ps.setInt(1, p.getRec_infoid());
			ps.executeUpdate();
			System.out.println(p.getRec_infoid());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("删除数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/*
	 * 修改招聘信息薪酬
	 */
	public void updaterecruitInfosalary(recruitInfo p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String updaterecruitInfosalarysql = "update recruit_info set rec_salary=? where rec_infoid=?";
		try {
			System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn
					.prepareStatement(updaterecruitInfosalarysql);
			ps.setFloat(1, p.getRec_salary());
			ps.setInt(2, p.getRec_infoid());
			ps.executeUpdate();
			System.out.println(p.getRec_infoid());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/*
	 * 修改招聘招聘人数
	 */
	public void updaterecruitInfonum(recruitInfo p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String updaterecruitInfonumsql = "update recruit_info set rec_num=? where rec_infoid=?";
		try {
			System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn
					.prepareStatement(updaterecruitInfonumsql);
			ps.setFloat(1, p.getRec_num());
			ps.setInt(2, p.getRec_infoid());
			ps.executeUpdate();
			System.out.println(p.getRec_infoid());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/*
	 * 修改招聘招聘人数
	 */
	public void updaterecruitInfostate(recruitInfo p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String updaterecruitInfostatesql = "update recruit_info set rec_state=? where rec_infoid=?";
		try {
			System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn
					.prepareStatement(updaterecruitInfostatesql);
			ps.setFloat(1, p.getRec_state());
			ps.setInt(2, p.getRec_infoid());
			ps.executeUpdate();
			System.out.println(p.getRec_infoid());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/**
	 * 根据receiveInfo查询一个对象
	 * 
	 * @return
	 */
	public recruitInfo findById(int rec_infoid) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		recruitInfo p = null;
		try {
			conn = (Connection) DBUtils.getConnection();
			String sql = "select rec_infoid,sell_id,rec_type,rec_salary,rec_num,rec_starttime,rec_endtime,rec_state,rec_content from recruit_info where rec_infoid=?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, rec_infoid);
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new recruitInfo();
				p.setRec_infoid(rs.getInt(1));
				p.setSell_id(rs.getInt(2));
				p.setRec_type(rs.getString(3));
				p.setRec_salary(rs.getFloat(4));
				p.setRec_num(rs.getInt(5));
				p.setRec_starttime(rs.getString(6));
				p.setRec_endtime(rs.getString(7));
				p.setRec_state(rs.getInt(8));
				p.setRec_content(rs.getString(9));
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

	/*
	 * 查询所有数据
	 */
	public List<recruitInfo> findAll(int rec_max) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		recruitInfo p = null;
		List<recruitInfo> recruit_infos = new ArrayList<recruitInfo>();
		String sql = "select * from recruit_info limit ?,?";
		try {
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, rec_max);
			ps.setInt(2, 5);
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new recruitInfo();
				p.setRec_infoid(rs.getInt(1));
				p.setSell_id(rs.getInt(2));
				p.setRec_type(rs.getString(3));
				p.setRec_salary(rs.getFloat(4));
				p.setRec_num(rs.getInt(5));
				p.setRec_starttime(rs.getString(6));
				p.setRec_endtime(rs.getString(7));
				p.setRec_state(rs.getInt(8));
				p.setRec_content(rs.getString(9));
				recruit_infos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("查询所有数据");
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		return recruit_infos;
	}

	/*
	 * 按照类型查询
	 */
	public List<recruitInfo> findtype(String type, int rec_max)
			throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		recruitInfo p = null;
		List<recruitInfo> recruit_infos = new ArrayList<recruitInfo>();
		String sql = "select * from recruit_info where rec_type = ? limit ?,?  ";
		try {
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, type);
			ps.setInt(2, rec_max);
			ps.setInt(3, rec_max + 5);
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new recruitInfo();
				p.setRec_infoid(rs.getInt(1));
				p.setSell_id(rs.getInt(2));
				p.setRec_type(rs.getString(3));
				p.setRec_salary(rs.getFloat(4));
				p.setRec_num(rs.getInt(5));
				p.setRec_starttime(rs.getString(6));
				p.setRec_endtime(rs.getString(7));
				p.setRec_state(rs.getInt(8));
				recruit_infos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("查询所有数据");
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		return recruit_infos;
	}
}