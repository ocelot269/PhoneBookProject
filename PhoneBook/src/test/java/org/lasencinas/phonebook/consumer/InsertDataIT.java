package org.lasencinas.phonebook.consumer;

import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.lasencinas.phonebook.bbdd.Bbdd;
import org.lasencinas.phonebook.person.Person;

public class InsertDataIT {

    public InsertDataIT() {
    }

    private InsertData datos;

    @Before
    public void init() throws IOException {
        InsertData datos = new InsertData("agenda/AgendaTelefonica.txt");
        datos.readTXT();
    }

    @Test
    public void testGetRoute() {
        InsertData datos = new InsertData("agenda/AgendaTelefonica.txt");
        assertNotNull(datos);
        assertEquals("agenda/AgendaTelefonica.txt", datos.getRoute());
    }

    @Test
    public void testSetRoute() {
        InsertData datos = new InsertData("agenda/AgendaTelefonica.txt");
        datos.setRoute("");
        assertEquals("", datos.getRoute());
    }

    @Test
    public void testReadTXT() throws Exception {

        int numeroUsuariosEsperados = 0;
        for (Person string : Bbdd.phoneBook.values()) {
            if ("Kevin".equalsIgnoreCase(string.getName())) {
                numeroUsuariosEsperados += 1;
            }
        }
        assertThat(numeroUsuariosEsperados).isEqualTo(2);

    }

    @Test
    public void testReadTXT1() throws Exception {

        int numeroUsuariosEsperados = 0;
        for (Person string : Bbdd.phoneBook.values()) {
            if ("Kevin Garcia".equalsIgnoreCase(string.getName())) {
                numeroUsuariosEsperados += 1;
            }
        }
        assertThat(numeroUsuariosEsperados).isEqualTo(1);

    }

    @Test
    public void testReadTXT2() throws Exception {

        int numeroUsuariosEsperados = 0;
        for (Person string : Bbdd.phoneBook.values()) {
            if ("Kevin Clark Jones".equalsIgnoreCase(string.getName())) {
                numeroUsuariosEsperados += 1;
            }
        }
        assertThat(numeroUsuariosEsperados).isEqualTo(1);

    }
}
