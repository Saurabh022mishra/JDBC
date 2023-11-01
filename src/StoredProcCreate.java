import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcCreate {
    public static void main(String[] args) {
        try(Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","12345");Statement stmt= conn.createStatement();){
           String queryDrop="DROP PROCEDURE IF EXISTS delete_book";
           String queryCreate=" CREATE PROCEDURE delete_book(IN bookID INT)";
           queryCreate+="BEGIN";
           queryCreate+=" DELETE FROM book where book_id=bookID;";
           queryCreate+="END ";
//           stmt.executeUpdate(queryDrop);
           stmt.executeUpdate(queryCreate);
           stmt.close();
            System.out.println("Stored Procrdure Created Successfully");


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
