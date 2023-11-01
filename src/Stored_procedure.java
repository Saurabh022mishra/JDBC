import java.sql.*;
public class Stored_procedure {
    public static void main(String[] args) {
        try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","12345")){
            if(conn!=null){
                System.out.println("connected");
            }
            else{
                System.out.println("Failed");
            }
            int result=0;
            String sql="{call AddtwoNumber(?,?)}";
            CallableStatement cs= conn.prepareCall(sql);
            cs.setInt(1,3);
            cs.setInt(2,4);



           // ResultSet resultSet = cs.executeQuery();

           System.out.println("Sucessfully Called");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
