
package pojekt;

import java.io.Serializable;


public abstract class Rynek implements Serializable{
    private String nazwa;
    private float marza;
    
    /**
    * Metoda setNazwa ustawia nazwę rynku.
    */
    public void setNazwa(String nazwa)
    {
        this.nazwa=nazwa;
    }
     /**
    * Metoda setMarza ustawia marżę rynku.
    */  
    public void setMarza(float marza) {
        this.marza = marza;
    }
    
    /**
     * Metoda getNazwa pobiera nazwę.
     */
    public String getNazwa()
    {
        return nazwa;
    }  

    /**
    * Metoda getMarza pobiera marżę rynku.
    */
    
    public float getMarza() {
        return marza;
    }
    /**
    * Konstruktor ustawia pola rynku.
    */
    public Rynek(String nazwa, float marza) {
        this.nazwa = nazwa;
        this.marza = marza;
    }
    
    
    
}
