package cn.cstqb.exam.testmaker.actions.examPaper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

    //MySQL8.0以上版本
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/testmaker?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    static final String DB_USER = "root";
    static final String DB_PASS = "ddf681126";

    //创建连接
    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭函数：只有状态和连接时，先关闭状态
    public static void close(Statement state, Connection conn) {
        try {
            if (state != null) state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //关闭函数：有结果集，状态和连接时，先关闭结果集，在关闭状态，在关闭连接
    public static void close(ResultSet rs, Statement state, Connection conn) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(state, conn);
    }

}
