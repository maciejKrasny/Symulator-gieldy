/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojekt.Generatory;

import java.util.ArrayList;
import java.util.Random;
import pojekt.Inwestor;
import pojekt.OdczytZPliku;
import pojekt.Zakup;


public class GeneratorInwestorow {
    
    private static ArrayList<String> listaImion;
    private static ArrayList<String> listaNazwisk;
    private static ArrayList<String> listaPeseli;
    private static int budzet;
    /**
    * Metoda generuj generuje pola inwestora.
    */
    public static Inwestor generuj(){
        Random generator = new Random();
        listaImion = new  ArrayList<>();
        listaNazwisk = new  ArrayList<>();
        listaPeseli = new  ArrayList<>();
        listaImion =  (ArrayList<String>) OdczytZPliku.odczytaj("src\\generator\\Imiona.txt");
        listaNazwisk =  (ArrayList<String>) OdczytZPliku.odczytaj("src\\generator\\Nazwiska.txt");
        listaPeseli =  (ArrayList<String>) OdczytZPliku.odczytaj("src\\generator\\PESELe.txt");
        budzet = generator.nextInt(10000000)+500000;
        
        return new Inwestor(listaImion.get(generator.nextInt(listaImion.size())),listaNazwisk.get(generator.nextInt(listaNazwisk.size())),listaPeseli.get(generator.nextInt(listaPeseli.size())),budzet, new ArrayList<Zakup>(),false);
        
    }

}
