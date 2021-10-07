import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    
    static RecipeBook recipes = new RecipeBook();

    public static void main(String[] args) {
        //setup();
        //CreateRecipe();
        
    }

    public static void setup() {
        File folder = new File("./savedrecipes/");
        File [] fileList = folder.listFiles();
        
        for (File file : fileList) {
            recipes.addRecipe(new Recipe(file.getName()));
        }
    }

    private static void CreateRecipe(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a recipe name: ");
        String fileName = in.nextLine();
        String name = fileName;
        System.out.println("Please enter a description for your recipe: ");
        String description = in.nextLine();
        
        ArrayList<String> ingredients = new ArrayList<String>();
        while(true) {
            System.out.println("Please enter your ingredients one by one, press enter when you finish entering the current ingredient, enter 'done' when you are done: ");
            String ingredient = in.nextLine();
            if (ingredient.equals("done")) {
                break;
            }
            ingredients.add(ingredient);
        }
        
        ArrayList<String> steps = new ArrayList<String>();
        while(true) {
            System.out.println("Please provide a step-to-step instruction, press enter when you finish entering the current step, enter 'done' when you are done: ");
            String step = in.nextLine();
            if (step.equals("done")) {
                break;
            }
            steps.add(step);
        }
        in.close();
       
        Recipe newRecipe = new Recipe(fileName, name, description, ingredients, steps);

        newRecipe.SaveToJSON();
        recipes.addRecipe(newRecipe);
    }
}
