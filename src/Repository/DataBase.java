package Repository;
import Entity.TaskValues;

import java.sql.*;

public class DataBase {

   private static final String url = "jdbc:mysql://localhost/user?useUnicode=true&serverTimezone=UTC";
   private static final String username = "root";
   private static final String password = "1234";

    public static void addTask(TaskValues taskValues){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)){
               String query = "INSERT INTO tasks (name, description, status) values (?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, taskValues.getName());
                statement.setString(2, taskValues.getDescription());
                statement.setString(3, taskValues.getStatus());
                statement.execute();
                statement.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateTask(String newName, String newDescription, int id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)){
                String query = "UPDATE TASKS SET name = ?, description = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, newName);
                statement.setString(2, newDescription);
                statement.setInt(3, id);
                statement.executeUpdate();
                int Up = statement.executeUpdate();
                if(Up > 0){
                    System.out.println("Изменения успешно внесены");
                }
                statement.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void deleteTask(int id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)){
                String query = "DELETE FROM TASKS WHERE id = '" + id + "'";

                Statement statement = connection.createStatement();
                statement.execute(query);
                statement.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void infoTask(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)){
                String query = "SELECT * FROM tasks";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                int count = 1;
                while (resultSet.next()){
                    System.out.print(count++ + " ");
                    System.out.print(resultSet.getString(2) + " ");
                    System.out.print(resultSet.getString(3) + " ");
                    System.out.println(resultSet.getString(4) + " ");
                }
                resultSet.close();
                statement.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void UpdateStatus(int id, String newStatus){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)){
                String query = "UPDATE TASKS SET status = ? WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1,newStatus);
                preparedStatement.setInt(2, id);
                preparedStatement.execute();
                preparedStatement.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

