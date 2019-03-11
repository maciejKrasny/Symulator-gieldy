
package pojekt.plikiFXML;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import pojekt.Akcja;
import pojekt.Generatory.GeneratorGieldPW;
import pojekt.Generatory.GeneratorInwestorow;
import pojekt.Generatory.GeneratorSpolki;
import pojekt.GieldaPW;
import pojekt.Inwestor;
import pojekt.Spolka;
import pojekt.Swiat;


public class GieldaPWController implements Serializable {

    @FXML
    private ChoiceBox listaGield;

    @FXML
    private ChoiceBox listaAktywow;
    
    @FXML
    private Text informacje;

    @FXML
    private LineChart wykresProcentowy;
    
    @FXML 
    private TableView table;
    @FXML
    private TableView table1;
     @FXML 
    private TableView table3;
    @FXML
    private TableColumn<Akcja,String> nazwa;
    @FXML
    private TableColumn<Akcja,String> dataWyceny;
    @FXML
    private TableColumn<Akcja,Double> kursOtwarcia;
    @FXML
    private TableColumn<Akcja,Double> kursObecny;
    @FXML
    private TableColumn<Akcja,Double> kursMax;
    @FXML
    private TableColumn<Akcja,Double> kursMin;
    @FXML
    private TableColumn<Spolka,Integer> liczbaAkcji;
    @FXML
    private TableColumn<Spolka,Double> zysk;
    @FXML
    private TableColumn<Spolka,Double> przychod;
    @FXML
    private TableColumn<Spolka,Double> kapitalZakladowy;
    @FXML
    private TableColumn<Spolka,Double> kapitalWlasny;
    @FXML
    private TableColumn<Spolka,Integer> wolumen;
    @FXML
    private TableColumn<Spolka,Double> obroty;
     @FXML
    private TableColumn<GieldaPW,String> kraj;
    @FXML
    private TableColumn<GieldaPW,String> miasto;
    @FXML
    private TableColumn<GieldaPW,String> adres;
    
    @FXML
    private TableColumn<GieldaPW,String> waluta;
    @FXML
    private TableColumn<GieldaPW,Float> marza;
    @FXML
    private ListView<String> indeks;
    
    @FXML
    private LineChart wykresWartosci;
    @FXML
    private NumberAxis xWartosci;
    @FXML
    private NumberAxis yWartosci;
    
    @FXML
    private Button dodaj;
    @FXML
    private Button usun;
    @FXML
    private Button wykup;
    
    private XYChart.Series wartosci;
    private int aktualnaAkcja;
    private int aktualnaGielda;
    private ArrayList<XYChart.Series> tablicaWykresow = new ArrayList<>();
    private Swiat swiat;

   private  ObservableList<String> test1= FXCollections.observableArrayList();
   private  ObservableList<Akcja> test2= FXCollections.observableArrayList();
   private  ObservableList<Spolka> test3= FXCollections.observableArrayList();
   private  ObservableList<GieldaPW> test4= FXCollections.observableArrayList();
   private  ObservableList<String> test5= FXCollections.observableArrayList();
   
   public int getAktualnaAkcja() {
        return aktualnaAkcja;
    }

    public void setAktualnaAkcja(int aktualnaAkcja) {
        this.aktualnaAkcja = aktualnaAkcja;
    }

    public int getAktualnaGielda() {
        return aktualnaGielda;
    }

    public void setAktualnaGielda(int aktualnaGielda) {
        this.aktualnaGielda = aktualnaGielda;
    }

    
    
    public Swiat getSwiat() {
        return swiat;
    }

    public void setSwiat(Swiat swiat) {
        this.swiat = swiat;
    }

    public ChoiceBox getListaGield() {
        return listaGield;
    }

    public void setListaGield(ChoiceBox listaGield) {
        this.listaGield = listaGield;
    }
    
    private ArrayList<GieldaPW> listaGieldPW;
    private ArrayList<Spolka> listaAktywa;
    
    

        
   /**
    * Metoda inicjalizuj inicjalizuje okno giełdy papierów wartościowych.
    */
    
