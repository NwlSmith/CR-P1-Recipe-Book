import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GUI {
	
	RecipeBook recipes;
	
	
	public GUI(RecipeBook recipes) {
		this.recipes = recipes;
	}
	
    public void renderInterface() {
        final JFrame frame = new JFrame("Recipe book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1152, 782);

        JPanel panel = new JPanel(new BorderLayout());

        // create buttons
        JButton create_Recipe_button = new JButton("Create a Recipe");
        JButton view_all_button = new JButton("View All Recipes");
        JButton search_recipe_button = new JButton("Search for a Recipe");

        JPanel topPanel = new JPanel(new BorderLayout());

        topPanel.add(create_Recipe_button, BorderLayout.WEST);
        topPanel.add(view_all_button, BorderLayout.CENTER);
        topPanel.add(search_recipe_button, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);
        
        
        final JPanel createRecipes = new RecipeCreateGUI(recipes);
        final JPanel viewAllRecipes = new RecipeViewAll(recipes);
        final JPanel searchRecipes = new RecipeSearchGUI(recipes);
        
        create_Recipe_button.addActionListener( new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.remove(viewAllRecipes);
        		frame.remove(searchRecipes);
        		frame.add(createRecipes);
        		frame.revalidate();
        		frame.repaint();
        	}
        });
        
        view_all_button.addActionListener( new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.remove(createRecipes);
        		frame.remove(searchRecipes);
        		frame.add(viewAllRecipes);
        		frame.revalidate();
        		frame.repaint();
        	}
        });
        
        search_recipe_button.addActionListener( new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.remove(viewAllRecipes);
        		frame.remove(createRecipes);
        		frame.add(searchRecipes);
        		frame.revalidate();
        		frame.repaint();
        	}
        });

        panel.setLayout(null);
        frame.setVisible(true);

    }
}