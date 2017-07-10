package com.yyx.vae.dao;

import java.sql.SQLException;
import java.util.List;

import com.yyx.entity.mrecInfo;

public interface mrecInfoDao {
	//添加方法
	public void add(mrecInfo p)throws SQLException;
	//更新方法
	public void update(mrecInfo p)throws SQLException;
	//删除方法
	public void delete(int mrec_infoid)throws SQLException;
	//查找方法
	public mrecInfo findById(int mrec_infoid)throws SQLException;
	//查找所有
	public List<mrecInfo> findAll()throws SQLException;
}
