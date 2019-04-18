package org.lasencinas.phonebook.main;

import java.io.IOException;
import org.lasencinas.phonebook.bbdd.Bbdd;
import org.lasencinas.phonebook.bbdd.InsertData;
import org.lasencinas.phonebook.consumer.PhoneBook;
import org.lasencinas.phonebook.interfaces.Findable;
import org.lasencinas.phonebook.interfaces.Listable;
import org.lasencinas.phonebook.interfaces.Readable;

public class Main {

    public static void main(String[] args) throws IOException {

        Readable datos = new InsertData("C:/Users/ozeh/Desktop/AgendaTelefonica.txt");
        Listable agenda = new PhoneBook();
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

        agenda.ListUsers("Ke"); //En este metodo puedes buscar el nombre de cualquier persona de la base de datos
                                //Importante que este bien escrito
        System.out.println("\nEstos son todos los contactos listados");

        System.out.println("\nProcesando busqueda por nombre y ciudad\n");
        
        System.out.println("Buscando en la base de datos...\n");
        
        Findable agendaBuscable = (Findable) agenda; //Upcasting
        
        agendaBuscable.FindUsers("Kevin", "Phoenix");//Buscamos por nombre y ciudad

    }
}
