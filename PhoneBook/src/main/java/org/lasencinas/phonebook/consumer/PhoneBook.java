package org.lasencinas.phonebook.consumer;

import org.lasencinas.phonebook.bbdd.Bbdd;
import org.lasencinas.phonebook.interfaces.Findable;
import org.lasencinas.phonebook.interfaces.Listable;

public class PhoneBook implements Listable, Findable {

    //Variables
    private String name = ""; //Programacion defensiva
    private String city = ""; //Programacion defensiva

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

    //Logica
    @Override
    public void ListUsers(String name) { //He modificado el nombre del metodo porque me parecia poco intuitivo

        for (String phone : Bbdd.phoneBook.keySet()) { //Recorre la base de datos
            if (Bbdd.phoneBook.get(phone).contains(name)) { //Esta condicion busca que el valor del mapa contenga parte del nombre pasado por parametro
                System.out.println(Bbdd.phoneBook.get(phone) + " y su telefono es " + phone); //Mensaje con los contactos encontrados
            } else {
                //Si no encuentra nada falla silenciosamente
            }

        }
    }
    
    //Metodo sobrecargado
    public void ListUsers() { //Lo mismo que el metodo anterior pero sin pasarle parametros
        for (String phone : Bbdd.phoneBook.keySet()) { //Recorre la base de datos
            if (Bbdd.phoneBook.get(phone).contains(getName())) { //Esta condicion busca que el valor del mapa contenga parte del nombre pasado por parametro
                System.out.println(Bbdd.phoneBook.get(phone) + " y su telefono es " + phone); //Mensaje con los contactos encontrados
            } else {
                //Si no encuentra nada falla silenciosamente
            }

        }

    }
    
    
    @Override
    public void FindUsers(String name, String citys) {//He modificado el nombre porque no me parecia lo suficientemente descriptivo
        for (String phone : Bbdd.phoneBook.keySet()) { //Recorremos la base de datos
            if (Bbdd.phoneBook.get(phone).contains(name) && Bbdd.nameAndCitys.get(phone).equalsIgnoreCase(citys)) {
                //Buscamos si el nombre está en la base de datos  y luego comparamos si las ciudades coinciden
                System.out.println(Bbdd.phoneBook.get(phone) + " su telefono es " + phone + " y vive en "
                        + citys);
            } else {
                //Falla silenciosamente
            }

        }
    }
    
     public void FindUsers() {
         for (String phone : Bbdd.phoneBook.keySet()) { //Recorremos la base de datos
            if (Bbdd.phoneBook.get(phone).contains(getName()) && Bbdd.nameAndCitys.get(phone).equalsIgnoreCase(getCity())) {
                //Buscamos si el nombre está en la base de datos  y luego comparamos si las ciudades coinciden
                System.out.println(Bbdd.phoneBook.get(phone) + " su telefono es " + phone + " y vive en "
                        + getCity());
            } else {
                //Falla silenciosamente
            }

        }
         
     }
     
     public void AddUsers(String name,String phone,String city){ //Te permite añadir contacto a la base de datos
         Bbdd.phoneBook.put(phone, name);
         Bbdd.nameAndCitys.put(phone, city);
     }
     
     public void DeleteUsers(String phone){ //Te permite eliminar contactos de la base de datos
         if (Bbdd.phoneBook.containsKey(phone)) {
            Bbdd.phoneBook.remove(phone);
            Bbdd.nameAndCitys.remove(phone); 
         }
         
     }

}
