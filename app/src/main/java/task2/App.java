package task2;

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
            if (selectedFields.isEmpty() || selectedFields.contains("name")) {
                System.out.println("Name: " + person.getName());
            }
            if (selectedFields.isEmpty() || selectedFields.contains("postalZip")) {
                System.out.println("Postal Zip: " + person.getPostalZip());
            }
            if (selectedFields.isEmpty() || selectedFields.contains("region")) {
                System.out.println("Region: " + person.getRegion());
            }
            if (selectedFields.isEmpty() || selectedFields.contains("country")) {
                System.out.println("Country: " + person.getCountry());
            }
            if (selectedFields.isEmpty() || selectedFields.contains("address")) {
                System.out.println("Address: " + person.getAddress());
            }
            if (selectedFields.isEmpty() || selectedFields.contains("list")) {
                System.out.println("List: " + person.getList());
            }
        }
    }
}
