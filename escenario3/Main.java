public class Main {
    public static void main(String[] args){
        ListaSimpleCircular<String> playlist = new ListaSimpleCircular<>();
        
        playlist.agregarCancion("Bajo De La Piel - Milo J");
        playlist.agregarCancion("Ella - Milo J");
        playlist.agregarCancion("Ama De Mi Sol - Milo J");
        playlist.agregarCancion("Tu - Milo J");
        playlist.agregarCancion("Rara - Milo J");
        System.out.println("IMPRIMIR LISTA");
        playlist.imprimirLista();
        System.out.println("eliminar");
        playlist.eliminarCancion(0);
        playlist.imprimirLista();
        System.out.println("BUSCAR");
        playlist.buscarPorIndice(1);
        
        
    }
}