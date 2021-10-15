import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GUI {

    RecipeBook recipes;

    public GUI(RecipeBook recipes) {
        this.recipes = recipes;
    }

    public void renderInterface() {
        final JFrame frame = new JFrame("Recipe Book");
        frame.setSize(1152, 782);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = gbc.gridy = 0;
        gbc.weightx = gbc.weighty = 1;
        gbc.insets = new Insets(45, 0, 0, 0);
        mainPanel.setBackground(Color.WHITE);

        JLabel title = new JLabel("Recipe Book");
        JLabel team = new JLabel("JJJON", SwingConstants.RIGHT);
        title.setFont(new Font("Roboto", Font.BOLD, 40));
        team.setFont(new Font("Roboto", Font.BOLD, 22));
        title.setBorder(new EmptyBorder(0, 0, 15, 0));
        team.setBorder(new EmptyBorder(0, 0, 15, 0));

        JButton create_recipe = new JButton("Create a Recipe");
        JButton view_all = new JButton("View All Recipes");
        JButton search_recipe = new JButton("Search for a Recipe");

        create_recipe.setFont(new Font("Roboto", Font.PLAIN, 18));
        view_all.setFont(new Font("Roboto", Font.PLAIN, 18));
        search_recipe.setFont(new Font("Roboto", Font.PLAIN, 18));

        JPanel header = new JPanel(new GridBagLayout());
        JPanel tabs = new JPanel(new GridLayout(1, 3));
        header.setPreferredSize(new Dimension(1050, 120));
        tabs.setPreferredSize(new Dimension(1050, 55));

        header.setBackground(Color.WHITE);
        tabs.setBackground(Color.WHITE);

        GridBagConstraints headerGbc = new GridBagConstraints();

        headerGbc.gridx = headerGbc.gridy = 0;
        headerGbc.weightx = headerGbc.weighty = 1;

        headerGbc.anchor = GridBagConstraints.WEST;
        header.add(title, headerGbc);

        headerGbc.anchor = GridBagConstraints.EAST;
        header.add(team, headerGbc);

        tabs.add(create_recipe);
        tabs.add(view_all);
        tabs.add(search_recipe);

        headerGbc.anchor = GridBagConstraints.WEST;
        headerGbc.gridy++;
        header.add(tabs, headerGbc);

        gbc.anchor = GridBagConstraints.NORTH;
        mainPanel.add(header, gbc);
        paintButton(null, new JButton[] { create_recipe, view_all, search_recipe });

        final JPanel createRecipes = new RecipeCreateGUI(recipes);
        final JPanel viewAllRecipes = new RecipeViewAll(recipes);
        final JPanel searchRecipes = new RecipeSearchGUI(recipes);

        createRecipes.setPreferredSize(new Dimension(1050, 500));
        viewAllRecipes.setPreferredSize(new Dimension(1050, 500));
        searchRecipes.setPreferredSize(new Dimension(1150, 500));

        createRecipes.setBackground(Color.RED);
        viewAllRecipes.setBackground(Color.WHITE);
        searchRecipes.setBackground(Color.WHITE);

        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        create_recipe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paintButton(create_recipe, new JButton[] { view_all, search_recipe });
                mainPanel.remove(viewAllRecipes);
                mainPanel.remove(searchRecipes);
                mainPanel.add(createRecipes, gbc);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        view_all.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paintButton(view_all, new JButton[] { create_recipe, search_recipe });
                mainPanel.remove(createRecipes);
                mainPanel.remove(searchRecipes);
                mainPanel.add(viewAllRecipes, gbc);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        search_recipe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paintButton(search_recipe, new JButton[] { create_recipe, view_all });
                mainPanel.remove(createRecipes);
                mainPanel.remove(viewAllRecipes);
                mainPanel.add(searchRecipes, gbc);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    public void paintButton(JButton active, JButton[] nonActive) {
        if (active != null) {
            active.setBackground(Color.BLACK);
            active.setForeground(Color.WHITE);
            active.setOpaque(true);
            active.setBorderPainted(false);
        }

        for (JButton bttn : nonActive) {
            bttn.setBorderPainted(true);
            bttn.setBackground(Color.WHITE);
            bttn.setForeground(Color.BLACK);
            bttn.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        }
    }
}