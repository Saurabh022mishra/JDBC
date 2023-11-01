import java.sql.*;

public class Scrollable_ResultSet {
    public static void main(String args[]){
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","12345"))
        {
            if(conn != null){
                System.out.println("Connected to database.....");
            }
            else{
                System.out.println("Failed to connect.....");
            }
            String sql = "Select * from student";
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet result = statement.executeQuery(sql);
            result.first();
            readStudentInfo("first",result);
            result.relative(3);
            readStudentInfo("relative(3)",result);
            result.previous();
            readStudentInfo("previous",result);
            result.absolute(4);
            readStudentInfo("absolute(4)",result);
            result.last();
            readStudentInfo("last",result);
            result.relative(-2);
            readStudentInfo("relative(-2)",result);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    private static void readStudentInfo(String position, ResultSet result)throws SQLException {
        String name = result.getString("name");
        int age = result.getInt("age");
        String studentInfo = "%s:%s-%d\n";
        System.out.format(studentInfo, position, name, age);
    }
}
