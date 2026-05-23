package unlar.edu.ar.TP_4.model;

public class UsuarioRegular extends Usuario {

    public UsuarioRegular(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public double calcularPago(double monto) {
        return monto;
    }
}