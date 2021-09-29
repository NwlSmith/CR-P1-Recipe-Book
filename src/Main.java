import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World!");

        Recipe recipe = new Recipe();

        recipe.name = "test recipe";
        recipe.description = "description";
        ArrayList<String> ingredients = new ArrayList<String>();
        ingredients.add("test 1");
        ingredients.add("test 2");
        ingredients.add("test 3");
        recipe.ingredients = ingredients;
        ArrayList<String> steps = new ArrayList<String>();
        steps.add("test steps 1");
        steps.add("test steps 2");
        steps.add("test steps 3");
        recipe.steps = steps;

        recipe.PrintToConsole();
    }
}
