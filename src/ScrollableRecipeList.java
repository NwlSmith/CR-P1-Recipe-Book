import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScrollableRecipeList extends JPanel {

    private JPanel containedPanel;
    private JScrollPane scrollPane;

    public ScrollableRecipeList()
    {
        containedPanel = new JPanel();
        scrollPane = new JScrollPane(containedPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(600, 600));
        add(scrollPane, BorderLayout.CENTER);
    }

    public void DisplayEntries(ArrayList<Recipe> recipesToDisplay)
    {
        containedPanel.setLayout(new BoxLayout(containedPanel, BoxLayout.Y_AXIS));
        containedPanel.removeAll();
        for (int i = 0; i < recipesToDisplay.size(); i++)
        {
            RecipeSearchEntry recipeSearchEntry = new RecipeSearchEntry(recipesToDisplay.get(i), true);
            containedPanel.add(recipeSearchEntry);
        }

    }
}
