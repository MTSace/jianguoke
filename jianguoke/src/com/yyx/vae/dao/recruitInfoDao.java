package com.yyx.vae.dao;

import java.sql.SQLException;
import java.util.List;

import com.yyx.entity.recruitInfo;

public interface recruitInfoDao {
			//添加方法
			public void add(recruitInfo p)throws SQLException;
			//更新方法
			public void update(recruitInfo p)throws SQLException;
			//删除方法
			public void delete(int rec_infoid)throws SQLException;
			//查找方法
			public recruitInfo findById(int rec_infoid)throws SQLException;
			//查找所有
			public List<recruitInfo> findAll()throws SQLException;
}
