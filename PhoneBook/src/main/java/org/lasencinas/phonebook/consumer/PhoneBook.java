package org.lasencinas.phonebook.consumer;

import java.util.HashSet;
import java.util.Set;
import org.lasencinas.phonebook.bbdd.Bbdd;
import org.lasencinas.phonebook.interfaces.Findable;
import org.lasencinas.phonebook.interfaces.Listable;
import org.lasencinas.phonebook.interfaces.Printable;

public class PhoneBook implements Listable, Findable, Printable {

    //Variables
    private String name = ""; //Programacion defensiva
    private String city = ""; //Programacion defensiva
    private Set<String> usersByName = new HashSet<>();
    private String printCode = "";//programacion defensiva

    //Constructor 
    public PhoneBook() {

    }

    //Constructor sobrecargado
    public PhoneBook(String name, String city) {
        setName(name);
        setCity(city);
    }

    //Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setUsersByName(Set<String> usersByName) {
        this.usersByName = usersByName;
    }

    public Set<String> getUsersByName() {
        return usersByName;
    }

    public String getPrintCode() {
        return printCode;
    }

    public void setPrintCode(String printCode) {
        this.printCode = printCode;
    }

    //Logica
    public String firstUppercaseChar(String name) { //Convierte el primer caracter en mayuscula y el resto en minusculas
        return name.toUpperCase().charAt(0) + name.substring(1, name.length()).toLowerCase();
    }

    @Override
    public String listUsers(String name) { //He modificado el nombre del metodo porque me parecia poco intuitivo

        for (String phone : Bbdd.phoneBook.keySet()) { //Recorre la base de datos
            if (Bbdd.phoneBook.get(phone).contains(firstUppercaseChar(name))) { //Esta condicion busca que el valor del mapa contenga parte del nombre pasado por parametro
                setPrintCode("\n" + Bbdd.phoneBook.get(phone) + " y su telefono es " + phone); //Mensaje con los contactos encontrados
                getUsersByName().add(getPrintCode());//Lo añades al Hashset
            } else {
                //Si no encuentra nada falla silenciosamente
            }

        }
        setPrintCode(getUsersByName().toString());//Crea un string del set
        getUsersByName().clear();//Vacia el conjunto
        return decoratePrint();
    }

    //Metodo sobrecargado
    @Override
    public String listUsers() { //Lo mismo que el metodo anterior pero sin pasarle parametros
        for (String phone : Bbdd.phoneBook.keySet()) { //Recorre la base de datos
            if (Bbdd.phoneBook.get(phone).contains(firstUppercaseChar(getName()))) { //Esta condicion busca que el valor del mapa contenga parte del nombre pasado por parametro
                setPrintCode("\n" + Bbdd.phoneBook.get(phone) + " y su telefono es " + phone); //Mensaje con los contactos encontrados
                getUsersByName().add(getPrintCode());//Lo añades al Hashset
            } else {
                //Si no encuentra nada falla silenciosamente
            }

        }
        setPrintCode(getUsersByName().toString());//Crea un string del set
        getUsersByName().clear();//Vacia el conjunto
        return decoratePrint();
    }

    @Override
    public String findUsers(String name, String cities) {//He modificado el nombre porque no me parecia lo suficientemente descriptivo
        for (String phone : Bbdd.phoneBook.keySet()) { //Recorremos la base de datos
            if (Bbdd.phoneBook.get(phone).contains(firstUppercaseChar(name)) && Bbdd.nameAndCities.get(phone).equalsIgnoreCase(cities)) {//Ignora si el nombre de la ciudad tiene mayusculas o minusculas
                //Buscamos si el nombre está en la base de datos  y luego comparamos si las ciudades coinciden
                setPrintCode("\n" + Bbdd.phoneBook.get(phone) + " su telefono es " + phone + " y vive en " + cities);
                getUsersByName().add(getPrintCode());//Lo añades al Hashset
            } else {
                //Falla silenciosamente
            }

        }
        setPrintCode(getUsersByName().toString());//Crea un string del set
        getUsersByName().clear();//Vacia el conjunto
        return decoratePrint();
    }

    @Override
    public String findUsers() {
        for (String phone : Bbdd.phoneBook.keySet()) { //Recorremos la base de datos
            if (Bbdd.phoneBook.get(phone).contains(firstUppercaseChar(getName())) && Bbdd.nameAndCities.get(phone).equalsIgnoreCase(getCity())) {
                //Buscamos si el nombre está en la base de datos  y luego comparamos si las ciudades coinciden
                setPrintCode("\n" + Bbdd.phoneBook.get(phone) + " su telefono es " + phone + " y vive en " + getCity());
                getUsersByName().add(getPrintCode());//Lo añades al Hashset
            } else {
                //Falla silenciosamente
            }

        }
        setPrintCode(getUsersByName().toString());//Crea un string del set
        getUsersByName().clear();//Vacia el conjunto
        return decoratePrint();
    }

    private String decoratePrint() { //Metodo para decorar el print
        setPrintCode(getPrintCode().replaceAll(",", ""));//reemplaza "," por "" 
        setPrintCode(getPrintCode().substring(1, getPrintCode().length() - 1));// quita del principio y del final "[]".        
        return getPrintCode();
    }

    @Override
    public void showResultSearch() { //Metodo para llamar a los prints
        System.out.println(getPrintCode());
    }

    public void addUsers(String name, String phone, String city) { //Te permite añadir contacto a la base de datos
        Bbdd.phoneBook.put(phone, name);
        Bbdd.nameAndCities.put(phone, city);
    }

    public void deleteUsers(String phone) { //Te permite eliminar contactos de la base de datos
        
        if (Bbdd.phoneBook.containsKey(phone)) {
            Bbdd.phoneBook.remove(phone);
            Bbdd.nameAndCities.remove(phone);
        }

    }

}
