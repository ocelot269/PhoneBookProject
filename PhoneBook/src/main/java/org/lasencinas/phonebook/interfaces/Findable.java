package org.lasencinas.phonebook.interfaces;

public interface Findable {

    void FindUsers(String name, String city);//Este metodo te busca a los contactos que coincidan en nombre y ciudad pasado por parametros

    void FindUsers();//Metodo anterior sobrecargado 
}
