package service;

import java.sql.SQLException;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAOImpl();
    }

    // Existing method to check if user exists
    public boolean isUserExists(int userId) throws SQLException {
        return userDAO.getUserById(userId) != null;
    }

    // New method to register a user
    public void registerUser(User user) throws SQLException {
        userDAO.addUser(user);
    }
}
