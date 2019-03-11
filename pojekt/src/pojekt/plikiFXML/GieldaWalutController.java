
package pojekt.plikiFXML;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pojekt.Generatory.GeneratorRynkuWalut;
import pojekt.Generatory.GeneratorWaluty;
import pojekt.RynekWalut;
import pojekt.Swiat;
import pojekt.Waluta;


public class GieldaWalutController implements Serializable {

    
    @FXML
    private ChoiceBox listaWykresow;

    @FXML
    private ChoiceBox listaAktywow;

    @FXML
    private Label informacje;

    @FXML
    private LineChart wykresProcentowy;

    @FXML
    private LineChart wykresWartosci;

    private XYChart.Series wartosci;

    @FXML
    private TableView tableInfo;
    @FXML
    private TableView tableWaluta;
    @FXML
    private TableColumn<Waluta, String> nazwa;
    @FXML
    private TableColumn<Waluta, String> listaKrajow;

    @FXML
    private ListView<String> waluty;
    @FXML
    private ListView<Double> cenyKupna;
    @FXML
    private ListView<Double> cenySprzedazy;

    private RynekWalut rynekPokaz;
    private ArrayList<RynekWalut> listaRynekWalut;
    private ArrayList<Waluta> listaAktywa;
    private ArrayList<Waluta> listaWalutDoWykresu;
    private Waluta aktualnaDoWykresu;
    private int aktualnaWaluta;
    private int aktualnyRynekWalut;
    private ArrayList<XYChart.Series> tablicaWykresow = new ArrayList<>();
    private  ObservableList<String> test1 = FXCollections.observableArrayList();
    private  ObservableList<Waluta> test3 = FXCollections.observableArrayList();
    private  ObservableList<String> test4 = FXCollections.observableArrayList();
    private  ObservableList<Double> test5 = FXCollections.observableArrayList();
    private  ObservableList<Double> test6 = FXCollections.observableArrayList();
    private  ObservableList<String> test7 = FXCollections.observableArrayList();

    public Waluta getAktualnaDoWykresu() {
        return aktualnaDoWykresu;
    }

    public void setAktualnaDoWykresu(Waluta aktualnaDoWykresu) {
        this.aktualnaDoWykresu = aktualnaDoWykresu;
    }

    public int getAktualnaWaluta() {
        return aktualnaWaluta;
    }

    public void setAktualnaWaluta(int aktualnaWaluta) {
        this.aktualnaWaluta = aktualnaWaluta;
    }

    public int getAktualnyRynekWalut() {
        return aktualnyRynekWalut;
    }

    public void setAktualnyRynekWalut(int aktualnyRynekWalut) {
        this.aktualnyRynekWalut = aktualnyRynekWalut;
    }

    private Swiat swiat;

    public Swiat getSwiat() {
        return swiat;
    }

    public void setSwiat(Swiat swiat) {
        this.swiat = swiat;
    }

    
   /**
    * Metoda inicjalizuj inicjalizuje okno rynku walut.
    */
    public void inicjalizuj() {

        wykresWartosci.setTitle("Wykres wartości");
        wartosci = new XYChart.Series();
        wykresWartosci.getData().add(wartosci);
        wartosci.setName("Wartości");

        wykresProcentowy.setTitle("Wykres Procentowy");
        if (swiat.getListaRynkowWalut().getTablicaKursow().get(0).isEmpty()) {
            for (int i = 0; i < swiat.getListaRynkowWalut().getListaWalut().size(); i++) {
                for (int j = 0; j < 30; j++) {
                    swiat.getListaRynkowWalut().aktualizujKurs(i);
                }
            }
        }

        listaAktywa = new ArrayList<>();
        rynekPokaz = swiat.getListaRynkowWalut();
        for (int i = 0; i < swiat.getListaRynkowWalut().getListaWalut().size(); i++) {
            test1.add(swiat.getListaRynkowWalut().getListaWalut().get(i).getNazwa());
            listaAktywa.add(swiat.getListaRynkowWalut().getListaWalut().get(i));

        }

        listaAktywow.setItems(test1);

        nazwa.setCellValueFactory(new PropertyValueFactory<Waluta, String>("nazwa"));
        listaKrajow.setCellValueFactory(new PropertyValueFactory<Waluta, String>("listaKrajow"));

    }

