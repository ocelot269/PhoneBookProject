package org.lasencinas.phonebook.consumer;

import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.StringTokenizer;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import static org.junit.Assert.*;
import org.lasencinas.phonebook.bbdd.Bbdd;
import org.lasencinas.phonebook.consumer.InsertData;
import org.lasencinas.phonebook.interfaces.Listable;

public class PhoneBookIT {

    public PhoneBookIT() {
    }

    @Test
    public void testListUsers() throws IOException { //Pendiente de forma de testear de manera correcta
        InsertData datos = new InsertData("C:/Users/ozeh/Desktop/AgendaTelefonica.txt");
        PhoneBook agenda = new PhoneBook();
        datos.readTXT();
        agenda.ListUsers("Kevin");
        int contador = 0;
        for (StringTokenizer stringTokenizer = new StringTokenizer(agenda.getPrintCode()); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();

            if (token.equalsIgnoreCase("Kevin")) {
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
        agenda.ListUsers();

        int contador = 0;
        for (int i = 0; i < agenda.getPrintCode().length(); i++) {

            if (agenda.getPrintCode().charAt(i) == 'L') {
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
        agenda.FindUsers("kevin", "phoenix");

        double contador = 0;

        for (StringTokenizer stringTokenizer = new StringTokenizer(agenda.getPrintCode()); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();

            if (token.equalsIgnoreCase("Kevin")) {
                contador += 0.5;

            } else if (token.equalsIgnoreCase("phoenix")) {
                contador += 0.5;
            } else {

            }
        }

        assertThat(contador).isEqualTo(2);

    }

    @Test
    public void testFindUsers1() throws IOException {
        PhoneBook agenda = new PhoneBook("Garcia", "Virginia beach");
        InsertData datos = new InsertData("C:/Users/ozeh/Desktop/AgendaTelefonica.txt");
        datos.readTXT();
        agenda.FindUsers();
        double contador = 0;

        for (StringTokenizer stringTokenizer = new StringTokenizer(agenda.getPrintCode()); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();

            if (token.equalsIgnoreCase(agenda.getName())) {
                contador += 0.5;

            } else if (token.equalsIgnoreCase("Virginia")) {
                contador += 0.25;
            } else if (token.equalsIgnoreCase("beach")) {
                contador += 0.25;
            } else {

            }
        }

        assertEquals(contador, 1, 0);

    }

}
