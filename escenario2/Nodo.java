package escenario2;


public class Nodo {

    String pagina;
    Nodo siguiente;
    Nodo anterior;

    public Nodo(String pagina) {
        this.pagina = pagina;
        siguiente = null;
        anterior = null;
    }
}