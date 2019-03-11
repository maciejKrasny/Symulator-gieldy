
package pojekt.plikiFXML;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pojekt.Generatory.GeneratorSurowcow;
import pojekt.RynekSurowcow;
import pojekt.Surowiec;
import pojekt.Swiat;

public class GieldaSurowcowController implements Serializable {

    @FXML
    private ChoiceBox listaRynkow;

    @FXML
    private ChoiceBox listaAktywow;
    
   

    @FXML
    private LineChart wykresProcentowy;

    @FXML
    private LineChart wykresWartosci;

    private XYChart.Series wartosci;

    @FXML
    private NumberAxis xWartosci;

    @FXML
    private TableView<Surowiec> table;
    @FXML
    private TableColumn<Surowiec, String> nazwa;
    @FXML
    private TableColumn<Surowiec, String> waluta;
    @FXML
    private TableColumn<Surowiec, String> jednostkaHandlowa;
    @FXML
    private TableColumn<Surowiec, Double> curWartosc;
    @FXML
    private TableColumn<Surowiec, Double> minWartosc;
    @FXML
    private TableColumn<Surowiec, Double> maxWartosc;
    
    @FXML
    private Button dodaj;
    @FXML
    private Button usun;
    private ArrayList<Surowiec> listaAktywa;

    private ArrayList<XYChart.Series> tablicaWykresow = new ArrayList<>();

    private  ObservableList<String> test = FXCollections.observableArrayList();
    private  ObservableList<String> test2 = FXCollections.observableArrayList();
    private  ObservableList<Surowiec> test3 = FXCollections.observableArrayList();

    private Swiat swiat;
    private int aktualnyRynekSurowcow;
    private int aktualnySurowiec;
    
    

    public int getAktualnyRynekSurowcow() {
        return aktualnyRynekSurowcow;
    }

    public void setAktualnyRynekSurowcow(int aktualnyRynekSurowcow) {
        this.aktualnyRynekSurowcow = aktualnyRynekSurowcow;
    }

    
    
    public int getAktualnySurowiec() {
        return aktualnySurowiec;
    }

    public void setAktualnySurowiec(int aktualnySurowiec) {
        this.aktualnySurowiec = aktualnySurowiec;
    }
    /**
    * Metoda inicjalizuj inicjalizuje okno rynku surowców.
    */

