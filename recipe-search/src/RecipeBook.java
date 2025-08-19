import java.util.ArrayList;

public class RecipeBook {
    private RecipeReader recipeReader;

    public RecipeBook(RecipeReader recipeReader) {
        this.recipeReader = recipeReader;
    }
    
    public void listRecipes() {
        ArrayList<Recipe> recipes = recipeReader.getRecipes();

        System.out.println("\nRecipes:");
        for (Recipe recipe : recipes) {
            System.out.println(recipe);
        }
    }

    public void findName(String searchTerm) {
       ArrayList<Recipe> recipes = recipeReader.getRecipes();
        System.out.println("\nRecipes:");
    
        for (Recipe recipe : recipes) {
        if (recipe.getName().contains(searchTerm)) {
            System.out.println(recipe);
        }
    }
    }

    public void findByIngredient(String ingred) {
        ArrayList<Recipe> recipes = recipeReader.getRecipes();
        System.out.println("\nRecipes:");
    
        for (Recipe recipe : recipes) {
        if (recipe.getIngredients().contains(ingred)) {
            System.out.println(recipe);
        }
    }
    }

    public void findByTime(int maxTime) {
        ArrayList<Recipe> recipes = recipeReader.getRecipes();
        System.out.println("\nRecipes:");

        for(Recipe recipe : recipes) {
            if (recipe.getCookingTime() <= maxTime) {
                System.out.println(recipe);
            }
        }
    }

    public void printMenu() {
        System.out.println("\nCommands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
    }

    
}
