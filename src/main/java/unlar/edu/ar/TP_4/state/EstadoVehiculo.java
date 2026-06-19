package unlar.edu.ar.TP_4.state;

import unlar.edu.ar.TP_4.model.Vehiculos;

public interface EstadoVehiculo {

    void iniciarViaje(Vehiculos vehiculo);

    void finalizarViaje(Vehiculos vehiculo);

    void enviarAReparacion(Vehiculos vehiculo);

    String getNombreEstado();

}