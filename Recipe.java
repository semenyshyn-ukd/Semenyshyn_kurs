import enums.RecipeCategory;

import java.util.ArrayList;

public class Recipe {
    private int recipeId;
    private String nameCocktail;
    private ArrayList<String> ingredients;
    private ArrayList<String> instruction;
    private RecipeCategory category;
    private boolean favorite;

    public Recipe(
            String nameCocktail,
            ArrayList<String> ingredients, ArrayList<String> instruction,
            RecipeCategory category,
            boolean favorite
    ) {
        this.recipeId = recipeId;
        this.nameCocktail = nameCocktail;
        this.ingredients = ingredients;
        this.instruction = instruction;
        this.category = category;
        this.favorite = favorite;
    }

    public int getRecipeId() {return recipeId;}
    public void setRecipeId(int recipeId) {this.recipeId = recipeId;}

    public String getNameCocktail() {
        return nameCocktail;
    }
    public void setNameCocktail(String nameCocktail) {
        this.nameCocktail = nameCocktail;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }
    public void setIngredients(ArrayList<String> ingredients) {this.ingredients = ingredients;}

    public ArrayList<String> getInstruction() {
        return instruction;
    }
    public void setInstruction(ArrayList<String> instruction) {this.instruction = instruction;}

    public RecipeCategory getCategory() {return category;}
    public void setCategory(RecipeCategory category) {this.category = category;}

    public boolean isFavorite() {return favorite;}
    public void setFavorite(boolean isFavorite) {this.favorite = isFavorite;}

    @Override
    public String toString() {
        return "\nНазва напою: " + nameCocktail +
                "\nІнгредієнти напою: " + ingredients +
                "\nСпосіб приготування: " + instruction +
                "\nКатегорія: " + category +
                "\nУлюблений: " + (favorite ? "так" : "ні");
    }
}
