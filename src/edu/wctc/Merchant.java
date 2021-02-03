package edu.wctc;

public class Merchant {
    private String name;
    private String address;

    public Merchant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return name + " " + address;
    }

    public boolean equals(Object o) {
        return ((Merchant)o).getName().equals(this.name);
    }

    public int hashCode() {
        return name.hashCode();
    }
}
