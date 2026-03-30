import java.util.Iterator;

import javax.xml.crypto.dsig.CanonicalizationMethod;

public class ListaSimpleCircular<T> implements Iterable<T> {
    private Cancion<T> PrimeraCancion;
	private Cancion<T> UltimaCancion;
	private int tamanio;
	

	public ListaSimpleCircular() {
		PrimeraCancion = null;
		UltimaCancion = null;
		tamanio = 0;
	}



    public void agregarCancion(T valorCancion){

        Cancion<T> nuevaCancion =  new Cancion(valorCancion);


        if(PrimeraCancion== null){
             PrimeraCancion = nuevaCancion;
             PrimeraCancion.setSiguienteCancion(PrimeraCancion);

        }
        else if(PrimeraCancion.getSiguienteCancion() == null){

            PrimeraCancion.setSiguienteCancion(nuevaCancion);
            nuevaCancion.setSiguienteCancion(PrimeraCancion);
            UltimaCancion = nuevaCancion;


        } else{
            Cancion<T> aux = PrimeraCancion;
            while (aux.getSiguienteCancion()!= PrimeraCancion) {
                aux = aux.getSiguienteCancion();  
            }
            aux.setSiguienteCancion(nuevaCancion);
            nuevaCancion.setSiguienteCancion(PrimeraCancion);
            UltimaCancion = nuevaCancion;
            

            
        }

        tamanio++;
        


    }



    public  void eliminarCancion(int indice){

        Cancion<T> cancionAux = PrimeraCancion;
        int contador= 0;

        if(PrimeraCancion == null || PrimeraCancion.getSiguienteCancion()== null){
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