package escenario1;

public class Nodo {

    String cliente;
    Nodo siguiente;

    public Nodo(String cliente) {
        this.cliente = cliente;
        this.siguiente = null;
    }
}