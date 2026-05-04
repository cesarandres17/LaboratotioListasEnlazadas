package escenario4;

public class DemoJuegoPorTurnos {
    
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN: JUEGO POR TURNOS CON LISTA CIRCULAR DOBLE ===");
        System.out.println();
        
        JuegoPorTurnos juego = new JuegoPorTurnos();
        
        // Fase 1: Agregar jugadores
        System.out.println("1. AGREGANDO JUGADORES:");
        juego.agregarJugador("Ana");
        juego.agregarJugador("Carlos");
        juego.agregarJugador("María");
        juego.agregarJugador("Luis");
        juego.agregarJugador("Sofía");
        System.out.println();
        
        // Fase 2: Mostrar estado inicial
        System.out.println("2. ESTADO INICIAL:");
        juego.mostrarJugadores();
        juego.mostrarEstadoActual();
        
        // Fase 3: Iniciar partida
        System.out.println("3. INICIANDO PARTIDA:");
        juego.iniciarPartida();
        System.out.println();
        
        // Fase 4: Avanzar varios turnos
        System.out.println("4. AVANZANDO TURNOS:");
        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.siguienteTurno();
        System.out.println();
        
        // Fase 5: Consultar jugadores adyacentes
        System.out.println("5. CONSULTANDO JUGADORES ADYACENTES:");
        juego.consultarJugadoresAdyacentes("María");
        juego.consultarJugadoresAdyacentes("Ana");
        System.out.println();
        
        // Fase 6: Retroceder turno
        System.out.println("6. RETROCEDIENDO TURNO:");
        juego.retrocederTurno();
        System.out.println();
        
        // Fase 7: Expulsar un jugador
        System.out.println("7. EXPULSANDO JUGADOR:");
        juego.mostrarEstadoActual();
        juego.expulsarJugador("Carlos");
        juego.mostrarJugadores();
        juego.mostrarEstadoActual();
        System.out.println();
        
        // Fase 8: Continuar jugando después de expulsión
        System.out.println("8. CONTINUANDO JUEGO DESPUÉS DE EXPULSIÓN:");
        juego.siguienteTurno();
        juego.siguienteTurno();
        juego.siguienteTurno();
        System.out.println();
        
        // Fase 9: Mostrar orden inverso
        System.out.println("9. MOSTRANDO ORDEN INVERSO:");
        juego.mostrarOrdenInverso();
        System.out.println();
        
        // Fase 10: Demostrar comportamiento circular
        System.out.println("10. DEMOSTRANDO COMPORTAMIENTO CIRCULAR:");
        System.out.println("Avanzando 10 turnos para mostrar el ciclo:");
        for (int i = 0; i < 10; i++) {
            juego.siguienteTurno();
        }
        System.out.println();
        
        // Fase 11: Expulsar más jugadores
        System.out.println("11. EXPULSANDO MÁS JUGADORES:");
        juego.expulsarJugador("Luis");
        juego.expulsarJugador("Sofía");
        juego.mostrarJugadores();
        System.out.println();
        
        // Fase 12: Intentar expulsar jugador que no existe
        System.out.println("12. INTENTANDO EXPULSAR JUGADOR INEXISTENTE:");
        juego.expulsarJugador("Pedro");
        System.out.println();
        
        // Fase 13: Terminar partida
        System.out.println("13. TERMINANDO PARTIDA:");
        juego.terminarPartida();
        juego.mostrarEstadoActual();
        System.out.println();
        
        // Fase 14: Demostrar que no se pueden agregar jugadores durante partida activa
        System.out.println("14. INTENTANDO AGREGAR JUGADOR DURANTE PARTIDA:");
        juego.iniciarPartida();
        juego.agregarJugador("NuevoJugador");
        juego.terminarPartida();
        System.out.println();
        
        // Fase 15: Reiniciar partida
        System.out.println("15. REINICIANDO PARTIDA:");
        juego.reiniciarPartida();
        juego.mostrarEstadoActual();
        System.out.println();
        
        System.out.println("=== FIN DE LA DEMOSTRACIÓN ===");
    }
}
