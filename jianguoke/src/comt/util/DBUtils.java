package comt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

public class DBUtils {
	// 数据库连接地址
	public static String URL;
	// 用户名
	public static String USERNAME;
	// 密码
	public static String PASSWORD;
	// mysql驱动类
	public static String DRIVER;
	// 使用静态块加载驱动程序(为了避免重复代码，使用静态代码块：只会在类加载的时候执行一次)
	static {
		URL = "jdbc:mysql://localhost:3306/jgk?useSSL=false";
		USERNAME = "root";
		PASSWORD = "122488";
		DRIVER = "com.mysql.jdbc.Driver";
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 定义一个获取数据库连接的方法
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取连接失败");
		}
		return conn;
	}

	// 关闭数据库连接
	public static void close(ResultSet rs, Statement stat, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (stat != null)
				stat.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
