package escenario1;

public class Main {

    public static void main(String[] args) {

        ListaTurnos turnos = new ListaTurnos();

        turnos.agregarCliente("Juan");
        turnos.agregarCliente("Maria");
        turnos.agregarCliente("Pedro");

        turnos.mostrarTurnos();

        turnos.siguienteCliente();

        turnos.atenderCliente();
        turnos.mostrarTurnos();

        turnos.buscarCliente("Maria");
    }
}