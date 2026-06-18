package actividadd_4_2;

import javax.swing.SwingUtilities;

public class Principal {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaEquipo ventana = new VentanaEquipo();
            ventana.setVisible(true);
        });
    }
}
