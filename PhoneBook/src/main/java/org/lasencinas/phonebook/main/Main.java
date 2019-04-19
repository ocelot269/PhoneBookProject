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
        Findable agendaBuscable = (Findable) agenda; //Upcasting 
        PhoneBook agendaBuscable1 = (PhoneBook) agendaBuscable; //Upcasting
        //  Listable agenda1 = new PhoneBook("Jones", "Portland"); //Opcional
        //  Findable agendaBuscable2 = (Findable) agenda1; //Upcasting //Opcional
        //  PhoneBook agenda3 = (PhoneBook) agenda1;
        datos.readTXT();

        System.out.println("Arrancando agenda electronica... \n");
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

        agenda.ListUsers("ke"); //En este metodo puedes buscar el nombre de cualquier persona de la base de datos
        
        
        //    agenda1.ListUsers(); //Este metodo es igual al anterior pero sin pasarle parametros //Opcional
        //    agenda3.showResultSearch(); //Opcional
        
        agenda.showResultSearch();

        System.out.println("\nEstos son todos los contactos listados");

        agenda.AddUsers("Jose", "654020017", "Palma");

        System.out.println("\nContacto añadido exitosamente\n");

        System.out.println("\nProcesando busqueda por nombre y ciudad\n");

        System.out.println("Buscando en la base de datos coincidencias...\n");

        agendaBuscable.FindUsers("Jose", "Palma");//Buscamos por nombre y ciudad

        //    agendaBuscable2.FindUsers();  //Opcional
        //    agenda3.showResultSearch(); //Opcional
        
        agenda.showResultSearch();

        agenda.DeleteUsers("654020017");

        System.out.println("\nContacto eliminado exitosamente\n");

        agendaBuscable.FindUsers("Jose", "Palma");//No debe aparecer porque esta eliminado

        agendaBuscable1.showResultSearch();

        System.out.println("Iniciando busqueda ..\n");

        agendaBuscable.FindUsers("Garcia", "virginia beach");

        agenda.showResultSearch();

        System.out.println("\nApagando agenda...");

    }
}
