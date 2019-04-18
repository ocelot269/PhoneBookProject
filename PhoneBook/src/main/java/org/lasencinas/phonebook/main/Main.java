package org.lasencinas.phonebook.main;

import java.io.IOException;
import org.lasencinas.phonebook.bbdd.Bbdd;
import org.lasencinas.phonebook.bbdd.InsertData;
import org.lasencinas.phonebook.interfaces.Readable;

public class Main {

    public static void main(String[] args) throws IOException {

        Readable datos = new InsertData("C:/Users/ozeh/Desktop/AgendaTelefonica.txt");

        datos.readTXT();
        for (String phone : Bbdd.phoneBook.keySet()) {
            for (String city : Bbdd.nameAndCitys.keySet()) {
                if (city.equals(phone)) {
                    System.out.println(Bbdd.phoneBook.get(phone) + " y su telefono es " + phone + " y vive en "
                            + Bbdd.nameAndCitys.get(city));
                } else {

                }
            }

        }

    }
}
