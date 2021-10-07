import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RecipeCreationEntry extends JPanel {
    private String name;
    private String description;
    private ArrayList<String> ingredients;
    private ArrayList<String> steps;

    public RecipeCreationEntry(String name, String description, ArrayList<String> ingredients,
            ArrayList<String> steps) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.steps = steps;
        SetupEntry();
    }

    private void SetupEntry() {
        JLabel nameLabel = new JLabel("Recipe Name");
        JLabel descriptionLabel = new JLabel("Description");
        JLabel ingredientsLabel = new JLabel("Ingredients List");
        JLabel instructionsLabel = new JLabel("Step-by-Step Instructions");
    }
}
