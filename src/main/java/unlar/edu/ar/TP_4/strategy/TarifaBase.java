package unlar.edu.ar.TP_4.strategy;

public class TarifaBase implements TarifaStrategy {

    @Override
    public double calcularTarifa(double tarifaBase) {
        return tarifaBase;
    }

}