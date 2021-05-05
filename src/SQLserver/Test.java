package SQLserver;

/**
 * @Author: XQ-Yang
 * @Date: 2021/5/4 0004
 * @Tools: IntelliJ IDEA
 * @Remember: Be professional every day
 **/
public class Test {
        public static void main(String[] args) throws Exception {
        UserDao dao = new UserDao();
        User user = new User();

        dao.findUser();
    }

}
