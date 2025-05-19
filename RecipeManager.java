import enums.RecipeCategory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RecipeManager {
    private ArrayList<Recipe> menu = new ArrayList<>();

    public ArrayList<Recipe> getMenu() {
        return new ArrayList<>(menu);
    }

    public void setMenu(ArrayList<Recipe> menu) {
        this.menu = menu;
    }

    public Recipe search(int recipeId) {
        if (menu.isEmpty()) {
            System.out.println("Таких рецептів не знайдено!");
            return null;
        }

        for (Recipe search : menu) {
            if (search.getRecipeId() == recipeId) {
                return search;
            }
        }
        return null;
    }

    public ArrayList<Recipe> searchName(String nameCocktail){
        ArrayList<Recipe> results = new ArrayList<>();
        if (menu.isEmpty()) {
            System.out.println("Таких рецептів не знайдено!");
            return results;
        }

        for (Recipe search : menu) {
            if (search.getNameCocktail().equalsIgnoreCase(nameCocktail)) {
                results.add(search);
            }
        }
        return results;
    }
    public ArrayList<Recipe> searchCategory(RecipeCategory category) {
        ArrayList<Recipe> results = new ArrayList<>();
        if (menu.isEmpty()) {
            System.out.println("Таких рецептів не знайдено!");
            return results;
        }

        for (Recipe search : menu) {
            if (search.getCategory().equals(category)) {
                results.add(search);
            }
        }
        return results;
    }
    public ArrayList<Recipe> searchIngredient(String ingredient) {
        ArrayList<Recipe> results = new ArrayList<>();
        if (menu.isEmpty()) {
            System.out.println("Таких рецептів не знайдено!");
            return results;
        }

        for (Recipe search : menu) {
            for (String recipeIngredient : search.getIngredients()) {
                if (recipeIngredient.toLowerCase().contains(ingredient.toLowerCase())) {
                    results.add(search);
                    break;
                }
            }
        }
        return results;
    }

    public void addRecipe(Recipe recipe) {
        int recipeId = menu.size() + 1;
        recipe.setRecipeId(recipeId);
        menu.add(recipe);
        System.out.println("Рецепт з ID " + recipeId + " додано!");
    }

    public void removeRecipe(int recipeId) {
        if (menu.isEmpty()){
            System.out.println("Таких рецептів не знайдено!");
            return;
        }

        Recipe recipeToRemove = search(recipeId);

        if (recipeToRemove != null) {
            menu.remove(recipeToRemove);
            System.out.println("Рецепт видалено!");
        } else {
            System.out.println("Такого рецепту не знайдено!");
        }
    }

    public void editRecipeName(int recipeId, String newName) {
        Recipe edit = search(recipeId);

        if (edit != null) {
            edit.setNameCocktail(newName);
            System.out.println("Назву змінено");
        } else {
            System.out.println("Такого рецепту не знайдено!");
        }
    }
    public void addRecipeIngredients(int recipeId, String newIngredient) {
        Recipe edit = search(recipeId);

        if (edit != null) {
            edit.getIngredients().add(newIngredient);
            System.out.println("Інгредієнт додано!");
        } else {
            System.out.println("Такого рецепту не знайдено!");
        }
    }
    public void deleteRecipeIngredients(int recipeId, String deleteIngredient) {
        Recipe edit = search(recipeId);
        if (edit != null) {
            if(edit.getIngredients().equals(deleteIngredient)) {
                edit.getIngredients().remove(deleteIngredient);
                System.out.println("Інгредієнт видалено!");
            } else {
                System.out.println("Інгредієнта не знайдено!");
            }
        } else {
            System.out.println("Такого рецепту не знайдено!");
        }
    }
    public void addRecipeInstruction(int recipeId, String newInstruction) {
        Recipe edit = search(recipeId);

        if (edit != null) {
            edit.getInstruction().add(newInstruction);
            System.out.println("Дію додано!");
        } else {
            System.out.println("Такого рецепту не знайдено!");
        }
    }
    public void deleteRecipeInstruction(int recipeId, String deleteInstruction) {
        Recipe edit = search(recipeId);
        if (edit != null) {
            if(edit.getInstruction().equals(deleteInstruction)) {
                edit.getInstruction().remove(deleteInstruction);
                System.out.println("Дію видалено!");
            } else {
                System.out.println("Дії не знайдено!");
            }
        } else {
            System.out.println("Такого рецепту не знайдено!");
        }
    }
    public void editCategory(int recipeId, RecipeCategory newCategory) {
        Recipe edit = search(recipeId);

        if (edit != null) {
            edit.setCategory(newCategory);
            System.out.println("Категорію змінено!");
        } else {
            System.out.println("Категорію не знайдено!");
        }
    }

    public void orFavorite(int recipeId) {
        Recipe fav = search(recipeId);

        if (fav != null) {
            fav.setFavorite(!fav.isFavorite());
            System.out.println("Статус улюбленого рецепту змінено на: " + (fav.isFavorite() ? "Так" : "Ні"));
        } else {
            System.out.println("Рецепт не знайдено!");
        }
    }

    public void sortName() {
        if (menu.isEmpty()) {
            System.out.println("Меню порожнє, додайте рецепт");
            return;
        }

        Collections.sort(menu, Comparator.comparing(Recipe::getNameCocktail));
        System.out.println("Рецепти відсортовані за назвою.");
        show();
    }
    public void sortByIngredients() {
        if (menu.isEmpty()) {
            System.out.println("Меню порожнє, додайте рецепт");
            return;
        }

        Collections.sort(menu, new Comparator<Recipe>() {
            @Override
            public int compare(Recipe recipe1, Recipe recipe2) {
                return Integer.compare(recipe1.getIngredients().size(), recipe2.getIngredients().size());
            }
        });
        System.out.println("Рецепти відсортовані за кількістю інгредієнтів.");
        show();
    }
    public void sortByCategory() {
        if (menu.isEmpty()) {
            System.out.println("Меню порожнє, додайте рецепт");
            return;
        }

        Collections.sort(menu, Comparator.comparing(Recipe::getCategory));
        System.out.println("Рецепти відсортовані за категоріями.");
        show();
    }

    public void show(){
        if (menu.isEmpty()){
            System.out.println("Таких рецептів не знайдено!");
            return;
        }

        System.out.println("Ваше меню:");
        for (Recipe show : menu) {
            System.out.println(show);
        }
    }
}