    public void inicjalizuj(){
        
        wykresWartosci.setTitle("Wykres wartości");
        wartosci = new XYChart.Series<>();
        wykresWartosci.getData().add(wartosci);
        wartosci.setName("Wartości");
        
        dodaj.setDisable(true);
        usun.setDisable(true);
        wykup.setDisable(true);
        listaGield.setItems(swiat.getListaGieldC());
        
        nazwa.setCellValueFactory(new PropertyValueFactory<Akcja,String>("nazwa"));
        dataWyceny.setCellValueFactory(new PropertyValueFactory<Akcja,String>("dataPierwszejWyceny"));
        kursOtwarcia.setCellValueFactory(new PropertyValueFactory<Akcja,Double>("openKurs"));
        kursObecny.setCellValueFactory(new PropertyValueFactory<Akcja,Double>("curKurs"));
        kursMax.setCellValueFactory(new PropertyValueFactory<Akcja,Double>("maxKurs"));
        kursMin.setCellValueFactory(new PropertyValueFactory<Akcja,Double>("minKurs"));
        liczbaAkcji.setCellValueFactory(new PropertyValueFactory<Spolka,Integer>("liczbaAkcji"));
        zysk.setCellValueFactory(new PropertyValueFactory<Spolka,Double>("zysk"));
        przychod.setCellValueFactory(new PropertyValueFactory<Spolka,Double>("przychod"));
        kapitalZakladowy.setCellValueFactory(new PropertyValueFactory<Spolka,Double>("kapitalZakladu"));
        kapitalWlasny.setCellValueFactory(new PropertyValueFactory<Spolka,Double>("kapitalWlasny"));
        wolumen.setCellValueFactory(new PropertyValueFactory<Spolka,Integer>("wolumen"));
        obroty.setCellValueFactory(new PropertyValueFactory<Spolka,Double>("obroty"));
        kraj.setCellValueFactory(new PropertyValueFactory<GieldaPW,String>("kraj"));
        miasto.setCellValueFactory(new PropertyValueFactory<GieldaPW,String>("miasto"));
        adres.setCellValueFactory(new PropertyValueFactory<GieldaPW,String>("adresSiedziby"));
        marza.setCellValueFactory(new PropertyValueFactory<GieldaPW,Float>("marza"));
        waluta.setCellValueFactory(new PropertyValueFactory<GieldaPW,String>("waluta"));
        


    }
    /**
    * Metoda wybierzGielde pobiera wybraną giełdę i dodaje do tabeli informacje 
    * o spółki i giełdzie, tworzy wykres zmian wszystkich aktywów.
    */
    public void wybierzGielde(){
        
        
        listaAktywa = new ArrayList<>();
        
        
        listaGield.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> ov, Number oldValue, Number newValue) -> {
            wykresProcentowy.getData().clear();
            tablicaWykresow.clear();
            listaAktywow.getItems().clear();
            table.getItems().clear();
            tablicaWykresow.clear();
            wykresProcentowy.getData().clear();
            listaAktywow.getItems().clear();
            table1.getItems().clear();
            table3.getItems().clear();
            indeks.getItems().clear();
            aktualnaGielda = newValue.intValue(); 
            test4.add(swiat.getListaGield().get(newValue.intValue()));
             for (int i =0 ; i<swiat.getListaGield().get(newValue.intValue()).getIndeks().length;i++){
             test5.add(swiat.getListaGield().get(newValue.intValue()).getIndeks()[i]);
             }
            for (int i=0; i<swiat.getListaGield().get(newValue.intValue()).getListaSpolek().size(); i++){
                listaAktywa.add(swiat.getListaGield().get(newValue.intValue()).getListaSpolek().get(i));
                test1.add(swiat.getListaGield().get(newValue.intValue()).getListaSpolek().get(i).getAkcja().getNazwa());
                test2.add(swiat.getListaGield().get(newValue.intValue()).getListaSpolek().get(i).getAkcja());
                test3.add(swiat.getListaGield().get(newValue.intValue()).getListaSpolek().get(i));
                
                XYChart.Series temp = new XYChart.Series();
                temp.setName(this.listaAktywa.get(i).getAkcja().getNazwa());

                for (int j = 0; j < 10; j++) {
                    temp.getData().add(new XYChart.Data(j,
                            swiat.getListaGield().get(newValue.intValue()).getListaSpolek().get(i).getAkcja().getTablicaProcentow().
                                    get(swiat.getListaGield().get(newValue.intValue()).getListaSpolek().get(i).getAkcja().getTablicaProcentow().size() - 10 + j)));
                }
                tablicaWykresow.add(temp);
                wykresProcentowy.getData().add(temp);
            }
              
        listaAktywow.setItems(test1);
        table.setItems(test2);
        table1.setItems(test3);
        table3.setItems(test4);
        indeks.setItems(test5);  
        dodaj.setDisable(false);
        usun.setDisable(true);  
        wykup.setDisable(true);

        });
        
    }
    /**
    * Metoda wybierzAkcje pobiera wybraną spólkę tworzy jej wykres.
    */
     public void wybierzAkcje(){
         

         listaAktywow.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> ov, Number oldValue, Number newValue) -> {
             wartosci.getData().clear();
            aktualnaAkcja= newValue.intValue();
            
            
            for(int i = 0; i < listaAktywa.get(newValue.intValue()).getAkcja().getTablicaKursow().size();i++){
                wartosci.getData().add(new XYChart.Data(i,listaAktywa.get(newValue.intValue()).getAkcja().getTablicaKursow().get(i)));
                
            }
          usun.setDisable(false); 
          wykup.setDisable(false);

        });
    
     }
     public synchronized void aktualizujWykresWartosci(double nowyKurs) {
        Platform.runLater(new Runnable() {
            public void run() {
                if (!(wartosci.getData().isEmpty())){
                    wartosci.getData().remove(0);
                for (int i = 0; i < wartosci.getData().size(); i++) {
                    XYChart.Data<Number, Number> dataWartosci = (XYChart.Data<Number, Number>) wartosci.getData().get(i);
                    int xW = dataWartosci.getXValue().intValue() - 1;
                    dataWartosci.setXValue(xW);
                }
                wartosci.getData().add(new XYChart.Data(30, nowyKurs));
                }
            }

        });
    }
     /**
     * Metoda dodajAkcje dodaje akcję.
     */
      public void dodajAkcje() throws IOException{
       
       Spolka spolka ;
           if (swiat.getListaGield().get(aktualnaGielda).getListaSpolek().size()<10)   { 
               if (swiat.getListaGield().get(aktualnaGielda).getListaUsunietych().isEmpty()){
                spolka = GeneratorSpolki.generuj(aktualnaGielda,swiat.getListaGield().get(aktualnaGielda).getListaSpolek().size());
               }
               else {
                   spolka = swiat.getListaGield().get(aktualnaGielda).getListaUsunietych().get(0);
                   swiat.getListaGield().get(aktualnaGielda).getListaUsunietych().remove(0);
               }
            swiat.getListaGield().get(aktualnaGielda).getListaSpolek().add(spolka);
            for (int i =0 ; i<30 ; i++){
                         spolka.getAkcja().aktualizujKurs();
                 }
               
                listaAktywa.add(spolka);
                test1.add(spolka.getAkcja().getNazwa());
                test2.add(spolka.getAkcja());
                test3.add(spolka);
               
                
                this.aktualizujTabele();
                XYChart.Series temp = new XYChart.Series();
                temp.setName(this.listaAktywa.get(listaAktywa.size()-1).getAkcja().getNazwa());
                
                for (int j = 0; j < 10; j++) {
                    temp.getData().add(new XYChart.Data(j,
                            swiat.getListaGield().get(aktualnaGielda).getListaSpolek().get(listaAktywa.size()-1).getAkcja().getTablicaProcentow().
                                    get(swiat.getListaGield().get(aktualnaGielda).getListaSpolek().get(listaAktywa.size()-1).getAkcja().getTablicaProcentow().size() - 10 + j)));
            }
           tablicaWykresow.add(temp);
           wykresProcentowy.getData().add(temp);
           Thread t = new Thread(spolka);
           t.start();
           }
           else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Nie możesz dodać więcej akcji do tego rynku!");
            alert.showAndWait();
           } 
           Inwestor inwestor = GeneratorInwestorow.generuj();
           swiat.getListaInwestorow().add(inwestor);
           swiat.getListaInwestorowT().add(inwestor);
           Thread t = new Thread(inwestor);
           t.start();
      }      
      /**
     * Metoda usunAkcje usuwa akcję.
     */
    public synchronized void usunSpolke(){
        swiat.getListaGield().get(aktualnaGielda).getListaUsunietych().add(swiat.getListaGield().get(aktualnaGielda).getListaSpolek().get(aktualnaAkcja));
        this.swiat.getListaGield().get(aktualnaGielda).getListaSpolek().get(aktualnaAkcja).setCzySkonczyc(true);
        swiat.getListaGield().get(aktualnaGielda).getListaSpolek().remove(aktualnaAkcja);
         listaAktywa.remove(aktualnaAkcja);
         test1.clear();
         test2.clear();
         test3.clear();
         table.getItems().clear();
         wykresProcentowy.getData().clear();
         
        for (int i = 0; i<swiat.getListaGield().get(aktualnaGielda).getListaSpolek().size(); i++){
             test1.add(swiat.getListaGield().get(aktualnaGielda).getListaSpolek().get(i).getAkcja().getNazwa());
             test2.add(swiat.getListaGield().get(aktualnaGielda).getListaSpolek().get(i).getAkcja());
             test3.add(swiat.getListaGield().get(aktualnaGielda).getListaSpolek().get(i));
         }
         for (int i=0 ; i<swiat.getListaGield().get(aktualnaGielda).getListaSpolek().size(); i++){
             XYChart.Series temp = new XYChart.Series();
             temp.setName(swiat.getListaGield().get(aktualnaGielda).getListaSpolek().get(i).getAkcja().getNazwa());

                for (int j = 0; j < 10; j++) {
                    temp.getData().add(new XYChart.Data(j,
                            swiat.getListaGield().get(aktualnaGielda).getListaSpolek().get(i).getAkcja().getTablicaProcentow().
                                    get(swiat.getListaGield().get(aktualnaGielda).getListaSpolek().get(i).getAkcja().getTablicaProcentow().size() - 10 + j)));
                }
                tablicaWykresow.add(temp);
                wykresProcentowy.getData().add(temp);
            }
         wykup.setDisable(true);
         
        }

    /** 
    * Metoda aktualizujTabele akutalizuje tabelę informacji.
    */
        
     public synchronized void aktualizujTabele() {
        Platform.runLater(new Runnable() {
            public void run() {
                

                table.refresh();
                table1.refresh();
               
            }
        });

    }
     /**
     * Metoda wykupSpolke wykupuje przez spółkę od inwestorów swoje akcje.
     */
     public synchronized void wykupSpolke(){
         System.out.println(swiat.getListaGield().get(aktualnaGielda).getListaSpolek().get(aktualnaAkcja).getLiczbaAkcji());
         for (int i = 0 ; i<swiat.getListaInwestorow().size(); i++){
             for(int j=0 ; j<swiat.getListaInwestorow().get(i).getHistoriaZakupow().size(); j++)
             {  
                 
                 if (swiat.getListaInwestorow().get(i).getHistoriaZakupow().get(j).getAkcja()!=null){
                    if (swiat.getListaInwestorow().get(i).getHistoriaZakupow().get(j).getAkcja().getNazwa() == null ? (swiat.getListaGield().get(aktualnaGielda).getListaSpolek().get(aktualnaAkcja).getAkcja().getNazwa()) == null : swiat.getListaInwestorow().get(i).getHistoriaZakupow().get(j).getAkcja().getNazwa().equals(swiat.getListaGield().get(aktualnaGielda).getListaSpolek().get(aktualnaAkcja).getAkcja().getNazwa())){
                        swiat.getListaGield().get(aktualnaGielda).getListaSpolek().get(aktualnaAkcja).setLiczbaAkcji(swiat.getListaInwestorow().get(i).getHistoriaZakupow().get(j).getIlosc()+swiat.getListaGield().get(aktualnaGielda).getListaSpolek().get(aktualnaAkcja).getLiczbaAkcji());
                        swiat.getListaInwestorow().get(i).getHistoriaZakupow().remove(j);
                        System.out.println(swiat.getListaGield().get(aktualnaGielda).getListaSpolek().get(aktualnaAkcja).getLiczbaAkcji());
                    }
             
                 }
             }
         }
     
     }
     /**
     * Metoda dodaje indeks do giełdy.
     */
     public void dodajIndeksy(){
         if(swiat.getListaGield().get(aktualnaGielda).getIndeks().length<2)
         {
             test5.clear();
             indeks.getItems().clear();
             String temp[]= new String[2];
             temp[0]=swiat.getListaGield().get(aktualnaGielda).getIndeks()[0];
             temp[1]=GeneratorGieldPW.getIndeksy()[aktualnaGielda][1];
             swiat.getListaGield().get(aktualnaGielda).setIndeks(temp);
             for (int i =0 ; i<swiat.getListaGield().get(aktualnaGielda).getIndeks().length;i++){
                test5.add(swiat.getListaGield().get(aktualnaGielda).getIndeks()[i]);
            }
             indeks.setItems(test5);
         }
         else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Nie możesz dodać więcej indeksów do tego rynku!");
            alert.showAndWait();
           } 
     }
}