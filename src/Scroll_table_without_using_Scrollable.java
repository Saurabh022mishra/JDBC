import com.sun.deploy.security.ValidationState;

import java.sql.*;
public class Scroll_table_without_using_Scrollable {
    public static void main(String[] args) {


        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "12345")) {
            if (conn!=null){
                System.out.println("Connected To Database");
            }
            else{
                System.out.println("Connection Failed");
            }
            String sql ="select * from student";
            Statement stmt= conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs= stmt.executeQuery(sql);
            rs.first();
            readStudentInfo("first",rs);
            rs.relative(3);
readStudentInfo("relative(3)",rs);
rs.previous();
readStudentInfo("previous",rs);
rs.absolute(4);
readStudentInfo("absolute(4)",rs);
rs.relative(-2);
readStudentInfo("relative(-2)",rs);
        }catch (Exception e){
            System.out.println("massage"+e.getMessage());
        }


    }
    public static void readStudentInfo(String position,ResultSet rs)throws  SQLException{
        String name=rs.getString("name");
        int age=rs.getInt("age");
        int markes=rs.getInt("markes");
        String info="%s : %s : %d :%d\n";
        System.out.format(info,position,name,age,markes);
    }
}