  /**
    * Metoda pobiera walutę i wpisuje do tabeli informacje o niej.
    */

    public void wybierzWalute() {

        listaWalutDoWykresu = new ArrayList<>();
        
        listaAktywow.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> ov, Number oldValue, Number newValue) -> {
            wartosci.getData().clear();
            test4.clear();
            test7.clear();
            cenyKupna.getItems().clear();
            cenySprzedazy.getItems().clear();
            tableInfo.getItems().clear();
            wykresProcentowy.getData().clear();
            wartosci.getData().clear();
            
            test3.add(listaAktywa.get(newValue.intValue()));
            
            aktualnaWaluta = newValue.intValue();
            for (int i = 0; i < swiat.getListaRynkowWalut().getListaWalut().size(); i++) {
                if (!swiat.getListaRynkowWalut().getListaWalut().get(newValue.intValue()).getNazwa().equals(swiat.getListaRynkowWalut().getListaWalut().get(i).getNazwa())) {
                    listaWalutDoWykresu.add(swiat.getListaRynkowWalut().getListaWalut().get(i));
                    test7.add(swiat.getListaRynkowWalut().getListaWalut().get(i).getNazwa());

                    XYChart.Series temp = new XYChart.Series();
                    temp.setName(swiat.getListaRynkowWalut().getListaWalut().get(i).getNazwa());

                    for (int j = 0; j < 10; j++) {
                        temp.getData().add(new XYChart.Data(j,
                                swiat.getListaRynkowWalut().getTablicaProcentow().get(i).get(swiat.getListaRynkowWalut().getTablicaProcentow().get(i).size() - 10 + j)));
                    }

                    
                    wykresProcentowy.getData().add(temp);
                }
            }

            for (int i = 0; i < rynekPokaz.getParyWalut().length; i++) {
                if (listaAktywa.get(newValue.intValue()).getNazwa().equals(rynekPokaz.getParyWalut()[i][0])) {
                    test4.add(rynekPokaz.getParyWalut()[i][1]);
                    if (rynekPokaz.getCenyKupnaiSprzedazy()[i][1] < rynekPokaz.getCenyKupnaiSprzedazy()[i][0]) {
                        test5.add(rynekPokaz.getCenyKupnaiSprzedazy()[i][0]);
                        test6.add(rynekPokaz.getCenyKupnaiSprzedazy()[i][1]);
                    } else {
                        test5.add(rynekPokaz.getCenyKupnaiSprzedazy()[i][1]);
                        test6.add(rynekPokaz.getCenyKupnaiSprzedazy()[i][0]);
                    }
                } else if (listaAktywa.get(newValue.intValue()).getNazwa().equals(rynekPokaz.getParyWalut()[i][1])) {
                    test4.add(rynekPokaz.getParyWalut()[i][0]);
                    if (rynekPokaz.getCenyKupnaiSprzedazy()[i][1] < rynekPokaz.getCenyKupnaiSprzedazy()[i][0]) {
                        test5.add((double) Math.round(((1 / (rynekPokaz.getCenyKupnaiSprzedazy()[i][1])) * 10000)) / 10000);
                        test6.add((double) Math.round(((1 / (rynekPokaz.getCenyKupnaiSprzedazy()[i][0])) * 10000)) / 10000);
                    } else {
                        test5.add((double) Math.round(((1 / (rynekPokaz.getCenyKupnaiSprzedazy()[i][0])) * 10000)) / 10000);
                        test6.add((double) Math.round(((1 / (rynekPokaz.getCenyKupnaiSprzedazy()[i][1])) * 10000)) / 10000);

                    }
                }
            }

        });

        waluty.setItems(test4);
        cenyKupna.setItems(test5);
        cenySprzedazy.setItems(test6);
        tableInfo.setItems(test3);
        listaWykresow.setItems(test7);

    }
