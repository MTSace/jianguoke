package comt.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import comt.model.adminInfo;
import comt.util.DBUtils;

public class adminInfoDaoimpl implements adminInfoDao{


	/**
	 * 实现添加方法
	 */
	@Override
	public void add(adminInfo p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String admininsertsql = "insert into admin_info(admin_phone,admin_password,admin_name) values(?,?,?)";
		try {
			System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(admininsertsql);
			ps.setString(1, p.getAdmin_phone());
			ps.setString(2, p.getAdmin_password());
			ps.setString(3, p.getAdmin_name());
			ps.executeUpdate();
			System.out.println(p.getAdmin_name());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("添加数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/**
	 * 更新方法
	 */
	@Override
	public void update(adminInfo p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update admin_info set admin_password=?,admin_name=? where admin_phone=?";
		try {
			System.out.println(p.toString());
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(3, p.getAdmin_phone());
			ps.setString(1, p.getAdmin_password());
			ps.setString(2, p.getAdmin_name());
			ps.executeUpdate();
			System.out.println(p.getAdmin_name());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("更新数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/**
	 * 删除方法
	 */
	@Override
	public void delete(String admin_phone) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from admin_info where admin_phone=?";
		try {
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, admin_phone);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("删除数据失败");
		} finally {
			DBUtils.close(null, ps, conn);
		}
	}

	/**
	 * 根据phone查询一个对象
	 * 
	 * @return
	 */
	@Override
	public adminInfo findById(String admin_phone) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		adminInfo p = null;
		String sql = "select admin_phone,admin_password,admin_name from admin_info where admin_phone=?";
		try {
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, admin_phone);
			rs = ps.executeQuery();
			if (rs.next()) {
				p = new adminInfo();
				p.setAdmin_phone(rs.getString(1));
				p.setAdmin_password(rs.getString(2));
				p.setAdmin_name(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("根据ID查询数据失败");
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		return p;
	}

	/**
	 * 查询所有数据
	 */
	@Override
	public List<adminInfo> findAll() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		adminInfo p = null;
		List<adminInfo> admin_infos = new ArrayList<adminInfo>();
		String sql = "select admin_phone,admin_password,admin_name from admin_info";
		try {
			conn = (Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new adminInfo();
				p.setAdmin_phone(rs.getString(1));
				p.setAdmin_password(rs.getString(2));
				p.setAdmin_name(rs.getString(3));
				admin_infos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("查询所有数据");
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		return admin_infos;
	}

}
