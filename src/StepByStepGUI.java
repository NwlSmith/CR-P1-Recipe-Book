import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StepByStepGUI extends JPanel {	
    private int currInstruction;

	public StepByStepGUI(Recipe recipe) {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints listGbc = new GridBagConstraints();

        gbc.gridx = gbc.gridy = listGbc.gridx = listGbc.gridy = 0;
        gbc.weighty = listGbc.weighty = 1;

        JLabel recipeName = new JLabel("Recipe " + recipe.name);
        recipeName.setFont(new Font("Roboto", Font.BOLD, 20));
        gbc.anchor = GridBagConstraints.NORTHWEST;
        add(recipeName, gbc);

        JPanel listContent = new JPanel(new GridBagLayout());
        listContent.setPreferredSize(new Dimension(1050,320));
        listContent.setBackground(Color.WHITE);

        gbc.anchor = GridBagConstraints.CENTER;
        listGbc.anchor = GridBagConstraints.WEST;
        add(listContent, gbc);

        JButton nextButton = new JButton("Next");
        nextButton.setBorderPainted(false);
        nextButton.setOpaque(true);
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
		nextButton.setFont(new Font("Roboto", Font.BOLD, 16));

        gbc.anchor = GridBagConstraints.PAGE_END;

        int instructionCount = recipe.steps.size();
        populateTextFields(listContent, listGbc, instructionCount);

        nextButton.addActionListener( new ActionListener() { 
            public void actionPerformed(ActionEvent e) {   
                if (currInstruction < instructionCount) {
                    JLabel currLabel = (JLabel)listContent.getComponents()[currInstruction];
                    currLabel.setText(String.format("- %s", recipe.steps.get(currInstruction)));
                    currInstruction++;

                    if (currInstruction == instructionCount) {
                        nextButton.setText("Start Over");
                    }
                }
                else {
                    currInstruction = 0;
                    nextButton.setText("Next");
                    listContent.removeAll();
                    populateTextFields(listContent, listGbc, instructionCount);
                }

                revalidate();
                repaint();
            }
        });

        add(nextButton, gbc);
	}


    public void populateTextFields(JPanel container, GridBagConstraints c, int numOfElems) {
        c.gridy = 0;
        for (int i = 0; i < numOfElems; i++) {
            JLabel newLabel = new JLabel();
            newLabel.setPreferredSize(new Dimension(1040, 20));
            newLabel.setBorder(new EmptyBorder(0,10,0,0));
            c.gridy++;
            container.add(newLabel,c);
        }
    }
}
