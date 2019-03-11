/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojekt.Generatory;

import java.util.ArrayList;
import java.util.Random;
import pojekt.RynekSurowcow;
import pojekt.Surowiec;

public class GeneratorRynkuSurowcow {
    
    /**
    * Metoda generuj generuje pola rynku surowców.
    */
    public static RynekSurowcow generuj() {

        ArrayList<Surowiec> lista = new ArrayList<>();
        Random generator = new Random();
        int ilosc = generator.nextInt(GeneratorSurowcow.getIlosc()-3)+3;
        for (int i = 0; i < ilosc; i++) {
            Surowiec surowiec = GeneratorSurowcow.generuj(i);
            for (int j=0; j<30;j++){
                surowiec.aktualizujKurs();
            }
            lista.add(surowiec);
        }
        return new RynekSurowcow("Rynek surowcow", generator.nextFloat(), lista);
    }

}
