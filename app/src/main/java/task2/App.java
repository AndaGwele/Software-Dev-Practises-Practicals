package task2;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java -jar app.jar <path_to_xml_file> <field1> <field2> ...");
            return;
        }

        String filePath = args[0];
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }

        List<String> selectedFields = Arrays.asList(args).subList(1, args.length);
        Person person = XmlReader.readPersonFromXml(filePath);

        if (person != null) {
            JsonObject jsonObject = new JsonObject();

            if (selectedFields.contains("name")) {
                jsonObject.addProperty("name", person.getName());
            }
            if (selectedFields.contains("postalZip")) {
                jsonObject.addProperty("postalZip", person.getPostalZip());
            }
            if (selectedFields.contains("region")) {
                jsonObject.addProperty("region", person.getRegion());
            }
            if (selectedFields.contains("country")) {
                jsonObject.addProperty("country", person.getCountry());
            }
            if (selectedFields.contains("address")) {
                jsonObject.addProperty("address", person.getAddress());
            }
            if (selectedFields.contains("list")) {
                jsonObject.add("list", new Gson().toJsonTree(person.getList()));
            }

            System.out.println(new Gson().toJson(jsonObject));
        } else {
            System.out.println("Failed to parse XML file.");
        }
    }
}
