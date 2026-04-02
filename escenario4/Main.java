package escenario4;

public class Main {

    public static void main(String[] args){
        ListaDobleEnlazada<String> players = new ListaDobleEnlazada<>();
    
    players.addPlayer("carlos");
    players.addPlayer("juan");
    players.addPlayer("pedro");
    players.printList();

    System.out.println("REMOVE PLAYER---------------");
    players.removePlayer(1);
    System.out.println("PRINT BY INDEX 2 = PEDRO");
    players.printByIndex(2);

    
    }

    
}
