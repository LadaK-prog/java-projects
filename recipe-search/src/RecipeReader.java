import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class RecipeReader {
    private ArrayList<Recipe> recipes;

    public RecipeReader() {
        this.recipes = new ArrayList<>();
    }

    public void readRecipesFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {

                String name = fileScanner.nextLine();

                int cookingTime = Integer.valueOf(fileScanner.nextLine());

                Recipe recipe = new Recipe(name, cookingTime);

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    if (line.isEmpty()) {
                        break;
                    }
                    recipe.addIngredients(line);
                }
                recipes.add(recipe);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

}
