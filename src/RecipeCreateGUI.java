import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;

public class RecipeCreateGUI extends JPanel {
	private RecipeBook recipes;

	private JTextField recipeName;
	private JTextArea description;
	private JTextArea ingredientList;
	private JTextArea instructions;

	public RecipeCreateGUI(RecipeBook recipes) {
		super();
		this.recipes = recipes;

		// JLabel jlabel = new JLabel("This is the Recipe Creation Panel");
		// add(jlabel, BorderLayout.CENTER);

		recipeName = new JTextField(20);
		description = new JTextArea(5, 20);
		ingredientList = new JTextArea(4, 20);
		instructions = new JTextArea(8, 20);

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(4, 4, 4, 4);
		gbc.anchor = GridBagConstraints.WEST;

		// JLabel recipeName = new JLabel("Recipe Name");
		// JTextField recipeNameInput = new JTextField();
		// JLabel description = new JLabel("Description");
		// JTextField descriptionInput = new JTextField();
		// JLabel ingredientList = new JLabel("Ingredient List");
		// JTextField ingredientListInput = new JTextField();
		// JLabel instructions = new JLabel("Step-by-step Instructions");
		// JTextField instructionsInput = new JTextField();

		// recipeName.setBounds(10, 20, 80, 25);
		// add(recipeName, BorderLayout.WEST);
		// recipeNameInput.setBounds(100, 20, 165, 25);
		// add(recipeNameInput, BorderLayout.EAST);

		recipeNameInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populate();
			}
		});

	}

	private void populate() {
		int x;
	}
}
