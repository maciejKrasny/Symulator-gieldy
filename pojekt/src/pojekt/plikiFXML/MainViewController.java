/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojekt.plikiFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pojekt.Swiat;

/**
 *
 * @author macko
 */
public class MainViewController {

    @FXML
    private BorderPane mainView;
    
    private Swiat swiat;
    @FXML
    private Button rynekPW;
    @FXML
    private Button rynekWalut;
    @FXML
    private Button rynekSurowcow;
    @FXML
    private Button panel;
    @FXML
    private Button inwestorzy;
    
    
    public Swiat getSwiat() {
        return swiat;
    }

    public void setSwiat(Swiat swiat) {
        this.swiat = swiat;
    }
    
    public void initialize(URL url, ResourceBundle rb) {
    }
    /**
    * Metoda tworzy okno rynku surowców.
    */
    public void openRynekSurowcow() throws IOException{
        
        rynekSurowcow.setDisable(true);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GieldaSurowcow.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        GieldaSurowcowController controller = fxmlLoader.<GieldaSurowcowController>getController();
        swiat.setGieldaSurowcowController(controller);
        controller.setSwiat(this.swiat);
        controller.inicjalizuj();
        Stage stage = new Stage();
        stage.setTitle("Rynek surowców");
        stage.setScene(new Scene(root1));
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              rynekSurowcow.setDisable(false);
          }
    });
    }
     /**
    * Metoda tworzy okno giełdy PW.
    */
    public void openRynekPW() throws IOException{
        rynekPW.setDisable(true);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GieldaPW.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        GieldaPWController controller = fxmlLoader.<GieldaPWController>getController();
        swiat.setGieldaPWController(controller);
        controller.setSwiat(this.swiat);
        controller.inicjalizuj();
        Stage stage = new Stage();
        stage.setTitle("Rynek papierów wartościowych");
        stage.setScene(new Scene(root1));
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              rynekPW.setDisable(false);
          }
    });
                }
     /**
    * Metoda tworzy okno rynku walut.
    */
    public void openRynekWalut() throws IOException{
        rynekWalut.setDisable(true);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GieldaWalut.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        GieldaWalutController controller = fxmlLoader.<GieldaWalutController>getController();
        swiat.setGieldaWalutaController(controller);
        controller.setSwiat(this.swiat);
        controller.inicjalizuj();
        Stage stage = new Stage();
        stage.setTitle("Rynek walut");
        stage.setScene(new Scene(root1));
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              rynekWalut.setDisable(false);
          }
    });
    }
     /**
    * Metoda tworzy okno panelu kontrolnego.
    */
    public void openPanel() throws IOException{
        panel.setDisable(true);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PanelKontrolny.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        PanelKontrolnyController controller = fxmlLoader.<PanelKontrolnyController>getController();
        controller.setSwiat(this.swiat);
        controller.inicjalizuj();
        Stage stage = new Stage();
        stage.setTitle("Panel Kontrolny");
        stage.setScene(new Scene(root1));
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              panel.setDisable(false);
          }
    });
    }
     /**
    * Metoda tworzy okno inwestorów.
    */
    public void openInwestorzy() throws IOException{
        
        inwestorzy.setDisable(true);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Inwestorzy.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        InwestorzyController controller = fxmlLoader.<InwestorzyController>getController();
        controller.setSwiat(this.swiat);
        controller.inicjalizuj();
        Stage stage = new Stage();
        stage.setTitle("Inwestorzy");
        stage.setScene(new Scene(root1));
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              inwestorzy.setDisable(false);
          }
    });
    }
}
