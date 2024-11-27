package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestorEventos {

    private final List<Evento> eventos;

    public GestorEventos() {
        this.eventos = new ArrayList<>();
    }
    

    public boolean agregarEvento(Evento evento) {
        if (evento != null) {
            eventos.add(evento);
            return true;
        }
        return false;
    };
    
    public Optional<Evento> buscarPorId(int id) {
        for (Evento evento : eventos) {
            if (evento.getId() == id) {
                return Optional.of(evento);
            }
        }
        return Optional.empty();
    }

    public List<Evento> consultarEventosPorCosto(double costoMin) {
        List<Evento> listaRetorno = new ArrayList<>();

        for (Evento e : eventos) {
            if (e.calcularCostoFinal() >= costoMin) {
                listaRetorno.add(e);
            }
        }

        return listaRetorno;
    };

    @Override
    public String toString() {
        return "GestorEventos{" + "eventos=" + eventos + '}';
    }
    
}
