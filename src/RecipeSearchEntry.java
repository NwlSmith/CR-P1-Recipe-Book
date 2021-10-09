import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RecipeSearchEntry extends JPanel {

    private Recipe recipe;
    private Boolean isClickable;

    public RecipeSearchEntry(Recipe newRecipe, Boolean clickable)
    {
        super();
        recipe = newRecipe;
        isClickable = clickable;
        SetupEntry();
    }

    private void SetupEntry()
    {
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel("Recipe Name");
        JLabel descriptionLabel = new JLabel("Description");
        JLabel ingredientsLabel = new JLabel("Ingredients List");
        JLabel instructionsLabel = new JLabel("Step-by-Step Instructions");
        nameLabel.setFont(new Font("Roboto", Font.BOLD, 12));
        descriptionLabel.setFont(new Font("Roboto", Font.BOLD, 12));
        ingredientsLabel.setFont(new Font("Roboto", Font.BOLD, 12));
        instructionsLabel.setFont(new Font("Roboto", Font.BOLD, 12));

        // Labels
        GridBagConstraints labelConstraints = new GridBagConstraints();
        labelConstraints.anchor = GridBagConstraints.NORTHWEST;
        labelConstraints.gridx = 0;
        labelConstraints.gridy = 0;
        labelConstraints.weightx = 1;
        labelConstraints.weighty = 1;
        labelConstraints.insets = new Insets(5, 10, 5, 10);

        add(nameLabel, labelConstraints);
        labelConstraints.gridy++;
        add(descriptionLabel, labelConstraints);
        labelConstraints.gridy++;
        add(ingredientsLabel, labelConstraints);
        labelConstraints.gridy++;
        add(instructionsLabel, labelConstraints);

        // Info
        GridBagConstraints infoConstraints = new GridBagConstraints();
        infoConstraints.anchor = GridBagConstraints.NORTHWEST;
        infoConstraints.gridx = 1;
        infoConstraints.gridy = 0;
        infoConstraints.weightx = 20;
        infoConstraints.weighty = 1;
        infoConstraints.fill = GridBagConstraints.HORIZONTAL;
        infoConstraints.insets = new Insets(5, 10, 5, 10);

        JTextArea name = FormatName();
        JTextArea description = FormatDescription();
        JTextArea ingredients = FormatIngredients();
        JTextArea instructions = FormatInstructions();

        add(name, infoConstraints);
        infoConstraints.gridy++;
        add(description, infoConstraints);
        infoConstraints.gridy++;
        add(ingredients, infoConstraints);
        infoConstraints.gridy++;
        add(instructions, infoConstraints);
        
        if (isClickable) {
            this.addMouseListener(new MouseAdapter(){
                public void mouseClicked (MouseEvent event) {
                    DetailsGUI detailsWindow = new DetailsGUI(recipe);
                    detailsWindow.renderInterface();
                }
            });
        }
    }

    private JTextArea FormatName()
    {
        JTextArea name = new JTextArea();
        name.setText(recipe.name);
        name.setEditable(false);
        name.setLineWrap(true);
        name.setOpaque(false);
        return name;
    }

    private JTextArea FormatDescription()
    {
        JTextArea description = new JTextArea();
        description.setText(recipe.description);
        description.setEditable(false);
        description.setLineWrap(true);
        description.setOpaque(false);
        return description;
    }

    private JTextArea FormatIngredients()
    {
        String ingredientsString = new String();
        for (int i = 0; i < recipe.ingredients.size(); i++) {
            ingredientsString += recipe.ingredients.get(i);
            if (i < recipe.ingredients.size() - 1)
                ingredientsString += ", ";
        }
        JTextArea ingredients = new JTextArea();//recipe.ingredients.size(), 30);
        ingredients.setText(ingredientsString);
        ingredients.setEditable(false);
        ingredients.setLineWrap(true);
        ingredients.setOpaque(false);
        return ingredients;
    }

    private JTextArea FormatInstructions()
    {
        String instructionsString = new String();
        for (String instruction : recipe.steps) {
            instructionsString += "• " + instruction + "\n";// + "<br>";
        }

        JTextArea instructions = new JTextArea(recipe.steps.size(), 30);
        instructions.setText(instructionsString);
        instructions.setEditable(false);
        instructions.setLineWrap(true);
        instructions.setOpaque(false);
        return instructions;
    }

}