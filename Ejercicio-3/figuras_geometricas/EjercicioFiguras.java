package figuras_geometricas;

import javax.swing.SwingUtilities;

public class EjercicioFiguras {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VentanaFiguras ventana = new VentanaFiguras();
                ventana.setVisible(true);
            }
        });
    }
}
