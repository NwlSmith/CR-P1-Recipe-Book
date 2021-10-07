import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeSearchGUI extends JPanel {

    private JPanel searchBar;
    private ScrollableRecipeList scrollableRecipeList;

    private JTextField searchField;

    private RecipeBook recipeBook;

    public RecipeSearchGUI(RecipeBook newRecipeBook)
    {
        super();

        recipeBook = newRecipeBook;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 60));

        searchBar = new JPanel(new BorderLayout());
        searchField = new JTextField(20);
        searchField.addActionListener( new ActionListener() { public void actionPerformed(ActionEvent e) { search(); } } );
        searchBar.add(searchField, BorderLayout.CENTER);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener( new ActionListener() { public void actionPerformed(ActionEvent e) { search(); } } );
        searchBar.add(searchButton, BorderLayout.EAST);

        scrollableRecipeList = new ScrollableRecipeList();

        add(searchBar, BorderLayout.NORTH);
        add(scrollableRecipeList, BorderLayout.CENTER);

        scrollableRecipeList.DisplayEntries(recipeBook.getAllRecipes());
    }

    private void search()
    {
        scrollableRecipeList.DisplayEntries(recipeBook.find(searchField.getText()));
		revalidate();
		repaint();
    }
}