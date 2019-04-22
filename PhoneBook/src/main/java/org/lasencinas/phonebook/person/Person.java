package org.lasencinas.phonebook.person;

public class Person {

    //Variables
    private String name;
    private String city;

    //Constructor basico
    public Person() {

    }

    //Constructor sobrecargado
    public Person(String name, String city) {
        setName(name);
        setCity(city);
    }
    
    //getters y setters
    
    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
