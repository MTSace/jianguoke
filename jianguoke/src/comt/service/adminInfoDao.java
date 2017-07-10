package comt.service;

import java.sql.SQLException;
import java.util.List;

import comt.model.adminInfo;



public interface adminInfoDao {
	//添加方法
	public void add(adminInfo p)throws SQLException;
	//更新方法
	public void update(adminInfo p)throws SQLException;
	//删除方法
	public void delete(String admin_phone)throws SQLException;
	//查找方法
	public adminInfo findById(String admin_phone)throws SQLException;
	//查找所有
	public List<adminInfo> findAll()throws SQLException;
}
