package unlar.edu.ar.TP_4.model;

public abstract class Vehiculos {

    protected String patente;
    protected int bateria;
    protected double tarifaBase;

    public Vehiculos(String patente, int bateria, double tarifaBase) {
        this.patente = patente;
        this.bateria = bateria;
        this.tarifaBase = tarifaBase;
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
}