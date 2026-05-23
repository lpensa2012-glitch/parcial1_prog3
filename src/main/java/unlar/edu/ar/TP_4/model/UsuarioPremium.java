package unlar.edu.ar.TP_4.model;

public class UsuarioPremium extends Usuario {

    private double descuento;

    public UsuarioPremium(int id, String nombre, double descuento) {
        super(id, nombre);
        this.descuento = descuento;
    }

    @Override
    public double calcularPago(double monto) {
        return monto - (monto * descuento);
    }

    public double getDescuento() {
        return descuento;
    }
}