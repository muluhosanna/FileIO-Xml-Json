package com.java.xml;

public class PersonModel {
    private int id;
    private final String firstName;
    private final String lastName;
    private final String country;
    private final String street;
    private final String city;
    private final String state;
    private final String email;

    public PersonModel(int id, String firstName,
                       String lastName, String country,
                       String street, String city,
                       String state, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.street = street;
        this.city = city;
        this.state = state;
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() { return country; }

    public int getId() { return id; }



}
