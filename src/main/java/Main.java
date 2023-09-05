import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {
        String fileName = "new_data.json";
        String json = readString(fileName);

        List<Employee> list = jsonToList(json);
        System.out.println(list.toString());
    }

    public static String readString(String fileName) {

        JSONParser jsonParser = new JSONParser();
        Object object = null;

        try (var buffReader = new BufferedReader(new FileReader(fileName))) {
            object = jsonParser.parse(buffReader);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = (JSONArray) object;

        return jsonArray.toString();
    }

    public static List<Employee> jsonToList(String json) throws ParseException {

        Employee employee = new Employee();
        List<Employee> list = new ArrayList<>();

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(json);
        JSONArray jsonArray = (JSONArray) object;

        for (Object obj : jsonArray) {
            employee = gson.fromJson(String.valueOf(obj), (Type) Employee.class);
            list.add(employee);
        }

        return list;

    }
}




