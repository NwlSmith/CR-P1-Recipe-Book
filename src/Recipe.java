import java.util.*;

/**
 * Class containing recipe data as well as methods for saving and loading.
 * Contains a name, description, list of ingredients, and instruction steps.
 */

public class Recipe {

    public String name = "";
    public String description = "";
    public ArrayList<String> ingredients;
    public ArrayList<String> steps;

    public Recipe() {
        ingredients = new ArrayList<String>();
        steps = new ArrayList<String>();
    }

    public void SaveToJSON()
    {

    }

    public void LoadFromJSON()
    {

    }

    public void PrintToConsole()
    {
        System.out.println("Name:");
        System.out.println(name);
        System.out.println("Description:");
        System.out.println(description);
        System.out.println("Ingredients:");
        for (String ingredient : ingredients) {
            System.out.println(ingredient);
        }
        System.out.println("Instructions:");
        for (String step : steps) {
            System.out.println(step);
        }
    }
}
