package com.kuan.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.kuan.db.DBManager;

public class Service {
	public Boolean login(String username, String password) {

        String logSql = "select * from test where username ='" + username
                + "' and password ='" + password + "'";

        // ��ȡDB����
        DBManager sql = DBManager.createInstance();
        sql.connectDB();

        // ����DB����
        try {
            ResultSet rs = sql.executeQuery(logSql);
            if (rs.next()) {
                sql.closeDB();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.closeDB();
        return false;
	}

	public Boolean register(String username, String password) {
	    
        // ��ȡSql��ѯ���
        String regSql = "insert into stu_info values('"+ username+ "','"+ password+ "') ";
        DBManager sql = DBManager.createInstance();
        sql.connectDB();

        int ret = sql.executeUpdate(regSql);
        if (ret != 0) {
            sql.closeDB();
            return true;
        }
        sql.closeDB();
        
        return false;
    }
	
	public void topnewgrid(){
		
	}

}
