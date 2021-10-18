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

		fullRecipeGUI = new RecipeSearchEntry(recipe, false, true);
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

		paintButton(entire_button, step_by_step_button);

		fullRecipeGUI.setPreferredSize(new Dimension(1050,400));
		stepByStepGUI.setPreferredSize(new Dimension(1050,400));
        
        entire_button.addActionListener( new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				switchTabs(mainPanel, stepByStepGUI, fullRecipeGUI, gbc);
				paintButton(entire_button, step_by_step_button);
        	}
        });
        
        step_by_step_button.addActionListener( new ActionListener() {
        	public void actionPerformed(ActionEvent e) {	
				switchTabs(mainPanel, fullRecipeGUI, stepByStepGUI, gbc);
				paintButton(step_by_step_button, entire_button);
        	}
        });

		frame.add(mainPanel);
        frame.setVisible(true);
    }

	public void paintButton(JButton active, JButton nonActive) {
		active.setBackground(Color.BLACK);
		active.setForeground(Color.WHITE);
		active.setOpaque(true);
		active.setBorderPainted(false);
		nonActive.setBorderPainted(true);
		nonActive.setBackground(Color.WHITE);
		nonActive.setForeground(Color.BLACK);
		nonActive.setBorder(BorderFactory.createLineBorder(Color.black, 2));
	}

	public void switchTabs(JPanel parent, JPanel current, JPanel next, GridBagConstraints c) {
		parent.remove(current);
		parent.add(next, c);
		parent.revalidate();
		parent.repaint();
	}
}
