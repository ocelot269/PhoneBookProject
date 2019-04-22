package org.lasencinas.phonebook.main;

import java.io.IOException;
import org.lasencinas.phonebook.bbdd.Bbdd;
import org.lasencinas.phonebook.consumer.InsertData;
import org.lasencinas.phonebook.consumer.PhoneBook;
import org.lasencinas.phonebook.interfaces.Findable;
import org.lasencinas.phonebook.interfaces.Listable;
import org.lasencinas.phonebook.interfaces.Readable;

public class Main {

    public static void main(String[] args) throws IOException {

        Readable datos = new InsertData("agenda/AgendaTelefonica.txt"); //Introduzca la ruta a su archivo.txt
        PhoneBook agenda = new PhoneBook();
        //PhoneBook agenda1 = new PhoneBook("Jones", "Portland"); //Constructor opcional que recibe 2 parametros nombre y ciudad
        datos.readTXT();

        System.out.println("\nArrancando agenda electronica... \n");
        
        System.out.println("..............-:+**===**+:.............\n"
                + "\n"
                + "..........:*=================*-........\n"
                + "\n"
                + ".......-========================*......\n"
                + "\n"
                + ".....-============================*....\n"
                + "\n"
                + "....*=====+....+====================+..\n"
                + "\n"
                + "..-======.......-====================*.\n"
                + "\n"
                + "..======:........-====================+\n"
                + "\n"
                + ".+======:......-*======================\n"
                + "\n"
                + ".========-.....*=======================\n"
                + "\n"
                + ":=========:.....*======================\n"
                + "\n"
                + ":===========-.....*====================\n"
                + "\n"
                + "-=============-.....*=====*-:==========\n"
                + "\n"
                + ".*==============-.....+*+-.....+=======\n"
                + "\n"
                + ".-================-..............=====*\n"
                + "\n"
                + "..-=================-...........+====*.\n"
                + "\n"
                + "...*==================+-......+=====*..\n"
                + "\n"
                + "..+================================-...\n"
                + "\n"
                + ".-===============================-.....\n"
                + "\n"
                + ".*============================:........");

        System.out.println("\nBienvenido...");

        System.out.println("Buscando similitudes... \n");

        agenda.listUsers("ke"); //En este metodo puedes buscar el nombre de cualquier persona de la base de datos
        
        //agenda1.listUsers(); //Este metodo es igual al anterior pero sin pasarle parametros //Opcional
        
        //agenda1.showResultSearch(); //Te muestra por pantalla las busquedas

        agenda.showResultSearch();
        
        System.out.println("\nEstos son todos los contactos listados");

        agenda.addUsers("Jose", "654020017", "Palma");
        
        //agenda1.addUsers("Jose", "654020017", "Palma"); //agregar usuario para la agenda 1
        
        System.out.println("\nContacto añadido exitosamente\n");

        System.out.println("\nProcesando busqueda por nombre y ciudad\n");

        System.out.println("Buscando en la base de datos coincidencias...\n");

        agenda.findUsers("Jose", "Palma");//Buscamos por nombre y ciudad
        
        //agenda1.findUsers();  //Opcional
        
        //agenda1.showResultSearch(); //Opcional

        agenda.showResultSearch();
        
        agenda.deleteUsers("654020017");
        
        //agenda1.deleteUsers("654020017");  //agregar usuario para la agenda 1
        
        System.out.println("\nContacto eliminado exitosamente\n");

        agenda.findUsers("Jose", "Palma");//No debe aparecer porque esta eliminado
        
        agenda.showResultSearch();
        
        //agenda1.showResultSearch(); // Mostrar el resultado para agenda1

        System.out.println("\nIniciando busqueda ..\n");

        agenda.findUsers("Garcia", "virginia beach");
        
        agenda.showResultSearch();
        
        //agenda1.findUsers("Garcia", "virginia beach");

        //agenda1.showResultSearch();

        System.out.println("\nApagando agenda...");

    }
}
