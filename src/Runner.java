import java.util.*;
import java.io.File;

public class Runner {
	static RecipeBook recipes = new RecipeBook();
	public static void main(String[]args) {
		setup();
		boolean running = true;
		Scanner scanner = new Scanner(System.in);
		String input;
		
		while(running) {
			System.out.println("Please input a number corresponding to the instruction or exit.");
			System.out.println("1. Create a Recipe");
			System.out.println("2. View all Recipes");
			System.out.println("3. Search for a Recipe");
			
			input = scanner.nextLine();  
			//System.out.println(input);
			
			if(input.toLowerCase().equals("exit")) {
				running = false;
				System.out.println("\nGoodbye!");
			}
			else if(Integer.parseInt(input)== 1) {
				// Create a recipe
				CreateRecipe();
			}
			else if(Integer.parseInt(input)== 2) {
				/* 1. Retrieve recipe
				 * 2. Can read the entire recipe, description, ingredients, instructions
				 * 3. Can step through the instructions one at a time*/
				RecipeExploration();
				
			}
			else if(Integer.parseInt(input)== 3) {
				// Search for recipe
				RecipeSearch();
			}
			
			else {
				System.out.println("That is not a valid input.");
			}
			
		}
		System.out.println("");
		scanner.close();
		
	}
	
	private static void setup() {
		// Taken from Jen main.java
    	File folder = new File("./savedrecipes/");
    	File [] fileList = folder.listFiles();
    	for (File file : fileList) {
    		recipes.addRecipe(new Recipe(file.getName()));
    	}
    }
	
	private static void CreateRecipe() {
		Scanner scanner = new Scanner(System.in);
		String name;
		String description;
		String ingredient;
		String step;
		ArrayList<String> ingredients = new ArrayList<String>();
		ArrayList<String> steps = new ArrayList<String>();
		boolean running = true;
		
		System.out.println("Enter a name for your recipe.");
		name = scanner.nextLine();
		System.out.println("Enter a description for your recipe.");
		description = scanner.nextLine();
		while(running) {
			System.out.println("Enter your ingredient or type next to move onto the steps.");
			ingredient = scanner.nextLine();
			if(ingredient.toLowerCase().equals("next")) {
				running = false;
			}
			else
				ingredients.add(ingredient);
		}
		running = true;
		while(running) {
			System.out.println("Enter your steps one at a type or type finish to complete this recipe.");
			step = scanner.nextLine();
			if(step.toLowerCase().equals("finish")) {
				running = false;
			}
			else
				steps.add(step);
		}
		Recipe recipeInput = new Recipe(name, description, ingredients, steps);
		recipes.addRecipe(recipeInput);
		recipeInput.SaveToJSON();
	}
	
	private static void RecipeExploration() {
		// View all of the recipes
		Scanner scanner = new Scanner(System.in);
		String input;
		String recipeIndex = "-1";
		ArrayList<Recipe> allRecipes;
		ArrayList<Recipe> foundRecipes;
		boolean running = true;
		
		System.out.println();
		while(running) {
			// Print all the recipes
			allRecipes = recipes.getAllRecipes();
			for(int i = 0; i < allRecipes.size(); i++) {
				System.out.print(i+1);
				System.out.println(". "+allRecipes.get(i).name);
			}
			
			// Need to enter a valid number loop
			while(Integer.parseInt(recipeIndex) <= 0 || Integer.parseInt(recipeIndex) > allRecipes.size()) {
				System.out.println("\nPlease enter a valid number of a recipe from the ones above or type back.");
				recipeIndex = scanner.nextLine();
				if(recipeIndex.toLowerCase().equals("back")) {
					running = false;
					break;
				}
			}
			
			// Should be a better way to do this instead of writing it twice
			if(recipeIndex.toLowerCase().equals("back")) {
				break;
			}
			else
				ViewRecipe(allRecipes.get(Integer.parseInt(recipeIndex)-1));
			running = false;
		}
	}
	
	private static void ViewRecipe(Recipe recipe) {
		Scanner scanner = new Scanner(System.in);
		String input;
		boolean running = true;
		while(running) {
			System.out.println("1 for entire recipe, 2 for step-by-step");
			input = scanner.nextLine();
			if(Integer.parseInt(input) == 1) {
				System.out.println(recipe);
				running = false;
			}
			else if(Integer.parseInt(input) == 2) {
				StepByStep(recipe);
				running = false;
			}				
			else
				System.out.println("Not a valid answer");
		}
		
	}
	
	private static void StepByStep(Recipe recipe) {
		Scanner scanner = new Scanner(System.in);
		String input;
		boolean running = true;
		System.out.println("Enter “y” when you are ready for the next step: ");
		for(int i = 0; i < recipe.steps.size(); i++) {
			System.out.println(recipe.steps.get(i));
			running = true;
			while(running) {
				input = scanner.nextLine();
				// If they type y, it breaks out of loop onto next step
				if((input.toLowerCase().equals("y")))
					running = false;
			}
		}
	}
	
	private static void RecipeSearch() {
		Scanner scanner = new Scanner(System.in);
		String input;
		String recipeIndex = "-1";
		ArrayList<Recipe> results; 
		boolean running = true;
		boolean finding = true;
		
		while(running) {
			running = true;
			finding = true;
			recipeIndex = "-1";
			
			System.out.println("Please enter your keywords to search by recipe name or back to go to the main menu:");
			input = scanner.nextLine();
			
			if(input.toLowerCase().equals("back")) {
				running = false;
			}
			else {
				results = recipes.find(input);
				
				while(finding) {
					if(results.size() == 0)
						System.out.println("Nothing found for that keyword");
					else {
						System.out.println("\nPlease select a recipe from the ones below.");
						// Print all the recipes
						for(int i = 0; i < results.size(); i++) {
							System.out.print(i+1);
							System.out.println(". "+results.get(i).name);
						}
						finding = false;
					}
				}
				
				
				//Select a recipe
				// Need to enter a valid number
				while(Integer.parseInt(recipeIndex) <= 0 || Integer.parseInt(recipeIndex) > results.size()) {
					System.out.println("\nPlease enter a valid number of a recipe from the ones above or type back.");
					recipeIndex = scanner.nextLine();
					if(recipeIndex.toLowerCase().equals("back")) {
						running = false;
						break;
					}
				}
				if(recipeIndex.toLowerCase().equals("back")) {
					running = false;
				}
				else
					ViewRecipe(results.get(Integer.parseInt(recipeIndex)-1));
			}
			
		}
	}
}
