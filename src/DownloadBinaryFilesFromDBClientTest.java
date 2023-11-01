import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DownloadBinaryFilesFromDBClientTest{
    public static void main(String[] args)throws SQLException {
        downloadBinaryFilesFromDatabase();
    }

    private static void downloadBinaryFilesFromDatabase() throws SQLException {
        String SQL = "SELECT * FROM binary_table";
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery()){
            System.out.println("Following files are download from database. ");
            while(rs.next()){
                int fileId = rs.getInt("file_id");
                String fileName = rs.getString("file_name");
                long filesizeinKb = rs.getLong("filesize_in_kb");
                String fileExtension = rs.getString("file_extension");
                System.out.println("File Extension: " + fileExtension);
                Blob blob = rs.getBlob("file_contant");
                InputStream inputStream = blob.getBinaryStream();

                System.out.println("-----------------------------------");
                Files.copy(inputStream, Paths.get("D:\\DownloadDB\\"  + fileName));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
