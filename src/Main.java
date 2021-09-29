import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World!");

        Recipe recipe = new Recipe();

        recipe.LoadFromJSON("test recipe");

        recipe.PrintToConsole();
    }
}
