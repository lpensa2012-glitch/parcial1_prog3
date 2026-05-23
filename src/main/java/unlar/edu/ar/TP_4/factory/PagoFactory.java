package unlar.edu.ar.TP_4.factory;

import unlar.edu.ar.TP_4.pago.PagoBilletera;
import unlar.edu.ar.TP_4.pago.PagoTarjeta;
import unlar.edu.ar.TP_4.pago.ProcesadorPago;

public class PagoFactory {

    public static ProcesadorPago crearPago(String metodo) {

        if (metodo.equalsIgnoreCase("TARJETA")) {
            return new PagoTarjeta();
        }

        if (metodo.equalsIgnoreCase("BILLETERA")) {
            return new PagoBilletera();
        }

        throw new RuntimeException("Metodo de pago invalido");
    }
}