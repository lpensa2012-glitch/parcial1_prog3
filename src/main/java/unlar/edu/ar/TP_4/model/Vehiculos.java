package unlar.edu.ar.TP_4.model;

import unlar.edu.ar.TP_4.state.EstadoEnEspera;
import unlar.edu.ar.TP_4.state.EstadoVehiculo;

public abstract class Vehiculos implements Comparable<Vehiculos> {

    protected String patente;
    protected int bateria;
    protected double tarifaBase;

    // Estado actual del vehículo
    protected EstadoVehiculo estado;

    public Vehiculos(String patente, int bateria, double tarifaBase) {
        this.patente = patente;
        this.bateria = bateria;
        this.tarifaBase = tarifaBase;

        // Todo vehículo comienza en espera
        this.estado = new EstadoEnEspera();
    }

    public String getPatente() {
        return patente;
    }

    public int getBateria() {
        return bateria;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }

    public void iniciarViaje() {
        estado.iniciarViaje(this);
    }

    public void finalizarViaje() {
        estado.finalizarViaje(this);
    }

    public void enviarAReparacion() {
        estado.enviarAReparacion(this);
    }

    @Override
    public int compareTo(Vehiculos otro) {
        return Integer.compare(this.bateria, otro.bateria);
    }
}