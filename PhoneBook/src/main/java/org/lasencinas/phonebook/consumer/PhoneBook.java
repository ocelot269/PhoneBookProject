package org.lasencinas.phonebook.consumer;

import org.lasencinas.phonebook.bbdd.Bbdd;
import org.lasencinas.phonebook.interfaces.Listable;

public class PhoneBook implements Listable {
    
    //Constructor 
    public PhoneBook(){
        
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
    
    

}
