package unlar.edu.ar.TP_4.state;

import unlar.edu.ar.TP_4.model.Vehiculos;

public class EstadoEnEspera implements EstadoVehiculo {

    @Override
    public void iniciarViaje(Vehiculos vehiculo) {
        vehiculo.setEstado(new EstadoEnViaje());
        System.out.println("El vehículo inició un viaje.");
    }

    @Override
    public void finalizarViaje(Vehiculos vehiculo) {
        System.out.println("El vehículo ya se encuentra en espera.");
    }

    @Override
    public void enviarAReparacion(Vehiculos vehiculo) {
        vehiculo.setEstado(new EstadoEnReparacion());
        System.out.println("El vehículo fue enviado a reparación.");
    }

    @Override
    public String getNombreEstado() {
        return "EN ESPERA";
    }
}