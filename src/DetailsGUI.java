import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DetailsGUI {
	
	Recipe recipe;
	JFrame frame;
	RecipeSearchEntry fullRecipeGUI;
	StepByStepGUI stepByStepGUI;
	int currentIndex;
	
	
	public DetailsGUI(Recipe recipe) {
		this.recipe = recipe;
		
		frame = new JFrame("Recipe Details");
        frame.setSize(1152, 782);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		fullRecipeGUI = new RecipeSearchEntry(recipe, false);
		stepByStepGUI = new StepByStepGUI(recipe);
	}
	
    public void renderInterface() {
        

        JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.WHITE);

        // create buttons
        JButton entire_button = new JButton("View Entire Recipe");
        JButton step_by_step_button = new JButton("Follow Step-by-step Guide");

        JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(Color.WHITE);

        topPanel.add(entire_button, BorderLayout.WEST);
        topPanel.add(step_by_step_button, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);
        
        frame.add(fullRecipeGUI);
        
        
        entire_button.addActionListener( new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.remove(stepByStepGUI);
        		frame.add(fullRecipeGUI);
        		frame.revalidate();
        		frame.repaint();
        	}
        });
        
        
        step_by_step_button.addActionListener( new ActionListener() {
        	public void actionPerformed(ActionEvent e) {	
        		frame.remove(fullRecipeGUI);
        		frame.add(stepByStepGUI);
        		frame.revalidate();
        		frame.repaint();
        	}
        });

        panel.setLayout(null);
        frame.setVisible(true);

    }
}
