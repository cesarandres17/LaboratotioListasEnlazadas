package escenario2;

public class ListaHistorial {
    Nodo primero;
    Nodo actual;
    public ListaHistorial() {
        primero = null;
        actual = null;
    }


    public void visitarPagina(String pagina) {

        Nodo nuevo = new Nodo(pagina);

        if (primero == null) {
            primero = nuevo;
            actual = nuevo;
        } else {

  
            actual.siguiente = null;

            nuevo.anterior = actual;
            actual.siguiente = nuevo;
            actual = nuevo;
        }
    }

    public void irAtras() {
        if (actual != null && actual.anterior != null) {
            actual = actual.anterior;
        } else {
            System.out.println("No hay página anterior");
        }
    }

 
    public void irAdelante() {
        if (actual != null && actual.siguiente != null) {
            actual = actual.siguiente;
        } else {
            System.out.println("No hay página siguiente");
        }
    }


    public void mostrarActual() {
        if (actual != null) {
            System.out.println("Página actual: " + actual.pagina);
        } else {
            System.out.println("No hay páginas");
        }
    }


    public void mostrarHistorial() {

        Nodo aux = primero;

        while (aux != null) {
            System.out.print(aux.pagina + " -> ");
            aux = aux.siguiente;
        }

        System.out.println("null");
    }
}
