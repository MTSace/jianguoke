package com.yyx.vae.dao;

import java.sql.SQLException;
import java.util.List;

import com.yyx.entity.stuComplaint;

public interface stuComplaintDao {
		//添加方法
		public void add(stuComplaint p)throws SQLException;
		//更新方法
		public void update(stuComplaint p)throws SQLException;
		//删除方法
		public void delete(int stu_comid)throws SQLException;
		//查找方法
		public stuComplaint findById(String stu_comid)throws SQLException;
		//查找所有
		public List<stuComplaint> findAll()throws SQLException;

}
