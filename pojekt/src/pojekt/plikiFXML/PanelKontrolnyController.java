
package pojekt.plikiFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import pojekt.Fundusz;
import pojekt.Generatory.GeneratorFunduszu;
import pojekt.Generatory.GeneratorGieldPW;
import pojekt.Generatory.GeneratorInwestorow;
import pojekt.Generatory.GeneratorRynkuSurowcow;
import pojekt.GieldaPW;
import pojekt.Inwestor;
import pojekt.RynekSurowcow;
import pojekt.Swiat;


public class PanelKontrolnyController implements Initializable {

    @FXML
    private ChoiceBox wybierzGielde;
    @FXML
    private ChoiceBox wybierzRynekWalut;
    @FXML
    private ChoiceBox wybierzRynekSurowcow;

    private Swiat swiat;

    public Swiat getSwiat() {
        return swiat;
    }

    public void setSwiat(Swiat swiat) {
        this.swiat = swiat;
    }

    private ObservableList<String> test1;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void inicjalizuj() {

        /*int index;
        
        for (int i = 0; i< swiat.getListaGield().size(); i++){
            index=i+1;
            test1.add((swiat.getListaGield().get(i).getNazwa()+" #"+index));
        }
        for (int i = 0; i< swiat.getListaRynkowWalut().size(); i++){
            index=i+1;
            test2.add((swiat.getListaRynkowWalut().get(i).getNazwa()+" #"+index));
        }
        for (int i = 0; i< swiat.getListaRynkowSurowcow().size(); i++){
            index=i+1;
            test3.add((swiat.getListaRynkowSurowcow().get(i).getNazwa()+" #"+index));
        }
        
        wybierzGielde.setItems(test1);
        wybierzRynekWalut.setItems(test2);
        wybierzRynekSurowcow.setItems(test3);*/
    }

    /**
    * Metoda dodaję inwestora.
    */
    public void dodajInwestora() {
        Inwestor inwestor = GeneratorInwestorow.generuj();
        inwestor.setSwiat(this.swiat);
        this.swiat.getListaInwestorow().add(inwestor);
        this.swiat.getListaInwestorowT().add(inwestor);
        Thread t = new Thread(inwestor);
        t.start();
    }
/**
    * Metoda dodaję fundusz.
    */
    public void dodajFundusz() {
        Fundusz fundusz = GeneratorFunduszu.generuj();
        fundusz.setSwiat(this.swiat);
        this.swiat.getListaFunduszy().add(fundusz);
        this.swiat.getListaFunduszyT().add(fundusz);
        Thread t = new Thread(fundusz);
        t.start();
    }

   /**
    * Metoda dodaję giełdę.
    */

    public void dodajGielde() throws IOException {
        if (swiat.getListaGield().size() < 5) {
            GieldaPW gieldaPW;
            gieldaPW = GeneratorGieldPW.generuj(swiat.getListaGield().size());
            swiat.getListaGield().add(gieldaPW);
            int index = swiat.getListaGield().size();
            swiat.getListaGieldC().add(gieldaPW.getNazwa() + " #" + index);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Nie możesz dodać więcej giełd papierów wartościowych!");
            alert.showAndWait();
        }
    }
/**
    * Metoda dodaję rynek surowców.
    */
    public void dodajRynekSurowcow() throws IOException {

        if (swiat.getListaRynkowSurowcow().size() < 7) {
            RynekSurowcow rynek;
            rynek = GeneratorRynkuSurowcow.generuj();
            swiat.getListaRynkowSurowcow().add(rynek);
            int index = swiat.getListaRynkowSurowcow().size();
            swiat.getListaRynkowSurowcowC().add(rynek.getNazwa() + " #" + index);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Nie możesz dodać więcej rynków surowców!");
            alert.showAndWait();
        }

    }

}
