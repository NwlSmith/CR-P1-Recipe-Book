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

    public Recipe getRecipe(String recipeName) {
        for (int i = 0; i < getNumOfRecipes(); i++) {
            Recipe currRecipe = recipes.get(i);
            if ((currRecipe.name).equalsIgnoreCase(recipeName) || ((currRecipe.name).toLowerCase()).contains(recipeName.toLowerCase()) ) {
                return currRecipe;
            }
        }
        return null;
    }

    public ArrayList<Recipe> getAllRecipes(){
        return recipes;
    }

}
