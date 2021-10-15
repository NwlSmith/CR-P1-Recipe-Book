import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;

public class RecipeCreateGUI extends JPanel {
	private RecipeBook recipes;

	private JPanel recipeSection;
	private JTextArea recipeName;
	private JTextArea description;
	private JTextArea ingredientList;
	private JTextArea instructions;

	public RecipeCreateGUI(RecipeBook recipes) {
		super();

		this.recipes = recipes;

		setLayout(new GridBagLayout());

		GridBagConstraints gridbc = new GridBagConstraints();

		gridbc.anchor = GridBagConstraints.NORTHWEST;
		gridbc.gridx = gridbc.gridy = 0;
		gridbc.weighty = 1;

		setBackground(Color.RED);

		gridbc.insets = new Insets(0, 8, 64, 8);

		setPreferredSize(new Dimension(1050, 320));
		JLabel title = new JLabel("Recipe Name");
		title.setPreferredSize(new Dimension(750, 20));
		title.setHorizontalAlignment(SwingConstants.LEFT);
		title.setBorder(BorderFactory.createLineBorder(Color.black));

		add(title, gridbc);
		gridbc.gridy++;
		add(new JLabel("Description"), gridbc);
		gridbc.gridy++;
		add(new JLabel("Ingredient List"), gridbc);
		gridbc.gridy++;
		add(new JLabel("Step-by-step Instructions"), gridbc);
		gridbc.gridy++;

		recipeName = new JTextArea(1, 40);
		description = new JTextArea(5, 40);
		ingredientList = new JTextArea(4, 40);
		instructions = new JTextArea(8, 40);

		gridbc.gridx += 56;
		gridbc.gridy = 0;
		gridbc.anchor = GridBagConstraints.NORTHWEST;
		add(recipeName, gridbc);
		recipeName.setBorder(BorderFactory.createLineBorder(Color.black));

		recipeName.setText("Add Recipe Name here                  ");
		gridbc.gridy++;
		add(description, gridbc);
		description.setText("Add a description of your recipe here      ");
		description.setBorder(BorderFactory.createLineBorder(Color.black));

		gridbc.gridy++;
		add(ingredientList, gridbc);
		ingredientList.setText("Add a list of ingredients here   ");
		ingredientList.setBorder(BorderFactory.createLineBorder(Color.black));
		gridbc.gridy++;
		add(instructions, gridbc);
		instructions.setText("Add instructions here                              ");
		instructions.setBorder(BorderFactory.createLineBorder(Color.black));

		gridbc.gridwidth = 2;
		gridbc.fill = GridBagConstraints.HORIZONTAL;
		JButton saveRecipe = new JButton("Save Recipe");

		add(saveRecipe, gridbc);
	}
	// private void populate() {
	// int x;
	// }
}
