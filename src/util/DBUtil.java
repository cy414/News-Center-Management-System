package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * mysql jdbc 数据库连接
 *
 */
public class DBUtil {
    private static String username;     //数据库登陆账号
    private static String password;     //数据库登陆密码
    private static String url;          //数据库 url 及端口
    private static String driver;       //驱动类

    //通常情况下把数据密码放置 项目配置文件中 , 相对于放入类中，更安全一些。
    static {	//静态初始化块
        username = "root";
        password = "123456";
        url = "jdbc:mysql://localhost:3306/newsdb?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
        driver = "com.mysql.jdbc.Driver";
        //加载驱动类
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 私有化构造器，防止用户重复创建对象，造成资源浪费。
     */
    private DBUtil(){

    }
    /**
     * 定义一个Connection类型的变量用来存储获取到的Connection实例化对象
     */

    private static Connection con;

    //创建数据库连接对象
    public static Connection getConnection() {

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    //关闭对应数据流
    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
        //关闭流原则，先创建后关闭

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
