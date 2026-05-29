package figuras_geometricas;

public class Piramide extends Figura {

    double base;
    double altura;
    double apotema;

    public Piramide(double base, double altura, double apotema) {
        this.base = base;
        this.altura = altura;
        this.apotema = apotema;
    }

    double calcular_volumen() {
        return (Math.pow(base, 2) * altura) / 3;
    }

    double calcular_superficie() {
        double area_base = Math.pow(base, 2);
        double area_lateral = 2 * base * apotema;

        return area_base + area_lateral;
    }
}
