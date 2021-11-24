package memento;

import java.util.Random;

public class Arvuuttaja {

    public Memento liityPeliin(Asiakas asiakas) {
        Random laske = new Random();
        int numero = laske.nextInt(10) + 1;
        return new Memento(numero);
    }
}
