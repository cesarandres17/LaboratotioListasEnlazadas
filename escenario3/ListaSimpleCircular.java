import java.util.Iterator;

import javax.xml.crypto.dsig.CanonicalizationMethod;

/**
 * Implementación de una lista circular simplemente enlazada.
 * 
 * Esta estructura es ideal para el escenario de reproducción continua de música,
 * donde la lista nunca termina y automáticamente vuelve al inicio cuando llega al final.
 * 
 * Características principales:
 * - Cada nodo solo tiene referencia al siguiente nodo
 * - El último nodo apunta al primero, creando un ciclo infinito
 * - Permite navegación hacia adelante en forma continua
 * - Eficiente en uso de memoria comparada con listas doblemente enlazadas
 * 
 * @param <T> Tipo de datos almacenados en la lista (genérico)
 * 
 * Escenario de uso: Reproducción continua de música donde se necesita:
 * - Avanzar a la siguiente canción
 * - Eliminar canciones de la lista
 * - Mostrar toda la secuencia actual
 * - Reproducción infinita sin fin real
 */
public class ListaSimpleCircular<T> implements Iterable<T> {
    /** Referencia al primer nodo de la lista circular */
    private Cancion<T> PrimeraCancion;
    
    /** Referencia al último nodo de la lista circular */
    private Cancion<T> UltimaCancion;
    
    /** Contador del número de elementos en la lista */
    private int tamanio;
	
    /**
     * Constructor de la lista circular simplemente enlazada.
     * Inicializa una lista vacía con todos sus atributos en nulo/cero.
     */
	public ListaSimpleCircular() {
		PrimeraCancion = null;
		UltimaCancion = null;
		tamanio = 0;
	}

    /**
     * Agrega una nueva canción al final de la lista circular.
     * 
     * Casos manejados:
     * - Lista vacía: el nuevo nodo apunta a sí mismo
     * - Lista con un elemento: conecta el primero con el nuevo y viceversa
     * - Lista con múltiples elementos: encuentra el último y lo conecta con el nuevo
     * 
     * @param valorCancion El valor de la canción a agregar
     */
    public void agregarCancion(T valorCancion){

        Cancion<T> nuevaCancion =  new Cancion(valorCancion);

        
        if(PrimeraCancion== null){
             PrimeraCancion = nuevaCancion;
             PrimeraCancion.setSiguienteCancion(PrimeraCancion);
             UltimaCancion = nuevaCancion;
             return;
        }
        
        else if(PrimeraCancion.getSiguienteCancion() == null){
            PrimeraCancion.setSiguienteCancion(nuevaCancion);
            nuevaCancion.setSiguienteCancion(PrimeraCancion);
            UltimaCancion = nuevaCancion;
        }
        
        else{
            Cancion<T> aux = PrimeraCancion;
            
            while (aux.getSiguienteCancion()!= PrimeraCancion){
                aux = aux.getSiguienteCancion();  
            }
            
            aux.setSiguienteCancion(nuevaCancion);
            nuevaCancion.setSiguienteCancion(PrimeraCancion);
            UltimaCancion = nuevaCancion;
        }
        tamanio++;
    }    

    /**
     * Elimina una canción de la lista circular por su índice.
     * 
     * Casos manejados:
     * - Lista vacía: no se puede eliminar
     * - Índice fuera de límites: mensaje de error
     * - Eliminar primero (índice 0): actualiza referencias circulares
     * - Eliminar segundo (índice 1): conecta primero con tercero
     * - Eliminar general (índice ≥ 2): conecta anterior con siguiente del eliminado
     * 
     * @param indice Posición de la canción a eliminar (0 a tamanio-1)
     */
    public  void eliminarCancion(int indice){

        Cancion<T> cancionAux = PrimeraCancion;
        int contador= 0;

        if(PrimeraCancion == null || PrimeraCancion.getSiguienteCancion()== null){
            return;
        }
        if(indice > tamanio || indice < 0){
            System.out.println("el indice estra por fuera de los limites de la lista. ");
            return;
        }
        else if(indice == 0) {
            Cancion<T> ultimo = PrimeraCancion;
            while (ultimo.getSiguienteCancion() != PrimeraCancion) {

                ultimo = ultimo.getSiguienteCancion();
        
            }

            PrimeraCancion = PrimeraCancion.getSiguienteCancion();
            ultimo.setSiguienteCancion(PrimeraCancion);
            tamanio--;
            return;

        }
        else if(indice == 1){
            PrimeraCancion.setSiguienteCancion(PrimeraCancion.getSiguienteCancion().getSiguienteCancion());
            tamanio --;
            return;
        }
        else if(indice >= tamanio || indice < 0){
            return;

        }

        while (contador < indice - 1) {
            cancionAux = cancionAux.getSiguienteCancion();
            contador ++;
            
        }

        cancionAux.setSiguienteCancion(cancionAux.getSiguienteCancion().getSiguienteCancion());
        tamanio--;

    }

    /**
     * Busca y muestra una canción específica por su índice.
     * 
     * Casos manejados:
     * - Lista vacía: mensaje indicando que no hay canciones
     * - Índice fuera de límites: mensaje de error
     * - Índice general: recorre hasta encontrar la canción solicitada
     * 
     * @param indice Posición de la canción a buscar (0 a tamanio-1)
     */
    public void buscarPorIndice(int indice){

        Cancion<T> auxCancion = PrimeraCancion;
        int count = 0;

        if(PrimeraCancion== null){
            System.out.print("lista vacia");
            return;
        }
        if(indice > tamanio || indice < 0){
            System.out.println("el indice estra por fuera de los limites de la lista. ");
            return;
        }

        while(count < indice){
            auxCancion = auxCancion.getSiguienteCancion();
            count++;
        }
        System.out.println(auxCancion.getValorCancion());

    }

    /**
     * Muestra todas las canciones de la lista en orden circular.
     * 
     * Funcionamiento:
     * - Si la lista está vacía: muestra mensaje apropiado
     * - Recorre circularmente mostrando cada canción
     * - Utiliza un contador para evitar bucles infinitos
     */
    public void imprimirLista(){

        Cancion<T> aux = PrimeraCancion;

        if(PrimeraCancion == null){
            System.out.println("lsita vacia");
            return;
        }
        System.out.println(PrimeraCancion.getValorCancion());
        int count = 0;
        while (count < tamanio - 1) {
            aux = aux.getSiguienteCancion();
            count ++;
            System.out.println(aux.getValorCancion());
        }
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}