package org.lasencinas.phonebook.bbdd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.lasencinas.phonebook.interfaces.Readable;

public class InsertData implements Readable {

    //Variables
    private String route = ""; //Programacion defensiva
    private String regex = "[|] "; //Expresion regular para separar mi .txt

    //Constructor por defecto
    public InsertData() {

    }

    //Constructor sobrecargado
    public InsertData(String route) {
        setRoute(route);
    }

    //Getters y setters
    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    //Logica
    @Override
    public void readTXT() throws IOException {

        String line;
        try {
            BufferedReader phoneBookTXT = new BufferedReader(new FileReader(getRoute())); //Te mantiene el txt en memoria

            while ((line = phoneBookTXT.readLine()) != null) {

                String[] parts = line.split(getRegex());//se utiliza una expresion regular para la separacion entre los campos

                if (parts.length >= 2) { //Esta parte mira que la separacion hecha por el split se ha minima de 2
                    String name = parts[0].trim(); //te obtiene los nombre del archivo de texto y el trim te quita tabulaciones y espacios al principio y al final del texto
                    String city = parts[1].trim();  //te obtiene las ciudades del archivo de texto y el trim te quita tabulaciones y espacios al principio y al final del texto
                    String phone = parts[2].trim(); //te obtiene los telefonos  del archivo de texto y el trim te quita tabulaciones y espacios al principio y al final del texto

                    Bbdd.phoneBook.put(phone, name); //Añade a la base de datos telefono y nombre
                    Bbdd.nameAndCitys.put(phone, city); // Añade a la base de datos telefono y ciudad

                } else {
                    //Else por si hay algun caso inesperado
                }

            }
            phoneBookTXT.close(); //Cierras el Buffer
        } catch (FileNotFoundException e) {                 //Catch en caso de que no encuentre el archivo o la ruta sea equivocá
            System.out.println("Archivo no encontrado,posibles causas, mal introducida la ruta o archivo no existente");
        }

    }

}