/**
    * Metoda wybierzDoWykresu pobiera walutę względem, której ma stworzyć wykres.
    */
    public void wybierzDoWykresu() {

        listaWykresow.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> ov, Number oldValue, Number newValue) -> {
            aktualnaDoWykresu = listaWalutDoWykresu.get(newValue.intValue());
            wartosci.getData().clear();

            if (aktualnaWaluta == 0) {
                for (int i = swiat.getListaRynkowWalut().getTablicaKursow().get(newValue.intValue()).size() - 30; i < swiat.getListaRynkowWalut().getTablicaKursow().get(newValue.intValue()).size(); i++) {

                    wartosci.getData().add(new XYChart.Data(i, swiat.getListaRynkowWalut().getTablicaKursow().get(newValue.intValue()).get(i)));

                }
            } else if (newValue.intValue() == aktualnaWaluta) {
                for (int i = swiat.getListaRynkowWalut().getTablicaKursow().get(newValue.intValue()).size() - 30; i < swiat.getListaRynkowWalut().getTablicaKursow().get(newValue.intValue()).size(); i++) {

                    wartosci.getData().add(new XYChart.Data(i, swiat.getListaRynkowWalut().getTablicaKursow().get(aktualnaWaluta - 1).get(i) / swiat.getListaRynkowWalut().getTablicaKursow().get(newValue.intValue() + 1).get(i)));
                }
            } else if (newValue.intValue() < aktualnaWaluta && newValue.intValue() != 0) {
                for (int i = swiat.getListaRynkowWalut().getTablicaKursow().get(newValue.intValue()).size() - 30; i < swiat.getListaRynkowWalut().getTablicaKursow().get(newValue.intValue()).size(); i++) {

                    wartosci.getData().add(new XYChart.Data(i, swiat.getListaRynkowWalut().getTablicaKursow().get(newValue.intValue() - 1).get(i) / swiat.getListaRynkowWalut().getTablicaKursow().get(aktualnaWaluta - 1).get(i)));
                }
            } else if (newValue.intValue() > aktualnaWaluta) {
                for (int i = swiat.getListaRynkowWalut().getTablicaKursow().get(newValue.intValue()).size() - 30; i < swiat.getListaRynkowWalut().getTablicaKursow().get(newValue.intValue()).size(); i++) {

                    wartosci.getData().add(new XYChart.Data(i, swiat.getListaRynkowWalut().getTablicaKursow().get(aktualnaWaluta - 1).get(i) / swiat.getListaRynkowWalut().getTablicaKursow().get(newValue.intValue() - 1).get(i)));
                }
            } else if (newValue.intValue() == 0) {
                for (int i = swiat.getListaRynkowWalut().getTablicaKursow().get(newValue.intValue()).size() - 30; i < swiat.getListaRynkowWalut().getTablicaKursow().get(newValue.intValue()).size(); i++) {
                    System.out.println(1 / swiat.getListaRynkowWalut().getTablicaKursow().get(aktualnaWaluta).get(i));
                    wartosci.getData().add(new XYChart.Data(i, 1 / swiat.getListaRynkowWalut().getTablicaKursow().get(aktualnaWaluta).get(i)));
                }
            }
        });
    }

    /**
    * Metoda akutalizuje tabele.
    */

    public void aktualizujTabele() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
               

                cenyKupna.refresh();
                cenySprzedazy.refresh();

            }
        });
    }
