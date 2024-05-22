package task2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlReader {
    public static Person readPersonFromXml(String filePath) {
        try {
            File xmlFile = new File(filePath);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            PersonHandler handler = new PersonHandler();
            saxParser.parse(xmlFile, handler);
            return handler.getPerson();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class PersonHandler extends DefaultHandler {
        private Person person;
        private StringBuilder data;

        private String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            if ("person".equals(qName)) {
                person = new Person();
            }
            data = new StringBuilder();
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("person".equals(qName)) {
                // End of person element, do nothing
            } else if ("name".equals(qName)) {
                person.setName(data.toString());
            } else if ("postalZip".equals(qName)) {
                person.setPostalZip(data.toString());
            } else if ("region".equals(qName)) {
                person.setRegion(data.toString());
            } else if ("country".equals(qName)) {
                person.setCountry(data.toString());
            } else if ("address".equals(qName)) {
                person.setAddress(data.toString());
            } else if ("list".equals(qName)) {
                String[] items = data.toString().split(",");
                person.setList(List.of(items));
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            data.append(new String(ch, start, length));
        }

        public Person getPerson() {
            return person;
        }
    }
}
