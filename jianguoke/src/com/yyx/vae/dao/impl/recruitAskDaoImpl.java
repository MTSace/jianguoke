package com.yyx.vae.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.yyx.entity.recruitAsk;
import com.yyx.util.db.DBUtils;

public class recruitAskDaoImpl {
	/**
	 * 实现添加方法
	 */ 
	public void add(recruitAsk p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps = null;
		String recruitAsksql="insert into recruit_ask(rec_infoid,rec_ask1,rec_ask2,rec_ask3,rec_ask4,rec_ask5,rec_ask6,rec_ask7,rec_ask8) VALUES(?,?,?,?,?,?,?,?,?)";
		try{
			//System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(recruitAsksql);
			ps.setInt(1, p.getRec_infoid());
			ps.setString(2, p.getRec_ask1());
			ps.setString(3, p.getRec_ask2());
			ps.setString(4, p.getRec_ask3());
			ps.setString(5, p.getRec_ask4());
			ps.setString(6, p.getRec_ask5());
			ps.setString(7, p.getRec_ask6());
			ps.setString(8, p.getRec_ask7());
			ps.setString(9, p.getRec_ask8());
			ps.executeUpdate();
			System.out.println(p.getRec_askid());
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
	public void delete(recruitAsk p) throws SQLException{
		Connection conn=null;
		PreparedStatement ps = null;
		String recruitAskdeletesql="delete from recruit_ask where rec_askid=?";
		try{
			System.out.println(p.toString());
			conn=(Connection) DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement(recruitAskdeletesql);
			ps.setInt(1, p.getRec_askid());
			ps.executeUpdate();
			System.out.println(p.getRec_askid());
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
	 * 修改要求1
	 */
		public void updateask1(recruitAsk p) throws SQLException{
			Connection conn = null;
			PreparedStatement ps = null;
			String stuIdeaUpdateAsk1sql = "update recruit_ask set rec_ask1=? where rec_askid=?";
			try{
				System.out.println(p.toString());
				conn=(Connection) DBUtils.getConnection();
				ps = (PreparedStatement) conn.prepareStatement(stuIdeaUpdateAsk1sql);
				ps.setString(1, p.getRec_ask1());
				ps.setInt(2, p.getRec_askid());
				ps.executeUpdate();
				System.out.println(p.getRec_askid());
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
		 * 修改要求2
		 */
			public void updateask2(recruitAsk p) throws SQLException{
				Connection conn = null;
				PreparedStatement ps = null;
				String stuIdeaUpdateAsk2sql = "update recruit_ask set rec_ask2=? where rec_askid=?";
				try{
					System.out.println(p.toString());
					conn=(Connection) DBUtils.getConnection();
					ps = (PreparedStatement) conn.prepareStatement(stuIdeaUpdateAsk2sql);
					ps.setString(1, p.getRec_ask2());
					ps.setInt(2, p.getRec_askid());
					ps.executeUpdate();
					System.out.println(p.getRec_askid());
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
			 * 修改要求1
			 */
				public void updateask3(recruitAsk p) throws SQLException{
					Connection conn = null;
					PreparedStatement ps = null;
					String stuIdeaUpdateAsk3sql = "update recruit_ask set rec_ask3=? where rec_askid=?";
					try{
						System.out.println(p.toString());
						conn=(Connection) DBUtils.getConnection();
						ps = (PreparedStatement) conn.prepareStatement(stuIdeaUpdateAsk3sql);
						ps.setString(1, p.getRec_ask3());
						ps.setInt(2, p.getRec_askid());
						ps.executeUpdate();
						System.out.println(p.getRec_askid());
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
				 * 修改要求1
				 */
					public void updateask4(recruitAsk p) throws SQLException{
						Connection conn = null;
						PreparedStatement ps = null;
						String stuIdeaUpdateAsk4sql = "update recruit_ask set rec_ask4=? where rec_askid=?";
						try{
							System.out.println(p.toString());
							conn=(Connection) DBUtils.getConnection();
							ps = (PreparedStatement) conn.prepareStatement(stuIdeaUpdateAsk4sql);
							ps.setString(1, p.getRec_ask4());
							ps.setInt(2, p.getRec_askid());
							ps.executeUpdate();
							System.out.println(p.getRec_askid());
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
					 * 修改要求1
					 */
						public void updateask5(recruitAsk p) throws SQLException{
							Connection conn = null;
							PreparedStatement ps = null;
							String stuIdeaUpdateAsk5sql = "update recruit_ask set rec_ask5=? where rec_askid=?";
							try{
								System.out.println(p.toString());
								conn=(Connection) DBUtils.getConnection();
								ps = (PreparedStatement) conn.prepareStatement(stuIdeaUpdateAsk5sql);
								ps.setString(1, p.getRec_ask5());
								ps.setInt(2, p.getRec_askid());
								ps.executeUpdate();
								System.out.println(p.getRec_askid());
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
						 * 修改要求1
						 */
							public void updateask6(recruitAsk p) throws SQLException{
								Connection conn = null;
								PreparedStatement ps = null;
								String stuIdeaUpdateAsk6sql = "update recruit_ask set rec_ask6=? where rec_askid=?";
								try{
									System.out.println(p.toString());
									conn=(Connection) DBUtils.getConnection();
									ps = (PreparedStatement) conn.prepareStatement(stuIdeaUpdateAsk6sql);
									ps.setString(1, p.getRec_ask6());
									ps.setInt(2, p.getRec_askid());
									ps.executeUpdate();
									System.out.println(p.getRec_askid());
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
							 * 修改要求1
							 */
								public void updateask7(recruitAsk p) throws SQLException{
									Connection conn = null;
									PreparedStatement ps = null;
									String stuIdeaUpdateAsk7sql = "update recruit_ask set rec_ask7=? where rec_askid=?";
									try{
										System.out.println(p.toString());
										conn=(Connection) DBUtils.getConnection();
										ps = (PreparedStatement) conn.prepareStatement(stuIdeaUpdateAsk7sql);
										ps.setString(1, p.getRec_ask7());
										ps.setInt(2, p.getRec_askid());
										ps.executeUpdate();
										System.out.println(p.getRec_askid());
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
								 * 修改要求8
								 */
									public void updateask8(recruitAsk p) throws SQLException{
										Connection conn = null;
										PreparedStatement ps = null;
										String stuIdeaUpdateAsk8sql = "update recruit_ask set rec_ask8=? where rec_askid=?";
										try{
											System.out.println(p.toString());
											conn=(Connection) DBUtils.getConnection();
											ps = (PreparedStatement) conn.prepareStatement(stuIdeaUpdateAsk8sql);
											ps.setString(1, p.getRec_ask8());
											ps.setInt(2, p.getRec_askid());
											ps.executeUpdate();
											System.out.println(p.getRec_askid());
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
									public recruitAsk findById(int rec_askid)throws SQLException{
										Connection conn=null;
										PreparedStatement ps=null;
										ResultSet rs=null;
										recruitAsk p = null;

										try{
											conn=(Connection) DBUtils.getConnection();
											String sql="select rec_ask1,rec_ask2,rec_ask3,rec_ask4,rec_ask5,rec_ask6,rec_ask7,rec_ask8 from recruit_ask where rec_askid=?";
											ps=(PreparedStatement) conn.prepareStatement(sql);
											ps.setInt(1, rec_askid);
											rs=ps.executeQuery();
											while(rs.next()){
												p=new recruitAsk();
												p.setRec_askid(rec_askid);
												p.setRec_ask1(rs.getString(1));
												p.setRec_ask2(rs.getString(2));
												p.setRec_ask3(rs.getString(3));
												p.setRec_ask4(rs.getString(4));
												p.setRec_ask5(rs.getString(5));
												p.setRec_ask6(rs.getString(6));
												p.setRec_ask7(rs.getString(7));
												p.setRec_ask8(rs.getString(8));
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
