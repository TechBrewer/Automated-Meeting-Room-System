package com.mycompany.buisness;
import com.mycompany.persistence.UserDao;
import com.mycompany.exceptions.BusinessException;
import com.mycompany.exceptions.DataAccessException;
import java.util.List;
import java.util.UUID;
public class UserManager {
    private UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }
    public UserManager() {
        // Default constructor
    }
    public User getUserById(String userId) throws BusinessException {
        try {
            User user = userDao.getUserById(userId);
            if (user == null) {
                throw new BusinessException("User not found with ID: " + userId);
            }
            return user;
        } catch (DataAccessException e) {
            throw new BusinessException("Error fetching user by ID", e);
        }
    }

    public List<User> getAllUsers() throws BusinessException {
        try {
            return userDao.getAllUsers();
        } catch (DataAccessException e) {
            throw new BusinessException("Error fetching all users", e);
        }
    }

    public User createUser(User user) throws BusinessException {
        try {
            // Validate user input
            validateUser(user);

            // Generate a unique user ID (You can use a UUID or any other method)
            user.setUserId(generateUniqueUserId());

            // Create the user
            User createdUser = userDao.createUser(user);

            return createdUser;
        } catch (DataAccessException e) {
            throw new BusinessException("Error creating user", e);
        }
    }

    public User updateUser(User user) throws BusinessException {
        try {
            // Validate user input
            validateUser(user);

            // Update the user
            User updatedUser = userDao.updateUser(user);

            return updatedUser;
        } catch (DataAccessException e) {
            throw new BusinessException("Error updating user", e);
        }
    }

    public void deleteUser(String userId) throws BusinessException {
        try {
            userDao.deleteUser(userId);
        } catch (DataAccessException e) {
            throw new BusinessException("Error deleting user", e);
        }
    }

    // Other business methods for user management

    // Helper method to validate user input
    private void validateUser(User user) throws BusinessException {
        if (user == null || user.getName() == null || user.getName().isEmpty()
                || user.getEmail() == null || user.getEmail().isEmpty()
                || user.getPhone() == null || user.getPhone().isEmpty()) {
            throw new BusinessException("Invalid user data.");
        }
    }

    // Helper method to generate a unique user ID (you can replace this with your own logic)
    private String generateUniqueUserId() {
        // Generate a unique user ID (e.g., using UUID.randomUUID().toString())
        return UUID.randomUUID().toString();
    }
}
