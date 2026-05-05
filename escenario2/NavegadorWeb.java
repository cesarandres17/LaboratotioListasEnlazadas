package escenario2;

public class NavegadorWeb {
    private ListaHistorial historial;

    public NavegadorWeb() {
        this.historial = new ListaHistorial();
    }

    public void visitarPagina(String pagina) {
        historial.visitarPagina(pagina);
        System.out.println("Visitando: " + pagina);
    }

    public void irAtras() {
        historial.irAtras();
        historial.mostrarActual();
    }

    public void irAdelante() {
        historial.irAdelante();
        historial.mostrarActual();
    }

    public void mostrarPaginaActual() {
        historial.mostrarActual();
    }

    public void mostrarHistorialCompleto() {
        System.out.println("Historial completo:");
        historial.mostrarHistorial();
    }

    public static void main(String[] args) {
        NavegadorWeb navegador = new NavegadorWeb();
        
        System.out.println("=== DEMOSTRACIÓN NAVEGADOR WEB ===");
        
        navegador.visitarPagina("google.com");
        navegador.visitarPagina("facebook.com");
        navegador.visitarPagina("youtube.com");
        navegador.visitarPagina("github.com");
        
        System.out.println("\nPágina actual:");
        navegador.mostrarPaginaActual();
        
        System.out.println("\nHistorial completo:");
        navegador.mostrarHistorialCompleto();
        
        System.out.println("\nNavegando hacia atrás:");
        navegador.irAtras();
        navegador.irAtras();
        
        System.out.println("\nNavegando hacia adelante:");
        navegador.irAdelante();
        
        System.out.println("\nVisitando nueva página después de retroceder:");
        navegador.visitarPagina("stackoverflow.com");
        
        System.out.println("\nIntentando ir adelante (debería mostrar mensaje):");
        navegador.irAdelante();
        
        System.out.println("\nHistorial final:");
        navegador.mostrarHistorialCompleto();
    }
}
