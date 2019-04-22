package org.lasencinas.phonebook.consumer;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.lasencinas.phonebook.bbdd.Bbdd;

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
        assertNotNull(Bbdd.phoneBook);
        assertNotNull(Bbdd.nameAndCities);
        assertEquals(7, Bbdd.phoneBook.size());
        assertEquals(7, Bbdd.nameAndCities.size());
        assertEquals(true, Bbdd.phoneBook.containsValue("Kevin"));
        assertEquals(false, Bbdd.nameAndCities.containsValue("Palma"));
        assertEquals(true, Bbdd.nameAndCities.containsValue("Phoenix"));
    }

}
