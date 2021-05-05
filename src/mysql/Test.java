package mysql;

/**
 * @Author:yxq
 * @Date: 2020/6/26 15:02
 * @Tools: IntelliJ IDEA
 **/
public class Test {
    public static void main(String[] args) throws Exception {
        UserDao dao = new UserDao();
        User user = new User();

        dao.findUser();
    }
}
