package actividadd_4;

public class CalculosNumericos {

    public double calcular_logaritmo_neperiano(double valor) {
        if (valor <= 0) {
            throw new ArithmeticException("El valor debe ser mayor que cero.");
        }

        return Math.log(valor);
    }

    public double calcular_raiz_cuadrada(double valor) {
        if (valor < 0) {
            throw new ArithmeticException("No se puede calcular la raiz de un numero negativo.");
        }

        return Math.sqrt(valor);
    }
}
