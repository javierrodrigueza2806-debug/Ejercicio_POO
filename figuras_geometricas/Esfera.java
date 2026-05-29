package figuras_geometricas;

public class Esfera extends Figura {

    double radio;

    public Esfera(double radio) {
        this.radio = radio;
    }

    double calcular_volumen() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
    }

    double calcular_superficie() {
        return 4 * Math.PI * Math.pow(radio, 2);
    }
}
