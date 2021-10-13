import javax.swing.*;
import java.awt.*;

public class RecipeViewAll extends JPanel {

	public RecipeViewAll(RecipeBook recipes) {
        super();

		ScrollableRecipeList scrollableRecipeList = new ScrollableRecipeList();
        scrollableRecipeList.setBackground(Color.WHITE);
        scrollableRecipeList.DisplayEntries(recipes.getAllRecipes());
        add(scrollableRecipeList, BorderLayout.CENTER);		
	}
	
}
