package org.lasencinas.phonebook.consumer;

import org.lasencinas.phonebook.bbdd.Bbdd;
import org.lasencinas.phonebook.interfaces.Findable;
import org.lasencinas.phonebook.interfaces.Listable;

public class PhoneBook implements Listable, Findable {

    //Constructor 
    public PhoneBook() {
        
    }
    
    
    //Logica
    @Override
    public void ListUsers(String name) { //He modificado el nombre del metodo porque me parecia poco intuitivo

        for (String phone : Bbdd.phoneBook.keySet()) { //Recorre la base de datos
            if (Bbdd.phoneBook.get(phone).contains(name)) { //Esta condicion busca que el valor del mapa 
                //contenga parte del nombre pasado por parametro
                System.out.println(Bbdd.phoneBook.get(phone) + " y su telefono es " + phone); //Mensaje con los contactos encontrados
            } else {
                //Si no encuentra nada falla silenciosamente
            }
            
        }
    }
    
    @Override
    public void FindUsers(String name, String citys) {
        for (String phone : Bbdd.phoneBook.keySet()) { //Recorremos la base de datos
            if (Bbdd.phoneBook.get(phone).contains(name) && Bbdd.nameAndCitys.get(phone).equals(citys)) {
                //Buscamos si el nombre está en la base de datos  y luego comparamos si las ciudades coinciden
                System.out.println(Bbdd.phoneBook.get(phone) + " y su telefono es " + phone + " y vive en "
                        + citys);
            } else {
                //Falla silenciosamente
            }
            
        }
    }
    
}
