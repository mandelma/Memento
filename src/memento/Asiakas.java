package memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Asiakas extends Thread {
    private List<Memento> allMementos = new ArrayList<>();

    private Boolean end = false;
    private int asiakkaanNumero;
    private String nimi;

    public Asiakas(String nimi) {
        this.nimi = nimi;
    }

    public void addMemento(Memento state) {
        allMementos.add(state);
    }

    public Memento getMemento(int index) {
        return allMementos.get(index);
    }

    public String getCustomerName() {
        return this.nimi;
    }

    public int getAsiakkaanNumero() {
        return asiakkaanNumero;
    }

    public void setAsiakkaanNumero(int num) {
        this.asiakkaanNumero = num;
    }

    public int arvaNumero() {
        Random arva = new Random();
        int numero = arva.nextInt(10) + 1;
        return numero;
    }

    public Boolean getEnd() {
        return end;
    }

    public void setEnd(Boolean b) {
        end = b;
    }

    public void run() {
        while(!end) {
            setAsiakkaanNumero(arvaNumero());
        }
    }
}
