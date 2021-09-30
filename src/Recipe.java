import java.io.IOException;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Class containing recipe data as well as methods for saving and loading.
 * Contains a name, description, list of ingredients, and instruction steps.
 *
 * JSON library: SimpleJSON https://github.com/fangyidong/json-simple
 */

public class Recipe {

    public String name = "";
    public String description = "";
    public ArrayList<String> ingredients;
    public ArrayList<String> steps;

    private final static String nameKey = "Name";
    private final static String descriptionKey = "Description";
    private final static String ingredientsKey = "Ingredients";
    private final static String stepsKey = "Steps";

    private static FileWriter file;

    public Recipe() {
        ingredients = new ArrayList<String>();
        steps = new ArrayList<String>();
    }

    // Used to construct a recipe directly from a JSON file.
    public Recipe(String fileName)
    {
        ingredients = new ArrayList<String>();
        steps = new ArrayList<String>();
        LoadFromJSON(fileName);
    }

    public void SaveToJSON()
    {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put(nameKey, name);
        jsonObject.put(descriptionKey, description);

        JSONArray ingredientsJsonArray = new JSONArray();
        ingredientsJsonArray.addAll(ingredients);
        jsonObject.put(ingredientsKey, ingredientsJsonArray);

        JSONArray stepsJsonArray = new JSONArray();
        stepsJsonArray.addAll(steps);
        jsonObject.put(stepsKey, stepsJsonArray);

        try {
            String fileName = "savedrecipes/" + name + ".json";
            file = new FileWriter(fileName);
            file.write(jsonObject.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("JSON Object: \n" + jsonObject);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void LoadFromJSON(String fileName)
    {
        JSONParser jsonParser = new JSONParser();

        name = fileName;

        try {
            Object obj = jsonParser.parse(new FileReader(GetFileName()));

            JSONObject jsonObject =  (JSONObject) obj;

            description = (String) jsonObject.get(descriptionKey);

            JSONArray ingredientsJsonArray = (JSONArray) jsonObject.get(ingredientsKey);
            ingredients.clear();
            for (int i = 0; i < ingredientsJsonArray.size(); i++)
            {
                ingredients.add(ingredientsJsonArray.get(i).toString());
            }

            JSONArray stepsJsonArray = (JSONArray) jsonObject.get(stepsKey);
            steps.clear();
            for (int i = 0; i < stepsJsonArray.size(); i++)
            {
                steps.add(stepsJsonArray.get(i).toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private String GetFileName()
    {
        return "savedrecipes/" + name + ".json";
    }

    public void PrintToConsole()
    {
        System.out.println("Name:");
        System.out.println(name);
        System.out.println("Description:");
        System.out.println(description);
        System.out.println("Ingredients:");
        for (String ingredient : ingredients) {
            System.out.println(ingredient);
        }
        System.out.println("Instructions:");
        for (String step : steps) {
            System.out.println(step);
        }
    }
}
