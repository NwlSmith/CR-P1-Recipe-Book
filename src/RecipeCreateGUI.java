import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeCreateGUI extends JPanel {
    private RecipeBook recipes;

	public RecipeCreateGUI(RecipeBook recipes) {
        super();
		this.recipes = recipes;
		
		JLabel jlabel = new JLabel("This is the Recipe Creation Panel");
        add(jlabel, BorderLayout.CENTER);
	}
	
}
