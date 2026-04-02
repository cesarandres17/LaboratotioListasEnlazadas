package escenario4;

/**
 * Node class for the circular doubly linked list.
 * Represents a player in the game with bidirectional connections.
 * 
 * @param <T> Type of data stored in the player (generic)
 */
public class jugador<T>{

    /** Reference to the next player in the circular list */
    public jugador<T> nextPlayer;
    
    /** Reference to the previous player in the circular list */
    public jugador<T> previousPlayer;
    
    /** Value stored in this player node */
    public T playerValue;

    /**
     * Constructor with player value only.
     * Creates a player with null references to next and previous.
     * 
     * @param playerValue The value to store in this player
     */
    public jugador(T playerValue){
        this.playerValue = playerValue;
    }

    /**
     * Constructor with all parameters.
     * Creates a player with specified next and previous references.
     * 
     * @param playerValue The value to store in this player
     * @param nextPlayer Reference to the next player
     * @param previousPlayer Reference to the previous player
     */
    public jugador(T playerValue, jugador<T> nextPlayer, jugador<T> previousPlayer){
        this.playerValue = playerValue;
        this.nextPlayer = nextPlayer;
        this.previousPlayer = previousPlayer;
    }

    /**
     * Gets the next player in the circular list.
     * 
     * @return Reference to the next player
     */
    public jugador<T> getNextPlayer() {
        return nextPlayer;
    }

    /**
     * Sets the next player in the circular list.
     * 
     * @param nextPlayer Reference to the next player
     */
    public void setNextPlayer(jugador<T> nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    /**
     * Gets the previous player in the circular list.
     * 
     * @return Reference to the previous player
     */
    public jugador<T> getPreviousPlayer() {
        return previousPlayer;
    }

    /**
     * Sets the previous player in the circular list.
     * 
     * @param previousPlayer Reference to the previous player
     */
    public void setPreviousPlayer(jugador<T> previousPlayer) {
        this.previousPlayer = previousPlayer;
    }

    /**
     * Gets the value stored in this player.
     * 
     * @return The player's value
     */
    public T getPlayerValue() {
        return playerValue;
    }

    /**
     * Sets the value stored in this player.
     * 
     * @param playerValue The new player value
     */
    public void setPlayerValue(T playerValue) {
        this.playerValue = playerValue;
    }
}
