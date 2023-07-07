package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();
        System.out.println("table is create");

        userService.saveUser("Anthony", "Kiedis", (byte) 60);
        userService.saveUser("Michael Peter", "Balzary", (byte) 60);
        userService.saveUser("Chad Gaylord", "Smith", (byte) 61);
        userService.saveUser("John Anthony", "Frusciante", (byte) 53);

        userService.getAllUsers();

        //userService.removeUserById((int) 3);
        //userService.getAllUsers();
        userService.cleanUsersTable();
        //userService.getAllUsers();
        userService.dropUsersTable();
        System.out.println("table is drop");


    }
}
