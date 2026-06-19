package unlar.edu.ar.TP_4.strategy;

public class TarifaHoraPico implements TarifaStrategy {

    @Override
    public double calcularTarifa(double tarifaBase) {
        return tarifaBase * 1.30;
    }

}