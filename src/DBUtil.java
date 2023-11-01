import java.sql.*;
public class DBUtil {
    private static final String DB_username = "root";
    private static final String DB_password = "12345";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/university";
    private static Connection connection = null;
    static {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_username, DB_password);
            System.out.println("connected");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return connection;
    }

}
