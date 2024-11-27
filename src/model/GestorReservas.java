
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class GestorReservas {
    private List<Reserva> reservas;
    private final int capacidad;
    private GestorEventos gestorEventos;

    public GestorReservas(int capacidad, GestorEventos gestorEventos) {
        this.reservas = new ArrayList<>();
        this.capacidad = capacidad;
        this.gestorEventos = gestorEventos;
    }
    
    
    
    public boolean realizarReserva(String cliente, int idEvento){
        Optional<Evento> eventoOpt = gestorEventos.buscarPorId(idEvento);

        if (eventoOpt.isEmpty()) {
            System.out.println("El evento con ID " + idEvento + " no existe.");
            return false;
        }
        
        if(reservas.size() < capacidad){
            reservas.add(new Reserva(cliente, idEvento));
        } else {
            System.out.println(cliente + " no pudo efectuar reserva. Capacidad excedida");
            return false;
        }
        return false;
    };
    
    public int contarReservas(){
        return reservas.size();
    };
    
    
    public Map<Integer, Integer> estadisticasReservasPorEvento(){
        Map<Integer, Integer> estadisticas = new HashMap();
        
        for(Reserva reserva : reservas){
            Integer idEvento = reserva.getIdEvento();
            Integer cantidadReservasDelEvento = estadisticas.get(idEvento);
            
            if(cantidadReservasDelEvento == null){
                cantidadReservasDelEvento = 0;
            }
            
            estadisticas.put(idEvento, cantidadReservasDelEvento + 1);
            
        }
        
        return estadisticas;
    };
    

    @Override
    public String toString() {
        return "GestorReservas{" + "reservas=" + reservas + ", capacidad=" + capacidad + '}';
    }
    
}
