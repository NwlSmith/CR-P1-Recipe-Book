import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        CreateTestRecipe();

        Recipe spaghettiRecipe = new Recipe("Spaghetti and meatballs");
        Recipe toastRecipe = new Recipe("Toast");
        
        spaghettiRecipe.PrintToConsole();
        toastRecipe.PrintToConsole();
    }

    private static void CreateTestRecipe()
    {
        Recipe recipe = new Recipe();

        recipe.name = "NAME";
        recipe.description = "DESCRIPTION";

        ArrayList<String> ingredients = new ArrayList<String>();
        ingredients.add("INGREDIENT 1");
        ingredients.add("INGREDIENT 2");
        recipe.ingredients = ingredients;

        ArrayList<String> steps = new ArrayList<String>();
        steps.add("STEP 1");
        steps.add("STEP 2");
        recipe.steps = steps;

        recipe.SaveToJSON();

        recipe.PrintToConsole();
    }
}