    public void inicjalizuj() {

        wykresWartosci.setTitle("Wykres wartości");
        wartosci = new XYChart.Series();
        wykresWartosci.getData().add(wartosci);
        wartosci.setName("Wartości");

        wykresProcentowy.setTitle("Wykres Procentowy");
        dodaj.setDisable(true);
        usun.setDisable(true);

        /* for (int i = 0; i < swiat.getListaRynkowSurowcow().size(); i++) {
            index = i + 1;
            swiat.getListaRynkowSurowcowC().add((swiat.getListaRynkowSurowcow().get(i).getNazwa() + " #" + index));
        }*/
        listaRynkow.setItems(swiat.getListaRynkowSurowcowC());

        nazwa.setCellValueFactory(new PropertyValueFactory<Surowiec, String>("nazwa"));
        waluta.setCellValueFactory(new PropertyValueFactory<Surowiec, String>("waluta"));
        jednostkaHandlowa.setCellValueFactory(new PropertyValueFactory<Surowiec, String>("jednostkaHandlowa"));
        curWartosc.setCellValueFactory(new PropertyValueFactory<Surowiec, Double>("curWartosc"));
        minWartosc.setCellValueFactory(new PropertyValueFactory<Surowiec, Double>("minWartosc"));
        maxWartosc.setCellValueFactory(new PropertyValueFactory<Surowiec, Double>("maxWartosc"));
    }
    /**
    * Metoda wybierzRynek pobiera wybraną giełdę i dodaje do tabeli informacje 
    * o surowcu i giełdzie, tworzy wykres zmian wszystkich aktywów.
    */
    public void wybierzRynek() {
       

        listaAktywa = new ArrayList<>();
        listaRynkow.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> ov, Number oldValue, Number newValue) -> {
            test2.clear();
            test3.clear();
            table.getItems().clear();
            tablicaWykresow.clear();
            wykresProcentowy.getData().clear();
            listaAktywow.getItems().clear();
            wartosci.getData().clear();
            aktualnyRynekSurowcow = newValue.intValue();
            for (int i = 0; i < swiat.getListaRynkowSurowcow().get(newValue.intValue()).getListaSurowcow().size(); i++) {
                test2.add(swiat.getListaRynkowSurowcow().get(newValue.intValue()).getListaSurowcow().get(i).getNazwa());
                listaAktywa.add(swiat.getListaRynkowSurowcow().get(newValue.intValue()).getListaSurowcow().get(i));
                test3.add(listaAktywa.get(i));

                XYChart.Series temp = new XYChart.Series();
                temp.setName(this.listaAktywa.get(i).getNazwa());

                for (int j = 0; j < 10; j++) {
                    temp.getData().add(new XYChart.Data(j,
                            swiat.getListaRynkowSurowcow().get(newValue.intValue()).getListaSurowcow().get(i).getTablicaProcentow().
                                    get(swiat.getListaRynkowSurowcow().get(newValue.intValue()).getListaSurowcow().get(i).getTablicaProcentow().size() - 10 + j)));
                }
                tablicaWykresow.add(temp);
                wykresProcentowy.getData().add(temp);
            }
            listaAktywow.setItems(test2);
            table.setItems(test3);
            dodaj.setDisable(false);
            usun.setDisable(true);

        });

    }
    /**
    * Metoda aktualizuje wykres surowca.
    */
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
    * Metoda aktualizuje wykres wszystkich surowców.
    */
    public synchronized void aktualizujWykresProcentowy(double nowyProcent, Surowiec surowiec) {

        for (int i = 0; i < listaAktywa.size(); i++) {
            if (surowiec.equals(listaAktywa.get(i))) {
                tablicaWykresow.get(i).getData().remove(0);
                for (int j = 0; j < tablicaWykresow.get(i).getData().size(); j++) {
                    XYChart.Data<Number, Number> dataProcentow = (XYChart.Data<Number, Number>) tablicaWykresow.get(i).getData().get(j);
                    int xP = dataProcentow.getXValue().intValue() - 1;
                    dataProcentow.setXValue(xP);
                }
                tablicaWykresow.get(i).getData().add(new XYChart.Data(10, nowyProcent));
                break;
            }
        }
    }
    /**
    * Metoda akualizuje tabelę.
    */
    public synchronized void aktualizujTabele() {
        Platform.runLater(new Runnable() {
            public void run() {
                
                table.refresh();

            }
        });

    }
    
    
    /**
    * Metoda   wybierzSurowiec tworzy wykres zmian wartości surowca.
    */
    public void wybierzSurowiec() {

        listaAktywow.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> ov, Number oldValue, Number newValue) -> {
            aktualnySurowiec = newValue.intValue();
            wartosci.getData().clear();

            for (int i = swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaSurowcow().get(newValue.intValue()).getTablicaKursow().size() - 30; i < swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaSurowcow().get(newValue.intValue()).getTablicaKursow().size(); i++) {
                
                wartosci.getData().add(new XYChart.Data(i, swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaSurowcow().get(newValue.intValue()).getTablicaKursow().get(i)));
            }
        usun.setDisable(false);

        });

    }
    /**
    * Metoda dodajSurowiec dodaje surowiec.
    */
     public void dodajSurowiec(){
        Surowiec surowiec;
            if (swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaSurowcow().size()<10)    {
                if (!(swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaUsunietych().isEmpty())) { 
                    surowiec = swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaUsunietych().get(0);
                    swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaUsunietych().remove(0);
                    
                }
                else {
                    
                    surowiec = GeneratorSurowcow.generuj(swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaSurowcow().size());
                for (int i =0 ; i<30 ; i++){
                        surowiec.aktualizujKurs();
                }
                }
                listaAktywa.add(surowiec);
                test2.add(surowiec.getNazwa());
                listaAktywow.setItems(test2);
                test3.add(surowiec);
                swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaSurowcow().add(surowiec);
                
                XYChart.Series temp = new XYChart.Series();
                temp.setName(this.listaAktywa.get(listaAktywa.size()-1).getNazwa());
                for (int j = 0; j < 10; j++) {
                    
                     temp.getData().add(new XYChart.Data(j,
                            swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaSurowcow().get(listaAktywa.size()-1).getTablicaProcentow().
                                    get(swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaSurowcow().get(listaAktywa.size()-1).getTablicaProcentow().size() - 10 + j)));
                }
                tablicaWykresow.add(temp);
                wykresProcentowy.getData().add(temp);
               
                
             }
           else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Nie możesz dodać więcej surowcow do tego rynku!");
            alert.showAndWait();
           } 
      
           
    }
    /**
     * Metoda usunSurowiec usuwa surowiec.
     */
     public synchronized void usunSurowiec(){
         swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaUsunietych().add(swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaSurowcow().get(aktualnySurowiec));
         swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaSurowcow().remove(aktualnySurowiec);
         listaAktywa.remove(aktualnySurowiec);
        test2.clear();
        test3.clear();
         table.getItems().clear();
         wykresProcentowy.getData().clear();
         for (int i =0 ; i<listaAktywa.size(); i++){
             System.out.println(listaAktywa.get(i).getNazwa());
         }
        for (int i = 0; i< swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaSurowcow().size(); i++){
             test2.add( swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaSurowcow().get(i).getNazwa());
             test3.add( swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaSurowcow().get(i));
         }
         for (int i=0 ; i< swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaSurowcow().size(); i++){
             XYChart.Series temp = new XYChart.Series();
                temp.setName(this. swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaSurowcow().get(i).getNazwa());

                for (int j = 0; j < 10; j++) {
                    temp.getData().add(new XYChart.Data(j,
                            swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaSurowcow().get(i).getTablicaProcentow().
                                    get(swiat.getListaRynkowSurowcow().get(aktualnyRynekSurowcow).getListaSurowcow().get(i).getTablicaProcentow().size() - 10 + j)));
                }
                tablicaWykresow.add(temp);
                wykresProcentowy.getData().add(temp);
            }
         
        }

    public void setSwiat(Swiat swiat) {
        this.swiat = swiat;
    }

}
