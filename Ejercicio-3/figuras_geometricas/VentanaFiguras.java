package figuras_geometricas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaFiguras extends JFrame {

    private JComboBox<String> lista_figuras;
    private JTextField caja_radio;
    private JTextField caja_altura;
    private JTextField caja_base;
    private JTextField caja_apotema;
    private JLabel texto_volumen;
    private JLabel texto_superficie;

    public VentanaFiguras() {
        setTitle("Calculadora de figuras geometricas");
        setSize(500, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        crear_parte_datos();
        crear_parte_resultados();
    }

    private void crear_parte_datos() {
        JPanel panel_datos = new JPanel(new GridLayout(6, 2, 20, 12));
        panel_datos.setBorder(BorderFactory.createEmptyBorder(20, 25, 10, 25));

        lista_figuras = new JComboBox<String>();
        lista_figuras.addItem("Cilindro");
        lista_figuras.addItem("Esfera");
        lista_figuras.addItem("Piramide");

        caja_radio = new JTextField();
        caja_altura = new JTextField();
        caja_base = new JTextField();
        caja_apotema = new JTextField();

        panel_datos.add(new JLabel("Figura:"));
        panel_datos.add(lista_figuras);
        panel_datos.add(new JLabel("Radio:"));
        panel_datos.add(caja_radio);
        panel_datos.add(new JLabel("Altura:"));
        panel_datos.add(caja_altura);
        panel_datos.add(new JLabel("Base:"));
        panel_datos.add(caja_base);
        panel_datos.add(new JLabel("Apotema:"));
        panel_datos.add(caja_apotema);

        JButton boton_calcular = new JButton("Calcular");
        boton_calcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular_figura();
            }
        });

        JButton boton_limpiar = new JButton("Limpiar");
        boton_limpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiar_campos();
            }
        });

        panel_datos.add(boton_calcular);
        panel_datos.add(boton_limpiar);

        add(panel_datos, BorderLayout.CENTER);
    }

    private void crear_parte_resultados() {
        JPanel panel_resultados = new JPanel(new GridLayout(2, 1, 5, 5));
        panel_resultados.setBorder(BorderFactory.createEmptyBorder(5, 25, 25, 25));

        texto_volumen = new JLabel("Volumen: ");
        texto_superficie = new JLabel("Superficie: ");

        panel_resultados.add(texto_volumen);
        panel_resultados.add(texto_superficie);

        add(panel_resultados, BorderLayout.SOUTH);
    }

    private void calcular_figura() {
        try {
            Figura figura = crear_figura_elegida();
            DecimalFormat formato = new DecimalFormat("#.##");

            texto_volumen.setText("Volumen: " + formato.format(figura.calcular_volumen()) + " cm3");
            texto_superficie.setText("Superficie: " + formato.format(figura.calcular_superficie()) + " cm2");
        } catch(NumberFormatException error) {
            JOptionPane.showMessageDialog(this, "Ingresa solo numeros en los datos necesarios.");
        }
    }

    private Figura crear_figura_elegida() {
        String figura_elegida = lista_figuras.getSelectedItem().toString();

        if(figura_elegida.equals("Cilindro")) {
            double radio = Double.parseDouble(caja_radio.getText());
            double altura = Double.parseDouble(caja_altura.getText());

            return new Cilindro(radio, altura);
        }

        if(figura_elegida.equals("Esfera")) {
            double radio = Double.parseDouble(caja_radio.getText());

            return new Esfera(radio);
        }

        double base = Double.parseDouble(caja_base.getText());
        double altura = Double.parseDouble(caja_altura.getText());
        double apotema = Double.parseDouble(caja_apotema.getText());

        return new Piramide(base, altura, apotema);
    }

    private void limpiar_campos() {
        caja_radio.setText("");
        caja_altura.setText("");
        caja_base.setText("");
        caja_apotema.setText("");
        texto_volumen.setText("Volumen: ");
        texto_superficie.setText("Superficie: ");
    }
}
