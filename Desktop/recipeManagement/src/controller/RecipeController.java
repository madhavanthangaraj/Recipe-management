package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Date;

import service.RecipeIngredientService;
import service.ReviewService;
import service.UserService;
import model.RecipeIngredient;
import model.Review;
import model.User;

public class RecipeController {
    private final RecipeIngredientService recipeIngredientService;
    private final ReviewService reviewService;
    private final UserService userService;
    private BufferedReader br;

    public RecipeController() {
        this.recipeIngredientService = new RecipeIngredientService();
        this.reviewService = new ReviewService();
        this.userService = new UserService();
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() throws NumberFormatException, IOException, SQLException {
        boolean running = true;
        int choice;
        while (running) {
            displayMenu();
            choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    addRecipe();
                    break;
                case 2:
                    searchRecipeById();
                    break;
                case 3:
                    searchRecipe();
                    break;
                case 4:
                    registerUser(); // New option for user registration
                    break;   
                case 5:
                    loginAndAddReview();
                    break;
             
                case 0:
                    running = false;
                    System.out.println("Exiting the app. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public void displayMenu() {
        System.out.println("=== Recipe Management ===");
        System.out.println("1. Add Recipe");
        System.out.println("2. Search Dishes by ID");
        System.out.println("3. Search Ingredients by Recipe ID");
        System.out.println("4. Register");
        System.out.println("5. Add Review for Recipe");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    public void addRecipe() throws NumberFormatException, IOException, SQLException {
        System.out.print("Enter Recipe ID: ");
        int recId = Integer.parseInt(br.readLine());

        if (recipeIngredientService.isRecipeIdExists(recId)) {
            System.out.println("Error: Recipe ID " + recId + " already exists.");
            return;
        }

        System.out.print("Enter Dish ID: ");
        int dishId = Integer.parseInt(br.readLine());

        System.out.print("Enter Recipe Name: ");
        String recName = br.readLine();

        System.out.print("Enter Category (Vegetarian/Non-Vegetarian): ");
        String category = br.readLine();

        System.out.print("Enter the number of ingredients: ");
        int numIngredients = Integer.parseInt(br.readLine());

        for (int i = 0; i < numIngredients; i++) {
            System.out.print("Enter Ingredient " + (i + 1) + " Name: ");
            String inName = br.readLine();

            System.out.print("Enter Ingredient " + (i + 1) + " Quantity: ");
            String quantity = br.readLine();

            RecipeIngredient recipeIngredient = new RecipeIngredient(recId, dishId, recName, category, inName, quantity);
            recipeIngredientService.addRecipeIngredient(recipeIngredient);
            System.out.println("Ingredient " + inName + " added successfully!");
        }

        System.out.println("Recipe added with Recipe ID: " + recId);
    }

    public void searchRecipeById() throws SQLException, IOException {
        System.out.print("Enter Recipe ID to search: ");
        int recipeId = Integer.parseInt(br.readLine());
        recipeIngredientService.searchRecipeById(recipeId);
    }
    public void registerUser() throws IOException, SQLException {
        System.out.println("=== User Registration ===");
        System.out.print("Enter Username: ");
        String username = br.readLine();
        
        System.out.print("Enter Password: ");
        String password = br.readLine();
        
        System.out.print("Enter Email: ");
        String email = br.readLine();

        // Create a new User object
        User newUser = new User(0, username, password, email, new java.util.Date());

        // Register user through UserService
        userService.registerUser(newUser);
        System.out.println("User registered successfully!");
    }
    public void searchRecipe() throws SQLException, IOException {
        System.out.print("Enter Recipe ID to search for ingredients: ");
        int recipeId = Integer.parseInt(br.readLine());
        recipeIngredientService.searchRecipe(recipeId);
    }

    public void loginAndAddReview() throws IOException, SQLException {
        System.out.print("Enter User ID: ");
        int userId = Integer.parseInt(br.readLine());

        // Check if the user exists in the database
        if (!userService.isUserExists(userId)) {
            System.out.println("Error: User ID " + userId + " does not exist. Please register first.");
            return;
        }

        System.out.print("Enter Username: ");
        String userName = br.readLine();

        System.out.print("Enter Password: ");
        String password = br.readLine();

        // Authenticate user (basic validation here; ideally should check stored passwords)
        if (authenticateUser(userId, password)) {
            System.out.println("Login successful!");

            // Collecting review details
            System.out.print("Enter Recipe ID to review: ");
            int recipeId = Integer.parseInt(br.readLine());

            // Ensure rating is between 0 and 5
            double rating;
            while (true) {
                System.out.print("Enter Rating (0 to 5): ");
                rating = Double.parseDouble(br.readLine());
                if (rating >= 0 && rating <= 5) {
                    break;
                } else {
                    System.out.println("Invalid rating! Please enter a rating between 0 and 5.");
                }
            }

            System.out.print("Enter Review Comment: ");
            String comment = br.readLine();

            // Create a new Review object and add it to the database
            Review review = new Review(0, recipeId, userId, userName, rating, comment, new Date());
            reviewService.addReview(review);

            System.out.println("Review added successfully!");
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    // Basic authentication method (placeholder)
    private boolean authenticateUser(int userId, String password) {
        return userId > 0 && password != null && !password.isEmpty();
    }


    public void addReview(int userId, String userName) throws IOException, SQLException {
        System.out.print("Enter Recipe ID to review: ");
        int recipeId = Integer.parseInt(br.readLine());

        double rating;
        while (true) {
            System.out.print("Enter Rating (0 to 5): ");
            rating = Double.parseDouble(br.readLine());
            if (rating >= 0 && rating <= 5) {
                break;
            } else {
                System.out.println("Invalid rating! Please enter a rating between 0 and 5.");
            }
        }

        System.out.print("Enter Review Comment: ");
        String comment = br.readLine();

        Review review = new Review(0, recipeId, userId, userName, rating, comment, new Date());

        reviewService.addReview(review);
        System.out.println("Review added successfully!");
    }
}
