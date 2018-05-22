package connection;

import logging.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static ConnectionUtil instance;
    private static String url;
    private static String user;
    private static String pass;

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            url = "jdbc:mysql://localhost/quiz_db";
            user = "root";
            pass = "root";
        } catch (ClassNotFoundException e){
            Log.writeError(e, "com.mysql.cj.jdbc.Driver is not found");
        }
    }

    private ConnectionUtil(){}

    public static Connection getConnection() throws SQLException {
        synchronized (ConnectionUtil.class){
            if (instance == null){
                instance = new ConnectionUtil();
            }
        }
        Connection connection = DriverManager.getConnection(instance.url, instance.user, instance.pass);
        connection.setAutoCommit(false);
        return connection;
    }

    public static void close(Connection connection) {
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
