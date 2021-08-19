package SQLserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author: XQ-Yang
 * @Date: 2021/5/5 0005
 * @Tools: IntelliJ IDEA
 * @Remember: Be professional every day
 **/
public class UserDao {
    DBUtil db = new DBUtil();

    /**
     * 插入用户信息
     */
    public void insertUser(User user) throws Exception {
        Connection conn = db.getConn();
        PreparedStatement pstm;
        //sql语言
        String sql_insert = "insert into [user] values(?,?)";
        pstm = conn.prepareStatement(sql_insert);

        //填充sql语句中的？
        pstm.setString(1, user.getName());
        pstm.setString(2, user.getPassword());

        //使用executeUpdate函数执行sql语句
        int row = pstm.executeUpdate();
        if (row > 0) {
            System.out.println("新增用户成功, " + row + "行受到影响");
        } else {
            System.out.println("新增用户失败！");
        }
        //释放对数据库的连接
        db.closeConn(null, pstm, conn);
    }

    /**
     * 修改用户信息
     */
    public void updateUser(int id, User user) throws Exception {
        Connection conn = db.getConn();
        PreparedStatement pstm;
        String sql_update = "update [user] set password=? where id=?";
        pstm = conn.prepareStatement(sql_update);

//        pstm.setString(1,user.getUsername());     //运行报错说与mysql关键字相同，故不修改用户名
        pstm.setString(1, user.getPassword());
        pstm.setInt(2, id);

        int row = pstm.executeUpdate();
        if (row > 0) {
            System.out.println("修改用户信息成功, " + row + "行受到影响");
        } else {
            System.out.println("修改用户信息失败！");
        }
        db.closeConn(null, pstm, conn);
    }

    /**
     * 删除用户信息
     */
    public void deleteUser(int id) throws Exception {
        Connection conn = db.getConn();
        PreparedStatement pstm;
        String sql_delete = "delete from [user] where id=?";
        pstm = conn.prepareStatement(sql_delete);

        pstm.setInt(1, id);

        int row = pstm.executeUpdate();
        if (row > 0) {
            System.out.println("删除用户成功, " + row + "行受到影响");
        } else {
            System.out.println("删除用户失败！");
        }
        db.closeConn(null, pstm, conn);
    }

    /**
     * 查询全部用户
     */
    public void findUser() throws Exception {
        Connection conn = db.getConn();
        PreparedStatement pstm;
        ResultSet res;

        String sql_find = "select * from [user] ";

        pstm = conn.prepareStatement(sql_find);

        res = pstm.executeQuery();
        System.out.println("查询用户成功!!");
        System.out.println("id\tname\tpassword");
        while (res.next()) {
            System.out.println(res.getInt(1) + "\t" +
                    res.getString(2) + "\t" + res.getString(3));
        }


        db.closeConn(res, pstm, conn);
    }

    /**
     * 根据id查询用户
     */
    public void findUserbyid(int id) throws Exception {
        Connection conn = db.getConn();
        PreparedStatement pstm;
        ResultSet res;

        String sql_find = "select * from [user] where id = ?";

        pstm = conn.prepareStatement(sql_find);

        pstm.setInt(1, id);

        res = pstm.executeQuery();
        if (res.next()) {
            System.out.println("找到了该用户！");
            System.out.println("id\tname\tpassword");
            System.out.println(res.getInt(1) + "\t" +
                    res.getString(2) + "\t" + res.getString(3));
        } else {
            System.out.println("未找到该用户！");
        }
        db.closeConn(res, pstm, conn);
    }

    /**
     * 统计用户
     */
    public void countUser() throws Exception {
        Connection conn = db.getConn();
        PreparedStatement pstm;
        ResultSet res;

        String sql_count = "select count(*) from [user]";

        pstm = conn.prepareStatement(sql_count);
        res = pstm.executeQuery();
        int count = 0;
        if (res.next()) {
            count = res.getInt(1);
            System.out.println("用户数有" + count + "个！");
        } else {
            System.out.println("没有用户！");
        }

        db.closeConn(res, pstm, conn);
    }

}
