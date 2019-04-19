package org.lasencinas.phonebook.interfaces;

public interface Findable {

    String FindUsers(String name, String city);//Este metodo te busca a los contactos que coincidan en nombre y ciudad pasado por parametros

    String FindUsers();//Metodo anterior sobrecargado 
}
