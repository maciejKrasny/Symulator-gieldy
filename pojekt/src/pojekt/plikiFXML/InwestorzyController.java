
package pojekt.plikiFXML;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pojekt.Inwestor;
import pojekt.Swiat;


public class InwestorzyController {
   @FXML
   private TableView<Inwestor> tabelaInwestorow;
   @FXML
   private TableColumn<Inwestor,String> imiei;
   @FXML
   private TableColumn<Inwestor,String> nazwiskoi;
   @FXML
   private TableColumn<Inwestor,String> peseli;
   @FXML
   private TableColumn<Inwestor,Integer> budzeti;
   @FXML
   private TableView tabelaFunduszy;
   @FXML
   private TableColumn<Inwestor,String> imief;
   @FXML
   private TableColumn<Inwestor,String> nazwiskof;
   @FXML
   private TableColumn<Inwestor,String> nazwaf;
   @FXML
   private TableColumn<Inwestor,Integer> budzetf;
   

   
   
   private Swiat swiat;
   private int aktualnyInwestor;
   private int aktualnyFundusz;
   
   /**
   * Metoda inicjalizuj inicjalizuje okno iwestorów.
   */
   public void inicjalizuj(){
         
       imiei.setCellValueFactory(new PropertyValueFactory<Inwestor,String>("imie"));
       nazwiskoi.setCellValueFactory(new PropertyValueFactory<Inwestor,String>("nazwisko"));
       peseli.setCellValueFactory(new PropertyValueFactory<Inwestor,String>("pesel"));
       budzeti.setCellValueFactory(new PropertyValueFactory<Inwestor,Integer>("budzet"));
       imief.setCellValueFactory(new PropertyValueFactory<Inwestor,String>("imie"));
       nazwiskof.setCellValueFactory(new PropertyValueFactory<Inwestor,String>("nazwisko"));
       nazwaf.setCellValueFactory(new PropertyValueFactory<Inwestor,String>("nazwa"));
       budzetf.setCellValueFactory(new PropertyValueFactory<Inwestor,Integer>("budzet"));
       
       
       tabelaInwestorow.setItems(swiat.getListaInwestorowT());
       tabelaFunduszy.setItems(swiat.getListaFunduszyT());
   }
/**
   * Metoda pobierzInwestora pobiera inwestora z listy.
   */
   public void pobierzInwestora(){
       aktualnyInwestor = tabelaInwestorow.getSelectionModel().getSelectedIndex();
       
       
   }
   /**
   * Metoda usunInwestora usuwa wybranego inwestora z listy.
   */
   public void usunInwestora(){
       if (swiat.getListaInwestorow().size()>0){
       swiat.getListaInwestorow().get(aktualnyInwestor).setCzySkonczyc(true);
       swiat.getListaInwestorowT().remove(aktualnyInwestor);
       swiat.getListaInwestorow().remove(aktualnyInwestor);
       }
       else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Nie możesz usunąć obiektu, który nie istnieje ;)");
            alert.showAndWait();
        } 
   }
   /**
   * Metoda pobierzFundusz pobiera fundusz z listy.
   */
   public void pobierzFundusz(){
       aktualnyFundusz = tabelaFunduszy.getSelectionModel().getSelectedIndex();
   }
   /**
   * Metoda usunFundusz usuwwa fundusz z listy.
   */
   public void usunFundusz(){
       if (swiat.getListaFunduszy().size()>0){
       swiat.getListaFunduszy().get(aktualnyFundusz).setCzySkonczyc(true);
       swiat.getListaFunduszyT().remove(aktualnyFundusz);
       swiat.getListaFunduszy().remove(aktualnyFundusz);
       
       }
       else{
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Nie możesz usunąć obiektu, który nie istnieje ;)");
            alert.showAndWait();
       }
   }
  
    public void setSwiat(Swiat swiat) {
        this.swiat = swiat;
    }
   
}
