
package org.lasencinas.phonebook.consumer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.lasencinas.phonebook.bbdd.Bbdd;


public class InsertDataIT {
    
    public InsertDataIT() {
    }

    
    @Test
    public void testGetRoute() {
        InsertData datos = new InsertData("C:/Users/ozeh/Desktop/AgendaTelefonica.txt");
        assertNotNull(datos);
        assertEquals("C:/Users/ozeh/Desktop/AgendaTelefonica.txt", datos.getRoute());
    }

    @Test
    public void testSetRoute() {
        InsertData datos = new InsertData("C:/Users/ozeh/Desktop/AgendaTelefonica.txt");
        datos.setRoute("");
        assertEquals("", datos.getRoute());
    }

    
    @Test
    public void testReadTXT() throws Exception {
        InsertData datos = new InsertData("C:/Users/ozeh/Desktop/AgendaTelefonica.txt");
        assertEquals(0,Bbdd.phoneBook.size());
        assertEquals(0,Bbdd.nameAndCitys.size());
        datos.readTXT();
        assertNotNull(Bbdd.phoneBook);
        assertNotNull(Bbdd.nameAndCitys);
        assertEquals(7, Bbdd.phoneBook.size());
        assertEquals(7, Bbdd.nameAndCitys.size());
        assertEquals(true, Bbdd.phoneBook.containsValue("Kevin"));
        assertEquals(false, Bbdd.nameAndCitys.containsValue("Palma"));
        assertEquals(true, Bbdd.nameAndCitys.containsValue("Phoenix"));
    }
    
}
