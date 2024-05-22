package task2;

import java.util.List;

public class Person {
    private String name;
    private String postalZip;
    private String region;
    private String country;
    private String address;
    private List<String> list;

    // Getters
    public String getName() {
        return name;
    }

    public String getPostalZip() {
        return postalZip;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getList() {
        return list;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPostalZip(String postalZip) {
        this.postalZip = postalZip;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
