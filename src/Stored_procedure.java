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
            String sql="{call AddtwoNumber(?,?)}";
            CallableStatement cs= conn.prepareCall(sql);
            cs.setInt(1,3);
            cs.setInt(2,4);


            ResultSet resultSet = cs.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                // Retrieve data from the result set
                int resultColumn1 = resultSet.getInt("column_name1");
                String resultColumn2 = resultSet.getString("column_name2");

                // Do something with the retrieved data
                System.out.println("Column 1: " + resultColumn1);
                System.out.println("Column 2: " + resultColumn2);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
