package pojekt.Generatory;

import java.util.ArrayList;
import pojekt.Waluta;

public class GeneratorWaluty {

    private static String[] kraje = {"Polska", "Niemcy", "USA", "Wielka Brytania", "Szwajcaria", "Szwecja", "Australia", "Kanada", "Czechy", "Japonia", "Rosja"};

    private static String[] nazwy = {"Złoty", "Euro", "Dolar amerykański", "Funt brytyjski", "Frank szwajcarski", "Korona szwedzka", "Dolar australijski", "Dolar kanadyjski", "Korona czeska", "Jen", "Rubel rosyjski"};
    /**
    * Metoda generuj generuje pola waluty.
    */
    public static Waluta generuj(int i) {

        
        return new Waluta(nazwy[i], kraje[i]);
    }

}
