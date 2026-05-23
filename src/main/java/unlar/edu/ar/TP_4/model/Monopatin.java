package unlar.edu.ar.TP_4.model;

public class Monopatin extends Vehiculos {

    private boolean tieneAmortiguacion;

    public Monopatin(String patente, int bateria, double tarifaBase, boolean tieneAmortiguacion) {
        super(patente, bateria, tarifaBase);
        this.tieneAmortiguacion = tieneAmortiguacion;
    }

    public boolean isTieneAmortiguacion() {
        return tieneAmortiguacion;
    }
}