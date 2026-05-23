package unlar.edu.ar.TP_4.service;

import unlar.edu.ar.TP_4.dto.SolicitudDto;
import unlar.edu.ar.TP_4.factory.PagoFactory;
import unlar.edu.ar.TP_4.model.BicicletaElectrica;
import unlar.edu.ar.TP_4.model.Estacion;
import unlar.edu.ar.TP_4.model.Monopatin;
import unlar.edu.ar.TP_4.model.Usuario;
import unlar.edu.ar.TP_4.model.UsuarioPremium;
import unlar.edu.ar.TP_4.model.UsuarioRegular;
import unlar.edu.ar.TP_4.model.Vehiculos;
import unlar.edu.ar.TP_4.pago.ProcesadorPago;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlquilerService {

    private Estacion estacion;
    private List<Usuario> usuarios;

    public AlquilerService() {

        List<Vehiculos> vehiculos = new ArrayList<>();

        vehiculos.add(
                new Monopatin("AAA111", 80, 500, true)
        );

        vehiculos.add(
                new BicicletaElectrica("BBB222", 10, 700, 30)
        );

        estacion = new Estacion("Centro", vehiculos);

        usuarios = new ArrayList<>();

        usuarios.add(
                new UsuarioRegular(1, "Juan")
        );

        usuarios.add(
                new UsuarioPremium(2, "Maria", 0.15)
        );
    }

    public String desbloquear(SolicitudDto dto) {

        Vehiculos vehiculo = estacion.buscarVehiculo(dto.getPatente());

        if (vehiculo == null) {
            throw new RuntimeException("Vehiculo no encontrado");
        }

        if (vehiculo.getBateria() < 15) {
            throw new RuntimeException("Bateria insuficiente");
        }

        Usuario usuarioEncontrado = null;

        for (Usuario u : usuarios) {
            if (u.getId() == dto.getIdUsuario()) {
                usuarioEncontrado = u;
            }
        }

        if (usuarioEncontrado == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        double montoFinal = usuarioEncontrado.calcularPago(
                vehiculo.getTarifaBase()
        );

        ProcesadorPago pago = PagoFactory.crearPago(dto.getMetodoPago());

        pago.cobrar(montoFinal);

        return "Vehiculo desbloqueado correctamente. Monto cobrado: $" + montoFinal;
    }
}