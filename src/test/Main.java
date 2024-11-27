package test;

import java.util.Map;
import model.Deportes;
import model.EventoDeportivo;
import model.EventoMusical;
import model.GestorEventos;
import model.GestorReservas;
import model.PersistenciaDatos;
import model.PopularidadArtista;

public class Main {

    public static void main(String[] args) {

        try {
            System.out.println(" ---- PRUEBAS 1 ---- ");
            GestorEventos gestorEventos = new GestorEventos();
            GestorReservas gestorReserva = new GestorReservas(100, gestorEventos);

            EventoDeportivo e1 = new EventoDeportivo(Deportes.FUTBOL, "Partido", 5000, 100, gestorReserva);
            EventoMusical e2 = new EventoMusical("Dillom", PopularidadArtista.ALTA, "Tour Argentina", 6000, 85, gestorReserva);

            EventoDeportivo e3 = new EventoDeportivo(Deportes.FUTBOL, "", 5000, 100, gestorReserva);

            System.out.println("--------------------------------");
        } catch (Exception e) {
            System.out.println("Error en pruebas 1: " + e.getMessage());
        }

        try {
            System.out.println(" ---- PRUEBAS 2 ---- ");
            GestorEventos gestorEventos1 = new GestorEventos();
            GestorReservas gestorReserva1 = new GestorReservas(3, gestorEventos1);

            EventoMusical e4 = new EventoMusical("PR", PopularidadArtista.BAJA, "Tour Argentina", 6000, 85, gestorReserva1);
            gestorEventos1.agregarEvento(e4);

            gestorReserva1.realizarReserva("Juan", e4.getId());
            gestorReserva1.realizarReserva("Maria", e4.getId());
            gestorReserva1.realizarReserva("Pepe", e4.getId());
            gestorReserva1.realizarReserva("Ana", e4.getId());

            gestorReserva1.realizarReserva("Juana", 15);

        } catch (Exception e) {
            System.out.println("Error en pruebas 2: " + e.getMessage());
        }

        try {
            System.out.println(" ---- PRUEBAS 3 ---- ");
            
            GestorEventos gestorEventos2 = new GestorEventos();
            GestorReservas gestorReserva2 = new GestorReservas(3, gestorEventos2);
            
            EventoDeportivo e5 = new EventoDeportivo(Deportes.FUTBOL, "Partido", 5000, 100, gestorReserva2);
            EventoMusical e6 = new EventoMusical("Dillom", PopularidadArtista.ALTA, "Tour Argentina", 6000, 85, gestorReserva2);
            EventoDeportivo e7 = new EventoDeportivo(Deportes.BASQUET, "Partido1", 8000, 100, gestorReserva2);
            
            gestorEventos2.agregarEvento(e5);
            gestorEventos2.agregarEvento(e6);
            gestorEventos2.agregarEvento(e7);
            
            System.out.println(gestorEventos2.consultarEventosPorCosto(9000));
            
            gestorReserva2.realizarReserva("Pepe", e5.getId());
            gestorReserva2.realizarReserva("Maria", e5.getId());
            gestorReserva2.realizarReserva("Jose", e6.getId());
            gestorReserva2.realizarReserva("Lorena", e7.getId());
            
            System.out.println(gestorReserva2.contarReservas());
            
            System.out.println(gestorReserva2.estadisticasReservasPorEvento());
            
        } catch (Exception e) {
            System.out.println("Error en pruebas 3: " + e.getMessage());
        }
        
        try{
            
            System.out.println(" ---- PRUEBAS 4 ---- ");
            
            GestorEventos gestorEventos3 = new GestorEventos();
            GestorReservas gestorReserva3 = new GestorReservas(3, gestorEventos3);
            
            EventoDeportivo e8 = new EventoDeportivo(Deportes.FUTBOL, "Partido", 5000, 100, gestorReserva3);
            EventoMusical e9 = new EventoMusical("Dillom", PopularidadArtista.ALTA, "Tour Argentina", 6000, 85, gestorReserva3);
            EventoDeportivo e10 = new EventoDeportivo(Deportes.BASQUET, "Partido1", 8000, 100, gestorReserva3);
            
            gestorEventos3.agregarEvento(e8);
            gestorEventos3.agregarEvento(e9);
            gestorEventos3.agregarEvento(e10);
            
            System.out.println(gestorEventos3.consultarEventosPorCosto(9000));
            
            gestorReserva3.realizarReserva("Pepe", e8.getId());
            gestorReserva3.realizarReserva("Maria", e8.getId());
            gestorReserva3.realizarReserva("Jose", e9.getId());
            gestorReserva3.realizarReserva("Lorena", e10.getId());
            
            System.out.println(gestorReserva3.contarReservas());
            
            System.out.println(gestorReserva3.estadisticasReservasPorEvento());
            
            PersistenciaDatos.saveAll("datos", gestorReserva3.estadisticasReservasPorEvento());
            Map<Integer, Integer> datos = PersistenciaDatos.loadAll("datos");
            
            System.out.println("Mostrando datos guardados en binario");
            System.out.println(datos);
        }catch(Exception e){
            System.out.println("Error en pruebas 4: " + e.getMessage());
        }

    }

}
