import java.util.*;

class RecipeBook {

    private ArrayList<Recipe> recipes;

    public RecipeBook() {
        recipes = new ArrayList<Recipe>();
    }

    public int getNumOfRecipes() {
        return recipes.size();
    }

    public void addRecipe(Recipe newRecipe) {
        recipes.add(newRecipe);
    }

    public ArrayList<Recipe> find(String recipeName) {
    	ArrayList<Recipe> searchResults = new ArrayList<>();
    	
        for (int i = 0; i < getNumOfRecipes(); i++) {
            Recipe currRecipe = recipes.get(i);
            String lcRecipe = currRecipe.name.toLowerCase();
            String lcQuery = recipeName.toLowerCase();
            
            
            if (lcRecipe.equals(lcQuery)) {
                searchResults.add(currRecipe);
            }
            else {
                String[] query = lcQuery.split(" ");
                
                for (String word : query) {
                	if (lcRecipe.contains(word)) {
                        searchResults.add(currRecipe);
                	}
                }
            }

        }
        return searchResults;
    }

    public ArrayList<Recipe> getAllRecipes(){
        return recipes;
    }

}
