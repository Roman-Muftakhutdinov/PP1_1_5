package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl udjin = new UserDaoJDBCImpl();

    public void createUsersTable() {
        udjin.createUsersTable();
    }

    public void dropUsersTable() {
        udjin.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        udjin.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        udjin.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return udjin.getAllUsers();
    }

    public void cleanUsersTable() {
        udjin.cleanUsersTable();
    }
}
