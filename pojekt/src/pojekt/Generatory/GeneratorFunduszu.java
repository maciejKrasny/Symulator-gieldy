/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojekt.Generatory;

import java.util.ArrayList;
import java.util.Random;
import pojekt.Fundusz;
import pojekt.OdczytZPliku;
import pojekt.Zakup;


public class GeneratorFunduszu {
    
    private static ArrayList<String> listaImion;
    private static ArrayList<String> listaNazwisk;
    private static ArrayList<String> listaNazw;
    private static int budzet; 
    /**
    * Metoda generuj generuje pola funduszu.
    */
public static Fundusz generuj(){
    Random generator = new Random();
        listaImion = new  ArrayList<>();
        listaNazwisk = new  ArrayList<>();
        listaNazw = new  ArrayList<>();
        listaImion = (ArrayList<String>) OdczytZPliku.odczytaj("src\\generator\\Imiona.txt");
        listaNazwisk =  (ArrayList<String>) OdczytZPliku.odczytaj("src\\generator\\Nazwiska.txt");
        listaNazw =  (ArrayList<String>) OdczytZPliku.odczytaj("src\\generator\\Fundusze.txt");
        budzet = generator.nextInt(450000)+50000;
        
        return new Fundusz(listaImion.get(generator.nextInt(listaImion.size())),listaNazwisk.get(generator.nextInt(listaNazwisk.size())),listaNazw.get(generator.nextInt(listaNazw.size())),budzet, new ArrayList<Zakup>(),false);
}

}
