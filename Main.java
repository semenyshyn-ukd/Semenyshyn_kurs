import enums.RecipeCategory;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeManager manager = new RecipeManager();

        while (true) {
            System.out.println("\nМЕНЮ УПРАВЛІННЯ РЕЦЕПТАМИ");
            System.out.println("1. Додати новий рецепт");
            System.out.println("2. Показати всі рецепти");
            System.out.println("3. Пошук рецепту за назвою");
            System.out.println("4. Пошук рецепту за категорією");
            System.out.println("5. Пошук рецепту за інгредієнтом");
            System.out.println("6. Редагувати назву рецепту");
            System.out.println("7. Додати інгредієнт до рецепту");
            System.out.println("8. Видалити інгредієнт з рецепту");
            System.out.println("9. Додати інструкцію до рецепту");
            System.out.println("10. Видалити інструкцію з рецепту");
            System.out.println("11. Змінити категорію рецепту");
            System.out.println("12. Додати/видалити рецепт з улюблених");
            System.out.println("13. Сортувати рецепти за назвою");
            System.out.println("14. Сортувати рецепти за кількістю інгредієнтів");
            System.out.println("15. Сортувати рецепти за категорією");
            System.out.println("16. Видалити рецепт");
            System.out.println("0. Вихід");
            System.out.print("Виберіть опцію: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: //додати рецепт
                    System.out.print("Введіть назву напою: ");
                    String name = scanner.nextLine();

                    ArrayList<String> ingredients = new ArrayList<>();
                    System.out.println("Введіть інгредієнти(через кому):");
                    String ingredient = scanner.nextLine();
                    ingredient.split(", ");
                    ingredients.add(ingredient);

                    ArrayList<String> instructions = new ArrayList<>();
                    System.out.println("Введіть інструкції (через кому):");
                    String instruction = scanner.nextLine();
                    instruction.split(", ");
                    instructions.add(instruction);

                    System.out.println("Виберіть категорію:");
                    for (RecipeCategory category : RecipeCategory.values()) {
                        System.out.println(category.ordinal() + ". " + category);
                    }
                    int categoryIndex = scanner.nextInt();
                    scanner.nextLine();
                    RecipeCategory category = RecipeCategory.values()[categoryIndex];

                    boolean isFavorite = false;

                    Recipe newRecipe = new Recipe(name, ingredients, instructions, category, isFavorite);
                    manager.addRecipe(newRecipe);
                    break;

                case 2: // Показати рецепти
                    manager.show();
                    break;

                case 3: // Пошук за назвою
                    System.out.print("Введіть назву рецепту для пошуку: ");
                    String searchName = scanner.nextLine();

                    ArrayList<Recipe> nameResults = manager.searchName(searchName);
                    if (nameResults.isEmpty()) {
                        System.out.println("Рецептів з такою назвою не знайдено.");
                    } else {
                        System.out.println("\nЗнайдені рецепти:");
                        for (Recipe recipe : nameResults) {
                            System.out.println(recipe);
                        }
                    }
                    break;

                case 4: // Пошук за категорією
                    System.out.println("Виберіть категорію для пошуку:");
                    for (RecipeCategory cat : RecipeCategory.values()) {
                        System.out.println(cat.ordinal() + ". " + cat);
                    }
                    int catIndex = scanner.nextInt();
                    scanner.nextLine();
                    RecipeCategory searchCategory = RecipeCategory.values()[catIndex];

                    ArrayList<Recipe> categoryResults = manager.searchCategory(searchCategory);
                    if (categoryResults.isEmpty()) {
                        System.out.println("Рецептів у цій категорії не знайдено.");
                    } else {
                        System.out.println("\nЗнайдені рецепти:");
                        for (Recipe recipe : categoryResults) {
                            System.out.println(recipe);
                        }
                    }
                    break;

                case 5: // Пошук за інгредієнтом
                    System.out.print("Введіть інгредієнт для пошуку: ");
                    String searchIngredient = scanner.nextLine();

                    ArrayList<Recipe> ingredientResults = manager.searchIngredient(searchIngredient);
                    if (ingredientResults.isEmpty()) {
                        System.out.println("Рецептів з цим інгредієнтом не знайдено.");
                    } else {
                        System.out.println("\nЗнайдені рецепти:");
                        for (Recipe recipe : ingredientResults) {
                            System.out.println(recipe);
                        }
                    }
                    break;

                case 6: // Редагувати назву рецепту
                    System.out.print("Введіть індекс рецепту: ");
                    int recipeId = scanner.nextInt();
                    scanner.nextLine();

                    Recipe foundRecipe = manager.search(recipeId);
                    if (foundRecipe != null) {
                        System.out.print("Введіть нову назву рецепту: ");
                        String newName = scanner.nextLine();

                        manager.editRecipeName(recipeId, newName);
                    }
                    break;

                case 7: // Додати інгредієнт
                    System.out.print("Введіть індекс рецепту: ");
                    recipeId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Введіть новий інгредієнт: ");
                    String newIngredient = scanner.nextLine();

                    manager.addRecipeIngredients(recipeId, newIngredient);
                    break;

                case 8: // Видалити інгредієнт
                    System.out.print("Введіть індекс рецепту: ");
                    recipeId = scanner.nextInt();
                    scanner.nextLine();

                    foundRecipe = manager.search(recipeId);
                    if (foundRecipe != null) {
                        System.out.print("Введіть інгредієнт для видалення: ");
                        String deleteIngredient = scanner.nextLine();

                        manager.deleteRecipeIngredients(recipeId, deleteIngredient);
                    }
                    break;

                case 9: // Додати інструкцію
                    System.out.print("Введіть індекс рецепту: ");
                    recipeId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Введіть нову інструкцію: ");
                    String newInstruction = scanner.nextLine();

                    manager.addRecipeInstruction(recipeId, newInstruction);
                    break;

                case 10: // Видалити інструкцію
                    System.out.print("Введіть індекс рецепту: ");
                    recipeId = scanner.nextInt();
                    scanner.nextLine();

                    foundRecipe = manager.search(recipeId);
                    if (foundRecipe != null) {
                        System.out.print("Введіть інструкцію для видалення: ");
                        String deleteInstruction = scanner.nextLine();

                        manager.deleteRecipeInstruction(recipeId, deleteInstruction);
                    }
                    break;

                case 11: // Змінити категорію
                    System.out.print("Введіть індекс рецепту: ");
                    recipeId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Виберіть нову категорію рецепту:");
                    for (RecipeCategory cat : RecipeCategory.values()) {
                        System.out.println(cat.ordinal() + ". " + cat);
                    }
                    int newCatIndex = scanner.nextInt();
                    scanner.nextLine();
                    RecipeCategory newCategory = RecipeCategory.values()[newCatIndex];

                    manager.editCategory(recipeId, newCategory);
                    break;

                case 12: // Додати/видалити з улюблених
                    System.out.print("Введіть індекс рецепту: ");
                    recipeId = scanner.nextInt();
                    scanner.nextLine();

                    manager.orFavorite(recipeId);
                    break;

                case 13: // Сортувати за назвою
                    manager.sortName();
                    break;

                case 14: // Сортувати за кількістю інгредієнтів
                    manager.sortByIngredients();
                    break;

                case 15: // Сортувати за категорією
                    manager.sortByCategory();
                    break;

                case 16: // Видалити рецепт
                    System.out.print("Введіть індекс рецепту для видалення: ");
                    recipeId = scanner.nextInt();
                    scanner.nextLine();

                    manager.removeRecipe(recipeId);
                    break;

                case 0: // Вихід
                    System.out.println("Дякуємо за використання програми!");
                    return;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }
}