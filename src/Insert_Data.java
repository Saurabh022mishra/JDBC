import java.sql.*;
public class Insert_Data {
    public static void main(String[]args){
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","12345") ){
            if(conn!=null){
                System.out.println("Connected to Database");
            }else{
                System.out.println("Failed");
            }
            Statement stmt =conn.createStatement();
            String sql="insert into student(name,age,markes) values('raushan',22,89.7)";
            stmt.executeUpdate(sql);
            System.out.println("Inserted");
            ResultSet Result=stmt.executeQuery("select * from student;");

            while(Result.next()){
                System.out.println(Result.getInt(1)+" "+Result.getString(2)+" "+Result.getInt(3)+" "+Result.getDouble(4));
            }
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
