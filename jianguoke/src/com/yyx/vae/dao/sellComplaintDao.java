package com.yyx.vae.dao;

import java.sql.SQLException;
import java.util.List;

import com.yyx.entity.sellComplaint;

public interface sellComplaintDao {
	//添加方法
	public void add(sellComplaint p)throws SQLException;
	//更新方法
	public void update(sellComplaint p)throws SQLException;
	//删除方法
	public void delete(int sell_comid)throws SQLException;
	//查找方法
	public sellComplaint findById(String order_id)throws SQLException;
	//查找所有
	public List<sellComplaint> findAll()throws SQLException;
}
