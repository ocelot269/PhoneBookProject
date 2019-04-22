package org.lasencinas.phonebook.bbdd;

import java.util.HashMap;
import java.util.Map;
import org.lasencinas.phonebook.person.Person;

public class Bbdd {

    // Nuestra base de datos
    
    public static Map<String, Person> phoneBook = new HashMap<>();//Este será una parte de nuestra base de datos
    //Esta BBDD guardara como clave el telefono,como valor la persona que posee nombre y ciudad

}
