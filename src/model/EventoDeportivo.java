package model;

public class EventoDeportivo extends Evento {

    private Deportes deporte;

    public EventoDeportivo(Deportes deporte, String nombre, double costoBase, int capacidad, GestorReservas gestorReservas) {
        super(nombre, costoBase, capacidad, gestorReservas);
        this.deporte = deporte;
    }


    @Override
    public double calcularCostoFinal() {
        double factor = 1.0;
        
        switch (deporte) {
            case FUTBOL -> factor = 1.2;
            case BASQUET -> factor = 1.1;
            case AUTOMOVILISMO -> factor = 1.5;
        }

        return getCostoBase() * factor;
    };

    @Override
    public String toString() {
        return "EventoDeportivo{" + "deporte=" + deporte + '}';
    }
    
    

}
