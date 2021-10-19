import java.io.File;

public class Main {
	
	static RecipeBook recipes = new RecipeBook();

    public static void main(String[] args) {
    	populateRecipeBook(); 
    	
        /* main program */
    	GUI uiWindow = new GUI(recipes);
    	uiWindow.renderInterface();
    }

    public static void populateRecipeBook() {
    	File folder = new File("./savedrecipes/");
    	File [] fileList = folder.listFiles();
    	for (File file : fileList) {
    		recipes.addRecipe(new Recipe(file.getName()));
    	}
    }
}
