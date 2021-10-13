import java.util.*;
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

    private static void CreateTestRecipe()
    {
        ArrayList<String> ingredients = new ArrayList<String>();
        ingredients.add("INGREDIENT 1");
        ingredients.add("INGREDIENT 2");
        
        ArrayList<String> steps = new ArrayList<String>();
        steps.add("STEP 1");
        steps.add("STEP 2");
        
        Recipe newRecipe = new Recipe("NAME", "DESCRIPTION", ingredients, steps);

        newRecipe.SaveToJSON();
    }
}
