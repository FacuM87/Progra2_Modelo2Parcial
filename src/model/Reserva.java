
package model;

import java.io.Serializable;


public class Reserva implements Serializable{
    private String cliente;
    private int idEvento;

    public Reserva(String cliente, int idEvento) {
        this.cliente = cliente;
        this.idEvento = idEvento;
    }

    @Override
    public String toString() {
        return "Reserva{" + "cliente=" + cliente + ", idEvento=" + idEvento + '}';
    }

    public int getIdEvento() {
        return idEvento;
    }
       
}
