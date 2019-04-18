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

        Readable datos = new InsertData("C:/Users/ozeh/Desktop/AgendaTelefonica.txt"); //Introduzca la ruta a su archivo.txt
        Listable agenda = new PhoneBook();
        PhoneBook agendaTelefonica = (PhoneBook) agenda;//Upcasting
        Findable agendaBuscable = (Findable) agenda; //Upcasting
        //    Listable agenda1 = new PhoneBook("Jones", "Portland"); //Opcional
        //    Findable agendaBuscable1 = (Findable) agenda1; //Upcasting //Opcional
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

        //    agenda1.ListUsers(); //Este metodo es igual al anterior pero sin pasarle parametros //Opcional
        System.out.println("\nEstos son todos los contactos listados");

        agendaTelefonica.AddUsers("Jose", "654020017", "Palma");

        System.out.println("\nContacto añadido exitosamente\n");

        System.out.println("\nProcesando busqueda por nombre y ciudad\n");

        System.out.println("Buscando en la base de datos coincidencias...\n");

        agendaBuscable.FindUsers("Jose", "Palma");//Buscamos por nombre y ciudad 
        //    agendaBuscable1.FindUsers();  //Opcional

        agendaTelefonica.DeleteUsers("654020017");

        System.out.println("\nContacto eliminado exitosamente\n");

        agendaBuscable.FindUsers("Jose", "Palma");

        System.out.println("Iniciando busqueda ..\n");
        agendaBuscable.FindUsers("Clark", "portland");

        System.out.println("\nApagando agenda..");

    }
}
