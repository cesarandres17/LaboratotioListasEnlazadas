package escenario1;

public class ListaTurnos {

    Nodo primero;
    Nodo ultimo;

    public ListaTurnos() {
        primero = null;
        ultimo = null;
    }

    public void agregarCliente(String cliente) {
        Nodo nuevo = new Nodo(cliente);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }

    public void atenderCliente() {
        if (primero != null) {
            System.out.println("Atendiendo a: " + primero.cliente);
            primero = primero.siguiente;

            if (primero == null) {
                ultimo = null;
            }
        } else {
            System.out.println("No hay clientes en espera");
        }
    }

    public void siguienteCliente() {
        if (primero != null) {
            System.out.println("Siguiente cliente: " + primero.cliente);
        } else {
            System.out.println("No hay clientes");
        }
    }

    public void mostrarTurnos() {
        Nodo aux = primero;

        while (aux != null) {
            System.out.print(aux.cliente + " -> ");
            aux = aux.siguiente;
        }

        System.out.println("null");
    }

    public void buscarCliente(String nombre) {
        Nodo aux = primero;

        while (aux != null) {
            if (aux.cliente.equals(nombre)) {
                System.out.println("Cliente encontrado: " + nombre);
                return;
            }
            aux = aux.siguiente;
        }

        System.out.println("Cliente no encontrado");
    }
}