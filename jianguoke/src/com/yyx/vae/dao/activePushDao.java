package com.yyx.vae.dao;

import java.sql.SQLException;
import java.util.List;

import com.yyx.entity.activePush;

public interface activePushDao {
	//添加方法
	public void add(activePush p)throws SQLException;
	//更新方法
	public void update(activePush p)throws SQLException;
	//删除方法
	public void delete(String act_infoid)throws SQLException;
	//查找方法
	public activePush findById(String act_infoid)throws SQLException;
	//查找所有
	public List<activePush> findAll()throws SQLException;
}
