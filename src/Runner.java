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
				
				// Retrieve recipe book. Display all of the recipes
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
	}
	
	private static void RecipeExploration() {
		// View all of the recipes
		Scanner scanner = new Scanner(System.in);
		String input;
		ArrayList<Recipe> results; 
		boolean running = true;
		
		while(running) {
			System.out.println("Please select a recipe from the ones below or type back to go to the main menu.");
			// Print all the recipes
			for(int i = 0; i < results.size(); i++) {
				System.out.println(results.get(i));
			}
			input = scanner.nextLine();
			
			if(input.toLowerCase().equals("back")) {
				running = false;
			}
			else {
				results = recipes.find(input);
				
				
				
				
				System.out.println("1 for entire recipe, 2 for step-by-step");
				input = scanner.nextLine();
				if(Integer.parseInt(input) == 1)
					ViewRecipe();
				else if(Integer.parseInt(input) == 2)
					StepByStep();
				else
					System.out.println("Not a valid answer");
			}
			System.out.println("\nPlease pick a recipe out of the ones below or type back to go back.");
			// Code to retrieve the recipes
			System.out.println("1. Lorem ipsum dolor sit amet, consectetur adipiscing elit,");
			System.out.println("2. sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
			System.out.println("3. Ut enim ad minim veniam");
			System.out.println("");
		}
	}
	
	private static void ViewRecipe() {
		System.out.println("Recipe Name: ");
		System.out.println("Description: ");
		System.out.println("Ingredient List: ");
		System.out.println("Step-by-step Instructions:");
	}
	
	private static void StepByStep() {
		int length = 10;
		
		for(int i = 0; i < length; i++) {
			System.out.println(i);
		}
	}
	
	private static void RecipeSearch() {
		Scanner scanner = new Scanner(System.in);
		String input;
		ArrayList<Recipe> results; 
		boolean running = true;
		
		while(running) {
			System.out.println("Please type the recipe name or back to go back to the main menu.");
			input = scanner.nextLine();
			
			if(input.toLowerCase().equals("back")) {
				running = false;
			}
			else {
				results = recipes.find(input);
				
				System.out.println("Please select a recipe from the ones below.");
				// Print all the recipes
				for(int i = 0; i < results.size(); i++) {
					System.out.println(results.get(i));
				}
				
				
				System.out.println("1 for entire recipe, 2 for step-by-step");
				input = scanner.nextLine();
				if(Integer.parseInt(input) == 1)
					ViewRecipe();
				else if(Integer.parseInt(input) == 2)
					StepByStep();
				else
					System.out.println("Not a valid answer");
			}
			System.out.println("\nPlease pick a recipe out of the ones below or type back to go back.");
			// Code to retrieve the recipes
			
		}
	}
}
