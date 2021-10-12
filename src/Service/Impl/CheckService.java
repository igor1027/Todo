package Service.Impl;

import java.sql.*;

public class CheckService {
    private static final String url = "jdbc:mysql://localhost/user?useUnicode=true&serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "1234";

    public boolean CheckDataBaseIsEmpty() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String query = "SELECT * FROM tasks";
               try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
                   try (ResultSet resultSet = preparedStatement.executeQuery()){
                       if(resultSet.next()){
                           return false;
                       }
                   }
               }
            }catch (SQLException ee) {
            ee.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }



}
