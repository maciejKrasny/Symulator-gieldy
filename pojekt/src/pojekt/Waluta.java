/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojekt;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author macko
 */
public class Waluta implements Serializable{
    private String nazwa;
    private  String listaKrajow;
    
    /**
    * Metoda setNazwa ustawia nazwę waluty.
    */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
    * Metoda setListaKrajow ustwia listę krajów waluty.
    */
    public void setListaKrajow(String listaKrajow) {
        this.listaKrajow = listaKrajow;
    }
    
    /**
    * Metoda getNazwa pobiera nazwę waluty.
    */
    public String getNazwa() {
        return nazwa;
    }

    /**
    * Metoda getListaKrajow pobiera listę krajów danej waluty.
    */
    public String getListaKrajow() {
        return listaKrajow;
    }

    /**
    * Konstruktor ustawia pola waluty.
    */
    public Waluta(String nazwa, String listaKrajow) {
        this.nazwa = nazwa;
        this.listaKrajow = listaKrajow;
    }
}
