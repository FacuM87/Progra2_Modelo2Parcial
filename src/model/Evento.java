
package model;

import java.io.Serializable;


public abstract class Evento implements Serializable {
    private static int idCounter = 1;
    protected int id;
    protected String nombre;
    protected double costoBase;
    protected int capacidad;
    protected GestorReservas gestorReservas;

    public Evento(String nombre, double costoBase, int capacidad, GestorReservas gestorReservas) {
        this.id = idCounter++;
        if(nombre.equals("")){
            throw new IllegalArgumentException("El campo nombre es requerido");
        } else {
            this.nombre = nombre;
        }
        
        this.costoBase = costoBase;
        if(capacidad>=1){
            this.capacidad = capacidad;
        } else {
            throw new IllegalArgumentException("La capacidad no puede ser menor a 1");
        }
        
        this.gestorReservas = gestorReservas;
    }

    
    public abstract double calcularCostoFinal();

    public double getCostoBase() {
        return costoBase;
    }

    public int getId() {
        return id;
    }
    
    
}
