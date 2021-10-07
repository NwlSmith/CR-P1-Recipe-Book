import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class StepByStepGUI extends JPanel {
	
	Recipe recipe;
	JFrame frame;
	int currentIndex;
	
	
	public StepByStepGUI(Recipe recipe) {
		this.recipe = recipe;
		
		this.frame = new JFrame("Recipe Detail");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(1152, 782);
        this.currentIndex = 0;
	}
	
    public void renderInterface() {
        

        JPanel panel = new JPanel(new BorderLayout());
        
        JTextArea nameText = FormatName();
        frame.add(nameText);
       
        this.addMouseListener(new MouseAdapter(){
        	public void mouseClicked (MouseEvent event) {
        		if (currentIndex < recipe.steps.size()) {
        			JTextArea stepText = FormatInstructions();
            		frame.add(stepText);
        		}

        	}
        });

        panel.setLayout(null);
        frame.setVisible(true);
    }
    
    private JTextArea FormatName() {
        JTextArea name = new JTextArea();
        name.setText(recipe.name);
        name.setEditable(false);
        name.setLineWrap(true);
        name.setOpaque(false);
        return name;
    }
    
    private JTextArea FormatInstructions() {
        String instructionsString = new String();
        String step = recipe.steps.get(currentIndex);
        instructionsString += "• " + step + "\n";

        JTextArea instructions = new JTextArea(recipe.steps.size(), 30);
        instructions.setText(instructionsString);
        instructions.setEditable(false);
        instructions.setLineWrap(true);
        instructions.setOpaque(false);
        
        currentIndex++;
        return instructions;
    }
}

