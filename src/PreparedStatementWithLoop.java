import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.*;


public class PreparedStatementWithLoop {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "12345")) {
            if (conn != null) {
                System.out.println("Connected");
            } else {
                System.out.println("Failed");

            }
            String sql = "INSERT INTO STUDENT(name,age,markes)values(?,?,?)";
            PreparedStatement stmt=conn.prepareStatement(sql);
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            do {
                System.out.println("Enter Student Name : ");
                String name=br.readLine();
                System.out.println("Enter Age : ");
                int age=Integer.parseInt(br.readLine());
                System.out.println("Enter Total Markes: ");
                int marks=Integer.parseInt(br.readLine());
                stmt.setString(1,name);
                stmt.setInt(2,age);
                stmt.setInt(3,marks);
                int i=stmt.executeUpdate();
                System.out.println(i+" Records Affected");
                System.out.println("Do you want to continue : Y/N ");
                String s=br.readLine();
                if(s.startsWith("N")){
                    break;
                }
            }while(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
