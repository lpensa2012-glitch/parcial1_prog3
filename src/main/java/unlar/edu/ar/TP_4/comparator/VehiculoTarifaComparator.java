package unlar.edu.ar.TP_4.comparator;

import java.util.Comparator;

import unlar.edu.ar.TP_4.model.Vehiculos;

public class VehiculoTarifaComparator implements Comparator<Vehiculos> {

    @Override
    public int compare(Vehiculos v1, Vehiculos v2) {

        return Double.compare(
                v1.getTarifaBase(),
                v2.getTarifaBase());

    }

}