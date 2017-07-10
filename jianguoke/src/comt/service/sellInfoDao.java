package comt.service;

import java.sql.SQLException;
import java.util.List;

import comt.model.sellInfo;



public interface sellInfoDao {
	//添加方法
	public void add(sellInfo p)throws SQLException;
	//更新方法
	public void update(sellInfo p)throws SQLException;
	//删除方法
	public void delete(String sell_id)throws SQLException;
	//查找方法
	public sellInfo findById(String sell_id)throws SQLException;
	//查找所有
	public List<sellInfo> findAll()throws SQLException;
}