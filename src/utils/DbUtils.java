package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {
    public static Connection connectToDb() {
        Connection conn = null;
        String DB_URL = "jdbc:mysql://localhost/transport_system";
        String USER = "root";
        String PASS = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER,PASS);

        }catch(SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void disconnect(Connection connection, Statement statement){
        try {
            if(connection != null && statement !=null){
                connection.close();
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
