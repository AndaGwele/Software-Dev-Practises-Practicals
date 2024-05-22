package task2;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the path to the XML file.");
            return;
        }

        String filePath = args[0];
        List<String> selectedFields = Arrays.asList(args).subList(1, args.length);
        Person person = XmlReader.readPersonFromXml(filePath);

        if (person != null) {
            JsonObject jsonObject = new JsonObject();

            if (selectedFields.isEmpty() || selectedFields.contains("name")) {
                jsonObject.addProperty("name", person.getName());
            }
            if (selectedFields.isEmpty() || selectedFields.contains("postalZip")) {
                jsonObject.addProperty("postalZip", person.getPostalZip());
            }
            if (selectedFields.isEmpty() || selectedFields.contains("region")) {
                jsonObject.addProperty("region", person.getRegion());
            }
            if (selectedFields.isEmpty() || selectedFields.contains("country")) {
                jsonObject.addProperty("country", person.getCountry());
            }
            if (selectedFields.isEmpty() || selectedFields.contains("address")) {
                jsonObject.addProperty("address", person.getAddress());
            }
            if (selectedFields.isEmpty() || selectedFields.contains("list")) {
                jsonObject.add("list", new Gson().toJsonTree(person.getList()));
            }

            System.out.println(new Gson().toJson(jsonObject));
        }
    }
}
