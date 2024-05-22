// src/main/java/com/example/XmlReader.java
package com.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class XmlReader {

    public static class IntegerListAdapter extends XmlAdapter<String, List<Integer>> {
        @Override
        public List<Integer> unmarshal(String v) {
            return Arrays.asList(v.split(",\\s*")).stream()
                    .map(Integer::parseInt)
                    .toList();
        }

        @Override
        public String marshal(List<Integer> v) {
            return v.toString();
        }
    }

    @XmlRootElement
    public static class Person {
        private String name;
        private String postalZip;
        private String region;
        private String country;
        private String address;
        private List<Integer> list;

        // Getters and Setters
        @XmlElement
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @XmlElement
        public String getPostalZip() {
            return postalZip;
        }

        public void setPostalZip(String postalZip) {
            this.postalZip = postalZip;
        }

        @XmlElement
        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        @XmlElement
        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @XmlElement
        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @XmlElement
        @XmlJavaTypeAdapter(IntegerListAdapter.class)
        public List<Integer> getList() {
            return list;
        }

        public void setList(List<Integer> list) {
            this.list = list;
        }
    }

    public static Person readPersonFromXml(String filePath) {
        try {
            File file = new File(filePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Person) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
