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
		setBackground(Color.RED);

		GridBagConstraints gridbc = new GridBagConstraints();

		gridbc.anchor = GridBagConstraints.NORTHWEST;
		gridbc.gridx = gridbc.gridy = 0;
		gridbc.weighty = 1;

		JPanel recipeSection = new JPanel();

		gridbc.insets = new Insets(0, 8, 64, 8);

		// recipeSection.setPreferredSize(new Dimension(2000, 320));
		JLabel title = new JLabel("Recipe Name");
		title.setHorizontalAlignment(SwingConstants.LEFT);
		// title.setBorder(BorderFactory.createLineBorder(Color.black));

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
		gridbc.gridy++;
		add(description, gridbc);
		gridbc.gridy++;
		add(ingredientList, gridbc);
		gridbc.gridy++;
		add(instructions, gridbc);

		gridbc.gridwidth = 2;
		gridbc.fill = GridBagConstraints.HORIZONTAL;

		add(recipeSection);

	}
	// private void populate() {
	// int x;
	// }
}
