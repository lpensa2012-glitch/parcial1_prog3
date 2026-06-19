package unlar.edu.ar.TP_4.state;

import unlar.edu.ar.TP_4.model.Vehiculos;

public class EstadoEnReparacion implements EstadoVehiculo {

    @Override
    public void iniciarViaje(Vehiculos vehiculo) {
        System.out.println("No se puede iniciar un viaje. El vehículo está en reparación.");
    }

    @Override
    public void finalizarViaje(Vehiculos vehiculo) {
        System.out.println("El vehículo no está realizando un viaje.");
    }

    @Override
    public void enviarAReparacion(Vehiculos vehiculo) {
        System.out.println("El vehículo ya está en reparación.");
    }

    @Override
    public String getNombreEstado() {
        return "EN REPARACIÓN";
    }
}