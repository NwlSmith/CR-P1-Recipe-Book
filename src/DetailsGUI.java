import java.awt.BorderLayout;
import java.awt.Dimension;
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
		
		this.frame = new JFrame("Recipe Detail");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(1152, 782);
        
		this.fullRecipeGUI = new RecipeSearchEntry(recipe);
		this.stepByStepGUI = new StepByStepGUI(recipe);
		this.currentIndex = 0;
	}
	
    public void renderInterface() {
        

        JPanel panel = new JPanel(new BorderLayout());

        // create buttons
        JButton entire_button = new JButton("View Entire Recipe");
        JButton step_by_step_button = new JButton("Follow Step-by-step Guide");

        JPanel topPanel = new JPanel(new BorderLayout());

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
