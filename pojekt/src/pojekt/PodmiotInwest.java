
package pojekt;

import java.io.Serializable;
import java.util.ArrayList;


public abstract class PodmiotInwest implements Serializable{

    private String imie;
    private String nazwisko;
    private double budzet;
    ArrayList<Zakup> historiaZakupow;
    private boolean czySkonczyc;
    /**
    * Metoda setImie ustawia imię podmiotu inwestującego.
    */
    public void setImie(String imie) {
        this.imie = imie;
    }

    /**
    * Metoda setNazwisko ustawia nazwisko podmiotu.
    */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    
    /**
    * Metoda setBudzet ustawia budzet podmiotu.
    */
    public void setBudzet(double budzet) {
        this.budzet = budzet;
    }

    /**
    * Metoda getImie pobiera imię podmiotu.
    */
    public String getImie() {
        return imie;
    }

    /**
    * Metoda getNazwisko pobiera nazwisko podmiotu.
    */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
    * Metoda getBudzet pobiera budzet podmiotu.
    */
    public double getBudzet() {
        return budzet;
    }

    /**
    * Metoda getHistoriaZakupow pobiera historię zakupów podmiotu.
    */
    public ArrayList<Zakup> getHistoriaZakupow() {
        return historiaZakupow;
    }
    /**
    * Kontruktor ustawia pola podmiotu.
    */
    public PodmiotInwest(String imie, String nazwisko, double budzet, ArrayList<Zakup> historiaZakupow, boolean czySkonczyc) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.budzet = budzet;
        this.historiaZakupow = historiaZakupow;
        this.czySkonczyc = czySkonczyc;
    }

    /**
    * Metoda pobiera pole czySkończyć do sprawdzenia czy wątek ma być zakończony.
    */
    public boolean getCzySkonczyc() {
        return czySkonczyc;
    }
    /**
    * Metoda ustawia pole czySkonczyc.
    */
    public void setCzySkonczyc(boolean czySkonczyc) {
        this.czySkonczyc = czySkonczyc;
    }

    
    
    

    

    public void kupno() {

    }

    public void sprzedaz() {

    }

    public void zmienBudzet() {

    }

}
