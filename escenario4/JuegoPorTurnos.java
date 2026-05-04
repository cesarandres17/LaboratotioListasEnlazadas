package escenario4;

public class JuegoPorTurnos {
    
    private ListaCircularDobleJugadores<String> jugadores;
    private int numeroTurno;
    private boolean juegoActivo;

    public JuegoPorTurnos() {
        this.jugadores = new ListaCircularDobleJugadores<>();
        this.numeroTurno = 0;
        this.juegoActivo = false;
    }

    public void iniciarPartida() {
        if (jugadores.estaVacia()) {
            System.out.println("No se puede iniciar la partida sin jugadores.");
            return;
        }
        this.juegoActivo = true;
        this.numeroTurno = 1;
        System.out.println("¡PARTIDA INICIADA!");
        System.out.println("Turno 1: " + jugadores.getJugadorActual());
        System.out.println();
    }

    public void agregarJugador(String nombreJugador) {
        if (juegoActivo) {
            System.out.println("No se pueden agregar jugadores durante una partida activa.");
            return;
        }
        jugadores.agregarJugador(nombreJugador);
        System.out.println("Jugador '" + nombreJugador + "' agregado a la partida.");
    }

    public boolean expulsarJugador(String nombreJugador) {
        if (!juegoActivo) {
            System.out.println("No hay partida activa para expulsar jugadores.");
            return false;
        }

        boolean eliminado = jugadores.eliminarJugador(nombreJugador);
        if (eliminado) {
            System.out.println("Jugador '" + nombreJugador + "' ha sido expulsado de la partida.");
            if (jugadores.estaVacia()) {
                System.out.println("No quedan jugadores. La partida ha terminado.");
                juegoActivo = false;
                numeroTurno = 0;
            }
        } else {
            System.out.println("El jugador '" + nombreJugador + "' no se encuentra en la partida.");
        }
        return eliminado;
    }

    public void siguienteTurno() {
        if (!juegoActivo) {
            System.out.println("No hay partida activa.");
            return;
        }

        jugadores.siguienteTurno();
        numeroTurno++;
        System.out.println("Turno " + numeroTurno + ": " + jugadores.getJugadorActual());
    }

    public void retrocederTurno() {
        if (!juegoActivo) {
            System.out.println("No hay partida activa.");
            return;
        }

        jugadores.anteriorTurno();
        System.out.println("Retrocediendo al turno anterior: " + jugadores.getJugadorActual());
    }

    public void mostrarEstadoActual() {
        System.out.println("=== ESTADO ACTUAL DE LA PARTIDA ===");
        System.out.println("Estado: " + (juegoActivo ? "ACTIVA" : "INACTIVA"));
        System.out.println("Turno actual: " + numeroTurno);
        System.out.println("Jugador actual: " + (juegoActivo ? jugadores.getJugadorActual() : "N/A"));
        
        if (juegoActivo) {
            System.out.println("Siguiente jugador: " + jugadores.getSiguienteJugador().getValorJugador());
            System.out.println("Jugador anterior: " + jugadores.getAnteriorJugador().getValorJugador());
        }
        
        System.out.println("Total jugadores: " + jugadores.getTamaño());
        System.out.println();
    }

    public void mostrarJugadores() {
        jugadores.mostrarJugadores();
    }

    public void mostrarOrdenInverso() {
        jugadores.mostrarOrdenInverso();
    }

    public void consultarJugadoresAdyacentes(String nombreJugador) {
        jugador<String> jugadorEncontrado = jugadores.buscarJugador(nombreJugador);
        
        if (jugadorEncontrado == null) {
            System.out.println("El jugador '" + nombreJugador + "' no se encuentra en la partida.");
            return;
        }

        System.out.println("Información del jugador '" + nombreJugador + "':");
        System.out.println("Jugador anterior: " + jugadorEncontrado.getAnteriorJugador().getValorJugador());
        System.out.println("Jugador siguiente: " + jugadorEncontrado.getSiguienteJugador().getValorJugador());
        System.out.println();
    }

    public void terminarPartida() {
        juegoActivo = false;
        numeroTurno = 0;
        System.out.println("PARTIDA TERMINADA.");
    }

    public void reiniciarPartida() {
        terminarPartida();
        jugadores = new ListaCircularDobleJugadores<>();
        System.out.println("Partida reiniciada. Todos los jugadores han sido eliminados.");
    }

    public boolean isJuegoActivo() {
        return juegoActivo;
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }
}
