import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

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

		JPanel recipeSection = new JPanel();
		setLayout(new GridBagLayout());
		setBackground(Color.WHITE);

		GridBagConstraints gridbc = new GridBagConstraints();
		gridbc.gridx = gridbc.gridy = 0;

		add(new JLabel("Recipe Name"));
		add(new JLabel("Description"));
		add(new JLabel("Ingredient List"));
		add(new JLabel("Step-by-Step Instruction"));

		add(new JTextArea(), gridbc);
		add(new JTextArea(), gridbc);
		add(new JTextArea(), gridbc);
		add(new JTextArea(), gridbc);

		add(recipeSection);
	}
	// private void populate() {
	// int x;
	// }
}
