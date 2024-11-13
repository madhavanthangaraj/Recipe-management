package dao;

import java.sql.SQLException;

import model.RecipeIngredient;

public interface RecipeIngredientDAO {
    void addRecipeIngredient(RecipeIngredient recipeIngredient) throws SQLException;
    boolean isRecipeIdExists(int recId) throws SQLException;  // Declare SQLException here
    void searchRecipeById(int recipeId) throws SQLException;
    void searchRecipe(int recipeId) throws SQLException;
}
