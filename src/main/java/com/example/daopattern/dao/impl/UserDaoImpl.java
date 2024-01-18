package com.example.daopattern.dao.impl;

import com.example.daopattern.dao.UserDao;
import com.example.daopattern.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Override
    public User findById(Long id) {
        try(Connection connection = getConnection()) {
            try (PreparedStatement prepStatement = connection.prepareStatement("SELECT * FROM _user WHERE id = ? ")) {
                prepStatement.setLong(1, id);
                try (ResultSet resultSet = prepStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return extractUserFromResultSet(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public User save(User user) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO _user (surname, name, patronymic) VALUES (?, ?, ?)";
            try (PreparedStatement prepStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                prepStatement.setString(1, user.getSurname());
                prepStatement.setString(2, user.getName());
                prepStatement.setString(3, user.getPatronymic());
                prepStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public Boolean deleteById(Long id) {
        try (Connection connection = getConnection()) {
            try (PreparedStatement prepState = connection.prepareStatement("DELETE FROM _user WHERE id = ?")) {
                prepState.setLong(1, id);
                prepState.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public List<User> findByFIO(String surname, String name, String patronymic) {
        List<User> users = new ArrayList<>();
        try(Connection connection = getConnection()) {
            try (PreparedStatement prepState = connection.prepareStatement("SELECT * FROM _user WHERE surname = ? AND name = ? AND patronymic = ?")) {
                prepState.setString(1, surname);
                prepState.setString(2, name);
                prepState.setString(3, patronymic);
                try (ResultSet resultSet = prepState.executeQuery()) {
                    while (resultSet.next()) {
                        users.add(extractUserFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getLong("id"))
                .surname(resultSet.getString("surname"))
                .name(resultSet.getString("name"))
                .patronymic(resultSet.getString("patronymic"))
                .build();
    }
}
