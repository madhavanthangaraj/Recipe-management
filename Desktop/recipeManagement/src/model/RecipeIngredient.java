package model;

public class RecipeIngredient {
    private int recId;         // Recipe ID to be set by user input
    private int dishId;        // Dish ID to associate with the dish table
    private String recName;    // Name of the recipe
    private String category;   // Category (e.g., Vegetarian or Non-Vegetarian)
    private String inName;     // Name of the ingredient
    private String quantity;   // Quantity of the ingredient

    // Updated constructor to include recId
    public RecipeIngredient(int recId, int dishId, String recName, String category, String inName, String quantity) {
        this.recId = recId;
        this.dishId = dishId;
        this.recName = recName;
        this.category = category;
        this.inName = inName;
        this.quantity = quantity;
    }

    // Getter and setter methods
    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInName() {
        return inName;
    }

    public void setInName(String inName) {
        this.inName = inName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "RecipeIngredient [recId=" + recId + ", dishId=" + dishId + ", recName=" + recName +
               ", category=" + category + ", inName=" + inName + ", quantity=" + quantity + "]";
    }
}
