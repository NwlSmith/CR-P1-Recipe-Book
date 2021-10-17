import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.border.Border;

public class RecipeCreateGUI extends JPanel {

	private int numIngredients = 1;
	private int numInstructions = 1;

	public RecipeCreateGUI(RecipeBook recipes) {
		setLayout(new GridBagLayout());
		GridBagConstraints gridbc = new GridBagConstraints();

		gridbc.gridx = gridbc.gridy = 0;
        gridbc.weightx = gridbc.weighty = 1;

		JLabel recipeName = new JLabel("Recipe Name");
		HintTextArea recipeInput = new HintTextArea("Add Recipe Name");
		
		Border compound = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createEmptyBorder(5, 15, 0, 0));

		gridbc.anchor = GridBagConstraints.NORTHWEST;
		recipeName.setPreferredSize(new Dimension(200,30));
		recipeName.setFont(new Font("Roboto", Font.BOLD, 16));
		add(recipeName, gridbc);

		gridbc.gridx++;
		gridbc.anchor = GridBagConstraints.NORTHEAST;
		recipeInput.setBorder(compound);
		recipeInput.setPreferredSize(new Dimension(850,30));
		recipeInput.setFont(new Font("Roboto", Font.PLAIN, 14));
		add(recipeInput, gridbc);

		gridbc.gridx--;
		gridbc.gridy++;
		gridbc.anchor = GridBagConstraints.NORTHWEST;

		JLabel description = new JLabel("Description");
		HintTextArea descriptionInput = new HintTextArea("Add a description of your recipe");
		
		description.setPreferredSize(new Dimension(200,30));
		description.setFont(new Font("Roboto", Font.BOLD, 16));
		add(description, gridbc);

		gridbc.gridx++;
		gridbc.anchor = GridBagConstraints.NORTHEAST;
		descriptionInput.setBorder(compound);
		descriptionInput.setPreferredSize(new Dimension(850,30));
		descriptionInput.setFont(new Font("Roboto", Font.PLAIN, 14));
		add(descriptionInput, gridbc);

		gridbc.gridx--;
		gridbc.gridy++;
		gridbc.anchor = GridBagConstraints.NORTHWEST;

		JLabel ingredient = new JLabel("Ingredient List");
		MultiLineList ingredientInput = new MultiLineList("Add an ingredient");
		
		ingredient.setPreferredSize(new Dimension(200,30));
		ingredient.setFont(new Font("Roboto", Font.BOLD, 16));
		add(ingredient, gridbc);

		gridbc.gridx++;
		gridbc.anchor = GridBagConstraints.NORTHEAST;
		add(ingredientInput, gridbc);

		gridbc.gridx--;
		gridbc.gridy++;
		gridbc.anchor = GridBagConstraints.NORTHWEST;

		JTextArea steps = new JTextArea("Step-by-step Instructions");
		MultiLineList stepsInput = new MultiLineList("Add an instruction");
		
		steps.setPreferredSize(new Dimension(200,50));
		steps.setFont(new Font("Roboto", Font.BOLD, 16));
		steps.setWrapStyleWord(true);
		steps.setLineWrap(true);
		steps.setEditable(false);
		steps.setFocusable(false);
		add(steps, gridbc);

		gridbc.gridx++;
		gridbc.anchor = GridBagConstraints.NORTHEAST;
		add(stepsInput, gridbc);

		gridbc.gridy++;
		JButton saveButton = new JButton("Save Recipe");
		saveButton.setPreferredSize(new Dimension(180,40));
        saveButton.setBorderPainted(false);
        saveButton.setOpaque(true);
        saveButton.setBackground(Color.BLACK);
        saveButton.setForeground(Color.WHITE);
		saveButton.setFont(new Font("Roboto", Font.BOLD, 18));
		add(saveButton, gridbc);

	}

}

class MultiLineList extends JPanel {

	private ArrayList<MultiLineListEntry> listEntries;
	private String hintString;

	public MultiLineList(final String newHintString)
	{
		this.setPreferredSize(new Dimension(850,40));
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		hintString = newHintString;

		listEntries = new ArrayList<MultiLineListEntry>();
		listEntries.add(new MultiLineListEntry(hintString, 0, this));
		redrawList();
	}

	private void redrawList()
	{
		this.removeAll();
		GridBagConstraints gridbc = new GridBagConstraints();

		gridbc.gridx = gridbc.gridy = 0;
		gridbc.weightx = gridbc.weighty = 1;
		gridbc.anchor = GridBagConstraints.NORTHWEST;

		for (int i = 0; i < listEntries.size(); i++) {
			this.add(listEntries.get(i), gridbc);
			listEntries.get(i).indexInList = i;
			gridbc.gridy++;
		}

		this.setPreferredSize(new Dimension(850,40 * listEntries.size()));
		revalidate();
		repaint();
	}

	public void addEntryAtIndex(final int indexToAddAt)
	{
		listEntries.add(indexToAddAt + 1, new MultiLineListEntry(hintString, indexToAddAt + 1, this));
		redrawList();
	}

	public void removeEntryAtIndex(final int indexToRemove)
	{
		listEntries.remove(indexToRemove);
		redrawList();
	}
}

class MultiLineListEntry extends JPanel {

	public int indexInList = 0;

	private HintTextArea textArea;
	private JButton minusButton;
	private JButton plusButton;
	private MultiLineList containingList;

	public MultiLineListEntry(final String hint, final int index, final MultiLineList list)
	{
		super();
		setLayout(new GridBagLayout());
		this.indexInList = index;
		this.containingList = list;
		this.setPreferredSize(new Dimension(850,30));
		this.setBackground(Color.WHITE);

		GridBagConstraints gridbc = new GridBagConstraints();

		gridbc.gridx = gridbc.gridy = 0;
		gridbc.weightx = gridbc.weighty = 100;
		gridbc.anchor = GridBagConstraints.NORTHWEST;
		gridbc.fill = GridBagConstraints.HORIZONTAL;

		textArea = new HintTextArea(hint);
		textArea.setPreferredSize(new Dimension(850,30));
		textArea.setFont(new Font("Roboto", Font.PLAIN, 14));
		textArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2),
				BorderFactory.createEmptyBorder(5, 15, 0, 0)));
		add(textArea, gridbc);
		gridbc.gridx++;
		gridbc.weightx = 1;
		gridbc.insets.left = 5;

		minusButton = new JButton("-");
		minusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				containingList.removeEntryAtIndex(indexInList);
			}
		});

		if (indexInList > 0) {
			this.add(minusButton, gridbc);
			gridbc.gridx++;
		}

		plusButton = new JButton("+");
		plusButton.addActionListener( new ActionListener() { public void actionPerformed(ActionEvent e) { containingList.addEntryAtIndex(indexInList); } } );
		this.add(plusButton, gridbc);
	}
}

class HintTextArea extends JTextArea implements FocusListener {

	private final String hint;
	private boolean showingHint;

	public HintTextArea(final String hint) {
		super(hint);
		this.hint = hint;
		this.showingHint = true;
		this.setForeground(Color.gray);
		super.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(this.getText().isEmpty()) {
			super.setText("");
			showingHint = false;
			this.setForeground(Color.BLACK);
		}
	}
	@Override
	public void focusLost(FocusEvent e) {
		if(this.getText().isEmpty()) {
			super.setText(hint);
			showingHint = true;
			this.setForeground(Color.gray);
		}
		else
		{
			this.setForeground(Color.BLACK);
		}
	}

	@Override
	public String getText() {
		return showingHint ? "" : super.getText();
	}
}
