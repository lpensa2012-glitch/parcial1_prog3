package unlar.edu.ar.TP_4.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import unlar.edu.ar.TP_4.comparator.VehiculoTarifaComparator;
import unlar.edu.ar.TP_4.model.ReporteGPS;
import unlar.edu.ar.TP_4.model.Vehiculos;

@Service
public class ReporteGpsService {

    // Elimina reportes GPS duplicados utilizando HashSet
    public List<ReporteGPS> eliminarDuplicados(List<ReporteGPS> reportes) {

        HashSet<ReporteGPS> reportesUnicos = new HashSet<>();

        for (ReporteGPS reporte : reportes) {
            reportesUnicos.add(reporte);
        }

        return new ArrayList<>(reportesUnicos);
    }

    // Ordenamiento natural (Comparable) por batería
    public List<Vehiculos> ordenarPorBateria(List<Vehiculos> vehiculos) {

        Collections.sort(vehiculos);

        return vehiculos;
    }

    // Ordenamiento alternativo (Comparator) por tarifa base
    public List<Vehiculos> ordenarPorTarifa(List<Vehiculos> vehiculos) {

        Collections.sort(vehiculos, new VehiculoTarifaComparator());

        return vehiculos;
    }

}