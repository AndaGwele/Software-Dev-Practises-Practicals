package task2;

import java.io.File;
import java.util.Arrays;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
///modified


public class XmlReader {
    public static Person readPersonFromXml(String filePath) {
        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("person");
            if (nList.getLength() > 0) {
                Node node = nList.item(0);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Person person = new Person();
                    person.setName(getTagValue("name", element));
                    person.setPostalZip(getTagValue("postalZip", element));
                    person.setRegion(getTagValue("region", element));
                    person.setCountry(getTagValue("country", element));
                    person.setAddress(getTagValue("address", element));
                    // Assuming 'list' is a comma-separated string in XML
                    String listValue = getTagValue("list", element);
                    if (listValue != null) {
                        person.setList(Arrays.asList(listValue.split(",")));
                    }
                    return person;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
