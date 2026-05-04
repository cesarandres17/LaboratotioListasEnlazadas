# Escenario 4: Juego por turnos con varios jugadores

## Parte 1. Análisis del problema

### Operaciones necesarias del sistema:
- **Registrar jugadores**: Agregar nuevos jugadores a la partida
- **Pasar turno**: Moverse al siguiente jugador en el círculo
- **Retroceder turno**: Moverse al jugador anterior en el círculo
- **Expulsar jugador**: Eliminar un jugador de la partida en cualquier momento
- **Consultar jugador actual**: Saber quién tiene el turno actualmente
- **Consultar jugadores adyacentes**: Saber quién jugó antes y quién juega después
- **Mostrar lista completa**: Ver todos los jugadores en orden circular
- **Gestionar partida**: Iniciar, terminar y reiniciar el juego

### Características requeridas de la estructura:
- **Recorrido circular**: El turno debe continuar indefinidamente en ciclo
- **Movimiento bidireccional**: Poder avanzar y retroceder entre jugadores
- **Eliminación eficiente**: Poder expulsar jugadores de cualquier posición
- **Acceso a nodos adyacentes**: Consultar rápidamente jugador anterior y siguiente
- **Mantenimiento del ciclo**: La estructura debe mantenerse circular después de eliminaciones

## Parte 2. Selección de la lista

### Elección: **Lista Circular Doblemente Enlazada**

### Justificación:

**¿Se requiere un recorrido circular?**
- **Sí**. Los jugadores están sentados "alrededor de una mesa virtual", lo que implica un ciclo sin fin. Cuando el último jugador termina su turno, debe continuar con el primero.

**¿Se necesita siguiente y anterior?**
- **Sí**. El sistema requiere consultar quién jugó antes y quién juega después. Además, se necesita la capacidad de retroceder turnos.

**¿El sistema debe continuar indefinidamente?**
- **Sí**. La partida puede extenderse indefinidamente mientras haya jugadores, por lo que el recorrido nunca debe "terminar".

**¿Se necesita eliminar nodos intermedios?**
- **Sí**. Se puede "expulsar a un jugador en mitad de la partida", lo que requiere eliminar nodos de cualquier posición manteniendo la integridad del ciclo.

### Por qué otras estructuras no son adecuadas:

**Lista simplemente enlazada:**
- ❌ No permite retroceder (solo movimiento forward)
- ❌ Eliminación del último nodo es O(n) en lugar de O(1)

**Lista doblemente enlazada (no circular):**
- ❌ El recorrido tiene un principio y un fin
- ❌ No permite continuar indefinidamente en ciclo
- ❌ Requeriría lógica adicional para "saltar" del último al primero

**Lista circular simplemente enlazada:**
- ❌ No permite retroceder turnos
- ❌ No puede consultar jugador anterior eficientemente
- ❌ Eliminación requiere recorrido completo para encontrar el nodo anterior

## Parte 3. Implementación

### Clase Nodo (jugador.java):
```java
public class jugador<T> {
    public jugador<T> siguienteJugador;  // Referencia al siguiente
    public jugador<T> anteriorJugador;  // Referencia al anterior
    public T valorJugador;              // Datos del jugador
    
    // Constructores y métodos get/set
}
```

### Clase Lista (ListaCircularDobleJugadores.java):
- **agregarJugador()**: Inserta al final del círculo manteniendo las referencias
- **eliminarJugador()**: Elimina cualquier jugador y reajusta las conexiones
- **buscarJugador()**: Encuentra un jugador específico en el círculo
- **siguienteTurno()**: Avanza al siguiente jugador
- **anteriorTurno()**: Retrocede al jugador anterior
- **mostrarJugadores()**: Muestra todos los jugadores en orden circular

### Clase de Gestión (JuegoPorTurnos.java):
- Administra el estado de la partida
- Controla el flujo de turnos
- Valida operaciones según el estado del juego
- Proporciona interfaz amigable para el usuario

## Parte 4. Reflexión

### Por qué la estructura elegida fue adecuada:

1. **Eficiencia en operaciones principales**:
   - Avanzar/retroceder turno: O(1)
   - Eliminar jugador actual: O(1)
   - Consultar jugadores adyacentes: O(1)

2. **Mantenimiento automático del ciclo**:
   - La estructura garantiza que nunca haya "fin" de la lista
   - Las eliminaciones mantienen la circularidad automáticamente

3. **Flexibilidad completa**:
   - Permite todas las operaciones requeridas sin complejidad adicional
   - No requiere casos especiales para el inicio/fin de la lista

4. **Integridad de datos**:
   - Las referencias dobles aseguran que la lista nunca se rompa
   - Facilita la depuración y manejo de errores

### Dificultades con otras estructuras:

**Con lista simplemente enlazada:**
- Retroceder turnos requeriría recorrido completo O(n)
- Eliminar jugador actual necesitaría encontrar el nodo anterior O(n)
- No se podría mantener eficientemente el concepto de "jugador anterior"

**Con lista doblemente enlazada no circular:**
- Se necesitaría lógica adicional para manejar el "salto" del último al primer jugador
- El turno podría "terminar" accidentalmente si no se maneja correctamente
- Mayor complejidad en el código para mantener el ciclo manualmente

**Con lista circular simplemente enlazada:**
- Imposible implementar retroceso de turnos eficientemente
- Consultar jugador anterior requeriría recorrido completo
- Eliminación sería más compleja y menos eficiente

La lista circular doblemente enlazada proporciona la solución más elegante y eficiente para este escenario, permitiendo todas las operaciones requeridas con complejidad temporal óptima y un código limpio y mantenible.
