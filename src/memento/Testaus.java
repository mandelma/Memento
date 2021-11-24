package memento;

import java.util.ArrayList;
import java.util.List;

public class Testaus extends  Thread {
    public static void main(String[] args) {
        List<Asiakas> asiakkaat = new ArrayList<>();
        Arvuuttaja arvuuttaja = new Arvuuttaja();
        Asiakas asiakas = null;

        asiakkaat.add(new Asiakas("Asiakas_1"));
        asiakkaat.add(new Asiakas("Asiakas_2"));
        asiakkaat.add(new Asiakas("Asiakas_3"));

        asiakkaat.get(0).addMemento(arvuuttaja.liityPeliin(asiakas));
        asiakkaat.get(1).addMemento(arvuuttaja.liityPeliin(asiakas));
        asiakkaat.get(2).addMemento(arvuuttaja.liityPeliin(asiakas));

        int asiakkaanNumero = 0;
        int asiakkaanTarjous = 0;
        int counter = 0;

        for(int i = 0; i < asiakkaat.size(); i++) {
            asiakkaat.get(i).start();
            asiakkaanNumero = asiakkaat.get(i).getMemento(0).getState();
            System.out.println(asiakkaat.get(i).getCustomerName() + " liittymisnumero: " + asiakkaat.get(i).getMemento(0).getState());
            System.out.println("------------------------------------------------------");
            counter = 0;
            do{
                asiakkaanTarjous = asiakkaat.get(i).getAsiakkaanNumero();
                if(asiakkaanNumero == asiakkaanTarjous) {
                    counter++;
                    asiakkaat.get(i).setEnd(true);
                } else {
                    System.out.println(asiakkaat.get(i).getCustomerName() + " tarjoama numero: " + asiakkaanTarjous + " ei täsmää!");
                    counter++;
                }
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (asiakkaanTarjous != asiakkaanNumero);

            System.out.println("Finally " + asiakkaat.get(i).getCustomerName() + " tarjoama numero: " + asiakkaanTarjous + " OK!");
            System.out.println(asiakkaat.get(i).getCustomerName() + " tarjoamia tarjouksia: " + counter);
            System.out.println(" ");
        }
    }
}
