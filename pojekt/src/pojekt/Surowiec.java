/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojekt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author macko
 */
public class Surowiec implements Serializable{
    private String nazwa;
    private String waluta;
    private String jednostkaHandlowa;
    private double curWartosc;
    private double minWartosc;
    private double maxWartosc;
    private ArrayList<Double> tablicaKursow = new ArrayList<>();
    private ArrayList<Double> tablicaProcentow = new ArrayList<>();

    /**
    * Metoda getTablicaProcentow pobiera listę zmian kursu surowca.
    */
    public ArrayList<Double> getTablicaProcentow() {
        return tablicaProcentow;
    }
    /**
    * Metoda setTablicaProcentow ustawia listę zmian kursu surowca.
    */
    public void setTablicaProcentow(ArrayList<Double> tablicaProcentow) {
        this.tablicaProcentow = tablicaProcentow;
    }

    /**
    * Metoda ustawia nazwę surowca .
    */

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
    * Metoda ustawia walutę surowca.
    */
    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    /**
    * Metoda setJednostkaHandlowa ustawia jednostkę handlową.
    */
    public void setJednostkaHandlowa(String jednostkaHandlowa) {
        this.jednostkaHandlowa = jednostkaHandlowa;
    }

    /**
    * Metoda setCurWartosc ustawia obecny kurs.
    */
    public void setCurWartosc(float curWartosc) {
        this.curWartosc = curWartosc;
    }

    /**
    * Metoda setMinWartosc ustawia minimalny kurs surowca.
    */
    public void setMinWartosc(float minWartosc) {
        this.minWartosc = minWartosc;
    }

    /** 
    * Metoda setMaxWartosc ustawia maksymalną wartość surowca.
    */
    public void setMaxWartosc(float maxWartosc) {
        this.maxWartosc = maxWartosc;
    }

    /**
     * Metoda getNazwa pobiera nazwę surowca.
    */
    
    public String getNazwa() {
        return nazwa;
    }

    /**
    * Metoda getWaluta pobiera walutę.
    */
    public String getWaluta() {
        return waluta;
    }

    /**
    * Metoda getJednostkaHandlowa pobiera jednostkę handlową.
    */
    public String getJednostkaHandlowa() {
        return jednostkaHandlowa;
    }

    /**
    * Metoda getCurWartosc pobiera obecny kurs.
    */
    public double getCurWartosc() {
        return curWartosc;
    }

    /**
    * Metoda getMinWartosc pobiera minimalny kurs surowca.
    */
    public double getMinWartosc() {
        return minWartosc;
    }

    /**
    * Metoda getMaxWartosc pobiera maksymalny kurs surowca.
    */
    public double getMaxWartosc() {
        return maxWartosc;
    }

    /*
    * Metoda getTablicaKursow pobiera listę poprzednich kursów surowca.
    */
    public ArrayList<Double> getTablicaKursow() {
        return tablicaKursow;
    }

    /*
    * Metoda setTablicaKursow ustawia listę poprzednich kursów surowca.
    */
    public void setTablicaKursow(ArrayList<Double> tablicaKursow) {
        this.tablicaKursow = tablicaKursow;
    }
    
     /**
    * Metoda akutalizujKus losuje zmianę kursu danego surowca i ustawia jej zaktualizowany obecny kurs.
    * Jeśli obecny kurs będzie większy od maksymalnego to aktualizuje kurs maksymalny i analogicznie minimalny.
    */
    
    public synchronized void aktualizujKurs(){
        Random generator = new Random();
        double zmiana = (generator.nextDouble()*10 - 5)/100;
        this.tablicaProcentow.add(zmiana);
        this.curWartosc = this.curWartosc * (1+zmiana);
        if (this.curWartosc > this.maxWartosc){
            
            this.maxWartosc = this.curWartosc;
        }
        if (this.curWartosc < this.minWartosc)
        {   
            this.minWartosc = this.curWartosc; 
        }    
        this.tablicaKursow.add(this.curWartosc);
        
    }
    
    /**
    * Konstruktor ustawia pola surowca.
    */
    public Surowiec(String nazwa, String waluta, String jednostkaHandlowa, double curWartosc, double minWartosc, double maxWartosc) {
        this.nazwa = nazwa;
        this.waluta = waluta;
        this.jednostkaHandlowa = jednostkaHandlowa;
        this.curWartosc = curWartosc;
        this.minWartosc = minWartosc;
        this.maxWartosc = maxWartosc;
        this.tablicaKursow.add(this.curWartosc);
        this.tablicaProcentow.add(1.0);
    }

}
