package escenario4;

public class jugador<T>{

    public jugador<T> siguienteJugador;
    public jugador<T> anteriorJugador;
    public T valorJugador;

    public jugador(T valorJugador){
        
        this.valorJugador = valorJugador;

    }

    public jugador(T valorJugador,jugador<T> siguienteJugador,jugador<T> anteriorJugador ){
        this.valorJugador = valorJugador;
        this.siguienteJugador = siguienteJugador;
        this.anteriorJugador = anteriorJugador;

    }

    public jugador<T> getSiguienteJugador() {
        return siguienteJugador;
    }

    public void setSiguienteJugador(jugador<T> siguienteJugador) {
        this.siguienteJugador = siguienteJugador;
    }

    public jugador<T> getAnteriorJugador() {
        return anteriorJugador;
    }

    public void setAnteriorJugador(jugador<T> anteriorJugador) {
        this.anteriorJugador = anteriorJugador;
    }

    public T getValorJugador() {
        return valorJugador;
    }

    public void setValorJugador(T valorJugador) {
        this.valorJugador = valorJugador;
    }

    

    
    
}
