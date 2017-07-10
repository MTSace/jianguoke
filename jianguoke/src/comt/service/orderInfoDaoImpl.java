package comt.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import comt.model.orderInfo;
import comt.util.DBUtils;


public class orderInfoDaoImpl {
	/**
	 * 实现添加方法
	 */ 
	public void add(orderInfo p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps = null;
		String orderInfoAddsql="insert into order_info(rec_infoid,stu_phone,sell_id,order_salary,order_access) VALUES(?,?,?,?,?)";
		try{
			//System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(orderInfoAddsql);
			ps.setInt(1, p.getRec_infoid());
			ps.setString(2, p.getStu_id());
			ps.setInt(3, p.getSell_id());
			ps.setFloat(4, p.getOrder_salary());
			ps.setString(5,p.getOrder_access());
			ps.executeUpdate();
			System.out.println(p.getOrder_salary());
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
	public void delete(orderInfo p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps = null;
		String deletesql="delete from order_info where order_id=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(deletesql);
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
	 *修改订单薪酬
	 */
		public void updatesalary(orderInfo p) throws SQLException{
			Connection conn = null;
			PreparedStatement ps = null;
			String updatesalarysql = "update order_info set order_salary=? where order_id=?";
			try{
				System.out.println(p.toString());
				conn=(Connection) DBUtils.getConnection();
				ps = (PreparedStatement) conn.prepareStatement(updatesalarysql);
				ps.setFloat(1, p.getOrder_salary());
				ps.setInt(2, p.getOrder_id());
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
		 *修改订单薪酬
		 */
			public void updatestate(orderInfo p) throws SQLException{
				Connection conn = null;
				PreparedStatement ps = null;
				String updatesalarysql = "update order_info set order_state=? where order_id=?";
				try{
					System.out.println(p.toString());
					conn=(Connection) DBUtils.getConnection();
					ps = (PreparedStatement) conn.prepareStatement(updatesalarysql);
					ps.setInt(1, p.getOrder_state());
					ps.setInt(2, p.getOrder_id());
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
			 * 根据order_info查询一个对象
			* @return 
			 */
			public orderInfo findById(int string)throws SQLException{
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				orderInfo p = null;

				try{
					conn=(Connection) DBUtils.getConnection();
					String sql="select * from order_info where order_id=?";
					ps=(PreparedStatement) conn.prepareStatement(sql);
					ps.setInt(1, string);
					rs=ps.executeQuery();
					while(rs.next()){
						p=new orderInfo();
						p.setOrder_id(rs.getInt(1));
						p.setRec_infoid(rs.getInt(2));
						p.setStu_id(rs.getString(3));
						p.setSell_id(rs.getInt(4));
						p.setOrder_starttime(rs.getString(5));
						p.setOrder_endtime(rs.getString(6));
						p.setOrder_salary(rs.getFloat(7));
						p.setOrder_state(rs.getInt(8));
						p.setOrder_access(rs.getString(9));
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
			
			
			
			//	根据个人phone查出所有的订单
			public List<orderInfo> findByPhone(String phone)throws SQLException{
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				orderInfo p = null;
				List<orderInfo> orderInfo = new ArrayList<orderInfo>();

				try{
					conn=(Connection) DBUtils.getConnection();
					String sql="select * from order_info where stu_phone=?";
					ps=(PreparedStatement) conn.prepareStatement(sql);
					ps.setString(1, phone);
					rs=ps.executeQuery();
					while(rs.next()){
						p=new orderInfo();
						p.setOrder_id(rs.getInt(1));
						p.setRec_infoid(rs.getInt(2));
						p.setStu_id(rs.getString(3));
						p.setSell_id(rs.getInt(4));
						p.setOrder_starttime(rs.getString(5));
						p.setOrder_endtime(rs.getString(6));
						p.setOrder_salary(rs.getFloat(7));
						p.setOrder_state(rs.getInt(8));
						p.setOrder_access(rs.getString(9));
						orderInfo.add(p);
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
				return orderInfo;
				}
		//根据订单ID、招聘信息ID、联系方式查询符合该条件订单信息
			public List<orderInfo> findByOther(String other) throws SQLException{
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				orderInfo p=null;
				List<orderInfo> orderInfo = new ArrayList<orderInfo>();
				conn=(Connection) DBUtils.getConnection();
				try{
					int order_id=Integer.parseInt(other);
					int rec_infoid=Integer.parseInt(other);
					System.out.println(1);
					conn=(Connection) DBUtils.getConnection();
					String sql="select * from order_info where stu_phone=? or order_id=? or rec_infoid=?";
					ps=(PreparedStatement) conn.prepareStatement(sql);
					ps.setString(1,other);
					ps.setInt(2, order_id);
					ps.setInt(3, rec_infoid);
					
					System.out.println(0);
					rs=ps.executeQuery();
					while(rs.next()){
						p=new orderInfo();
						p.setOrder_id(rs.getInt(1));
						p.setRec_infoid(rs.getInt(2));
						p.setStu_id(rs.getString(3));
						p.setSell_id(rs.getInt(4));
						p.setOrder_starttime(rs.getString(5));
						p.setOrder_endtime(rs.getString(6));
						p.setOrder_salary(rs.getFloat(7));
						p.setOrder_state(rs.getInt(8));
						p.setOrder_access(rs.getString(9));
						orderInfo.add(p);
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
				return orderInfo;
			}
			//根据订单状态查找所有订单信息
			public List<orderInfo> findBystate(int state)throws SQLException{
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				orderInfo p = null;
				List<orderInfo> orderInfo = new ArrayList<orderInfo>();

				try{
					conn=(Connection) DBUtils.getConnection();
					String sql="select * from order_info where order_state=?";
					ps=(PreparedStatement) conn.prepareStatement(sql);
					ps.setInt(1, state);
					rs=ps.executeQuery();
					while(rs.next()){
						p=new orderInfo();
						p.setOrder_id(rs.getInt(1));
						p.setRec_infoid(rs.getInt(2));
						p.setStu_id(rs.getString(3));
						p.setSell_id(rs.getInt(4));
						p.setOrder_starttime(rs.getString(5));
						p.setOrder_endtime(rs.getString(6));
						p.setOrder_salary(rs.getFloat(7));
						p.setOrder_state(rs.getInt(8));
						p.setOrder_access(rs.getString(9));
						orderInfo.add(p);
					}
				}
				catch(SQLException e){
					e.printStackTrace();
					throw new SQLException("根据订单状态查询数据失败");
					//System.out.println("查询数据失败");
				}
				finally{
					//System.out.println("查询数据失败");
					DBUtils.close(rs, ps, conn);
				}
				return orderInfo;
				}
			//查找所有订单信息
			public List<orderInfo> findAll()throws SQLException{
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				orderInfo p = null;
				List<orderInfo> orderInfo = new ArrayList<orderInfo>();

				try{
					conn=(Connection) DBUtils.getConnection();
					String sql="select * from order_info ";
					ps=(PreparedStatement) conn.prepareStatement(sql);
				
					rs=ps.executeQuery();
					while(rs.next()){
						p=new orderInfo();
						p.setOrder_id(rs.getInt(1));
						p.setRec_infoid(rs.getInt(2));
						p.setStu_id(rs.getString(3));
						p.setSell_id(rs.getInt(4));
						p.setOrder_starttime(rs.getString(5));
						p.setOrder_endtime(rs.getString(6));
						p.setOrder_salary(rs.getFloat(7));
						p.setOrder_state(rs.getInt(8));
						p.setOrder_access(rs.getString(9));
						orderInfo.add(p);
					}
				}
				catch(SQLException e){
					e.printStackTrace();
					throw new SQLException("根据ID查询数据失败");
				}
				finally{
					
					DBUtils.close(rs, ps, conn);
				}
				return orderInfo;
				}
		//根据薪酬筛选
			public List<orderInfo> findBySalary(float min,float max)throws SQLException{
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				orderInfo p = null;
				List<orderInfo> orderInfo = new ArrayList<orderInfo>();

				try{
					conn=(Connection) DBUtils.getConnection();
					String sql="select * from order_info where order_salary<?";
					ps=(PreparedStatement) conn.prepareStatement(sql);
					System.out.println(1);
					ps.setFloat(1, min);
					
					rs=ps.executeQuery();
					while(rs.next()){
						p=new orderInfo();
						p.setOrder_id(rs.getInt(1));
						p.setRec_infoid(rs.getInt(2));
						p.setStu_id(rs.getString(3));
						p.setSell_id(rs.getInt(4));
						p.setOrder_starttime(rs.getString(5));
						p.setOrder_endtime(rs.getString(6));
						p.setOrder_salary(rs.getFloat(7));
						p.setOrder_state(rs.getInt(8));
						p.setOrder_access(rs.getString(9));
						orderInfo.add(p);
					}
				}
				catch(SQLException e){
					e.printStackTrace();
					throw new SQLException("根据ID查询数据失败");
				}
				finally{
					
					DBUtils.close(rs, ps, conn);
				}
				return orderInfo;
				}
			
			
			public Boolean checkOrder(String phone,int rec_infoid)throws SQLException{
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				String value;
				try{
					conn=(Connection) DBUtils.getConnection();
					String sql="select * from order_info where stu_phone=? and rec_infoid=?";
					ps=(PreparedStatement) conn.prepareStatement(sql);
					ps.setString(1, phone);
					ps.setInt(2, rec_infoid);
					rs=ps.executeQuery();
					if(rs.next()){
						value="ture";
					}
					else{
						value="false";
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
				if(value=="ture")
				{
					return true;
				}
				else{
					return false;
				}
				
				}
			
}
