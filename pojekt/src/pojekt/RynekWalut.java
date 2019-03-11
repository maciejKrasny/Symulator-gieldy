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
public class RynekWalut extends Rynek implements Serializable{

    private ArrayList<Waluta> listaWalut;
    private String paryWalut[][];
    private double cenyKupnaiSprzedazy[][];
    private ArrayList<ArrayList<Double>> tablicaKursow = new ArrayList<>();
    private ArrayList<ArrayList<Double>> tablicaProcentow = new ArrayList<>();

   
    /**
    * Metoda getTablicaProcentow pobiera listę list zmian kursów waluty.
    */
    public ArrayList<ArrayList<Double>> getTablicaProcentow() {
        return tablicaProcentow;
    }
    /**
    * Metoda setTablicaProcentow ustawia listę list zmian kursów danej waluty.
    */
    public void setTablicaProcentow(ArrayList<ArrayList<Double>> tablicaProcentow) {
        this.tablicaProcentow = tablicaProcentow;
    }
    
    
    /**
    * Metoda getTablicaKursow pobiera listę list poprzednich kursów danej waluty.
    */
    public ArrayList<ArrayList<Double>> getTablicaKursow() {
        return tablicaKursow;
    }

    /**
    * Metoda setListaWalut ustawia listę list poprzednich kursów danej waluty.
    */
    public void setListaWalut(ArrayList<Waluta> listaWalut) {
        this.listaWalut = listaWalut;
    }

    /**
    * Metoda setParyWalut ustawia listę par walut.
    */
    public void setParyWalut(String[][] paryWalut) {
        this.paryWalut = paryWalut;
    }

    /**
    * Metoda setCenyKupnaiSprzedazy ustawia listę cen danej waluty w stosunku do innej. 
    */
    public void setCenyKupnaiSprzedazy(double[][] cenyKupnaiSprzedazy) {
        this.cenyKupnaiSprzedazy = cenyKupnaiSprzedazy;
    }

    /**
    * Metoda getListaWalut pobiera listę walut rynku.
    */
    public ArrayList<Waluta> getListaWalut() {
        return listaWalut;
    }

    /**
    * Metoda getParyWalut pobiera listę par walut.
    */
    public String[][] getParyWalut() {
        return paryWalut;
    }

    /**
    * Metoda getCenyKupnaiSprzedazy pobiera listę cen danej waluty w stosunku do innej. 
    */
    public double[][] getCenyKupnaiSprzedazy() {
        return cenyKupnaiSprzedazy;
    }
   
   /**
    * Metoda akutalizujKus losuje zmianę kursu danej waluty i ustawia jej zaktualizowany, obecny kurs.
    * Jeśli obecny kurs będzie większy od maksymalnego to aktualizuje kurs maksymalny i analogicznie minimalny.
    */
    public synchronized void aktualizujKurs(int ktory){
        Random generator = new Random();
        
            double zmiana = (generator.nextDouble()*10 - 5)/100;
            this.cenyKupnaiSprzedazy[ktory][0] *= (1+zmiana);
            this.cenyKupnaiSprzedazy[ktory][1] *= (1+zmiana);
            
            this.tablicaProcentow.get(ktory).add(zmiana);
            this.tablicaKursow.get(ktory).add(((cenyKupnaiSprzedazy[ktory][0]*(1+zmiana)+(cenyKupnaiSprzedazy[ktory][0]*(1+zmiana)))/2));
        
    }

    public RynekWalut(ArrayList<Waluta> listaWalut, String[][] paryWalut, double[][] cenyKupnaiSprzedazy, String nazwa, float marza) {
        super(nazwa, marza);
        this.listaWalut = listaWalut;
        this.paryWalut = paryWalut;
        this.cenyKupnaiSprzedazy = cenyKupnaiSprzedazy;
        for (int i = 0; i<11 ; i++){
            this.tablicaKursow.add(new ArrayList<Double>());
        }
        for (int i = 0; i<11 ; i++){
            this.tablicaProcentow.add(new ArrayList<Double>());
        }
    }

}
