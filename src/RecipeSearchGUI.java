import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RecipeSearchGUI extends JPanel {

    private JPanel searchBar;
    private JPanel containedPanel;
    private JScrollPane scrollPane;

    public RecipeSearchGUI()
    {
        super();

        setLayout(new BorderLayout());
        setMaximumSize(new Dimension(600, 1080));
        setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 60));

        searchBar = new JPanel();
        JLabel searchPlaceholderText = new JLabel("Search");
        searchBar.add(searchPlaceholderText);

        containedPanel = new JPanel();
        scrollPane = new JScrollPane(containedPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(600, 600));
        //scrollPane = new JScrollPane(containedPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(searchBar, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        // Show header
        // Show search bar
    }

    public void DisplayEntries(ArrayList<Recipe> recipesToDisplay)
    {
        //setBorder(BorderFactory.createLineBorder(Color.BLUE, 2, true));
        //containedPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2, true));
        containedPanel.setLayout(new BoxLayout(containedPanel, BoxLayout.Y_AXIS));
        for (int i = 0; i < recipesToDisplay.size(); i++)
        {
            RecipeSearchEntry recipeSearchEntry = new RecipeSearchEntry(recipesToDisplay.get(i));
            containedPanel.add(recipeSearchEntry);
        }

    }

}