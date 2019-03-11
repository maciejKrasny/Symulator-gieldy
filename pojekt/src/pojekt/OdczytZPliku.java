
package pojekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class OdczytZPliku {
    /**
    * Metoda odczytaj odczytuje zawartość pliku.
    */
    public static List<String> odczytaj(String plik) {

        
        ArrayList<String> records = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(plik));
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
            reader.close();
            return records;
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", plik);
            e.printStackTrace();
            return null;

        }

    }
    
}