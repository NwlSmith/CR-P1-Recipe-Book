import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gbc.gridy = 0;
        gbc.weightx = gbc.weighty = 1;
		gbc.insets = new Insets(45,0,0,0);
		mainPanel.setBackground(Color.WHITE);

		JLabel title = new JLabel("Recipe Book");
		JLabel team = new JLabel("JJJON", SwingConstants.RIGHT);
		title.setFont(new Font("Roboto", Font.BOLD, 40));
		team.setFont(new Font("Roboto", Font.BOLD, 22));
		title.setBorder(new EmptyBorder(0,0,15,0));
		team.setBorder(new EmptyBorder(0,0,15,0));

        JButton entire_button = new JButton("View Entire Recipe");
		JButton step_by_step_button = new JButton("View Step-by-Step Instructions");
		entire_button.setFont(new Font("Roboto", Font.PLAIN, 18));
		step_by_step_button.setFont(new Font("Roboto", Font.PLAIN, 18));

		JPanel navBar = new JPanel(new GridLayout(2,2));
		navBar.setPreferredSize(new Dimension(1050, 110));
		navBar.setBackground(Color.WHITE);

		navBar.add(title);
		navBar.add(team);
		navBar.add(entire_button);
		navBar.add(step_by_step_button);

		gbc.anchor = GridBagConstraints.NORTH;
		mainPanel.add(navBar, gbc);
		gbc.anchor = GridBagConstraints.CENTER;
		mainPanel.add(fullRecipeGUI, gbc);

		fullRecipeGUI.setPreferredSize(new Dimension(1050,400));
		stepByStepGUI.setPreferredSize(new Dimension(1050,400));
        
        entire_button.addActionListener( new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mainPanel.remove(stepByStepGUI);
        		mainPanel.add(fullRecipeGUI, gbc);
				mainPanel.revalidate();
        		mainPanel.repaint();
        	}
        });
        
        step_by_step_button.addActionListener( new ActionListener() {
        	public void actionPerformed(ActionEvent e) {	
        		mainPanel.remove(fullRecipeGUI);
        		mainPanel.add(stepByStepGUI, gbc);
        		mainPanel.revalidate();
        		mainPanel.repaint();
        	}
        });

		frame.add(mainPanel);
        frame.setVisible(true);
    }
}
