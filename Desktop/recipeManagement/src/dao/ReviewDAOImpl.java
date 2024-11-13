package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Review;
import utility.DBConnection;

public class ReviewDAOImpl implements ReviewDAO {

    @Override
    public void addReview(Review review) throws SQLException {
        String query = "INSERT INTO review (rec_id, user_id, user_name, rating, review, review_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, review.getRecId());
            stmt.setInt(2, review.getUserId());
            stmt.setString(3, review.getUserName());  // Set user_name
            stmt.setDouble(4, review.getRating());
            stmt.setString(5, review.getComment());
            stmt.setTimestamp(6, new java.sql.Timestamp(review.getReviewDate().getTime()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error while adding the review", e);
        }
    }
}
