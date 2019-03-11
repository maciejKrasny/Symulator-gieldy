
package pojekt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;




public class Akcja implements Serializable{
    private String nazwa;
    private String dataPierwszejWyceny;
    private double openKurs;
    private double curKurs;
    private double minKurs;
    private double maxKurs;
    private ArrayList<Double> tablicaKursow = new ArrayList<>();
    private ArrayList<Double> tablicaProcentow = new ArrayList<>();

    /**
    * Metoda getTablicaProcentow pobiera listę zmian kursu akcji.
    */
    public ArrayList<Double> getTablicaProcentow() {
        return tablicaProcentow;
    }

    /**
    * Metoda setTablicaProcentow ustawia listę zmian kursu akcji.
    */
    
    public void setTablicaProcentow(ArrayList<Double> tablicaProcentow) {
        this.tablicaProcentow = tablicaProcentow;
    }
    
    
    /**
    * Metoda getTablicaKursow pobiera listę poprzednich kursów akcji.
    */
    
    public ArrayList<Double> getTablicaKursow() {
        return tablicaKursow;
    }

    /**
    * Metoda getNazwa pobiera nazwę akcji.
    */
    
    public String getNazwa() {
        return nazwa;
    }

    /**
    * Metoda getDataPierwszejWyceny pobiera datę pierwszej wyceny akcji.
    */
    
    public String getDataPierwszejWyceny() {
        return dataPierwszejWyceny;
    }

    /**
    * Metoda getOpenKurs pobiera kurs otwarcia akcji.
    */
    
    public double getOpenKurs() {
        return openKurs;
    }

    /**
    * Metoda getCurKurs pobiera obecny kurs akcji.
    */
    
    public double getCurKurs() {
        return curKurs;
    }
    
    /**
    * Metoda getMinKurs pobiera minimalny kurs akcji.
    */

    public double getMinKurs() {
        return minKurs;
    }
    /**
    * Metoda getMaxKurs pobiera maksymalny kurs akcji.
    */
    
    public double getMaxKurs() {
        return maxKurs;
    }

    /**
    * Metoda setNazwa ustawia nazwę akcji.
    */
    
    
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
    * Metoda setDataPierwszejWyceny ustawia datę pierwszej wyceny.
    */
    
    public void setDataPierwszejWyceny(String dataPierwszejWyceny) {
        this.dataPierwszejWyceny = dataPierwszejWyceny;
    }
    /**
    * Metoda setOpenKurs ustawia kurs otwarcia akcji.
    */
    public void setOpenKurs(double openKurs) {
        this.openKurs = openKurs;
    }
    /**
     * Metoda setCurKurs ustawnia akutalny kurs.
     */
    public void setCurKurs(double curKurs) {
        this.curKurs = curKurs;
    }

    /**
    * Metoda setMinKurs ustatawia minimalny kurs.
    */
    
    public void setMinKurs(double minKurs) {
        this.minKurs = minKurs;
    }
    /**
    * Metoda setMaxKurs ustawia maksymalny kurs.
    */
    public void setMaxKurs(double maxKurs) {
        this.maxKurs = maxKurs;
    }
    
    /**
    * Metoda akutalizujKus losuje zmianę kursu danej akcji i ustawia jej zaktualizowany obecny kurs.
    * Jeśli obecny kurs będzie większy od maksymalnego to aktualizuje kurs maksymalny i analogicznie minimalny.
    */
    
    public synchronized void aktualizujKurs(){
        Random generator = new Random();
        double zmiana = (generator.nextDouble()*10 - 5)/100;
        this.tablicaProcentow.add(zmiana);
        this.curKurs= this.curKurs * (1+zmiana);
        if (this.curKurs > this.maxKurs)
            this.maxKurs = this.curKurs;
        if (this.curKurs < this.minKurs)
            this.minKurs = this.curKurs;
        this.tablicaKursow.add(this.curKurs);
    }

    /**
    * Konstruktor ustawia pola akcji.
    */
    
    public Akcja(String nazwa, String dataPierwszejWyceny, double openKurs, double curKurs, double minKurs, double maxKurs) {
        this.nazwa = nazwa;
        this.dataPierwszejWyceny = dataPierwszejWyceny;
        this.openKurs = openKurs;
        this.curKurs = curKurs;
        this.minKurs = minKurs;
        this.maxKurs = maxKurs;
        this.tablicaKursow.add(this.curKurs);
    }
    
    
}
