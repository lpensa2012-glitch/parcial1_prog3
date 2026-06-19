package unlar.edu.ar.TP_4.state;

import unlar.edu.ar.TP_4.model.Vehiculos;

public class EstadoEnViaje implements EstadoVehiculo {

    @Override
    public void iniciarViaje(Vehiculos vehiculo) {
        System.out.println("El vehículo ya está en viaje.");
    }

    @Override
    public void finalizarViaje(Vehiculos vehiculo) {
        vehiculo.setEstado(new EstadoEnEspera());
        System.out.println("El viaje finalizó. El vehículo vuelve a estar en espera.");
    }

    @Override
    public void enviarAReparacion(Vehiculos vehiculo) {
        vehiculo.setEstado(new EstadoEnReparacion());
        System.out.println("El vehículo fue enviado a reparación.");
    }

    @Override
    public String getNombreEstado() {
        return "EN VIAJE";
    }
}