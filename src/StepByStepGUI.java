import javax.swing.*;
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

        gbc.gridx = listGbc.gridx = gbc.gridy = listGbc.gridy = 0;
        gbc.weightx = gbc.weighty = listGbc.weightx = listGbc.weighty = 1;
        listGbc.insets = new Insets(10, 0, 10, 0);

        JLabel recipeName = new JLabel(recipe.name);
        gbc.anchor = GridBagConstraints.NORTH;
        add(recipeName, gbc);

        JPanel listContent = new JPanel();
        listContent.setBackground(Color.WHITE);
        listContent.setLayout(new GridBagLayout());

        gbc.anchor = GridBagConstraints.CENTER;
        listGbc.anchor = GridBagConstraints.WEST;
        add(listContent, gbc);

        JButton nextButton = new JButton("Next");
        gbc.anchor = GridBagConstraints.SOUTH;

        int instructionCount = recipe.steps.size();

        nextButton.addActionListener( new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                if (currInstruction < instructionCount) {
                    listContent.add(new JLabel(String.format("%d. %s", currInstruction+1, recipe.steps.get(currInstruction))), listGbc);
                    listGbc.gridy++;
                    currInstruction++;

                    if (currInstruction == instructionCount) {
                        nextButton.setText("Start Over");
                    }
                }
                else {
                    currInstruction = 0;
                    nextButton.setText("Next");
                    listContent.removeAll();
                }

                revalidate();
                repaint();
            }
        });

        add(nextButton, gbc);

	}
}
