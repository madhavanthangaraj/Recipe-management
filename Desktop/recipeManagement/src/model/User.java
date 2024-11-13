package model;

import java.util.Date;

public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private Date createdAt;

    public User(int userId, String username, String password, String email, Date createdAt) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
    }

    // Getters and setters
    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public Date getCreatedAt() { return createdAt; }

    public void setUserId(int userId) { this.userId = userId; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setEmail(String email) { this.email = email; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}
