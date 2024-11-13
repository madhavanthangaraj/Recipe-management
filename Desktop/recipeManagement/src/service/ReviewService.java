package service;

import java.sql.SQLException;
import dao.ReviewDAO;
import dao.ReviewDAOImpl;
import model.Review;

public class ReviewService {
    private final ReviewDAO reviewDAO;

    public ReviewService() {
        this.reviewDAO = new ReviewDAOImpl();
    }

    public void addReview(Review review) throws SQLException {
        reviewDAO.addReview(review);
    }
}
