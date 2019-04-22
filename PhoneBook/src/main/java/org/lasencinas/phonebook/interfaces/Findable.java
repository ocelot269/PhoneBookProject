package org.lasencinas.phonebook.interfaces;

public interface Findable {

    String findUsers(String name, String city);//Este metodo te busca a los contactos que coincidan en nombre y ciudad pasado por parametros

    String findUsers();//Metodo anterior sobrecargado 
}
