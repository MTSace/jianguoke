package com.yyx.vae.dao;

import java.sql.SQLException;
import java.util.List;

import com.yyx.entity.stuInfo;

public interface stuInfoDao {
	//添加方法
	public void add(stuInfo p)throws SQLException;
	//更新方法
	public void update(stuInfo p)throws SQLException;
	//删除方法
	public void delete(String stu_phone)throws SQLException;
	//查找方法
	public stuInfo findById(String stu_phone)throws SQLException;
	//查找所有
	public List<stuInfo> findAll()throws SQLException;
}
