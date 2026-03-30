package escenario4;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ListaDobleEnlazada<T> {

    public jugador<T> primeJugador;
    public jugador<T> ultimJugador;
    public int size;




    public ListaDobleEnlazada(){
        primeJugador = null;
        ultimJugador = null;
        size = 0;
    }




    public void AgregarJugador(T valorJugador){
        jugador<T> nuevoJugador = new jugador<T>(valorJugador);
        
        if(primeJugador == null){
            primeJugador = nuevoJugador;
            nuevoJugador.setSiguienteJugador(primeJugador);
            nuevoJugador.setAnteriorJugador(primeJugador);
            ultimJugador = nuevoJugador;
            
            return;

        }else if(primeJugador.getSiguienteJugador() == null){
            primeJugador.setSiguienteJugador(nuevoJugador);
            nuevoJugador.setSiguienteJugador(primeJugador);
            nuevoJugador.setAnteriorJugador(primeJugador);
            primeJugador.setAnteriorJugador(nuevoJugador);
            ultimJugador = nuevoJugador;
            

        }else{
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



    public void Eliminar(int indice){
        if(size == 1){
            primeJugador = null;
            ultimJugador = null;
            size = 0;
            return;

        }
        

        if(indice >= size|| indice < 0){
            System.out.println("indice por fuera de los limites. ");
            return;

        } else if(indice == 0){

            jugador<T> nuevoPrimeroJugador = primeJugador.getSiguienteJugador();

            ultimJugador.setSiguienteJugador(nuevoPrimeroJugador);
            nuevoPrimeroJugador.setAnteriorJugador(ultimJugador);
            primeJugador = nuevoPrimeroJugador;
        
            size --;
        }else if (indice == 1){
            primeJugador.setSiguienteJugador(primeJugador.getSiguienteJugador().getAnteriorJugador());
            primeJugador.getSiguienteJugador().getSiguienteJugador().setAnteriorJugador(primeJugador);
            size--;

        }else{
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



    public void imprimirPorIndice( int indice){

        if(indice == 0){
            System.out.println(primeJugador);
            return;

        }else if(primeJugador == null){
            System.out.println("no hay jugadores");

        } else if(indice >= size || indice < 0){
            System.out.println("indice por fuera de lo limites");

        } else{
            jugador<T> auxJugador  = primeJugador;
        int count = 0;

        while (count < indice) {
            auxJugador = auxJugador.getSiguienteJugador();
            count++;
        }

        System.out.println(auxJugador.getValorJugador());

        }

        
    }



    public void imprimirLista(){

        if(primeJugador == null){
            System.out.println("no hay jugadores");
        }
        
            jugador<T> auxJugador = primeJugador; 
            int count = 0;
            while(count < size){
                System.out.println(auxJugador.getValorJugador());
                auxJugador = auxJugador.getSiguienteJugador();
                count++;

            

        }
    }
    
}
