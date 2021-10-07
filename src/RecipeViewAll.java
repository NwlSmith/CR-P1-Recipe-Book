import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeViewAll extends JPanel {
    private RecipeBook recipes;

	public RecipeViewAll(RecipeBook recipes) {
        super();
		this.recipes = recipes;
		
		JLabel jlabel = new JLabel("This is the Recipe View All Panel");
        add(jlabel, BorderLayout.CENTER);
		
	}
	
}
