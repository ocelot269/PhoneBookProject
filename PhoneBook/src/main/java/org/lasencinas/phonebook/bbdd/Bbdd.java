package org.lasencinas.phonebook.bbdd;

import java.util.HashMap;
import java.util.Map;

public class Bbdd {

    // Nuestra base de datos
    public static Map<String, String> phoneBook = new HashMap<>();//Este mapa sera una parte de nuestra base de datos
    //Esta BBDD guardara como clave el telefono,como valor el nombre
    public static Map<String, String> nameAndCities = new HashMap<>();//Este mapa sera la otra parte y trabajaran de manera conjunta
    //Esta BBDD guardara como clave el telefono ,como valor la ciudad

}
