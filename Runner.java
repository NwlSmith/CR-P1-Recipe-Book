import java.util.Scanner;

public class Runner {
	public static void main(String[]args) {
		boolean running = true;
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
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
				// Go to recipe code and create a recipe
				// Should be in JenBranch
			}
			else if(Integer.parseInt(input)== 2) {
				/* 1. Retrieve recipe
				 * 2. Can read the entire recipe, description, ingredients, instructions
				 * 3. Can step through the instructions one at a time*/
				
				// Retrieve recipe book. Display all of the recipes
				RecipeExploration();
				
			}
			else if(Integer.parseInt(input)== 3) {
				// Go to recipe code and search function
				// Should be in JenBranch
			}
			
			else {
				System.out.println("That is not a valid input.");
			}
			
		}
		System.out.println("");
		scanner.close();
		
	}
	
	private static void RecipeExploration() {
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
		String input;
		boolean running = true;
		
		while(running) {
			System.out.println("\nPlease pick a recipe out of the ones below or type back to go back.");
			// Code to retrieve the recipes
			System.out.println("1. Lorem ipsum dolor sit amet, consectetur adipiscing elit,");
			System.out.println("2. sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
			System.out.println("3. Ut enim ad minim veniam");

			input = scanner.nextLine();
			
			if(input.toLowerCase().equals("back")) {
				running = false;
			}
			else {
				// For loop for finding number through the indexes of recipes
				// If not found, say not valid input
				
				
				//Found
				System.out.println("1 for entire recipe, 2 for step-by-step");
				input = scanner.nextLine();
				if(Integer.parseInt(input) == 1)
					ViewRecipe();
				else if(Integer.parseInt(input) == 2)
					StepByStep();
				else
					System.out.println("Not a valid answer");
			}
			
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
}
