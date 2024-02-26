import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            deleteDemo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectDemo() throws SQLException{
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {
            connection = dbHelper.getConneciton();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM country");
            ArrayList<Country> countries = new ArrayList<>();
            while (resultSet.next()){
                countries.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region")));
            }
            System.out.println(countries.size());
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        } finally {
            connection.close();
        }
    }
    public static void insertDemo() throws SQLException{
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try {
            connection = dbHelper.getConneciton();
            String sql = "Insert Into city (Name, CountryCode, District, Population) values(?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Düzce 2");
            preparedStatement.setString(2, "TUR");
            preparedStatement.setString(3, "Turkey");
            preparedStatement.setInt(4, 70000);
            int result = preparedStatement.executeUpdate();
            System.out.println("Başarıyla eklendi." + result);
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        } finally {
            connection.close();
        }
    }

    public static void updateDemo() throws SQLException{
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try {
            connection = dbHelper.getConneciton();
            String sql = "update city set population=1000 where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 4080);
            int result = preparedStatement.executeUpdate();
            System.out.println("kayıt güncellendi." + result);
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        } finally {
            connection.close();
        }
    }
    public static void deleteDemo() throws SQLException{
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try {
            connection = dbHelper.getConneciton();
            String sql = "delete from city where ID=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 4082);
            int result = preparedStatement.executeUpdate();
            System.out.println("kayıt silindi." + result);
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        } finally {
            connection.close();
        }
    }
}