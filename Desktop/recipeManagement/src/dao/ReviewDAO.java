package dao;

import java.sql.SQLException;
import model.Review;

public interface ReviewDAO {
    void addReview(Review review) throws SQLException;
    // Additional methods can be added as needed
}
