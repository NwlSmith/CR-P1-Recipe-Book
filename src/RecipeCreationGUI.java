import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RecipeCreationGUI extends JPanel {
    private JPanel createRecipeBox;

    public RecipeCreationGUI() {
        super();
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 60));
        createRecipeBox = new JPanel(new BorderLayout());

        JLabel recipeName = new JLabel("Recipe Name");
        JTextField recipeNameInput = new JTextField();
        JLabel description = new JLabel("Description");
        JTextField descriptionInput = new JTextField();
        JLabel ingredientList = new JLabel("Ingredient List");
        JTextField ingredientListInput = new JTextField();
        JLabel instructions = new JLabel("Step-by-step Instructions");
        JTextField instructionsInput = new JTextField();
        
    }
}
