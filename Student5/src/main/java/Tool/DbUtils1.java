package Tool;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtils1 {
    private static DruidDataSource ds;
    // 将线程和连接绑定，保证事务能统一执行
//数据库连接池，是将connection放进threadlocal里的，以保证每个线程从连接池中获得的都是线程自己的connection。
    private static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();
//https://blog.csdn.net/qq_43499096/article/details/104615346

    //加载配置文件
    static {
        Properties properties = new Properties();
        InputStream is = DbUtils1.class.getClassLoader().getResourceAsStream("jdbc.properties");
//https://blog.csdn.net/qq_43842093/article/details/130663768
//注意：class.getClassLoader().getResourceAsStream() 和 class.getResourceAsStream()区别
//1：类名.class.getClassLoader()相当于从classpath下开始读取；
//2：类名.class.getResourceAsStream(“文件名”)从当前类所在路径下读取。
//https://blog.csdn.net/weixin_48052161/article/details/115151874
        try {
            properties.load(is);
            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取链接
    public static Connection getConnection() {
        Connection connection = THREAD_LOCAL.get();
        try {
            if (connection == null) {
                connection = ds.getConnection();
                THREAD_LOCAL.set(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }






    //关闭资源
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
                THREAD_LOCAL.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}