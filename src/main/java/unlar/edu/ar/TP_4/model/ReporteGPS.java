package unlar.edu.ar.TP_4.model;

import java.util.Objects;

public class ReporteGPS {

    private double latitud;
    private double longitud;

    public ReporteGPS(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (!(o instanceof ReporteGPS))
            return false;

        ReporteGPS reporte = (ReporteGPS) o;

        return Double.compare(reporte.latitud, latitud) == 0 &&
                Double.compare(reporte.longitud, longitud) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitud, longitud);
    }

}