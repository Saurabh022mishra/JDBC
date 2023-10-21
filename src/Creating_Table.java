import java.sql.*;
public class Creating_Table {
    private static final String url="jdbc:mysql://localhost:3306/university";
    private static final String username="root";
    private static final String password="12345";
    public static void main(String[]args){
        try(Connection conn=DriverManager.getConnection(url,username,password)){
            if(conn!=null){
                System.out.println("Connected to Database");
            }
            else{
                System.out.println("Connection Failed");
            }
            Statement stmt=conn.createStatement();
            String sql="create table Courses(course_id INT AUTO_INCREMENT  PRIMARY Key,course_name varchar(225) NOT NULL,course_duration int NOT NULL);";
            stmt.executeUpdate(sql);
            System.out.println("Created");

            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
