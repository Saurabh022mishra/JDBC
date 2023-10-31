import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcInsertFile {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        String url="jdbc:mysql://localhost:3306/university";
        String username="root";
        String password="12345";
        String filepath="C:/Users/saurabh/Pictures/.1.jpg";
        try{
            Connection conn= DriverManager.getConnection(url,username,password);
            String sql="INSERT INTO person(firstname,lastname,photo)values(?,?,?)";
            PreparedStatement statement= conn.prepareStatement(sql);
            statement.setString(1,"Saurabh");
            statement.setString(2,"Mishra");
            InputStream inputStream=new FileInputStream(new File(filepath));
            statement.setBlob(3,inputStream);
            int row=statement.executeUpdate();
            if(row>0){
                System.out.println("A Content was Inserted with photo ");
            }
            conn.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
