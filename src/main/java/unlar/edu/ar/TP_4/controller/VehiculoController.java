package unlar.edu.ar.TP_4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import unlar.edu.ar.TP_4.model.Vehiculos;
import unlar.edu.ar.TP_4.service.ReporteGpsService;
import unlar.edu.ar.TP_4.service.VehiculoService;

@RestController
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private ReporteGpsService reporteGpsService;

    @GetMapping("/api/vehiculos/prioridad-carga")
    public List<Vehiculos> prioridadCarga() {
        return reporteGpsService.ordenarPorBateria(
                vehiculoService.obtenerVehiculos());
    }

    @GetMapping("/api/vehiculos/tarifa-descendente")
    public List<Vehiculos> tarifaDescendente() {
        return reporteGpsService.ordenarPorTarifa(
                vehiculoService.obtenerVehiculos());
    }
}