
package model;


public class EventoMusical extends Evento {
    private final String artista;
    private final PopularidadArtista popularidad;

    public EventoMusical(String artista, PopularidadArtista popularidad, String nombre, double costoBase, int capacidad, GestorReservas gestorReservas) {
        super(nombre, costoBase, capacidad, gestorReservas);
        this.artista = artista;
        this.popularidad = popularidad;
    }


    @Override
    public double calcularCostoFinal() {
        double factor = 1.0;
        
        switch (popularidad) {
            case BAJA -> factor = 1.1;
            case MEDIA -> factor = 1.3;
            case ALTA -> factor = 1.5;
        }

        return getCostoBase() * factor;
    }

    @Override
    public String toString() {
        return "EventoMusical{" + "artista=" + artista + ", popularidad=" + popularidad + '}';
    }
    
    
    
}
