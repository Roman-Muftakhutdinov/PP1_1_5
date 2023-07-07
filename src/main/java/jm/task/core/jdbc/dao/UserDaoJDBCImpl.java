package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Util util =new Util();
    private int i = 0;

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String createTable = "create table Users2222 (" +
                " id   int PRIMARY KEY not null auto_increment," +
                " name     varchar(45)," +
                " lastName varchar(45)," +
                " age      int)";
        try {
            Statement statement = util.getConnection().createStatement();
            statement.executeUpdate(createTable);

        } catch (SQLException e) {
           // throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        String droptable = "drop table Users2222";
        try {
            Statement statement = util.getConnection().createStatement();
            statement.executeUpdate(droptable);

        } catch (SQLException e) {
          //  throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String addUser = "INSERT INTO Users2222 VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = util.getConnection().prepareStatement(addUser);
            preparedStatement.setInt(1, ++i);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, lastName);
            preparedStatement.setByte(4, age);

            preparedStatement.execute();
            System.out.println("User с именем - "+ name + " добавлен в базу данных");
        } catch (SQLException e) {
           // throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String removeUser = "delete from Users2222 where id = ?";
        try {
            PreparedStatement preparedStatement = util.getConnection().prepareStatement(removeUser);
            preparedStatement.setInt(1, (int) id);

            preparedStatement.execute();
        } catch (SQLException e) {
           // throw new RuntimeException(e);
        }

    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String query = "select * from Users2222";
        try {
            Statement statement = util.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                User user = new User();
                user.setId((long) resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));

                list.add(user);
                System.out.println(user);
            }
        } catch (SQLException e) {
           // throw new RuntimeException(e);
        }
        return list;
    }

    public void cleanUsersTable() {
        String cleanUser = "delete from Users2222 where id = id";
        try {
            Statement statement = util.getConnection().createStatement();
            statement.executeUpdate(cleanUser);
        } catch (SQLException e) {
            //throw new RuntimeException(e);
        }


    }
}
