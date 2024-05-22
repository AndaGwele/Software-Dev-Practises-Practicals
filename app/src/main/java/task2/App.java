// src/main/java/com/example/Main.java
package task2;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the path to the XML file.");
            return;
        }

        String filePath = args[0];
        Person person = XmlReader.readPersonFromXml(filePath);

        if (person != null) {
            System.out.println("Name: " + person.getName());
            System.out.println("Postal Zip: " + person.getPostalZip());
            System.out.println("Region: " + person.getRegion());
            System.out.println("Country: " + person.getCountry());
            System.out.println("Address: " + person.getAddress());
            System.out.println("List: " + person.getList());
        }
    }
}
