package escenario2;

public class ListaHistorial {

    Nodo primero;
    Nodo actual;

    public ListaHistorial() {
        primero = null;
        actual = null;
    }

    // Visitar nueva página
    public void visitarPagina(String pagina) {

        Nodo nuevo = new Nodo(pagina);

        if (primero == null) {
            primero = nuevo;
            actual = nuevo;
        } else {

            // Eliminar páginas futuras
            actual.siguiente = null;

            nuevo.anterior = actual;
            actual.siguiente = nuevo;
            actual = nuevo;
        }
    }

    // Ir atrás
    public void irAtras() {
        if (actual != null && actual.anterior != null) {
            actual = actual.anterior;
        } else {
            System.out.println("No hay página anterior");
        }
    }

    // Ir adelante
    public void irAdelante() {
        if (actual != null && actual.siguiente != null) {
            actual = actual.siguiente;
        } else {
            System.out.println("No hay página siguiente");
        }
    }

    // Mostrar página actual
    public void mostrarActual() {
        if (actual != null) {
            System.out.println("Página actual: " + actual.pagina);
        } else {
            System.out.println("No hay páginas");
        }
    }

    // Mostrar historial completo
    public void mostrarHistorial() {

        Nodo aux = primero;

        while (aux != null) {
            System.out.print(aux.pagina + " -> ");
            aux = aux.siguiente;
        }

        System.out.println("null");
    }
}
