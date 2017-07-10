package com.yyx.vae.dao;

import java.sql.SQLException;
import java.util.List;

import com.yyx.entity.orderInfo;

public interface orderInfoDao {
    	//添加方法
		public void add(orderInfo p)throws SQLException;
		//更新方法
		public void update(orderInfo p)throws SQLException;
		//删除方法
		public void delete(int order_info)throws SQLException;
		//查找方法
		public orderInfo findById(int order_info)throws SQLException;
		//查找所有
		public List<orderInfo> findAll()throws SQLException;
}
