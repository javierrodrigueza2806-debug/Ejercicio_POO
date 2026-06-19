package actividadd_4;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Principal {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception error_apariencia) {
            System.out.println("Se usara la apariencia normal de Java.");
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaCalculos ventana_principal = new VentanaCalculos();
                ventana_principal.setVisible(true);
            }
        });
    }
}
