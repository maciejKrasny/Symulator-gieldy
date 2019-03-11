/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojekt.Generatory;

import java.util.ArrayList;
import pojekt.Surowiec;


public class GeneratorSurowcow {
    
    private static int ilosc = 10;
    private static String[] nazwy = {"Ropa", "Złoto", "Miedź", "Srebro", "Platyna", "Aluminium", "Drewno", "Gaz ziemny", "Bawełna", "Nikiel"};
    private static String waluty = "Dolar amerykański";
    private static String[] jednostkiHandlowe = {"Baryłka", "Uncja", "Tona", "Uncja", "Uncja", "Uncja", "1000 stóp deskowych", "Mln btu", "Funt", "Tona"};
    private static double[] curWartosci = {65.62, 1289.30, 7189.00, 16.65, 929.00, 2113.25, 449.50, 2.68, 77.33, 11952.50};
    private static double[] minWartosci = {65.50, 1286.00, 7155.00, 16.56, 925.00, 2170.50, 449.50, 2.61, 77.27, 11830.00};
    private static double[] maxWartosci = {66.36, 1290.90, 7206.25, 16.71, 930.70, 2213.25, 455.30, 2.69, 77.87, 12020.00};
    
    
    
    
    public static int getIlosc(){
        return ilosc;
    }
    /**
    * Metoda generuj generuje pola surowca.
    */
    public static Surowiec generuj(int i) {
       return new Surowiec(nazwy[i], waluty, jednostkiHandlowe[i], curWartosci[i], minWartosci[i], maxWartosci[i]);
       
        
    }

}
