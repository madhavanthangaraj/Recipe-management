package model;

import java.util.Date;

public class Review {
    private int reviewId;
    private int recId;
    private int userId;
    private String userName;
    private double rating;
    private String comment;
    private Date reviewDate;

    public Review(int reviewId, int recId, int userId, String userName, double rating, String comment, Date reviewDate) {
        this.reviewId = reviewId;
        this.recId = recId;
        this.userId = userId;
        this.userName = userName;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    // Getters and setters for each field, if needed
    public int getReviewId() { return reviewId; }
    public int getRecId() { return recId; }
    public int getUserId() { return userId; }
    public String getUserName() { return userName; }
    public double getRating() { return rating; }
    public String getComment() { return comment; }
    public Date getReviewDate() { return reviewDate; }

    // Add setters if required, e.g., setRating, setComment, etc.
}
