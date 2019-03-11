
package pojekt;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Fundusz extends PodmiotInwest implements Runnable{
    private String nazwa;
    private Swiat swiat;

    /**
    * Kontruktor funduszu ustatwia pola funduszu.
    */
    public Fundusz(String nazwa, String imie, String nazwisko, double budzet, ArrayList<Zakup> historiaZakupow, boolean czySkonczyc) {
        super(imie, nazwisko, budzet, historiaZakupow, czySkonczyc);
        this.nazwa = nazwa;
    }
    
    

    /**
    * Metoda getNazwa pobiera nazwę funduszu.
    */   

    public String getNazwa() {
        return nazwa;
    }
    /**
    * Medota kup jest sychronizowana, aby 2 fundusze nie wykupiły np. tej samej 
    * akcji lub której nie ma już na rynku.
    * Losuje ona rynek, z którego kupi aktyw, a następnie losuje jeden z aktywów danego rynku,
    * ale sprawdza wcześniej czy dany rynek jeszcze istnieje (nie został usunięty) 
    * i analogicznie aktyw.
    */
      public synchronized void kup() {
        Random generator = new Random();

        int wyborRynku;
        int wyborAktywu;
        int ilosc;
        int przelacz = generator.nextInt(3);
        Zakup zakup;

        switch (przelacz) {
            case 0: {
                if (!(swiat.getListaRynkowSurowcow().isEmpty())){
                    wyborRynku = generator.nextInt(swiat.getListaRynkowSurowcow().size());

                    wyborAktywu = generator.nextInt(swiat.getListaRynkowSurowcow().get(wyborRynku).getListaSurowcow().size());

                    ilosc = (int) ((this.getBudzet() * 0.15) / (swiat.getListaRynkowSurowcow().get(wyborRynku).getListaSurowcow().get(wyborAktywu).getCurWartosc()));
                    zakup = new Zakup(ilosc,wyborRynku,0,swiat.getListaRynkowSurowcow().get(wyborRynku).getListaSurowcow().get(wyborAktywu), null, null);
                    
                    this.setBudzet(this.getBudzet() - ilosc * swiat.getListaRynkowSurowcow().get(wyborRynku).getListaSurowcow().get(wyborAktywu).getCurWartosc());
                    this.getHistoriaZakupow().add(zakup);
                    if (this.swiat.getGieldaSurowcowController()!=null){
                        if (this.swiat.getGieldaSurowcowController().getAktualnySurowiec() == wyborAktywu 
                                && this.swiat.getGieldaSurowcowController().getAktualnyRynekSurowcow() == wyborRynku) {
                            this.swiat.getGieldaSurowcowController().aktualizujWykresWartosci(
                                    this.swiat.getListaRynkowSurowcow().get(wyborRynku).getListaSurowcow().get(wyborAktywu).getCurWartosc()) ;
                        }
                    }
                   if (!(this.swiat.getListaRynkowSurowcow().get(wyborRynku).getListaSurowcow().get(wyborAktywu).getTablicaKursow().isEmpty()))
                   this.swiat.getListaRynkowSurowcow().get(wyborRynku).getListaSurowcow().get(wyborAktywu).getTablicaKursow().remove(0);
                     this.swiat.getListaRynkowSurowcow().get(wyborRynku).getListaSurowcow().get(wyborAktywu).aktualizujKurs();
                     if (this.swiat.getGieldaSurowcowController()!=null)
                        this.swiat.getGieldaSurowcowController().aktualizujTabele();
                    }
            }    
            break; 
            case 1: {
                if (!(swiat.getListaRynkowWalut().getListaWalut().isEmpty())){
                    wyborAktywu = generator.nextInt(swiat.getListaRynkowWalut().getListaWalut().size());
                    for (int i = 0; i < swiat.getListaRynkowWalut().getCenyKupnaiSprzedazy().length; i++) {
                        if (swiat.getListaRynkowWalut().getListaWalut().get(wyborAktywu).getNazwa().equals(swiat.getListaRynkowWalut().getParyWalut()[i][1])
                                && swiat.getListaRynkowWalut().getParyWalut()[i][0].equals("Złoty")) {

                            ilosc = (int) ((this.getBudzet() * 0.15) / (swiat.getListaRynkowWalut().getCenyKupnaiSprzedazy()[i][0]));
                            zakup = new Zakup(ilosc,0,0, null, null, swiat.getListaRynkowWalut().getListaWalut().get(wyborAktywu));
                            this.setBudzet(this.getBudzet() - ilosc * swiat.getListaRynkowWalut().getCenyKupnaiSprzedazy()[i][0]);
                            this.getHistoriaZakupow().add(zakup);
                            if (this.swiat.getGieldaWalutaController()!=null){
                                if (this.swiat.getGieldaWalutaController().getAktualnaWaluta()== wyborAktywu){
                                    
                                }
                            }
                          
                        }
                    }
                     if (this.swiat.getGieldaWalutaController()!=null)
                        swiat.getGieldaWalutaController().aktualizujTabele();
                }
            }
            break;
            case 2: {
                
                if (!swiat.getListaGield().isEmpty()){
                    wyborRynku = generator.nextInt(swiat.getListaGield().size());
                    wyborAktywu = generator.nextInt(swiat.getListaGield().get(wyborRynku).getListaSpolek().size());
                    ilosc = (int) ((this.getBudzet() * 0.15) / (swiat.getListaGield().get(wyborRynku).getListaSpolek().get(wyborAktywu).getAkcja().getCurKurs()));
                    zakup = new Zakup(ilosc,0,wyborRynku, null, swiat.getListaGield().get(wyborRynku).getListaSpolek().get(wyborAktywu).getAkcja(), null);
    
                    this.setBudzet(this.getBudzet() - ilosc * swiat.getListaGield().get(wyborRynku).getListaSpolek().get(wyborAktywu).getAkcja().getCurKurs());
                    this.getHistoriaZakupow().add(zakup);
                    swiat.getListaGield().get(wyborRynku).getListaSpolek().get(wyborAktywu).setLiczbaAkcji(swiat.getListaGield().get(wyborRynku).getListaSpolek().get(wyborAktywu).getLiczbaAkcji() - ilosc);
                    if(this.swiat.getGieldaPWController()!=null){
                        if (this.swiat.getGieldaPWController().getAktualnaAkcja() == wyborAktywu 
                                && this.swiat.getGieldaPWController().getAktualnaGielda() == wyborRynku){
                             this.swiat.getGieldaPWController().aktualizujWykresWartosci(
                                    this.swiat.getListaGield().get(wyborRynku).getListaSpolek().get(wyborAktywu).getAkcja().getCurKurs()) ;
                        }
                    }
                if (!(swiat.getListaGield().get(wyborRynku).getListaSpolek().get(wyborAktywu).getAkcja().getTablicaKursow().isEmpty()))
                    swiat.getListaGield().get(wyborRynku).getListaSpolek().get(wyborAktywu).getAkcja().getTablicaKursow().remove(0);
                swiat.getListaGield().get(wyborRynku).getListaSpolek().get(wyborAktywu).getAkcja().aktualizujKurs();
                if(this.swiat.getGieldaPWController()!=null)
                    swiat.getGieldaPWController().aktualizujTabele();
                }
           }break;
        
        }
    }
   /**
    * Metoda sprzedaj losuje z historii zakupów zakup, sprawdzając wcześniej czy 
    * historia zakupów nie jest pusta. Następnie sprzedaje dany aktyw po obecnym kursie. 
    */
    
   public synchronized void sprzedaj(){
       Random generator = new Random();
       int ktorySprzedaj = generator.nextInt(historiaZakupow.size());
       int ilosc;
       Zakup zakup = historiaZakupow.get(ktorySprzedaj);
       if (zakup.getAkcja()!=null){
           for (int i=0; i <swiat.getListaGield().get(zakup.getKtoraGielda()).getListaSpolek().size(); i++ ){
            if(swiat.getListaGield().get(zakup.getKtoraGielda()).getListaSpolek().get(i).getAkcja().getNazwa().equals(zakup.getAkcja().getNazwa())){
                   ilosc =  generator.nextInt(zakup.getIlosc()+1);
                   this.setBudzet(getBudzet()+(swiat.getListaGield().get(zakup.getKtoraGielda()).getListaSpolek().get(i).getAkcja().getCurKurs()*ilosc));
                   swiat.getListaGield().get(zakup.getKtoraGielda()).getListaSpolek().get(i).setLiczbaAkcji( swiat.getListaGield().get(zakup.getKtoraGielda()).getListaSpolek().get(i).getLiczbaAkcji()+ilosc);
                   if (zakup.getIlosc()<ilosc){
                        zakup.setIlosc(zakup.getIlosc()-ilosc);
                        break;
                   }
                   else {
                       this.historiaZakupow.remove(ktorySprzedaj);
                       break;
                   }
                }
            }
        }
       else if (zakup.getSurowiec()!=null)
       {
           for (int i=0; i <swiat.getListaRynkowSurowcow().get(zakup.getKtoryRynek()).getListaSurowcow().size(); i++ ){
            if(swiat.getListaRynkowSurowcow().get(zakup.getKtoryRynek()).getListaSurowcow().get(i).getNazwa().equals(zakup.getSurowiec().getNazwa())){
                   ilosc =  generator.nextInt(zakup.getIlosc()+1);
                   this.setBudzet(getBudzet()+(swiat.getListaRynkowSurowcow().get(zakup.getKtoryRynek()).getListaSurowcow().get(i).getCurWartosc()*ilosc));
                   if (zakup.getIlosc()<ilosc){
                        historiaZakupow.get(ktorySprzedaj).setIlosc(zakup.getIlosc()-ilosc);
                        break;
                    }
                   else {
                        this.historiaZakupow.remove(ktorySprzedaj);
                   }
                }
            }
       }
       
      else if (zakup.getWaluta()!=null){
           for (int i=0; i <swiat.getListaRynkowWalut().getListaWalut().size(); i++ ){
                if(swiat.getListaRynkowWalut().getListaWalut().get(i).getNazwa().equals(zakup.getWaluta().getNazwa())){
                    for (int j = 0; j < swiat.getListaRynkowWalut().getCenyKupnaiSprzedazy().length; j++) {
                        if (swiat.getListaRynkowWalut().getListaWalut().get(i).getNazwa().equals(swiat.getListaRynkowWalut().getParyWalut()[j][1])
                            && swiat.getListaRynkowWalut().getParyWalut()[j][0].equals("Złoty")) {
                            ilosc =  generator.nextInt(zakup.getIlosc()+1);
                            this.setBudzet(this.getBudzet() + (ilosc * swiat.getListaRynkowWalut().getCenyKupnaiSprzedazy()[i][1]));
                            if (zakup.getIlosc()>ilosc){
                                this.historiaZakupow.get(ktorySprzedaj).setIlosc(zakup.getIlosc()-ilosc);
                            }
                            else {
                                this.historiaZakupow.remove(ktorySprzedaj);
                                break;
                            }
                        }
                       swiat.getListaRynkowWalut().aktualizujKurs(i);   
                    }
                }
           }
         
      }
   }
   /**
   * Metoda run co pętlę pozwala funduszowi na zakup aktywu, ale również przy wylosowaniu
   * opcji wywołuje fukcję sprzedaj. Przejście przez pętlę wykonuje co 5 sekund.
   */
    public void run() {
        while (!(this.getCzySkonczyc())) {
            kup();
            Random generator = new Random();
            int czySprzedac = generator.nextInt(5);
            if (czySprzedac == 1)
                    sprzedaj();
            try {
                
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Fundusz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setSwiat(Swiat swiat) {
        this.swiat=swiat;
    }
    
}
