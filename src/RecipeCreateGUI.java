import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class RecipeCreateGUI extends JPanel {

	public RecipeCreateGUI(RecipeBook recipes) {
		setLayout(new GridBagLayout());
		GridBagConstraints gridbc = new GridBagConstraints();

		gridbc.gridx = gridbc.gridy = 0;
        gridbc.weightx = gridbc.weighty = 1;

		JLabel recipeName = new JLabel("Recipe Name");
		JTextArea recipeInput = new JTextArea("Add Recipe Name");
		
		Border compound = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createEmptyBorder(5, 15, 0, 0));

		gridbc.anchor = GridBagConstraints.NORTHWEST;
		recipeName.setPreferredSize(new Dimension(200,30));
		recipeName.setFont(new Font("Roboto", Font.BOLD, 16));
		add(recipeName, gridbc);

		gridbc.gridx++;
		gridbc.anchor = GridBagConstraints.NORTHEAST;
		recipeInput.setBorder(compound);
		recipeInput.setPreferredSize(new Dimension(850,30));
		recipeInput.setFont(new Font("Roboto", Font.PLAIN, 14));
		add(recipeInput, gridbc);

		gridbc.gridx--;
		gridbc.gridy++;
		gridbc.anchor = GridBagConstraints.NORTHWEST;

		JLabel description = new JLabel("Description");
		JTextArea descriptionInput = new JTextArea("Add a description of your recipe");
		
		description.setPreferredSize(new Dimension(200,30));
		description.setFont(new Font("Roboto", Font.BOLD, 16));
		add(description, gridbc);

		gridbc.gridx++;
		gridbc.anchor = GridBagConstraints.NORTHEAST;
		descriptionInput.setBorder(compound);
		descriptionInput.setPreferredSize(new Dimension(850,30));
		descriptionInput.setFont(new Font("Roboto", Font.PLAIN, 14));
		add(descriptionInput, gridbc);

		gridbc.gridx--;
		gridbc.gridy++;
		gridbc.anchor = GridBagConstraints.NORTHWEST;

		JLabel ingredient = new JLabel("Ingredient List");
		JTextArea ingredientInput = new JTextArea("Add a list of comma-separated ingredients");
		
		ingredient.setPreferredSize(new Dimension(200,30));
		ingredient.setFont(new Font("Roboto", Font.BOLD, 16));
		add(ingredient, gridbc);

		gridbc.gridx++;
		gridbc.anchor = GridBagConstraints.NORTHEAST;
		ingredientInput.setBorder(compound);
		ingredientInput.setPreferredSize(new Dimension(850,80));
		ingredientInput.setFont(new Font("Roboto", Font.PLAIN, 14));
		add(ingredientInput, gridbc);

		gridbc.gridx--;
		gridbc.gridy++;
		gridbc.anchor = GridBagConstraints.NORTHWEST;

		JTextArea steps = new JTextArea("Step-by-step Instructions");
		JTextArea stepsInput = new JTextArea("Add a list of line-separated instructions");
		
		steps.setPreferredSize(new Dimension(200,50));
		steps.setFont(new Font("Roboto", Font.BOLD, 16));
		steps.setWrapStyleWord(true);
		steps.setLineWrap(true);
		steps.setEditable(false);
		steps.setFocusable(false);
		add(steps, gridbc);

		gridbc.gridx++;
		gridbc.anchor = GridBagConstraints.NORTHEAST;
		stepsInput.setBorder(compound);
		stepsInput.setPreferredSize(new Dimension(850,150));
		stepsInput.setFont(new Font("Roboto", Font.PLAIN, 14));
		add(stepsInput, gridbc);

		gridbc.gridy++;
		JButton saveButton = new JButton("Save Recipe");
		saveButton.setPreferredSize(new Dimension(180,40));
        saveButton.setBorderPainted(false);
        saveButton.setOpaque(true);
        saveButton.setBackground(Color.BLACK);
        saveButton.setForeground(Color.WHITE);
		saveButton.setFont(new Font("Roboto", Font.BOLD, 18));
		add(saveButton, gridbc);

	}

}
