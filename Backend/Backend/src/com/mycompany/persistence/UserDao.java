package com.mycompany.persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.buisness.User;


import com.mycompany.exceptions.DataAccessException;

public class UserDao {
    private Connection connection; // Your database connection

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public User getUserById(String userId) throws DataAccessException {
        String query = "SELECT * FROM users WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return extractUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error fetching user by ID", e);
        }
        return null;
    }

    public List<User> getAllUsers() throws DataAccessException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                users.add(extractUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error fetching all users", e);
        }
        return users;
    }

    public User createUser(User user) throws DataAccessException {
        String query = "INSERT INTO users (name, email, phone, credits, role) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhone());
            statement.setInt(4, user.getCredits());
            statement.setString(5, user.getRole());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DataAccessException("User creation failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setUserId(generatedKeys.getString(1)); // Set the generated user ID
                } else {
                    throw new DataAccessException("User creation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error creating user", e);
        }
        return user;
    }

    public User updateUser(User user) throws DataAccessException {
        String query = "UPDATE users SET name = ?, email = ?, phone = ?, credits = ?, role = ? WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhone());
            statement.setInt(4, user.getCredits());
            statement.setString(5, user.getRole());
            statement.setString(6, user.getUserId());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DataAccessException("User update failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error updating user", e);
        }
        return user;
    }

    public void deleteUser(String userId) throws DataAccessException {
        String query = "DELETE FROM users WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, userId);
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new DataAccessException("User deletion failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new DataAccessException("Error deleting user", e);
        }
    }

    // Helper method to extract a User object from a ResultSet
    private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getString("user_id"));
        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));
        user.setPhone(resultSet.getString("phone"));
        user.setCredits(resultSet.getInt("credits"));
        user.setRole(resultSet.getString("role"));
        return user;
    }
}
