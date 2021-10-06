import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RecipeCreationEntry extends JPanel {
    private String name;
    private String description;
    private ArrayList<String> ingredients;
    private ArrayList<String> steps;

    public RecipeCreationEntry(String name, String description, ArrayList<String> ingredients,
            ArrayList<String> steps) {
        super();

        SetupEntry();
    }

    private void SetupEntry() {

    }
}
