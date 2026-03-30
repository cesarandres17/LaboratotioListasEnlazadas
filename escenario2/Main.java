package escenario2;

public class Main {

    public static void main(String[] args) {

        ListaHistorial historial = new ListaHistorial();

        historial.visitarPagina("Google");
        historial.visitarPagina("YouTube");
        historial.visitarPagina("Facebook");

        historial.mostrarHistorial();

        historial.irAtras();
        historial.mostrarActual();

        historial.irAtras();
        historial.mostrarActual();

        historial.irAdelante();
        historial.mostrarActual();

        historial.visitarPagina("Twitter"); // elimina futuras

        historial.mostrarHistorial();
    }
}
