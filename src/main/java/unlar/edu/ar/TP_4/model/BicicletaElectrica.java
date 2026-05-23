package unlar.edu.ar.TP_4.model;

public class BicicletaElectrica extends Vehiculos {

    private double capacidadCanasto;

    public BicicletaElectrica(String patente, int bateria, double tarifaBase, double capacidadCanasto) {
        super(patente, bateria, tarifaBase);
        this.capacidadCanasto = capacidadCanasto;
    }

    public double getCapacidadCanasto() {
        return capacidadCanasto;
    }
}