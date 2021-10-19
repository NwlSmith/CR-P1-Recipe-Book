import java.io.File;

public class Main {
	
	static RecipeBook recipes = new RecipeBook();

    public static void main(String[] args) {
    	populateRecipeBook();

        /* main program */
        try {
            String choice = args[0];
            if (choice.equalsIgnoreCase("gui")) {
                GUI uiWindow = new GUI(recipes);
                uiWindow.renderInterface();
            }
            else if (choice.equalsIgnoreCase("cli")) {
                Runner CLI = new Runner(recipes);
                CLI.startCLI();
            }
            else {
                System.out.println("Invalid interface type. Please add a valid argument 'gui' or 'cli'");
            }
        }
        catch(ArrayIndexOutOfBoundsException e ) {
            System.err.println("No interface choice provided. Try again.");
        }
        catch(Exception e) {
            System.err.println("\nSomething went wrong ¯\\_(ツ)_/¯\n");
        }
    }

    public static void populateRecipeBook() {
    	File folder = new File("./savedrecipes/");
    	File [] fileList = folder.listFiles();
    	for (File file : fileList) {
    		recipes.addRecipe(new Recipe(file.getName()));
    	}
    }
}
