/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojekt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pojekt.Generatory.GeneratorRynkuWalut;
import pojekt.plikiFXML.MainViewController;

/**
 *
 * @author macko
 */
public class Pojekt extends Application {

    private Stage primaryStage;
    private Swiat swiat;
    
    /**
     * Metoda rozpoczyna działanie programu.
     */

    @Override
    public void start(Stage primaryStage) throws Exception {
       
            RynekWalut rynekWalut = GeneratorRynkuWalut.generuj();

            swiat = new Swiat(new ArrayList<Rynek>() , new ArrayList<GieldaPW>(),new ArrayList<RynekSurowcow>(),rynekWalut, new ArrayList<Inwestor>() ,new ArrayList<Fundusz>(),FXCollections.observableArrayList(),FXCollections.observableArrayList(),FXCollections.observableArrayList(),FXCollections.observableArrayList());

            /*Random generator = new Random();   
           int ilosc= generator.nextInt(2)+3;

                int index;
            for (int i = 0; i< ilosc; i++){
                index = i+1;
                swiat.getListaGield().add(GeneratorGieldPW.generuj(i));

                swiat.getListaRynkowSurowcow().add(GeneratorRynkuSurowcow.generuj());
                
                swiat.getListaRynkow().add(swiat.getListaGield().get(i));
                swiat.getListaRynkow().add(swiat.getListaRynkowSurowcow().get(i));
                swiat.getListaRynkowSurowcowC().add(swiat.getListaRynkowSurowcow().get(i).getNazwa()+" #"+index);
                swiat.getListaGieldC().add(swiat.getListaGield().get(i).getNazwa()+" #"+index);
                
            }
        Inwestor inwestor = GeneratorInwestorow.generuj();
        Fundusz fundusz = GeneratorFunduszu.generuj();
        swiat.getListaInwestorow().add(inwestor);
        swiat.getListaInwestorowT().add(inwestor);
        swiat.getListaFunduszy().add(fundusz);
        swiat.getListaFunduszyT().add(fundusz);
        swiat.setListaRynkowWalut(rynekWalut);
        swiat.getListaRynkow().add(rynekWalut);
       
          */
         serializacja.load(swiat);
          
        
        this.primaryStage = primaryStage;
        
        showMainView();
       
        
        
          
        primaryStage.setOnCloseRequest(e -> {
                try {
                    serializacja.save(this.swiat);
                } catch (IOException ex) {
                    Logger.getLogger(Pojekt.class.getName()).log(Level.SEVERE, null, ex);
                }
            Platform.exit();System.exit(0);});
 }
    public void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("plikiFXML/MainView.fxml"));
        BorderPane mainLayout = loader.load();
        MainViewController controller = loader.<MainViewController>getController();
        controller.setSwiat(this.swiat);
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Aplikacja giełdowa");
        primaryStage.show();
        
    }

    
    public static void main(String[] args) {
        launch(args);
    }

}
