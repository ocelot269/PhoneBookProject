package org.lasencinas.phonebook.consumer;

import java.io.IOException;

import java.util.StringTokenizer;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.lasencinas.phonebook.bbdd.Bbdd;
import org.lasencinas.phonebook.consumer.InsertData;
import org.lasencinas.phonebook.interfaces.Listable;

public class PhoneBookIT {

    public PhoneBookIT() {
    }

    private InsertData datos;
    private int numeroUsuariosEsperados;

    @Before
    public void init() throws IOException {
        InsertData datos = new InsertData("agenda/AgendaTelefonica.txt");
        datos.readTXT();
    }

    @Test
    public void testListUsers() throws IOException { //Pendiente de forma de testear de manera correcta        
        PhoneBook agenda = new PhoneBook();
        agenda.listUsers("Kevin");
        numeroUsuariosEsperados = 0;
        for (StringTokenizer stringTokenizer = new StringTokenizer(agenda.getPrintCode()); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();

            if (token.equalsIgnoreCase("Kevin")) {
                numeroUsuariosEsperados += 1;

            }
        }
        assertThat(numeroUsuariosEsperados).isEqualTo(5);
    }

    @Test
    public void testListUsers1() throws IOException {
        PhoneBook agenda = new PhoneBook("Linda", "San Antonio");
        agenda.addUsers("Linda", "00000000", "san antonio");
        agenda.listUsers();

        numeroUsuariosEsperados = 0;
        for (StringTokenizer stringTokenizer = new StringTokenizer(agenda.getPrintCode()); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();

            if (token.equalsIgnoreCase("linda")) {
                numeroUsuariosEsperados += 1;

            }
        }
        assertThat(numeroUsuariosEsperados).isEqualTo(2);
        agenda.deleteUsers("00000000");
    }

    @Test
    public void testAddUssers() {
        PhoneBook agenda = new PhoneBook();
        agenda.addUsers("Jose", "654000000", "Palma");
        assertNotNull(Bbdd.phoneBook);
        assertEquals(8, Bbdd.phoneBook.size());

    }

    @Test
    public void testDeleteUsers() {
        PhoneBook agenda = new PhoneBook();
        int numeroUsuariosEsperados = 8;
        agenda.addUsers("Jose", "654000000", "Palma");
        assertNotNull(Bbdd.phoneBook);
        assertEquals(numeroUsuariosEsperados, Bbdd.phoneBook.size());
        agenda.deleteUsers("654000000");
        assertEquals(numeroUsuariosEsperados - 1, Bbdd.phoneBook.size());
    }

    @Test
    public void testFindUsers() throws IOException {
        PhoneBook agenda = new PhoneBook();
        agenda.findUsers("kevin", "phoenix");

        double usuarios = 0;
        numeroUsuariosEsperados = 2;

        for (StringTokenizer stringTokenizer = new StringTokenizer(agenda.getPrintCode()); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();

            if (token.equalsIgnoreCase("Kevin")) {
                usuarios += 0.5;

            } else if (token.equalsIgnoreCase("phoenix")) {
                usuarios += 0.5;
            } else {

            }
        }

        assertThat(usuarios).isEqualTo(numeroUsuariosEsperados);

    }

    @Test
    public void testFindUsers1() throws IOException {

        PhoneBook agenda = new PhoneBook("Kevin", "phoenix");
        agenda.findUsers();

        numeroUsuariosEsperados = 2;
        double usuarios = 0;
        agenda.getPrintCode();
        for (StringTokenizer stringTokenizer = new StringTokenizer(agenda.getPrintCode()); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();

            if (token.equalsIgnoreCase(agenda.getName())) {
                usuarios += 0.5;

            } else if (token.equalsIgnoreCase(agenda.getCity())) {
                usuarios += 0.5;

            } else {

            }
        }

        assertThat(usuarios).isEqualTo(numeroUsuariosEsperados);

    }

    @Test
    public void testFindUsers2() throws IOException {

        PhoneBook agenda = new PhoneBook("Kevin", "Virginia beach");
        agenda.findUsers();

        numeroUsuariosEsperados = 2;
        double usuarios = 0;
        agenda.getPrintCode();
        for (StringTokenizer stringTokenizer = new StringTokenizer(agenda.getPrintCode()); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();

            if (token.equalsIgnoreCase(agenda.getName())) {
                usuarios += 0.5;

            } else if (token.equalsIgnoreCase("Virginia")) {
                usuarios += 0.25;
            } else if (token.equalsIgnoreCase("beach")) {
                usuarios += 0.25;

            } else {

            }
        }

        assertThat(usuarios)
                .isEqualTo(numeroUsuariosEsperados);

    }

    @Test
    public void firstUppercaseCharTest() {
        PhoneBook agenda = new PhoneBook();
        assertEquals("Kevin", agenda.firstUppercaseChar("KeViN"));
        assertEquals("Kevin", agenda.firstUppercaseChar("kevin"));
    }
}
