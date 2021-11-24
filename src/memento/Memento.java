package memento;

public class Memento {
    private int state;

    public Memento(int numero) {
        this.state = numero;
    }

    public int getState() {
        return this.state;
    }
}
