import javax.swing.*;
import java.awt.*;

public class RecipeViewAll extends JPanel {

    private ScrollableRecipeList scrollableRecipeList;
    private RecipeBook recipes;

	public RecipeViewAll(RecipeBook recipes) {
        super();
        this.recipes = recipes;
		scrollableRecipeList = new ScrollableRecipeList();
        scrollableRecipeList.setBackground(Color.WHITE);
        scrollableRecipeList.DisplayEntries(recipes.getAllRecipes());
        add(scrollableRecipeList, BorderLayout.CENTER);		
	}

    public void redraw()
    {
        scrollableRecipeList.DisplayEntries(recipes.getAllRecipes());
    }
	
}
