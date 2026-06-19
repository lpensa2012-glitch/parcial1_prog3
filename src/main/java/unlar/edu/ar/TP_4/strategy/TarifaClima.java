package unlar.edu.ar.TP_4.strategy;

public class TarifaClima implements TarifaStrategy {

    @Override
    public double calcularTarifa(double tarifaBase) {
        return tarifaBase * 1.15;
    }

}