/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojekt;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import pojekt.plikiFXML.GieldaPWController;
import pojekt.plikiFXML.GieldaSurowcowController;
import pojekt.plikiFXML.GieldaWalutController;
import pojekt.plikiFXML.InwestorzyController;


public class Swiat implements Serializable{
    private ArrayList<Rynek> listaRynkow;
    private ArrayList<GieldaPW> listaGield;
    private ArrayList<RynekSurowcow> listaRynkowSurowcow;
    private RynekWalut listaRynkowWalut;
    private ArrayList<Inwestor> listaInwestorow;
    private ArrayList<Fundusz> listaFunduszy;
    private transient ObservableList<String> listaRynkowSurowcowC;
    private transient ObservableList<String> listaGieldC;
    private transient ObservableList<Inwestor> listaInwestorowT;
    private transient ObservableList<Fundusz> listaFunduszyT;
    private transient GieldaSurowcowController gieldaSurowcowController;
    private transient GieldaPWController gieldaPWController;
    private transient GieldaWalutController gieldaWalutaController;
    private transient InwestorzyController inwestorzyController;
   
    public Swiat(ArrayList<Rynek> listaRynkow, ArrayList<GieldaPW> listaGield, ArrayList<RynekSurowcow> listaRynkowSurowcow, RynekWalut listaRynkowWalut, ArrayList<Inwestor> listaInwestorow, ArrayList<Fundusz> listaFunduszy, ObservableList<String> listaRynkowSurowcowC, ObservableList<String> listaGieldC, ObservableList<Inwestor> listaInwestorowT, ObservableList<Fundusz> listaFunduszyT) {
        this.listaRynkow = listaRynkow;
        this.listaGield = listaGield;
        this.listaRynkowSurowcow = listaRynkowSurowcow;
        this.listaRynkowWalut = listaRynkowWalut;
        this.listaInwestorow = listaInwestorow;
        this.listaFunduszy = listaFunduszy;
        this.listaRynkowSurowcowC = listaRynkowSurowcowC;
        this.listaGieldC = listaGieldC;
        this.listaInwestorowT = listaInwestorowT;
        this.listaFunduszyT = listaFunduszyT;
        
    }

    public ObservableList<Inwestor> getListaInwestorowT() {
        return listaInwestorowT;
    }

    public void setListaInwestorowT(ObservableList<Inwestor> listaInwestorowT) {
        this.listaInwestorowT = listaInwestorowT;
    }

    public ObservableList<Fundusz> getListaFunduszyT() {
        return listaFunduszyT;
    }

    public void setListaFunduszyT(ObservableList<Fundusz> listaFunduszyT) {
        this.listaFunduszyT = listaFunduszyT;
    }

    

    public InwestorzyController getInwestorzyController() {
        return inwestorzyController;
    }

    public void setInwestorzyController(InwestorzyController inwestorzyController) {
        this.inwestorzyController = inwestorzyController;
    }

   
    
    
    public ArrayList<Inwestor> getListaInwestorow() {
        return listaInwestorow;
    }

    public void setListaInwestorow(ArrayList<Inwestor> listaInwestorow) {
        this.listaInwestorow = listaInwestorow;
    }

    public ArrayList<Fundusz> getListaFunduszy() {
        return listaFunduszy;
    }

    public void setListaFunduszy(ArrayList<Fundusz> listaFunduszy) {
        this.listaFunduszy = listaFunduszy;
    }

   

    
    
    
    
    

   
    
    public void setListaRynkow(ArrayList<Rynek> listaRynkow) {
        this.listaRynkow = listaRynkow;
    }

    public void setListaGield(ArrayList<GieldaPW> listaGield) {
        this.listaGield = listaGield;
    }

    public void setListaRynkowSurowcow(ArrayList<RynekSurowcow> listaRynkowSurowcow) {
        this.listaRynkowSurowcow = listaRynkowSurowcow;
    }

    
    
    
    public ObservableList<String> getListaGieldC() {
        return listaGieldC;
    }

    public void setListaGieldC(ObservableList<String> listaGieldC) {
        this.listaGieldC = listaGieldC;
    }

    
    
    public GieldaWalutController getGieldaWalutaController() {
        return gieldaWalutaController;
    }

    public void setGieldaWalutaController(GieldaWalutController gieldaWalutaController) {
        this.gieldaWalutaController = gieldaWalutaController;
    }
    
    
    
    public GieldaPWController getGieldaPWController() {
        return gieldaPWController;
    }

    public void setGieldaPWController(GieldaPWController gieldaPWController) {
        this.gieldaPWController = gieldaPWController;
    }
    
    
    public GieldaSurowcowController getGieldaSurowcowController() {
        return gieldaSurowcowController;
    }

    public void setGieldaSurowcowController(GieldaSurowcowController gieldaSurowcowController) {
        this.gieldaSurowcowController = gieldaSurowcowController;
    }
    
    
    
    
   

    public ObservableList<String> getListaRynkowSurowcowC() {
        return listaRynkowSurowcowC;
    }

    public void setListaRynkowSurowcowC(ObservableList<String> listaRynkowSurowcowC) {
        this.listaRynkowSurowcowC = listaRynkowSurowcowC;
    }

   
    

   
    
    

    public ArrayList<Rynek> getListaRynkow() {
        return listaRynkow;
    }

    
    public ArrayList<GieldaPW> getListaGield() {
        return listaGield;
    }

    public ArrayList<RynekSurowcow> getListaRynkowSurowcow() {
        return listaRynkowSurowcow;
    }

    public RynekWalut getListaRynkowWalut() {
        return listaRynkowWalut;
    }

    public void setListaRynkowWalut(RynekWalut listaRynkowWalut) {
        this.listaRynkowWalut = listaRynkowWalut;
    }
    
    
    
}
