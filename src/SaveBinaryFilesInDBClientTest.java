import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class SaveBinaryFilesInDBClientTest {
    public static void main(String[] args) throws SQLException {
        SaveBinaryFilesInDataBase();
    }
    private static void SaveBinaryFilesInDataBase() throws SQLException{
        String SQL = "INSERT INTO binary_table(file_name,filesize_in_kb,file_extension,file_contant) values (?,?,?,?)";
        Path dir = Paths.get("D:\\Binary_File_java");
        try(Stream <Path> List = Files.list(dir);
            Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL) ){
            List <Path> PathList = List.collect(Collectors.toList());
            System.out.println("Binary Files are going to save---");
            for(Path path : PathList ){
                System.out.println(path.getFileName());
                File file = path.toFile();
                String fileName = file.getName();
                long fileLength = file.length();
                long filelenthinkb = fileLength/1024;
                ps.setString(1, fileName);
                ps.setLong(2, filelenthinkb);
                ps.setString(3, fileName.substring(fileName.lastIndexOf(".")+1));
                FileInputStream fis = new FileInputStream(file);
                ps.setBinaryStream(4, fis, fileLength);
                ps.addBatch();
            }
            System.out.println("--------------------------");
            int [] executeBatch = ps.executeBatch();
            for(int i : executeBatch){
                System.out.println(i);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
