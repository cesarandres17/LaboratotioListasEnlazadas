public class Cancion<T>{

    private Cancion<T> siguienteCancion;
    private T valorCancion;

    public Cancion(T valorCancion) {
        this.valorCancion = valorCancion;
        this.siguienteCancion = null;
    }

    public Cancion(T valorCancion, Cancion<T> siguienteCancion) {
        this.valorCancion = valorCancion;
        this.siguienteCancion = siguienteCancion;
    }

    public Cancion<T> getSiguienteCancion() {
        return siguienteCancion;
    }

    public void setSiguienteCancion(Cancion<T> siguienteCancion) {
        this.siguienteCancion = siguienteCancion;
    }

    public T getValorCancion() {
        return valorCancion;
    }

    public void setValorCancion(T valorCancion) {
        this.valorCancion = valorCancion;
    }

    





}