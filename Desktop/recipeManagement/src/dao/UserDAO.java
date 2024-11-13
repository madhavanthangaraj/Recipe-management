package dao;

import java.sql.SQLException;
import model.User;

public interface UserDAO {
    void addUser(User user) throws SQLException;
    User getUserById(int userId) throws SQLException;
}
