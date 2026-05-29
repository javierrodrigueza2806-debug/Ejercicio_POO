package ejercicio_3;

import javax.swing.SwingUtilities;

public class Ejercicio_3 {
      
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ventana_principal ventana = new ventana_principal();
                ventana.setVisible(true);
            }
        });
    }
}
