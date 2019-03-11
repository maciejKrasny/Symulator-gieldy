
package pojekt;

import java.io.Serializable;
import java.util.ArrayList;


public class GieldaPW extends Rynek implements Serializable{
   private String kraj;
   private String miasto;
   private String adresSiedziby;
   private String indeks[];
   private String waluta;
   private ArrayList <Spolka> listaSpolek;
   private ArrayList<Spolka> listaUsunietych = new ArrayList<>();

   /*
   * Metoda getListaUsunietych pobiera listę usuniętych spółek.
   */
    public ArrayList<Spolka> getListaUsunietych() {
        return listaUsunietych;
    }

    /*
    * Metoda setListaUsunietych ustawia listę usuniętych spółek.
    */
    public void setListaUsunietych(ArrayList<Spolka> listaUsunietych) {
        this.listaUsunietych = listaUsunietych;
    }
   
   
   /*
    * Metoda setKraj ustawia kraj giełdy.
    */
   
    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    /*
    * Metoda setMiasto ustawia miasto giełdy.
    */
    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    /*
    * Metoda setAdresSiedziby ustawia adres siedziby giełdy.
    */
    public void setAdresSiedziby(String adresSiedziby) {
        this.adresSiedziby = adresSiedziby;
    }
    /*
    * Metoda setIndeks ustawia indeksy danej giełdy.
    */
    
    public void setIndeks(String[] indeks) {
        this.indeks = indeks;
    }

    /*
    * Metoda setWaluta ustawia walutę danej giełdy.
    */
    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }
    /*
    * Metoda setListaSpolek ustawia listę spółek giełdy.
    */

    public void setListaSpolek(ArrayList<Spolka> listaSpolek) {
        this.listaSpolek = listaSpolek;
    }
    /*
    * Metoda getKraj pobiera kraj giełdy.
    */
    public String getKraj() {
        return kraj;
    }

    /*
    * Metoda getMiasto pobiera miasto giełdy.
    */
    public String getMiasto() {
        return miasto;
    }
    /*
    * Metoda getAdresSiedziby pobiera adres siedziby giełdy.
    */
    public String getAdresSiedziby() {
        return adresSiedziby;
    }
    
    /*
    * Metoda getIndeks pobuera indeksy giełdy.
    */
    public String[] getIndeks() {
        return indeks;
    }

    /*
    * Metoda getWaluta pobiera walutę giełdy.
    */
    public String getWaluta() {
        return waluta;
    }

    /*
    * Metoda getListaSpolek pobiera listę spółek giełdy.
    */
    public ArrayList<Spolka> getListaSpolek() {
        return listaSpolek;
    }
    /*
    * Konstruktor ustawia pola giełdy.
    */
    public GieldaPW(String kraj, String miasto, String adresSiedziby, String[] indeks, String waluta, ArrayList<Spolka> listaSpolek, String nazwa, float marza) {
        super(nazwa, marza);
        this.kraj = kraj;
        this.miasto = miasto;
        this.adresSiedziby = adresSiedziby;
        this.indeks = indeks;
        this.waluta = waluta;
        this.listaSpolek = listaSpolek;
    }

   
}
