import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    String userName = "root";
    String password = "123456";
    String dbUrl = "jdbc:mysql://localhost:3306/world?useSSL=false&useUnicode=true";

    public Connection getConneciton() throws SQLException {
        return DriverManager.getConnection(dbUrl, userName, password);
    }
    public void showErrorMessage(SQLException exception){
        System.out.println("Error: " + exception.getMessage());
        System.out.println("Error code: " + exception.getErrorCode());
    }
}
