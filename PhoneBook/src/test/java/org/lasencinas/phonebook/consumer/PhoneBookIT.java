
package org.lasencinas.phonebook.consumer;

import org.junit.Test;
import static org.junit.Assert.*;
import org.lasencinas.phonebook.bbdd.Bbdd;
import org.lasencinas.phonebook.interfaces.Listable;


public class PhoneBookIT {
    
    public PhoneBookIT() {
    }

 
    @Test
    public void testListUsers() { //Pendiente de forma de testear de manera correcta
        Listable agenda = new PhoneBook();
        agenda.ListUsers("Kevin");
        
    }
    
}
