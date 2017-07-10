package comt.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import comt.model.adminInfo;
import comt.model.sellInfo;
import comt.util.DBUtils;

public class sellInfoDaoImpl {
	/**
	 * 实现添加方法
	 */ 
	public void add(sellInfo p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps = null;
		String admininsertsql="insert into sell_info(sell_password,sell_name,sell_type,sell_liceid,sell_addr,sell_phone1,sell_phone2)  values(?,?,?,?,?,?,?)";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(admininsertsql);
			ps.setString(1, p.getSell_password());
			ps.setString(2, p.getSell_name());
			ps.setString(3, p.getSell_type());
			ps.setString(4, p.getSell_liceid());
			ps.setString(5, p.getSell_addr());
			ps.setString(6, p.getSell_phone1());
			ps.setString(7, p.getSell_phone2());
			ps.executeUpdate();
			System.out.println(p.getSell_name());
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
		 * 删除方法
		 */
		public void delete(int sell_id) throws SQLException{
			Connection conn=null;
			PreparedStatement ps=null;
			String sql="delete from sell_info where sell_id=?";
			try{
				conn=(Connection) DBUtils.getConnection();
				ps=(PreparedStatement) conn.prepareStatement(sql);
				ps.setInt(1,sell_id);
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
		 *修改密码
		 */
		public void updatepassword(sellInfo p) throws SQLException{
			Connection conn=null;
			PreparedStatement ps=null;
			String sql="update sell_info set sell_password=? where sell_id=?";
			try{
				conn=(Connection) DBUtils.getConnection();
				ps=(PreparedStatement) conn.prepareStatement(sql);
				ps.setString(1,p.getSell_password());
				ps.setInt(2,p.getSell_id());
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
		 *修改类型
		 */
		public void updatetype(sellInfo p) throws SQLException{
			Connection conn=null;
			PreparedStatement ps=null;
			String sql="update sell_info set sell_type=? where sell_id=?";
			try{
				conn=(Connection) DBUtils.getConnection();
				ps=(PreparedStatement) conn.prepareStatement(sql);
				ps.setString(1,p.getSell_type());
				ps.setInt(2,p.getSell_id());
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
		 *修改商家地址
		 */
		public void updateaddr(sellInfo p) throws SQLException{
			Connection conn=null;
			PreparedStatement ps=null;
			String sql="update sell_info set sell_addr=? where sell_id=?";
			try{
				conn=(Connection) DBUtils.getConnection();
				ps=(PreparedStatement) conn.prepareStatement(sql);
				ps.setString(1,p.getSell_addr());
				ps.setInt(2,p.getSell_id());
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
		 *修改商家电话1
		 */
		public void updatephone1(sellInfo p) throws SQLException{
			Connection conn=null;
			PreparedStatement ps=null;
			String sql="update sell_info set sell_phone1=? where sell_id=?";
			try{
				conn=(Connection) DBUtils.getConnection();
				ps=(PreparedStatement) conn.prepareStatement(sql);
				ps.setString(1,p.getSell_phone1());
				ps.setInt(2,p.getSell_id());
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
		 *修改商家电话2
		 */
		public void updatephone2(sellInfo p) throws SQLException{
			Connection conn=null;
			PreparedStatement ps=null;
			String sql="update sell_info set sell_phone2=? where sell_id=?";
			try{
				conn=(Connection) DBUtils.getConnection();
				ps=(PreparedStatement) conn.prepareStatement(sql);
				ps.setString(1,p.getSell_phone2());
				ps.setInt(2,p.getSell_id());
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
		 *修改商家等级
		 */
		public void updatelevel(sellInfo p) throws SQLException{
			Connection conn=null;
			PreparedStatement ps=null;
			String sql="update sell_info set sell_level=? where sell_id=?";
			try{
				conn=(Connection) DBUtils.getConnection();
				ps=(PreparedStatement) conn.prepareStatement(sql);
				ps.setInt(1,p.getSell_level());
				ps.setInt(2,p.getSell_id());
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
		 *修改商家认证状态
		 */
		public void updateidentstate(sellInfo p) throws SQLException{
			Connection conn=null;
			PreparedStatement ps=null;
			String sql="update sell_info set sell_identstate=? where sell_id=?";
			try{
				conn=(Connection) DBUtils.getConnection();
				ps=(PreparedStatement) conn.prepareStatement(sql);
				ps.setInt(1,p.getSell_identstate());
				ps.setInt(2,p.getSell_id());
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
		public sellInfo findById(int sell_id)throws SQLException{
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			sellInfo p = null;

			try{
				conn=(Connection) DBUtils.getConnection();
				String sql="select sell_name,sell_type,sell_addr,sell_phone1,sell_phone2,sell_level,sell_identstate from sell_info where sell_id=?";
				ps=(PreparedStatement) conn.prepareStatement(sql);
				ps.setInt(1, sell_id);
				rs=ps.executeQuery();
				while(rs.next()){
					p=new sellInfo();
					p.setSell_id(sell_id);
					p.setSell_name(rs.getString(1));
					p.setSell_type(rs.getString(2));
					p.setSell_addr(rs.getString(3));
					p.setSell_phone1(rs.getString(4));
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