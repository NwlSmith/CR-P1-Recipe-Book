import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScrollableRecipeList extends JPanel {

    private JPanel containedPanel;
    private JScrollPane scrollPane;
    private GridBagConstraints gbc;

    public ScrollableRecipeList()
    {
        containedPanel = new JPanel();
        scrollPane = new JScrollPane(containedPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(1030, 650));
        scrollPane.setBorder(null);
        gbc = new GridBagConstraints();
        add(scrollPane, BorderLayout.CENTER);
    }

    public void DisplayEntries(ArrayList<Recipe> recipesToDisplay)
    {
        containedPanel.setLayout(new GridBagLayout());
        containedPanel.setBackground(Color.WHITE);
        containedPanel.removeAll();

        gbc.gridy = gbc.gridx = 0;
        gbc.insets = new Insets(10,0,10,0);

        for (int i = 0; i < recipesToDisplay.size(); i++)
        {
            RecipeSearchEntry recipeSearchEntry = new RecipeSearchEntry(recipesToDisplay.get(i), true);
            recipeSearchEntry.setPreferredSize(new Dimension(1000, 300));
            containedPanel.add(recipeSearchEntry, gbc);
            gbc.gridy++;
        }

    }
}
