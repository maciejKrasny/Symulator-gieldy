/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojekt;

import java.io.Serializable;

/**
 *
 * @author macko
 */
public class Zakup implements Serializable{
    private int ilosc;
    private int ktoryRynek;
    private int ktoraGielda;
    private Surowiec surowiec;
    private Akcja akcja;
    private Waluta waluta;

    /**
    * Metoda getKtoryRynek pobiera rynek, na którym doszło do transakcji. 
    */
    public int getKtoryRynek() {
        return ktoryRynek;
    }

     /**
    * Metoda setKtoryRynek ustawia rynek, na którym doszło do transakcji. 
    */
    public void setKtoryRynek(int ktoryRynek) {
        this.ktoryRynek = ktoryRynek;
    }

    /**
    * Metoda getKtoraGielda pobiera giełdę, na którym doszło do transakcji. 
    */
    public int getKtoraGielda() {
        return ktoraGielda;
    }

     /**
    * Metoda setKtoraGielda ustawia giełdę, na którym doszło do transakcji. 
    */
    public void setKtoraGielda(int ktoraGielda) {
        this.ktoraGielda = ktoraGielda;
    }
    
   /**
    * Metoda getIlosc pobiera ilość zakupionego aktywu.
    */
    
    public int getIlosc() {
        return ilosc;
    }
    /**
    * Metoda setIlosc ustawia ilość zakupionego aktywu.
    */
    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
    /**
    * Metoda getSurowiec pobiera zakupiony surowiec.
    */
    public Surowiec getSurowiec() {
        return surowiec;
    }

    /**
    * Metoda setSurowiec ustawia zakupiony surowiec.
    */
    public void setSurowiec(Surowiec surowiec) {
        this.surowiec = surowiec;
    }

    /**
    * Metoda getAkcja pobiera zakupioną akcję.
    */
    public Akcja getAkcja() {
        return akcja;
    }
    /**
    * Metoda setAkcja ustawia zakupioną akcję.
    */
    public void setAkcja(Akcja akcja) {
        this.akcja = akcja;
    }

    /**
    * Metoda getWaluta pobiera zakupioną walutę.
    */
    public Waluta getWaluta() {
        return waluta;
    }
    /**
    * Metoda setWaluta ustawia zakupioną walutę.
    */
    public void setWaluta(Waluta waluta) {
        this.waluta = waluta;
    }

    /**
    * Konstruktor ustawia pola zakupu.
    */

    public Zakup(int ilosc, int ktoryRynek, int ktoraGielda, Surowiec surowiec, Akcja akcja, Waluta waluta) {
        this.ilosc = ilosc;
        this.ktoryRynek = ktoryRynek;
        this.ktoraGielda = ktoraGielda;
        this.surowiec = surowiec;
        this.akcja = akcja;
        this.waluta = waluta;
    }

   

   

  
    
}
