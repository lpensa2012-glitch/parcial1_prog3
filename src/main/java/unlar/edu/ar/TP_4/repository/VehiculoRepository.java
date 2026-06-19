package unlar.edu.ar.TP_4.repository;

import java.util.HashMap;
import unlar.edu.ar.TP_4.model.Vehiculos;

public class VehiculoRepository {

    private HashMap<String, Vehiculos> vehiculos = new HashMap<>();

    public void guardar(Vehiculos vehiculo) {
        vehiculos.put(vehiculo.getPatente(), vehiculo);
    }

    public Vehiculos buscarPorPatente(String patente) {
        return vehiculos.get(patente);
    }

    public void eliminar(String patente) {
        vehiculos.remove(patente);
    }

    public HashMap<String, Vehiculos> obtenerVehiculos() {
        return vehiculos;
    }
}