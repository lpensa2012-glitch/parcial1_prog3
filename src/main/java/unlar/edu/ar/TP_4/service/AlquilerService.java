package unlar.edu.ar.TP_4.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import unlar.edu.ar.TP_4.dto.SolicitudDto;
import unlar.edu.ar.TP_4.factory.PagoFactory;
import unlar.edu.ar.TP_4.model.BicicletaElectrica;
import unlar.edu.ar.TP_4.model.Monopatin;
import unlar.edu.ar.TP_4.model.Usuario;
import unlar.edu.ar.TP_4.model.UsuarioPremium;
import unlar.edu.ar.TP_4.model.UsuarioRegular;
import unlar.edu.ar.TP_4.model.Vehiculos;
import unlar.edu.ar.TP_4.pago.ProcesadorPago;
import unlar.edu.ar.TP_4.repository.VehiculoRepository;
import unlar.edu.ar.TP_4.strategy.TarifaBase;
import unlar.edu.ar.TP_4.strategy.TarifaStrategy;

@Service
public class AlquilerService {

    private List<Usuario> usuarios;
    private VehiculoRepository vehiculoRepository;

    public AlquilerService() {

        vehiculoRepository = new VehiculoRepository();

        Monopatin monopatin = new Monopatin("AAA111", 80, 500, true);
        BicicletaElectrica bicicleta = new BicicletaElectrica("BBB222", 10, 700, 30);

        vehiculoRepository.guardar(monopatin);
        vehiculoRepository.guardar(bicicleta);

        usuarios = new ArrayList<>();

        usuarios.add(new UsuarioRegular(1, "Juan"));
        usuarios.add(new UsuarioPremium(2, "Maria", 0.15));
    }

    public String desbloquear(SolicitudDto dto) {

        Vehiculos vehiculo = vehiculoRepository.buscarPorPatente(dto.getPatente());

        if (vehiculo == null) {
            throw new RuntimeException("Vehículo no encontrado");
        }

        if (vehiculo.getBateria() < 15) {
            throw new RuntimeException("Batería insuficiente");
        }

        Usuario usuarioEncontrado = null;

        for (Usuario u : usuarios) {
            if (u.getId() == dto.getIdUsuario()) {
                usuarioEncontrado = u;
                break;
            }
        }

        if (usuarioEncontrado == null) {
            throw new RuntimeException("Usuario no encontrado");
        }

        // Patrón Strategy
        TarifaStrategy estrategia = new TarifaBase();

        double tarifaCalculada = estrategia.calcularTarifa(
                vehiculo.getTarifaBase()
        );

        double montoFinal = usuarioEncontrado.calcularPago(
                tarifaCalculada
        );

        ProcesadorPago pago = PagoFactory.crearPago(dto.getMetodoPago());

        pago.cobrar(montoFinal);

        return "Vehículo desbloqueado correctamente. Monto cobrado: $" + montoFinal;
    }
}