import javax.swing.*;
import javax.swing.border.*;

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
        searchBar.setBackground(Color.WHITE);

        Border compound = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createEmptyBorder(0, 10, 0, 0));
        searchField = new JTextField(20);
        searchField.setBorder(compound);

        searchField.addActionListener( new ActionListener() { public void actionPerformed(ActionEvent e) { search(); } } );
        searchBar.add(searchField, BorderLayout.CENTER);

        JButton searchButton = new JButton("Search");
        searchButton.setBorderPainted(false);
        searchButton.setOpaque(true);
        searchButton.setBackground(Color.BLACK); 
        searchButton.setForeground(Color.WHITE);    
        searchButton.setFont(new Font("Roboto", Font.BOLD, 14)); 
        searchButton.addActionListener( new ActionListener() { public void actionPerformed(ActionEvent e) { search(); } } );
        searchBar.add(searchButton, BorderLayout.EAST);

        scrollableRecipeList = new ScrollableRecipeList();
        scrollableRecipeList.setBackground(Color.WHITE);

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