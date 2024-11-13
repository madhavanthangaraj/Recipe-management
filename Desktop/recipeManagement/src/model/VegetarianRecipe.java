package model;

import java.util.Date;

public class VegetarianRecipe {
    private int recipeId;  // Foreign key to Recipe
    private boolean isVegan;  // Indicates if the vegetarian recipe is vegan
    private Date creationDate;  // Use Date for creation timestamp

    // Constructor for initializing VegetarianRecipe object
    public VegetarianRecipe(int recipeId, boolean isVegan, Date creationDate) {
        this.recipeId = recipeId;
        this.isVegan = isVegan;
        this.creationDate = creationDate;
    }

    // Getter and setter methods
    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public boolean getIsVegan() {
        return isVegan;
    }

    public void setIsVegan(boolean isVegan) {
        this.isVegan = isVegan;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    // Override toString() method for displaying VegetarianRecipe details
    @Override
    public String toString() {
        return "VegetarianRecipe [RecipeID=" + recipeId + ", IsVegan=" + isVegan + ", Created on=" + creationDate + "]";
    }
}
