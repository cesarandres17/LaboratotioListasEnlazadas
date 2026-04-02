package escenario4;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * Implementation of a circular doubly linked list.
 * 
 * This structure is ideal for gaming scenarios where you need:
 * - Bidirectional navigation (forward and backward)
 * - Fast access to first and last elements
 * - Efficient insertion and deletion
 * - Maintaining a circular order of players
 * 
 * Main features:
 * - Each node has reference to next and previous
 * - Last node points to first and vice versa (circular)
 * - Allows traversing the list in both directions infinitely
 * 
 * @param <T> Type of data stored in the list (generic)
 * 
 * Use case: Player management in a game where you need:
 * - Add players to the list
 * - Remove specific players
 * - Navigate forward and backward
 * - Access players by index
 * - Display the entire current list
 * - Maintain an infinite circular order
 */
public class ListaDobleEnlazada<T> {
    
    /** Reference to the first player in the circular list */
    public jugador<T> firstPlayer;
    
    /** Reference to the last player in the circular list */
    public jugador<T> lastPlayer;
    
    /** Counter of the number of players in the list */
    public int size;

    /**
     * Constructor of the circular doubly linked list.
     * Initializes an empty list with all attributes null/zero.
     */
    public ListaDobleEnlazada(){
        firstPlayer = null;
        lastPlayer = null;
        size = 0;
    }

    /**
     * Adds a new player to the end of the circular list.
     * 
     * Cases handled:
     * - Empty list: new node points to itself
     * - List with one element: connects first with new and vice versa
     * - List with multiple elements: finds the last and connects it with the new
     * 
     * @param playerValue The value of the player to add
     */
    public void addPlayer(T playerValue){
        jugador<T> newPlayer = new jugador<T>(playerValue);
        
        if(firstPlayer == null){
            // Case 1: Empty list - new node points to itself
            firstPlayer = newPlayer;
            newPlayer.setNextPlayer(firstPlayer);
            newPlayer.setPreviousPlayer(firstPlayer);
            lastPlayer = newPlayer;
            return;
        }
        else if(firstPlayer.getNextPlayer() == null){
            // Case 2: List with one element - creates the initial circle
            firstPlayer.setNextPlayer(newPlayer);
            newPlayer.setNextPlayer(firstPlayer);
            newPlayer.setPreviousPlayer(firstPlayer);
            firstPlayer.setPreviousPlayer(newPlayer);
            lastPlayer = newPlayer;
            
        }else{
            // Case 3: List with multiple elements - finds the last and connects
            jugador<T> auxPlayer = firstPlayer;

        while(auxPlayer.getNextPlayer() != firstPlayer){
            auxPlayer = auxPlayer.getNextPlayer();

        }
        auxPlayer.setNextPlayer(newPlayer);
        newPlayer.setNextPlayer(firstPlayer);
        newPlayer.setPreviousPlayer(auxPlayer);
        firstPlayer.setPreviousPlayer(newPlayer);
        lastPlayer = newPlayer;
        }
        size ++;
    }


    /**
     * Removes a player from the circular list by its index.
     * 
     * Cases handled:
     * - Empty list: cannot remove
     * - Index out of bounds: error message
     * - Remove first (index 0): updates circular references
     * - Remove second (index 1): connects first with third
     * - Remove general (index ≥ 2): connects previous with next of removed
     * 
     * @param index Position of the player to remove (0 to size-1)
     */
    public void removePlayer(int index){
        if(size == 1){
            // Special case: list with only one element
            firstPlayer = null;
            lastPlayer = null;
            size = 0;
            return;
        }
        
        if(index >= size || index < 0){
            // Validation: index out of bounds
            System.out.println("index out of bounds.");
            return;
        } else if(index == 0){
            // Case 1: Remove the first player
            jugador<T> newFirstPlayer = firstPlayer.getNextPlayer();

            lastPlayer.setNextPlayer(newFirstPlayer);
            newFirstPlayer.setPreviousPlayer(lastPlayer);
            firstPlayer = newFirstPlayer;
        
            size --;
        }else if (index == 1){
            // Case 2: Remove the second player
            firstPlayer.setNextPlayer(firstPlayer.getNextPlayer().getPreviousPlayer());
            firstPlayer.getNextPlayer().getNextPlayer().setPreviousPlayer(firstPlayer);
            size--;

        }else{
            // Case 3: Remove any other player
            jugador<T> auxPlayer = firstPlayer;
            int count = 0;
            while(count < index - 1 ){

                auxPlayer = auxPlayer.getNextPlayer();
                count ++;

            }
            jugador<T> nextToRemove = auxPlayer.getNextPlayer().getNextPlayer();
            auxPlayer.setNextPlayer(nextToRemove);
            nextToRemove.setPreviousPlayer(auxPlayer);
            size--;

            
        }
    }



    /**
     * Searches and displays a specific player by its index.
     * 
     * Cases handled:
     * - Empty list: message indicating no players
     * - Index out of bounds: error message
     * - Index 0: shows the first player directly
     * - General index: traverses until finding the requested player
     * 
     * @param index Position of the player to search (0 to size-1)
     */
    public void printByIndex(int index){
        if(index == 0){
            // Special case: show the first player
            System.out.println(firstPlayer);
            return;
        }else if(firstPlayer == null){
            // Validation: empty list
            System.out.println("no players");
        } else if(index >= size || index < 0){
            // Validation: index out of bounds
            System.out.println("index out of bounds");
        } else{
            // General case: search player by index
            jugador<T> auxPlayer = firstPlayer;
        int count = 0;

        while (count < index) {
            auxPlayer = auxPlayer.getNextPlayer();
            count++;
        }
        System.out.println(auxPlayer.getPlayerValue());
        }
        
    }

    /**
     * Displays all players in the list in circular order.
     * 
     * Functionality:
     * - If the list is empty: shows appropriate message
     * - Traverses circularly showing each player
     * - Uses a counter to avoid infinite loops
     */
    public void printList(){
        if(firstPlayer == null){
            // Validation: empty list
            System.out.println("no players");
            return;
        }
        
            jugador<T> auxPlayer = firstPlayer; 
            int count = 0;
            while(count < size){
            // Prints the current player and advances to the next
            System.out.println(auxPlayer.getPlayerValue());
            auxPlayer = auxPlayer.getNextPlayer();
            count++;
        }
    }
}
