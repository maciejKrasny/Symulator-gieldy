/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojekt;

import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macko
 */
public class Spolka implements Serializable, Runnable{
    
    private int liczbaAkcji;
    private double zysk;
    private double przychod;
    private double kapitalZakladu;
    private double kapitalWlasny;
    private int wolumen;
    private double obroty;
    private Akcja akcja;
    private boolean czySkonczyc;
    
    /**
    * Metoda getAkcja pobiera akcję spółki.
    */
    public Akcja getAkcja() {
        return akcja;
    }

    /**
    * Metoda getCzySkonczyc pobiera pole, aby sprawdzić czy nie zakończyć wątku.
    */
    public boolean getCzySkonczyc() {
        return czySkonczyc;
    }

    /**
    * Metoda setCzySkonczyc ustawia pole, aby sprawdzić czy nie zakończyć wątku.
    */
    public void setCzySkonczyc(boolean czySkonczyc) {
        this.czySkonczyc = czySkonczyc;
    }
   

    /**
    * Metoda setLiczbaAkcji ustwia liczbą akcji spólki.
    */
    public void setLiczbaAkcji(int liczbaAkcji) {
        this.liczbaAkcji = liczbaAkcji;
    }

    /**
    * Metoda ustawia zysk spółki.
    */
    public void setZysk(double zysk) {
        this.zysk = zysk;
    }
    /**
    * Metoda setPrzychod ustawia przychód spółki.
    */
    public void setPrzychod(double przychod) {
        this.przychod = przychod;
    }

    /**
    * Metoda setKapitalZakladu ustawia kapitał zakładowy.
    */
    public void setKapitalZakladu(double kapitalZakladu) {
        this.kapitalZakladu = kapitalZakladu;
    }

    /**
    * Metoda ustawia kapitał własny.
    */
    public void setKapitalWlasny(double kapitalWlasny) {
        this.kapitalWlasny = kapitalWlasny;
    }

    /**
    * Metoda setWolumen ustwia wolumen.
    */
    public void setWolumen(int wolumen) {
        this.wolumen = wolumen;
    }

    /**
    * Metoda setObroty ustawia obroty spólki.
    */
    public void setObroty(double obroty) {
        this.obroty = obroty;
    }

    
    /**
    * Metoda getLiczbaAkcji pobiera liczbę akcji.
    */
    public int getLiczbaAkcji() {
        return liczbaAkcji;
    }
    
    /**
    * Metoda getZysk pobiera zysk spółki.
    */
    public double getZysk() {
        return zysk;
    }

    /**
    * Metoda getPrzychod pobiera przychód spółki.
    */
    public double getPrzychod() {
        return przychod;
    }

    /**
    * Metoda getKapitalZakladu pobiera kapitał zakładowy.
    */
    public double getKapitalZakladu() {
        return kapitalZakladu;
    }

    /**
    * Metoda pobiera kapitał własny.
    */
    public double getKapitalWlasny() {
        return kapitalWlasny;
    }

    /**
    * Metoda getWolumen pobiera wolumen.
    */
    public int getWolumen() {
        return wolumen;
    }

    /**
    * Metoda getObroty pobiera obroty spółki. 
    */
    public double getObroty() {
        return obroty;
    }

    /**
    * Konstruktor ustawia polla spólki.
    */
    public Spolka(int liczbaAkcji, double zysk, double przychod, double kapitalZakladu, double kapitalWlasny, int wolumen, double obroty, Akcja akcja,boolean czySkonczyc) {
        this.liczbaAkcji = liczbaAkcji;
        this.zysk = zysk;
        this.przychod = przychod;
        this.kapitalZakladu = kapitalZakladu;
        this.kapitalWlasny = kapitalWlasny;
        this.wolumen = wolumen;
        this.obroty = obroty;
        this.akcja = akcja;
        this.czySkonczyc = czySkonczyc;
    }
    
    public synchronized void aktualizuj(){
        Random generator = new Random();
        double zmiana = (double)((generator.nextInt(10)+1))/100;
        
        this.przychod = this.przychod*(1+zmiana);
        this.zysk = this.zysk*(1+zmiana)-100;
        
      
    } 
    public void run() {
        while (!(this.getCzySkonczyc())) {
            aktualizuj();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Spolka.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}