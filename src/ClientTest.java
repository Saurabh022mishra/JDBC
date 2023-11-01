import java.io.File;
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
public class ClientTest {
    public static void main(String[] args) throws SQLException {
        String SQL = "INSERT INTO storefile_mytable(file_name,filesize_in_kb,file_extension,file_contant)values(?,?,?,?)";
        Path dir = Paths.get("C:\\TxtFiles");
        try(Stream <Path> list = Files.list(dir);
            Connection connection=DBUtil.getConnection();
            PreparedStatement ps =connection.prepareStatement(SQL)){
            List <Path> PathList = list.collect(Collectors.toList());
            System.out.println("Following files are saved in database");
            for(Path path : PathList){
                System.out.println(path.getFileName());
                File file = path.toFile();
                String fileName = file.getName();
                long fileLength = file.length();
                long fileLengthinkb = fileLength/1024;

                ps.setString(1, fileName);
                ps.setLong(2, fileLengthinkb);

                ps.setString(3, fileName.substring(fileName.lastIndexOf(" ")+ 1 ));
                ps.setCharacterStream(4, new FileReader(file), fileLength);
                ps.addBatch();
            }
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
