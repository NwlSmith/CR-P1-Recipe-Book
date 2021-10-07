import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;

public class RecipeCreateGUI extends JPanel {
	private RecipeBook recipes;

	private JTextArea recipeName;
	private JTextArea description;
	private JTextArea ingredientList;
	private JTextArea instructions;

	public RecipeCreateGUI(RecipeBook recipes) {
		super();
		this.recipes = recipes;

		// JLabel jlabel = new JLabel("This is the Recipe Creation Panel");
		// add(jlabel, BorderLayout.CENTER);
		JButton saveRecipe = new JButton("Save Recipe");

		recipeName = new JTextArea(1, 40);
		description = new JTextArea(5, 40);
		ingredientList = new JTextArea(4, 40);
		instructions = new JTextArea(8, 40);

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;
		add(new JLabel("Recipe Name"), gbc);
		gbc.gridy++;
		add(new JLabel("Description"), gbc);
		gbc.gridy++;
		add(new JLabel("Ingredient List"), gbc);
		gbc.gridy++;
		add(new JLabel("Step-by-step Instructions"), gbc);
		gbc.gridy++;

		gbc.gridx += 56;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		add(recipeName, gbc);
		gbc.gridy++;
		add(description, gbc);
		gbc.gridy++;
		add(ingredientList, gbc);
		gbc.gridy++;
		add(instructions, gbc);

		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridx = 0;
		gbc.gridy = 32;
		add(saveRecipe, gbc);

		// recipeNameInput.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// populate();
		// }
		// });

	}

	// private void populate() {
	// int x;
	// }
}
