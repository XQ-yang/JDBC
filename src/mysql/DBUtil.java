package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author:yxq
 * @Date: 2020/6/26 14:12
 * @Tools: IntelliJ IDEA
 **/
public class DBUtil {

    private String url="jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
    public String username = "root";
    public String password = "yxq";
    /**
     * 1. 注册驱动
     */
    public Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("数据库连接成功！！！");
        } catch (Exception e) {
            System.out.println("数据库连接失败？？？？");
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 2. 释放资源
     */
    public void closeConn(ResultSet rs, PreparedStatement pstm, Connection conn) throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (pstm != null) {
            pstm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}