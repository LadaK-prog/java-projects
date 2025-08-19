import java.util.*;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeReader reader = new RecipeReader();
        RecipeBook recipeBook = new RecipeBook(reader);

        System.out.println("File to read: ");
        String filename = scanner.nextLine();
        reader.readRecipesFromFile(filename);
        recipeBook.printMenu();

        while (true) {
            System.out.print("\nEnter command: ");
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            } else if (command.equals("list")) {
                recipeBook.listRecipes();
            } else if (command.equals("find name")) {
                System.out.print("Searched word: ");
                String searchTerm = scanner.nextLine();
                recipeBook.findName(searchTerm);
            } else if (command.equals("find cooking time")) {
                System.out.print("Max cooking time: ");
                int maxTime = scanner.nextInt();
                scanner.nextLine();
                recipeBook.findByTime(maxTime);
            } else if (command.equals("find ingredient")) {
                System.out.print("Ingredient: ");
                String ingred = scanner.nextLine();
                recipeBook.findByIngredient(ingred);
            }
        }

    }

}
