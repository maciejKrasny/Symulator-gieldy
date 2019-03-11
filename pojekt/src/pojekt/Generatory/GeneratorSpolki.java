/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojekt.Generatory;

import java.util.Random;
import pojekt.Spolka;
public class GeneratorSpolki {
    
    private static double kapitalWlasnytys[][] = {{6533877,5505100,8777000,32013000,32584800,13010000,42679000,11299600,1085650,26763000}};
    
    /**
    * Metoda generuj generuje pola spółki.
    */
    
    public static Spolka generuj(int ktory, int i){
        
        Random generator = new Random();
        int kapitalWlasny = generator.nextInt(80000000)+5000000;
        
        
        return new Spolka((int)(kapitalWlasny/(GeneratorAkcji.getCurKurs()[ktory][i])),
                (generator.nextInt(1000000)+20000.5),
                (generator.nextInt(10000000)+400000.5),
                generator.nextInt(100000)+5000,
                kapitalWlasny,
                generator.nextInt(200000)+20000+generator.nextInt(50000)+20000,
                generator.nextInt(40000)+1000,
                GeneratorAkcji.generuj(ktory,i),false);
        
    }
}

