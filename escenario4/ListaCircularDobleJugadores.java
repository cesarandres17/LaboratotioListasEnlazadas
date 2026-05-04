package escenario4;

public class ListaCircularDobleJugadores<T> {
    
    private jugador<T> actual;
    private int tamaño;

    public ListaCircularDobleJugadores() {
        this.actual = null;
        this.tamaño = 0;
    }

    public boolean estaVacia() {
        return actual == null;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void agregarJugador(T valorJugador) {
        jugador<T> nuevoJugador = new jugador<>(valorJugador);
        
        if (estaVacia()) {
            actual = nuevoJugador;
            actual.setSiguienteJugador(actual);
            actual.setAnteriorJugador(actual);
        } else {
            jugador<T> ultimo = actual.getAnteriorJugador();
            ultimo.setSiguienteJugador(nuevoJugador);
            nuevoJugador.setAnteriorJugador(ultimo);
            nuevoJugador.setSiguienteJugador(actual);
            actual.setAnteriorJugador(nuevoJugador);
        }
        tamaño++;
    }

    public boolean eliminarJugador(T valorJugador) {
        if (estaVacia()) {
            return false;
        }

        jugador<T> actualActual = actual;
        boolean encontrado = false;

        do {
            if (actualActual.getValorJugador().equals(valorJugador)) {
                encontrado = true;
                break;
            }
            actualActual = actualActual.getSiguienteJugador();
        } while (actualActual != actual);

        if (!encontrado) {
            return false;
        }

        if (tamaño == 1) {
            actual = null;
        } else {
            jugador<T> anterior = actualActual.getAnteriorJugador();
            jugador<T> siguiente = actualActual.getSiguienteJugador();
            anterior.setSiguienteJugador(siguiente);
            siguiente.setAnteriorJugador(anterior);
            
            if (actualActual == actual) {
                actual = siguiente;
            }
        }
        tamaño--;
        return true;
    }

    public jugador<T> buscarJugador(T valorJugador) {
        if (estaVacia()) {
            return null;
        }

        jugador<T> actualActual = actual;
        do {
            if (actualActual.getValorJugador().equals(valorJugador)) {
                return actualActual;
            }
            actualActual = actualActual.getSiguienteJugador();
        } while (actualActual != actual);

        return null;
    }

    public T getJugadorActual() {
        return estaVacia() ? null : actual.getValorJugador();
    }

    public void siguienteTurno() {
        if (!estaVacia()) {
            actual = actual.getSiguienteJugador();
        }
    }

    public void anteriorTurno() {
        if (!estaVacia()) {
            actual = actual.getAnteriorJugador();
        }
    }

    public jugador<T> getSiguienteJugador() {
        return estaVacia() ? null : actual.getSiguienteJugador();
    }

    public jugador<T> getAnteriorJugador() {
        return estaVacia() ? null : actual.getAnteriorJugador();
    }

    public void mostrarJugadores() {
        if (estaVacia()) {
            System.out.println("No hay jugadores en la partida.");
            return;
        }

        System.out.println("Jugadores en la partida (en orden circular):");
        jugador<T> actualActual = actual;
        int contador = 1;
        
        do {
            String indicador = (actualActual == actual) ? " ← TURNO ACTUAL" : "";
            System.out.println(contador + ". " + actualActual.getValorJugador() + indicador);
            actualActual = actualActual.getSiguienteJugador();
            contador++;
        } while (actualActual != actual);
        
        System.out.println("Total: " + tamaño + " jugadores");
        System.out.println();
    }

    public void mostrarOrdenInverso() {
        if (estaVacia()) {
            System.out.println("No hay jugadores en la partida.");
            return;
        }

        System.out.println("Jugadores en orden inverso:");
        jugador<T> actualActual = actual.getAnteriorJugador();
        int contador = 1;
        
        do {
            System.out.println(contador + ". " + actualActual.getValorJugador());
            actualActual = actualActual.getAnteriorJugador();
            contador++;
        } while (actualActual != actual.getAnteriorJugador());
        
        System.out.println();
    }
}
