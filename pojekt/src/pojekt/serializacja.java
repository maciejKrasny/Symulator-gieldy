/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojekt;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author macko
 */
public class serializacja {

    private static String SAVE = "lista.bin";
    /**
    * Metoda save zapisuje do pliku pola swiata.
    */
    public static void save(Swiat swiat) throws FileNotFoundException, IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(SAVE)));

        outputStream.writeObject(swiat.getListaRynkow());
        outputStream.writeObject(swiat.getListaGield());
        outputStream.writeObject(swiat.getListaRynkowSurowcow());
        outputStream.writeObject(swiat.getListaRynkowWalut());
        outputStream.writeObject(swiat.getListaInwestorow());
        outputStream.writeObject(swiat.getListaFunduszy());
        outputStream.writeObject(new ArrayList<>(swiat.getListaRynkowSurowcowC()));
        outputStream.writeObject(new ArrayList<>(swiat.getListaGieldC()));
        outputStream.writeObject(new ArrayList<>(swiat.getListaInwestorowT()));
        outputStream.writeObject(new ArrayList<>(swiat.getListaFunduszyT()));

        outputStream.close();
    }
    /**
    * Metoda load pobiera z pliku pola swiata i rozpoczyna wątki zapisanych inwestorów i funduszy.
    */
    public static void load(Swiat swiat) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(SAVE)));

        swiat.setListaRynkow((ArrayList<Rynek>) inputStream.readObject());
        swiat.setListaGield((ArrayList<GieldaPW>) inputStream.readObject());
        swiat.setListaRynkowSurowcow((ArrayList<RynekSurowcow>) inputStream.readObject());
        swiat.setListaRynkowWalut((RynekWalut) inputStream.readObject());
        swiat.setListaInwestorow((ArrayList<Inwestor>) inputStream.readObject());
        swiat.setListaFunduszy((ArrayList<Fundusz>) inputStream.readObject());
        swiat.setListaRynkowSurowcowC(FXCollections.observableArrayList((ArrayList<String>) inputStream.readObject()));
        swiat.setListaGieldC(FXCollections.observableArrayList((ArrayList<String>) inputStream.readObject()));
        swiat.setListaInwestorowT(FXCollections.observableArrayList((ArrayList<Inwestor>) inputStream.readObject()));
        swiat.setListaFunduszyT(FXCollections.observableArrayList((ArrayList<Fundusz>) inputStream.readObject()));
        inputStream.close();
        if (!(swiat.getListaInwestorow().isEmpty())) {
            for (int i = 0; i < swiat.getListaInwestorow().size(); i++) {
                swiat.getListaInwestorow().get(i).setSwiat(swiat);
                Thread t = new Thread(swiat.getListaInwestorow().get(i));
                t.start();
            }
        }
        if (!(swiat.getListaFunduszy().isEmpty())) {
            for (int i = 0; i < swiat.getListaFunduszy().size(); i++) {
                swiat.getListaFunduszy().get(i).setSwiat(swiat);
                Thread t = new Thread(swiat.getListaFunduszy().get(i));
                t.start();
            }
        }
    }
}
