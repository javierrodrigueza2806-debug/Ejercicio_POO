package figuras_geometricas;

public class Cilindro extends Figura {

    double radio;
    double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
    }

    double calcular_volumen() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }

    double calcular_superficie() {
        return 2 * Math.PI * radio * (radio + altura);
    }
}
