package com.yyx.vae.dao;

import java.sql.SQLException;
import java.util.List;

import com.yyx.entity.recruitAsk;

public interface recruitAskDao {
	//添加方法
		public void add(recruitAsk p)throws SQLException;
		//更新方法
		public void update(recruitAsk p)throws SQLException;
		//删除方法
		public void delete(int rec_askid)throws SQLException;
		//查找方法
		public recruitAsk findById(int rec_askid)throws SQLException;
		//查找所有
		public List<recruitAsk> findAll()throws SQLException;
}