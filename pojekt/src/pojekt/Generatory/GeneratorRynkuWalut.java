
package pojekt.Generatory;

import java.util.ArrayList;
import java.util.Random;
import pojekt.RynekWalut;
import pojekt.Swiat;
import pojekt.Waluta;

public class GeneratorRynkuWalut {
    private Swiat swiat;
   private static String paryWalut[][]={{"Złoty","Euro"},{"Złoty","Dolar amerykański"},{"Złoty","Funt brytyjski"},{"Złoty","Frank szwajcarski"},{"Złoty","Korona szwedzka"},
       {"Złoty","Dolar australijski"},{"Złoty","Dolar kanadyjski"},{"Złoty","Korona czeska"},{"Złoty","Jen"},{"Złoty","Rubel rosyjski"},//
       {"Euro","Dolar amerykański"},{"Euro","Funt brytyjski"},{"Euro","Frank szwajcarski"},{"Euro","Korona szwedzka"},{"Euro","Dolar australijski"},{"Euro","Dolar kanadyjski"},
       {"Euro","Korona czeska"},{"Euro","Jen"},{"Euro","Rubel rosyjski"},//
       {"Dolar amerykański","Funt brytyjski"},{"Dolar amerykański","Frank szwajcarski"},{"Dolar amerykański","Korona szwedzka"},
       {"Dolar amerykański","Dolar australijski"},{"Dolar amerykański","Dolar kanadyjski"},{"Dolar amerykański","Korona czeska"},
       {"Dolar amerykański","Jen"},{"Dolar amerykański","Rubel rosyjski"},//
       {"Funt brytyjski","Frank szwajcarski"},{"Funt brytyjski","Korona szwedzka"},{"Funt brytyjski","Dolar australijski"},
       {"Funt brytyjski","Dolar kanadyjski"},{"Funt brytyjski","Korona czeska"},{"Funt brytyjski","Jen"},{"Funt brytyjski","Rubel rosyjski"},//
       {"Frank szwajcarski","Korona szwedzka"},{"Frank szwajcarski","Dolar australijski"},{"Frank szwajcarski","Dolar kanadyjski"},
       {"Frank szwajcarski","Korona czeska"},{"Frank szwajcarski","Jen"},{"Frank szwajcarski","Rubel rosyjski"},//
       {"Korona szwedzka","Dolar australijski"},{"Korona szwedzka","Dolar kanadyjski"},{"Korona szwedzka","Korona czeska"},{"Korona szwedzka","Jen"},
       {"Korona szwedzka","Rubel rosyjski"},//
       {"Dolar australijski","Dolar kanadyjski"},{"Dolar australijski","Korona czeska"},{"Dolar australijski","Jen"},{"Dolar australijski","Rubel rosyjski"},
       {"Dolar kanadyjski","Korona czeska"},{"Dolar kanadyjski","Jen"},{"Dolar kanadyjski","Rubel rosyjski"},//
       {"Korona czeska","Jen"},{"Korona czeska","Rubel rosyjski"},
       {"Jen","Rubel rosyjski"}};
   
   
   private static double cenaKupnaISprzedazy[][]={{4.201,4.1609},{3.5891,3.3679},{4.8128,4.700},{3.6004,3.5214},{0.4201,0.4286},{2.7902,2.7103},{2.7798,2.7673},{0.1678,0.1630},{0.03094,0.0321},{0.0614,0.0602},//
       {0.8382,0.8337},{1.1288,1.1204},{0.8514,0.8482},{0.1102,0.1090},{0.6573,0.6522},{0.66590,0.6632},{0.03971,0.03911},{0.00736,0.00764},{0.1431,0.1467},//
       {1.3572,1.3500},{1.0212,1.0308},{0.1211,0.1232},{0.7802,0.7815},{0.7982,0.7970},{0.04623,0.04693},{0.00882,0.00889},{0.01732,0.01739},
       {0.7591,0.7580},{0.0941,0.0910},{0.5799,0.5781},{0.5910,0.5902},{0.0339,0.03499},{0.00656,0.00657},{0.1281,0.1290},
       {0.1185,0.1191},{0.7612,0.7630},{0.7771,0.7784},{0.0453,0.04581},{0.00865,0.00858},{0.01684,0.01689},
       {6.4130,6.4200},{6.520,6.590},{0.3840,0.3862},{0.0723,0.0732},{0.1412,0.1439},
       {1.0231,1.0221},{0.06090,0.06003},{0.01131,0.01123},{0.0221,0.2221},
       {0.0576,0.0589},{0.0111,0.0112},{0.0216,0.02172},
       {0.1887,0.1898},{0.3700,0.3748},
       {0.511,0.51123}} ;

    public static String[][] getParyWalut() {
        return paryWalut;
    }

    public static double[][] getCenaKupnaISprzedazy() {
        return cenaKupnaISprzedazy;
    }
   
   /**
    * Metoda generuj generuje pola rynku walut.
    */
   
   public static RynekWalut generuj(){
    
        ArrayList<Waluta> listaWalut = new ArrayList<>();
        int index=0;
        Random generator = new Random();
        int iloscWalut = (int)generator.nextDouble()+10;
        System.out.println((int)2.9);
        String listaParWalut[][]=new String[(iloscWalut*(iloscWalut-1))/2][2];
        double listaCenKupnaISprzedazy[][] = new double[(iloscWalut*(iloscWalut-1))/2][2];
        for (int i=0; i<iloscWalut; i++) listaWalut.add(GeneratorWaluty.generuj(i));
        for (int p=0; p<listaWalut.size();p++){
            for (int q=p+1; q<listaWalut.size(); q++){ 
                for (int i=0; i< paryWalut.length ;i++){
                    if (paryWalut[i][0] == listaWalut.get(p).getNazwa() && paryWalut[i][1] == listaWalut.get(q).getNazwa()) {
                        listaParWalut[index][0]=paryWalut[i][0];
                        listaParWalut[index][1]=paryWalut[i][1];
                        listaCenKupnaISprzedazy[index][0]=cenaKupnaISprzedazy[i][0];
                        listaCenKupnaISprzedazy[index][1]=cenaKupnaISprzedazy[i][1];
                        index++;
                    } 
                    else if (paryWalut[i][0] == listaWalut.get(q).getNazwa() && paryWalut[i][1] == listaWalut.get(p).getNazwa()){
                        listaParWalut[index][0]=paryWalut[i][0];
                        listaParWalut[index][1]=paryWalut[i][1];
                        listaCenKupnaISprzedazy[index][0]=cenaKupnaISprzedazy[i][0];
                        listaCenKupnaISprzedazy[index][1]=cenaKupnaISprzedazy[i][1];
                        index++;
                    }
                
                }
            }
        }
        
        return new RynekWalut(listaWalut, listaParWalut, listaCenKupnaISprzedazy,"Rynek Walut",generator.nextFloat());
   }
    
}
