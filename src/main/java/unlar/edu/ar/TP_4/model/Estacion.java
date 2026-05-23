package unlar.edu.ar.TP_4.model;

import java.util.List;

public class Estacion {

    private String nombre;
    private List<Vehiculos> vehiculos;

    public Estacion(String nombre, List<Vehiculos> vehiculos) {
        this.nombre = nombre;
        this.vehiculos = vehiculos;
    }

    public Vehiculos buscarVehiculo(String patente) {

        for (Vehiculos v : vehiculos) {

            if (v.getPatente().equalsIgnoreCase(patente)) {
                return v;
            }
        }

        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Vehiculos> getVehiculos() {
        return vehiculos;
    }
}