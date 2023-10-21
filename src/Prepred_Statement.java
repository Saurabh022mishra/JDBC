
import java.sql.*;
import java.util.Scanner;

public class Prepred_Statement {
    private static final String url="jdbc:mysql://localhost:3306/university";
    private static final String username="root";
    private static final String password="12345";
    public static void main(String[]args){

        try(Connection conn=DriverManager.getConnection(url,username,password)){
            Scanner sc=new Scanner(System.in);
            if(conn!=null){
                System.out.println("Connected");
            }
            else{
                System.out.println("Failed");
            }
            String query="insert into courses ( course_name,course_duration)values(?,?)";
           PreparedStatement stmt= conn.prepareStatement(query);


            System.out.println("Enter Course Name : ");
            String c_name=sc.nextLine();
            stmt.setString(1,c_name);
            System.out.println("Enter Course Dueration : ");
            int c_dur=sc.nextInt();
            stmt.setInt(2,c_dur);
            stmt.executeUpdate();
            String query1="select * from courses;";
            ResultSet result=stmt.executeQuery(query1);
            while(result.next()){
                int id=result.getInt("course_id");
                String name=result.getString("course_name");
                int age=result.getInt("course_duration");

                System.out.println("ID : "+id+"\tCourse name : "+name+ " \tCourse Durection : "+age);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
