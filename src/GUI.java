import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import java.awt.GridLayout;
import java.io.File;

class GUI {
	
	RecipeBook recipes;
	
	public GUI(RecipeBook recipes) {
		this.recipes = recipes;
	}
	
    public void renderInterface() {
        JFrame frame = new JFrame("Recipe book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1152, 782);

        JPanel panel = new JPanel(new BorderLayout());
        //panel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5, true));
        //panel.setLayout(new BorderLayout());

        // panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // create buttons
        JButton create_Recipe_button = new JButton("Create a Recipe");
        JButton view_all_button = new JButton("View All Receipes");
        JButton search_recipe_button = new JButton("Search for a Recipe");

        //create_Recipe_button.setSize(350, 50);
        //create_Recipe_button.setLocation(52, 143);

        //view_all_button.setSize(350, 50);
        //view_all_button.setLocation(400, 143);

        //search_recipe_button.setSize(350, 50);
        //search_recipe_button.setLocation(746, 143);

        JPanel topPanel = new JPanel(new BorderLayout());
        //topPanel.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5, true));

        topPanel.add(create_Recipe_button, BorderLayout.WEST);
        topPanel.add(view_all_button, BorderLayout.CENTER);
        topPanel.add(search_recipe_button, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);


        RecipeSearchGUI recipeSearchGUI = new RecipeSearchGUI(recipes);

        //recipeSearchGUI.setSize(500, 300);
        //recipeSearchGUI.setLocation(400, 200);

        //panel.add(recipeSearchGUI, BorderLayout.CENTER);
        frame.add(recipeSearchGUI, BorderLayout.CENTER);

        // JLabel recipe_name = new JLabel("Recipe Name");
        // recipe_name.setLocation(52, 239);
        // JLabel description = new JLabel("Description");
        // description.setLocation(52, 313);
        // JLabel ingredient_list = new JLabel("Ingredient List");
        // ingredient_list.setLocation(52, 373);
        // JLabel instructions = new JLabel("Step by step instructions");
        // instructions.setLocation(52, 489);

        // panel.add(recipe_name);
        // panel.add(description);
        // panel.add(ingredient_list);
        // panel.add(instructions);

        // 1 ROW 3 COLUMNS
        // panel.setLayout(new GridLayout(0, 3));
        panel.setLayout(null);
        frame.setVisible(true);

        // JButton button = new JButton("Press");
        // frame.getContentPane().add(button); // Adds Button to content pane of frame
        // frame.setVisible(true);
    }
}