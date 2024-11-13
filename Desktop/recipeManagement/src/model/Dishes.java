package model;

import java.sql.Timestamp;

public class Dishes {
    private int dishId;          // dish_id (Primary key)
    private String name;         // Name of the dish (e.g., "Chicken Curry")
    private String category;     // Category (e.g., "Vegetarian" or "Non-Vegetarian")
    private Timestamp creationDate; // Timestamp for when the dish was created

    // Constructor for Dishes class
    public Dishes(int dishId, String name, String category, Timestamp creationDate) {
        this.dishId = dishId;
        this.name = name;
        this.category = category;
        this.creationDate = creationDate;
    }

    // Default constructor
    public Dishes() {
        // Empty constructor for easy object creation if needed
    }

    // Getter and Setter for dishId
    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Getter and Setter for creationDate
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    // Override toString() method for displaying the Dishes object in a user-friendly way
    @Override
    public String toString() {
        return "Dishes [dishId=" + dishId + ", name=" + name + ", category=" + category + ", creationDate=" + creationDate + "]";
    }
}
