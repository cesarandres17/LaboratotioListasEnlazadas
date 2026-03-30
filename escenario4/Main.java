package escenario4;

public class Main {

    public static void Main(String [] args){
        ListaDobleEnlazada<String> players = new ListaDobleEnlazada<>();
    

    players.AgregarJugador("carlos");
    players.AgregarJugador("juan");
    players.AgregarJugador("pedro");
    players.imprimirLista();



    System.out.println("ELIMINAR JUGADORS---------------");
    players.Eliminar(1);
    System.out.println("IMPRIMIR POR INDICE 2 = PEDRO");
    players.imprimirPorIndice(2);

    
    }

    
}
