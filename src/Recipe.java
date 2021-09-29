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

    private String nameKey = "Name";
    private String descKey = "Description";
    private String ingredKey = "Ingredients";
    private String stepsKey = "Steps";

    private static FileWriter file;

    public Recipe() {
        ingredients = new ArrayList<String>();
        steps = new ArrayList<String>();
    }

    public void SaveToJSON()
    {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put(nameKey, name);
        jsonObject.put(descKey, description);

        JSONArray ingredientsJsonArray = new JSONArray();
        ingredientsJsonArray.addAll(ingredients);
        jsonObject.put(ingredKey, ingredientsJsonArray);

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

            description = (String) jsonObject.get(descKey);

            JSONArray ingredientsJsonArray = (JSONArray) jsonObject.get(ingredKey);
            ingredients.clear();
            for (int i = 0; i < ingredientsJsonArray.size(); i++)
            {
                ingredients.add(ingredientsJsonArray.get(i).toString());
            }

            JSONArray stepsJsonArray = (JSONArray) jsonObject.get(stepsKey);
            steps.clear();
            for (int i = 0; i < stepsJsonArray.size(); i++)
            {
                ingredients.add(stepsJsonArray.get(i).toString());
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
