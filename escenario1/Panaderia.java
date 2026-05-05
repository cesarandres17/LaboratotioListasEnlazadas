package escenario1;

public class Panaderia {
    private ListaTurnos turnos;

    public Panaderia() {
        this.turnos = new ListaTurnos();
    }

    public void registrarCliente(String cliente) {
        turnos.agregarCliente(cliente);
        System.out.println("Cliente registrado: " + cliente);
    }

    public void atenderSiguienteCliente() {
        turnos.atenderCliente();
    }

    public void consultarSiguienteCliente() {
        turnos.siguienteCliente();
    }

    public void mostrarListaTurnos() {
        System.out.println("Lista de turnos actual:");
        turnos.mostrarTurnos();
    }

    public void buscarCliente(String nombre) {
        turnos.buscarCliente(nombre);
    }

    public static void main(String[] args) {
        Panaderia panaderia = new Panaderia();
        
        System.out.println("=== SISTEMA DE TURNOS - PANADERÍA ===");
        
        panaderia.registrarCliente("Ana");
        panaderia.registrarCliente("Carlos");
        panaderia.registrarCliente("María");
        panaderia.registrarCliente("Luis");
        panaderia.registrarCliente("Sofía");
        
        System.out.println("\nLista de turnos:");
        panaderia.mostrarListaTurnos();
        
        System.out.println("\nConsultando siguiente cliente:");
        panaderia.consultarSiguienteCliente();
        
        System.out.println("\nAtendiendo clientes:");
        panaderia.atenderSiguienteCliente();
        panaderia.atenderSiguienteCliente();
        
        System.out.println("\nLista de turnos después de atender:");
        panaderia.mostrarListaTurnos();
        
        System.out.println("\nConsultando siguiente cliente:");
        panaderia.consultarSiguienteCliente();
        
        System.out.println("\nBuscando cliente en la lista:");
        panaderia.buscarCliente("María");
        panaderia.buscarCliente("Pedro");
        
        System.out.println("\nAtendiendo todos los clientes restantes:");
        panaderia.atenderSiguienteCliente();
        panaderia.atenderSiguienteCliente();
        panaderia.atenderSiguienteCliente();
        
        System.out.println("\nIntentando atender cuando no hay clientes:");
        panaderia.atenderSiguienteCliente();
        
        System.out.println("\nEstado final:");
        panaderia.mostrarListaTurnos();
    }
}
