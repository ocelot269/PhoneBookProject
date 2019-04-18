package org.lasencinas.phonebook.consumer;

import java.io.IOException;
import java.util.Locale;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import static org.junit.Assert.*;
import org.lasencinas.phonebook.bbdd.Bbdd;
import org.lasencinas.phonebook.bbdd.InsertData;
import org.lasencinas.phonebook.interfaces.Listable;

public class PhoneBookIT {

    public PhoneBookIT() {
    }

    @Test
    public void testListUsers() throws IOException { //Pendiente de forma de testear de manera correcta
        InsertData datos = new InsertData("C:/Users/ozeh/Desktop/AgendaTelefonica.txt");
        datos.readTXT();

        int contador = 0;

        for (String phone : Bbdd.phoneBook.keySet()) {

            if (Bbdd.phoneBook.get(phone).contains("Kevin")) {
                contador += 1;
            }

        }
        assertThat(contador).isEqualTo(5);
    }

    @Test
    public void testListUsers1() throws IOException {
        PhoneBook agenda = new PhoneBook("Linda", "San Antonio");
        InsertData datos = new InsertData("C:/Users/ozeh/Desktop/AgendaTelefonica.txt");
        datos.readTXT();
        agenda.AddUsers("Linda", "00000000", "san antonio");

        int contador = 0;

        for (String phone : Bbdd.phoneBook.keySet()) {

            if (Bbdd.phoneBook.get(phone).contains(agenda.getName())) {
                contador += 1;
            }

        }
        assertThat(contador).isEqualTo(2);
        agenda.DeleteUsers("00000000");
    }

    @Test
    public void testAddUssers() {
        PhoneBook agenda = new PhoneBook();
        agenda.AddUsers("Jose", "654000000", "Palma");
        assertNotNull(Bbdd.phoneBook);
        assertNotNull(Bbdd.nameAndCitys);
        assertEquals(8, Bbdd.phoneBook.size());
        assertEquals(8, Bbdd.nameAndCitys.size());

    }

    @Test
    public void testDeleteUsers() {
        PhoneBook agenda = new PhoneBook();
        agenda.AddUsers("Jose", "654000000", "Palma");
        assertNotNull(Bbdd.phoneBook);
        assertNotNull(Bbdd.nameAndCitys);
        agenda.DeleteUsers("654000000");
        assertEquals(0, Bbdd.phoneBook.size());
        assertEquals(0, Bbdd.nameAndCitys.size());
    }

    @Test
    public void testFindUsers() throws IOException {
        PhoneBook agenda = new PhoneBook();
        InsertData datos = new InsertData("C:/Users/ozeh/Desktop/AgendaTelefonica.txt");
        datos.readTXT();
        agenda.AddUsers("Linda", "00000000", "san antonio");

        int contador = 0;

        for (String phone : Bbdd.phoneBook.keySet()) {

            if (Bbdd.phoneBook.get(phone).contains("Kevin") && Bbdd.nameAndCitys.get(phone).equalsIgnoreCase("phoenix")) {
                contador += 1;
            }

        }
        assertThat(contador).isEqualTo(2);
        agenda.DeleteUsers("00000000");

    }

    @Test
    public void testFindUsers1() throws IOException {
        PhoneBook agenda = new PhoneBook("Garcia", "Virginia beach");
        InsertData datos = new InsertData("C:/Users/ozeh/Desktop/AgendaTelefonica.txt");
        datos.readTXT();
        agenda.AddUsers("Linda Garcia", "00000000", "san antonio");

        int contador = 0;

        for (String phone : Bbdd.phoneBook.keySet()) {

            if (Bbdd.phoneBook.get(phone).contains(agenda.getName()) && Bbdd.nameAndCitys.get(phone).equalsIgnoreCase(agenda.getCity())) {
                contador += 1;
            }

        }
        assertThat(contador).isEqualTo(1);
        agenda.DeleteUsers("00000000");

    }
}
