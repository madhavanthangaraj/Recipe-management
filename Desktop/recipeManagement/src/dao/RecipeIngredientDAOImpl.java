package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.RecipeIngredient;
import utility.DBConnection;

public class RecipeIngredientDAOImpl implements RecipeIngredientDAO {

    @Override
    public void addRecipeIngredient(RecipeIngredient recipeIngredient) throws SQLException {
        int ingId = generateIngId();
        String query = "INSERT INTO recipe_ingredients (rec_id, ing_id, dish_id, rec_name, category, in_name, quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, recipeIngredient.getRecId());
            stmt.setInt(2, ingId);  // Add unique ingredient ID
            stmt.setInt(3, recipeIngredient.getDishId());
            stmt.setString(4, recipeIngredient.getRecName());
            stmt.setString(5, recipeIngredient.getCategory());
            stmt.setString(6, recipeIngredient.getInName());
            stmt.setString(7, recipeIngredient.getQuantity());

            stmt.executeUpdate();  // Executes the insert operation
        } catch (SQLException e) {
            throw new SQLException("Error while inserting recipe ingredient", e);
        }
    }

    @Override
    public boolean isRecipeIdExists(int recId) throws SQLException {  // Add SQLException to the method signature
        String query = "SELECT COUNT(*) FROM recipe_ingredients WHERE rec_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, recId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;  // Return true if rec_id exists
                }
            }
        }
        return false;  // Return false if rec_id does not exist
    }

    @Override
    public void searchRecipeById(int recipeId) throws SQLException {
        String query = "SELECT * FROM dishes WHERE dish_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, recipeId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Dish ID: " + rs.getInt("dish_id"));
                System.out.println("Dish Name: " + rs.getString("name"));
                System.out.println("Category: " + rs.getString("category"));
                System.out.println("Creation Date: " + rs.getTimestamp("creation_date"));
                System.out.println("-------------------------------");
            } else {
                System.out.println("No recipe found with the given recipe_id.");
            }
        } catch (SQLException e) {
            throw new SQLException("Error while searching for recipe by ID", e);
        }
    }

    @Override
    public void searchRecipe(int recipeId) throws SQLException {
        String query = "SELECT * FROM recipe_ingredients WHERE rec_id = ?";  // Fetch all ingredients for the given rec_id

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, recipeId);  // Set the provided recipe_id as parameter for the query

            try (ResultSet rs = stmt.executeQuery()) {
                boolean found = false;  // Flag to check if any records are found

                // Loop through the result set to display all ingredients for the given recipe_id
                while (rs.next()) {
                    found = true;
                    System.out.println("Dish ID: " + rs.getInt("dish_id"));
                    System.out.println("Recipe ID: " + rs.getInt("rec_id"));
                    System.out.println("Ingredient ID: " + rs.getInt("ing_id"));
                    System.out.println("Recipe Name: " + rs.getString("rec_name"));
                    System.out.println("Category: " + rs.getString("category"));
                    System.out.println("Ingredient Name: " + rs.getString("in_name"));
                    System.out.println("Quantity: " + rs.getString("quantity"));
                    System.out.println("-------------------------------");
                }

                if (!found) {
                    System.out.println("No ingredients found for the given recipe_id.");
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error while searching for ingredients by recipe_id", e);
        }
    }


    private int generateIngId() throws SQLException {
        String query = "SELECT MAX(ing_id) FROM recipe_ingredients";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1) + 1;
            }
        }
        return 1; // Return 1 if no ingredients exist (first ingredient)
    }
}
