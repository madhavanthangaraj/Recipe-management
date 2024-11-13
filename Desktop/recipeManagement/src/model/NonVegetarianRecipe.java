package model;

import java.util.Date;

public class NonVegetarianRecipe {
    private int recipeId;  // Foreign key to Recipe
    private String meatType;  // Type of meat used in the non-vegetarian recipe (e.g., chicken, beef, etc.)
    private Date creationDate;  // Use Date for creation timestamp

    // Constructor for initializing NonVegetarianRecipe object
    public NonVegetarianRecipe(int recipeId, String meatType, Date creationDate) {
        this.recipeId = recipeId;
        this.meatType = meatType;
        this.creationDate = creationDate;
    }

    // Getter and setter methods
    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getMeatType() {
        return meatType;
    }

    public void setMeatType(String meatType) {
        this.meatType = meatType;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    // Override toString() method for displaying NonVegetarianRecipe details
    @Override
    public String toString() {
        return "NonVegetarianRecipe [RecipeID=" + recipeId + ", MeatType=" + meatType + ", Created on=" + creationDate + "]";
    }
}
