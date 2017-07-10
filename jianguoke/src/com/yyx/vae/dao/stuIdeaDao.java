package com.yyx.vae.dao;

import java.sql.SQLException;
import java.util.List;

import com.yyx.entity.stuIdea;

public interface stuIdeaDao {
	//添加方法
	public void add(stuIdea p)throws SQLException;
	//更新方法
	public void update(stuIdea p)throws SQLException;
	//删除方法
	public void delete(int stu_identid)throws SQLException;
	//查找方法
	public stuIdea findById(String stu_identid)throws SQLException;
	//查找所有
	public List<stuIdea> findAll()throws SQLException;
}