/**
    * Metoda dodaje walutę.
    */
    public void dodajWalute() {

        if (swiat.getListaRynkowWalut().getListaWalut().size() < 10) {
            Waluta waluta = GeneratorWaluty.generuj(swiat.getListaRynkowWalut().getListaWalut().size());
            swiat.getListaRynkowWalut().getListaWalut().add(waluta);
             listaAktywa.add(waluta);
             test1.add(waluta.getNazwa());
             listaAktywow.setItems(test1);
             test7.add(waluta.getNazwa());
             listaWykresow.setItems(test7);
             
             waluty.setItems(test4);
             for (int i = 0; i<GeneratorRynkuWalut.getParyWalut().length;i++){
                 if (waluta.getNazwa().equals(GeneratorRynkuWalut.getParyWalut()[i][0]) && listaAktywa.contains(GeneratorRynkuWalut.getParyWalut()[i][1])){
                     swiat.getListaRynkowWalut().getParyWalut()[swiat.getListaRynkowWalut().getParyWalut().length][0]=waluta.getNazwa();
                     swiat.getListaRynkowWalut().getParyWalut()[swiat.getListaRynkowWalut().getParyWalut().length][1]=GeneratorRynkuWalut.getParyWalut()[i][1];
                     swiat.getListaRynkowWalut().getCenyKupnaiSprzedazy()[swiat.getListaRynkowWalut().getCenyKupnaiSprzedazy().length][0]=GeneratorRynkuWalut.getCenaKupnaISprzedazy()[i][0];
                     swiat.getListaRynkowWalut().getCenyKupnaiSprzedazy()[swiat.getListaRynkowWalut().getCenyKupnaiSprzedazy().length][1]=GeneratorRynkuWalut.getCenaKupnaISprzedazy()[i][1];
                 }
                 
                 else if (waluta.getNazwa().equals(GeneratorRynkuWalut.getParyWalut()[i][1]) && listaAktywa.contains(GeneratorRynkuWalut.getParyWalut()[i][0])){
                     swiat.getListaRynkowWalut().getParyWalut()[swiat.getListaRynkowWalut().getParyWalut().length][1]=waluta.getNazwa();
                     swiat.getListaRynkowWalut().getParyWalut()[swiat.getListaRynkowWalut().getParyWalut().length][0]=GeneratorRynkuWalut.getParyWalut()[i][0];
                     swiat.getListaRynkowWalut().getCenyKupnaiSprzedazy()[swiat.getListaRynkowWalut().getCenyKupnaiSprzedazy().length][1]=GeneratorRynkuWalut.getCenaKupnaISprzedazy()[i][1];
                     swiat.getListaRynkowWalut().getCenyKupnaiSprzedazy()[swiat.getListaRynkowWalut().getCenyKupnaiSprzedazy().length][0]=GeneratorRynkuWalut.getCenaKupnaISprzedazy()[i][0];
                 }
             }
             
             for (int i = 0; i < rynekPokaz.getParyWalut().length; i++) {
                if (listaAktywa.get(aktualnaWaluta).getNazwa().equals(rynekPokaz.getParyWalut()[i][0])) {
                    test4.add(rynekPokaz.getParyWalut()[i][1]);
                    if (rynekPokaz.getCenyKupnaiSprzedazy()[i][1] < rynekPokaz.getCenyKupnaiSprzedazy()[i][0]) {
                        test5.add(rynekPokaz.getCenyKupnaiSprzedazy()[i][0]);
                        test6.add(rynekPokaz.getCenyKupnaiSprzedazy()[i][1]);
                    } else {
                        test5.add(rynekPokaz.getCenyKupnaiSprzedazy()[i][1]);
                        test6.add(rynekPokaz.getCenyKupnaiSprzedazy()[i][0]);
                    }
                } else if (listaAktywa.get(aktualnaWaluta).getNazwa().equals(rynekPokaz.getParyWalut()[i][1])) {
                    test4.add(rynekPokaz.getParyWalut()[i][0]);
                    if (rynekPokaz.getCenyKupnaiSprzedazy()[i][1] < rynekPokaz.getCenyKupnaiSprzedazy()[i][0]) {
                        test5.add((double) Math.round(((1 / (rynekPokaz.getCenyKupnaiSprzedazy()[i][1])) * 10000)) / 10000);
                        test6.add((double) Math.round(((1 / (rynekPokaz.getCenyKupnaiSprzedazy()[i][0])) * 10000)) / 10000);
                    } else {
                        test5.add((double) Math.round(((1 / (rynekPokaz.getCenyKupnaiSprzedazy()[i][0])) * 10000)) / 10000);
                        test6.add((double) Math.round(((1 / (rynekPokaz.getCenyKupnaiSprzedazy()[i][1])) * 10000)) / 10000);

                    }
                }
             }
            waluty.setItems(test4);
            cenyKupna.setItems(test5);
            cenySprzedazy.setItems(test6);
            tableInfo.setItems(test3);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Nie możesz dodać więcej walut do tego rynku!");
            alert.showAndWait();
        }

    }
   
    }
