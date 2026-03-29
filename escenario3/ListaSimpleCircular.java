public class ListaSimpleCircular<T> implements Iterable<T> {
    private Cancion<T> PrimeraCancion;
	private Cancion<T> UltimaCancion;
	private int tamanio;
	

	public ListaSimpleCircular() {
		PrimeraCancion = null;
		UltimaCancion = null;
		tamanio = 0;
	}



    public void agregarCancion(){

        Cancion<T> nuevaCancion =  new Cancion();


        if(PrimeraCancion != null && PrimeraCancion.getSiguienteCancion()== null){

            PrimeraCancion = nuevaCancion;
            return;
        }





    }
    


    



}