package service;

import java.sql.SQLException;
import dao.RecipeIngredientDAO;
import dao.RecipeIngredientDAOImpl;
import model.RecipeIngredient;

public class RecipeIngredientService {
    private final RecipeIngredientDAO recipeIngredientDAO;

    public RecipeIngredientService() {
        this.recipeIngredientDAO = new RecipeIngredientDAOImpl();  // Use the DAO implementation
    }

    public void addRecipeIngredient(RecipeIngredient recipeIngredient) throws SQLException {
        recipeIngredientDAO.addRecipeIngredient(recipeIngredient);  // Delegate to DAO
    }

    public boolean isRecipeIdExists(int recId) throws SQLException {
        return recipeIngredientDAO.isRecipeIdExists(recId);  // Check if rec_id exists in the DAO
    }

    public void searchRecipeById(int recipeId) throws SQLException {
        recipeIngredientDAO.searchRecipeById(recipeId);
    }

    public void searchRecipe(int recipeId) throws SQLException {
        recipeIngredientDAO.searchRecipe(recipeId);
    }
}
