package enums;

public enum RecipeCategory {
    ALCOHOL ("алкогольний"),
    NON_ALCOHOLIC("безалкогольний"),
    HOT("гарячий");

    private final String categoryName;

    RecipeCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {return categoryName;}

    @Override
    public String toString() {return categoryName;}
}