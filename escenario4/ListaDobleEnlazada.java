package escenario4;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * Implementación de una lista doblemente enlazada circular.
 * 
 * Esta estructura es ideal para escenarios de juegos donde se necesita:
 * - Navegación bidireccional (hacia adelante y atrás)
 * - Acceso rápido al primer y último elemento
 * - Inserción y eliminación eficientes
 * - Mantenimiento de un orden circular de jugadores
 * 
 * Características principales:
 * - Cada nodo tiene referencia al siguiente y al anterior
 * - El último nodo apunta al primero y viceversa (circular)
 * - Permite recorrer la lista en ambas direcciones infinitamente
 * 
 * @param <T> Tipo de datos almacenados en la lista (genérico)
 * 
 * Escenario de uso: Gestión de jugadores en un juego donde se necesita:
 * - Agregar jugadores a la lista
 * - Eliminar jugadores específicos
 * - Navegar hacia adelante y atrás
 * - Acceder a jugadores por índice
 * - Mostrar toda la lista actual
 * - Mantener un orden circular infinito
 */
public class ListaDobleEnlazada<T> {

    /** Referencia al primer jugador de la lista circular */
    public jugador<T> primeJugador;
    
    /** Referencia al último jugador de la lista circular */
    public jugador<T> ultimJugador;
    
    /** Contador del número de jugadores en la lista */
    public int size;

    /**
     * Constructor de la lista doblemente enlazada circular.
     * Inicializa una lista vacía con todos sus atributos en nulo/cero.
     */
    public ListaDobleEnlazada(){
        primeJugador = null;
        ultimJugador = null;
        size = 0;
    }

    /**
     * Agrega un nuevo jugador al final de la lista circular.
     * 
     * Casos manejados:
     * - Lista vacía: el nuevo nodo apunta a sí mismo
     * - Lista con un elemento: conecta el primero con el nuevo y viceversa
     * - Lista con múltiples elementos: encuentra el último y lo conecta con el nuevo
     * 
     * @param valorJugador El valor del jugador a agregar
     */
    public void AgregarJugador(T valorJugador){
        jugador<T> nuevoJugador = new jugador<T>(valorJugador);
        
        if(primeJugador == null){
            // Caso 1: Lista vacía - el nuevo nodo apunta a sí mismo
            primeJugador = nuevoJugador;
            nuevoJugador.setSiguienteJugador(primeJugador);
            nuevoJugador.setAnteriorJugador(primeJugador);
            ultimJugador = nuevoJugador;
            return;
        }
        else if(primeJugador.getSiguienteJugador() == null){
            // Caso 2: Lista con un elemento - crea el círculo inicial
            primeJugador.setSiguienteJugador(nuevoJugador);
            nuevoJugador.setSiguienteJugador(primeJugador);
            nuevoJugador.setAnteriorJugador(primeJugador);
            primeJugador.setAnteriorJugador(nuevoJugador);
            ultimJugador = nuevoJugador;
            
        }else{
            // Caso 3: Lista con múltiples elementos - encuentra el último y lo conecta
            jugador<T> auxJugador = primeJugador;

        while(auxJugador.getSiguienteJugador() != primeJugador){
            auxJugador = auxJugador.getSiguienteJugador();

        }
        auxJugador.setSiguienteJugador(nuevoJugador);
        nuevoJugador.setSiguienteJugador(primeJugador);
        nuevoJugador.setAnteriorJugador(auxJugador);
        primeJugador.setAnteriorJugador(nuevoJugador);
        ultimJugador = nuevoJugador;
        }
        size ++;
    }



    /**
     * Elimina un jugador de la lista circular por su índice.
     * 
     * Casos manejados:
     * - Lista vacía: no se puede eliminar
     * - Índice fuera de límites: mensaje de error
     * - Eliminar primero (índice 0): actualiza referencias circulares
     * - Eliminar segundo (índice 1): conecta primero con tercero
     * - Eliminar general (índice ≥ 2): conecta anterior con siguiente del eliminado
     * 
     * @param indice Posición del jugador a eliminar (0 a size-1)
     */
    public void Eliminar(int indice){
        if(size == 1){
            // Caso especial: lista con un solo elemento
            primeJugador = null;
            ultimJugador = null;
            size = 0;
            return;
        }
        
        if(indice >= size|| indice < 0){
            // Validación: índice fuera de límites
            System.out.println("indice por fuera de los limites. ");
            return;
        } else if(indice == 0){
            // Caso 1: Eliminar el primer jugador
            jugador<T> nuevoPrimeroJugador = primeJugador.getSiguienteJugador();

            ultimJugador.setSiguienteJugador(nuevoPrimeroJugador);
            nuevoPrimeroJugador.setAnteriorJugador(ultimJugador);
            primeJugador = nuevoPrimeroJugador;
        
            size --;
        }else if (indice == 1){
            // Caso 2: Eliminar el segundo jugador
            primeJugador.setSiguienteJugador(primeJugador.getSiguienteJugador().getAnteriorJugador());
            primeJugador.getSiguienteJugador().getSiguienteJugador().setAnteriorJugador(primeJugador);
            size--;

        }else{
            // Caso 3: Eliminar cualquier otro jugador
            jugador<T> auxJugador = primeJugador;
            int count = 0;
            while(count < indice - 1 ){

                auxJugador = auxJugador.getSiguienteJugador();
                count ++;

            }
            jugador<T> siguienteBorrar = auxJugador.getSiguienteJugador().getSiguienteJugador();
            auxJugador.setSiguienteJugador(siguienteBorrar);
            siguienteBorrar.setAnteriorJugador(auxJugador);
            size--;

            
        }
    }



    /**
     * Busca y muestra un jugador específico por su índice.
     * 
     * Casos manejados:
     * - Lista vacía: mensaje indicando que no hay jugadores
     * - Índice fuera de límites: mensaje de error
     * - Índice 0: muestra el primer jugador directamente
     * - Índice general: recorre hasta encontrar el jugador solicitado
     * 
     * @param indice Posición del jugador a buscar (0 a size-1)
     */
    public void imprimirPorIndice( int indice){
        if(indice == 0){
            // Caso especial: mostrar el primer jugador
            System.out.println(primeJugador);
            return;
        }else if(primeJugador == null){
            // Validación: lista vacía
            System.out.println("no hay jugadores");
        } else if(indice >= size || indice < 0){
            // Validación: índice fuera de límites
            System.out.println("indice por fuera de lo limites");
        } else{
            // Caso general: buscar el jugador por índice
            jugador<T> auxJugador  = primeJugador;
        int count = 0;

        while (count < indice) {
            auxJugador = auxJugador.getSiguienteJugador();
            count++;
        }
        System.out.println(auxJugador.getValorJugador());
        }
        
    }

    /**
     * Muestra todos los jugadores de la lista en orden circular.
     * 
     * Funcionamiento:
     * - Si la lista está vacía: muestra mensaje apropiado
     * - Recorre circularmente mostrando cada jugador
     * - Utiliza un contador para evitar bucles infinitos
     */
    public void imprimirLista(){
        if(primeJugador == null){
            // Validación: lista vacía
            System.out.println("no hay jugadores");
            return;
        }
        
            jugador<T> auxJugador = primeJugador; 
            int count = 0;
            while(count < size){
                // Imprime el jugador actual y avanza al siguiente
                System.out.println(auxJugador.getValorJugador());
                auxJugador = auxJugador.getSiguienteJugador();
                count++;
            }
            
        }
    }

