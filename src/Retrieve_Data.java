import java.sql.*;
import java.sql.DriverManager;

public class Retrieve_Data {
private static final String url="jdbc:mysql://localhost:3306/university";
    private static final String username="root";
    private static final String password="12345";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection coon= DriverManager.getConnection(url,username,password);
            Statement stmt=coon.createStatement();
            String query="select * from student;";
            ResultSet result=stmt.executeQuery(query);
            while(result.next()){
                int id=result.getInt("id");
                String name=result.getString("name");
                int age=result.getInt("age");
                double markes=result.getDouble("markes");
                System.out.println("ID : "+id+"\tname : "+name+ " \tage : "+age+"\tmarkes : "+markes);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}