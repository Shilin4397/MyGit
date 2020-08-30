package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class DBUtil {
    private static volatile DataSource dataSource = null;
    private static final String URL = "jdbc:mysql://localhost:3306/java13_chatroom?characterEncoding=utf-8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    public static DataSource getDataSource() {
        //获取到这个单例的DataSource 实例
        if(dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    //必须告诉代码，数据库是谁，以什么方式登录
                    ((MysqlDataSource)dataSource).setURL(URL);
                    ((MysqlDataSource)dataSource).setUser(USERNAME);
                    ((MysqlDataSource)dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public static void close(Connection c, PreparedStatement ps) {
        close(c, ps, null);
    }

    public static void close(Connection c, PreparedStatement ps, ResultSet r) {
        try {
            if(r != null)
                r.close();
            if(ps != null)
                ps.close();
            if(c != null)
                c.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
