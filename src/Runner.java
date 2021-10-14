import java.util.*;

public class Runner {
	private RecipeBook recipes;
	private boolean running;
	private Scanner scanner;

	public Runner (RecipeBook recipes) {
		this.recipes = recipes;
		running = true;
		scanner = new Scanner(System.in);
	}

	public void startCLI() {
		String input;

		while (running) {
			System.out.println("\nPlease input a number corresponding to the instruction or 'exit'.");
			System.out.println("1. Create a Recipe");
			System.out.println("2. View all Recipes");
			System.out.println("3. Search for a Recipe");
			System.out.print("\nInput: ");
			
			input = scanner.nextLine();

			if (isNumber(input)) {
				int choice = Integer.parseInt(input);
				if (choice == 1) {
					divider("create a recipe");
					// Create a recipe
					CreateRecipe();
				}
				else if (choice == 2) {
					divider("view all recipes");
					/* 1. Retrieve recipe
					 * 2. Can read the entire recipe, description, ingredients, instructions
					 * 3. Can step through the instructions one at a time*/
					RecipeExploration();
				}
				else if (choice == 3) {
					divider("search a recipe");
					// Search for recipe
					RecipeSearch();
				}
				else {
					System.out.println("That is not a valid input.\n");
				}
				running = true;
			}
			else if (input.equalsIgnoreCase("exit")) {
				running = false;
				System.out.println("\nGoodbye!");
			}
			else {
				System.out.println("That is not a valid input.\n");
			}
		}

		System.out.println("");
		scanner.close();

	}

	public void CreateRecipe() {
		String name, description, ingredient, step;
		ArrayList<String> ingredients = new ArrayList<String>();
		ArrayList<String> steps = new ArrayList<String>();
		
		System.out.println("\nEnter a name for your recipe.");
		name = scanner.nextLine();
		System.out.println("Enter a description for your recipe.");
		description = scanner.nextLine();
		while(running) {
			System.out.println("Enter your ingredient or type 'next' to move onto the steps.");
			ingredient = scanner.nextLine();
			if(ingredient.toLowerCase().equals("next")) {
				running = false;
			}
			else
				ingredients.add(ingredient);
		}
		running = true;
		while(running) {
			System.out.println("Enter your steps one at a type or type 'finish' to complete this recipe.");
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

	public void RecipeExploration() {
		String recipeIndex = "-1";
		ArrayList<Recipe> allRecipes;

		System.out.println();
		while(running) {
			// Print all the recipes
			allRecipes = recipes.getAllRecipes();
			for(int i = 0; i < allRecipes.size(); i++) {
				System.out.print(i+1);
				System.out.println(". "+allRecipes.get(i).name);
			}

			// Need to enter a valid number loop
			while (true) {
				System.out.println("\nPlease enter a valid number of a recipe from the ones above or type 'back'.");
				recipeIndex = scanner.nextLine();

				if (isNumber(recipeIndex)) {
					int choice = Integer.parseInt(recipeIndex);
					if (choice > 0 && choice <= allRecipes.size()) break;
				}

				if (recipeIndex.equalsIgnoreCase("back")) break;
			}

			// Should be a better way to do this instead of writing it twice
			if(recipeIndex.equalsIgnoreCase("back")) {
				break;
			}
			else
				ViewRecipe(allRecipes.get(Integer.parseInt(recipeIndex)-1));
			running = false;
		}
	}

	public void RecipeSearch(){

		String input;
		String recipeIndex = "-1";
		ArrayList<Recipe> results; 

		boolean finding = true;
		
		while(running) {
			running = true;
			finding = true;
			recipeIndex = "-1";
			
			System.out.println("\nPlease enter your keywords to search by recipe name or 'back' to go to the main menu:");
			input = scanner.nextLine();
			
			if(input.equalsIgnoreCase("back")) {
				running = false;
			}
			else {
				results = recipes.find(input);

				if (input.equals("") || results.size() == 0) {
					System.out.println("Nothing found for that keyword");
					break;
				}
				else {
					System.out.println("\nPlease select a recipe from the ones below.");
					// Print all the recipes
					for(int i = 0; i < results.size(); i++) {
						System.out.print(i+1);
						System.out.println(". "+results.get(i).name);
					}
				}
				
				// while(finding) {
				// 	if(results.size() == 0){
				// 		System.out.println("Nothing found for that keyword");
				// 		finding = false;
				// 		break;
				// 	}
				// 	else {
				// 		System.out.println("\nPlease select a recipe from the ones below.");
				// 		// Print all the recipes
				// 		for(int i = 0; i < results.size(); i++) {
				// 			System.out.print(i+1);
				// 			System.out.println(". "+results.get(i).name);
				// 		}
				// 		finding = false;
				// 	}
				// }
				
				
				//Select a recipe
				// Need to enter a valid number
				while(Integer.parseInt(recipeIndex) <= 0 || Integer.parseInt(recipeIndex) > results.size()) {
					System.out.println("\nPlease enter a valid number of a recipe from the ones above or type 'back'.");
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

	public void ViewRecipe(Recipe recipe) {
		String input;

		while(running) {
			System.out.println("\n'1' for entire recipe, '2' for step-by-step");
			input = scanner.nextLine();
			if (isNumber(input)) {
				if(Integer.parseInt(input) == 1) {
					divider("entire recipe");
					System.out.printf("\n%s\n", recipe);
					divider("");
					running = false;
				}

				else if (Integer.parseInt(input) == 2) {
					divider("step-by-step");
					StepByStep(recipe);
					running = false;
				}		
				else {
					System.out.println("\nNot a valid answer");
				}	
			}
			else
				System.out.println("\nNot a valid answer");
		}
	}

	public void StepByStep(Recipe recipe) {
		String input;

		System.out.println("\n'Enter' when you are ready for the next step:\n");
		for(int i = 0; i < recipe.steps.size(); i++) {
			System.out.println(recipe.steps.get(i));
			running = true;
			while(running) {
				input = scanner.nextLine();
				if((input.equalsIgnoreCase("")))
					running = false;
			}
		}
		divider("");
	}


	public void divider(String method) {
		if (!method.equals("")) {
			System.out.println('\n'+method.toUpperCase());
		}
		for (int i = 0; i < 20; i++) {
			System.out.print("-");
		}
	}

	public boolean isNumber(String str) {
		return str.matches(".*\\d.*");
	}
}
