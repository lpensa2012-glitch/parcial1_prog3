package unlar.edu.ar.TP_4.pago;


public class PagoTarjeta implements ProcesadorPago {

    @Override
    public void cobrar(double monto) {

        System.out.println("Cobro exitoso de $" + monto + " realizado con Tarjeta");
    }
}
