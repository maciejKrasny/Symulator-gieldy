/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojekt.Generatory;

import java.util.ArrayList;
import java.util.Random;
import pojekt.Akcja;
import pojekt.GieldaPW;
import pojekt.Spolka;


/**
 *
 * @author macko
 */
public class GeneratorGieldPW {
    
    private static String kraj[] = {"Polska","Niemcy","Wielka Brytania", "USA", "Holandia"};
    private static String miasto[] = {"Warszawa","Frankfurt nad Menem","Londyn", "Nowy Jork", "Amsterdam"};
    private static String adresSiedziby[] = {"Książęca 4, 00-498","Börsenplatz 4, 60313","10 Paternoster Square, EC4M 7LS","11 Wall Street, 10005","Beursplein 5, 1012"};
    private static String indeksy[][]={{"WIG30","WIG20"},{"DAX","Euro Stoxx 50"},{"FTSE 100","FTSE 250"},{"Dow Jones Industrial Average","Nasdaq 100"},{"AEX","AEX All Share"}};
    private static String waluty[]={"Złoty","Euro","Funt brytyjski","Dolar amerykański","Euro"};

    public static String[][] getIndeksy() {
        return indeksy;
    }
    
    /**
    * Metoda generuj generuje pola giełdyPW.
    */
    
    public static GieldaPW generuj(int ktory){
        
         ArrayList<Spolka> listaSpolek = new ArrayList<>();
        Random generator = new Random();
        int iloscSpolek = generator.nextInt(7)+3;
        Spolka spolka;
        for (int i=0; i<iloscSpolek; i++){
            spolka = GeneratorSpolki.generuj(ktory,i);
            for (int j=0; j<30;j++){
                spolka.getAkcja().aktualizujKurs();
                Thread t1 = new Thread(spolka);
                t1.start();
            }
            listaSpolek.add(spolka);
        }
        String indeks[]= new String[1];
        indeks[0]= indeksy[ktory][0];
        return new GieldaPW(kraj[ktory],miasto[ktory],adresSiedziby[ktory],indeks,waluty[ktory],listaSpolek,"Giełda papierów wartościowych", generator.nextFloat());
        
    }
}