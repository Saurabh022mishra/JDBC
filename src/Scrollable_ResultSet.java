import java.sql.*;

public class Scrollable_ResultSet
{
    public static void main(String args[])
    {
        String url = "jdbc:mysql://localhost:3306/university";
        String username = "root";
        String password = "12345";

        try(Connection conn = DriverManager.getConnection(url, username, password))
        {
            String sql = "SELECT * FROM student";

            Statement st = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet result = st.executeQuery(sql);

            System.out.println("Cursor position " + result.getRow() + ", is before first ? " + result.isBeforeFirst());

            result.next();

            System.out.println("Cursor position " + result.getRow() + ", is first ? " + result.isFirst());

            result.last();

            System.out.println("Cursor position " + result.getRow() + ", is last ? " + result.isLast());

            result.afterLast();

            System.out.println("Cursor position " + result.getRow() + ", is after last ? " + result.isAfterLast());

            result.absolute(3);

            System.out.println("Cursor position " + result.getRow());

            result.absolute(-1);

            System.out.println("Cursor position " + result.getRow() + ", is last ? " + result.isLast());

            result.absolute(-4);

            System.out.println("Cursor position " + result.getRow());

            result.relative(5);

            System.out.println("Cursor position " + result.getRow() + ", is after last ? " + result.isAfterLast());
            result.relative(-13);
            System.out.println("Cursor position " + result.getRow() + ", is before first ? " + result.isBeforeFirst());}
        catch(Exception e) {}}
}
