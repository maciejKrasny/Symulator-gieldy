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
public class RynekSurowcow extends Rynek implements Serializable{
    
    private ArrayList<Surowiec> listaSurowcow;

    private  ArrayList<Surowiec> listaUsunietych = new ArrayList<>();
    /**
    * Metoda getListaUsunietych pobiera listę usuniętych surowców rynku.
    */
    public  ArrayList<Surowiec> getListaUsunietych() {
        return listaUsunietych;
    }

    /**
    * Metoda setListaUsunietych ustawia listę usuniętych surowców rynku.
    */
    public  void setListaUsunietych(ArrayList<Surowiec> listaUsunietych) {
        listaUsunietych = listaUsunietych;
    }
    
    /**
    * Metoda getListaSurowcow pobiera listę surowców rynku.
    */
    public ArrayList<Surowiec> getListaSurowcow() {
        return listaSurowcow;
    }

    /**
    * Metoda setListaSurowcow ustawia listę surowców rynku.
    */
    public void setListaSurowcow(ArrayList<Surowiec> listaSurowcow) {
        this.listaSurowcow = listaSurowcow;
    }
 
    /**
    * Konstruktor ustawia pola rynku surowców.
    */
    public RynekSurowcow(String nazwa, float marza, ArrayList<Surowiec> listaSurowcow) {
        super(nazwa, marza);
        this.listaSurowcow = listaSurowcow;
    }
    
    
    
}
