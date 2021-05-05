package SQLserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author: XQ-Yang
 * @Date: 2021/5/5 0005
 * @Tools: IntelliJ IDEA
 * @Remember: Be professional every day
 **/
public class DBUtil {
    //加载JDBC驱动
    private String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //连接服务器和数据库
    private String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=test";
    //默认用户名，一般为sa
    private String userName = "sa";
    //用户名密码
    private String password = "123456";

    /**
     * 注册驱动
     * @return
     */
    public Connection getConn() {
        Connection dbConn = null;
        try {
            Class.forName(driverName);
            dbConn = DriverManager.getConnection(dbURL, userName, password);
            // 如果连接成功 控制台输出!
            System.out.println("SQL server数据库连接成功！");
        } catch (Exception e) {
            System.out.println("SQL server数据库连接失败？？？？？");
            e.printStackTrace();
        }

        return  dbConn;
    }

    /**
     * 释放资源
     * @param rs
     * @param pstm
     * @param conn
     * @throws Exception
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
