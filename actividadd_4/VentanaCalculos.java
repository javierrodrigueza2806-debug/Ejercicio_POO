package actividadd_4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.InputMismatchException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaCalculos extends JFrame {

    private JTextField caja_valor;
    private JLabel texto_resultado_logaritmo;
    private JLabel texto_resultado_raiz;
    private CalculosNumericos calculadora;

    public VentanaCalculos() {
        calculadora = new CalculosNumericos();

        setTitle("Calculos numericos");
        setSize(520, 330);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        crear_interfaz();
    }

    private void crear_interfaz() {
        JPanel panel_principal = new JPanel(new BorderLayout(10, 15));
        panel_principal.setBorder(BorderFactory.createEmptyBorder(18, 25, 20, 25));
        panel_principal.setBackground(new Color(238, 242, 245));

        JLabel titulo = new JLabel("Calculadora de logaritmo y raiz", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel_principal.add(titulo, BorderLayout.NORTH);

        JPanel panel_centro = new JPanel(new GridLayout(3, 1, 8, 8));
        panel_centro.setOpaque(false);

        JPanel panel_entrada = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 4));
        panel_entrada.setOpaque(false);
        panel_entrada.add(new JLabel("Ingrese un numero:"));
        caja_valor = new JTextField(15);
        panel_entrada.add(caja_valor);

        texto_resultado_logaritmo = new JLabel("Logaritmo neperiano: --", JLabel.CENTER);
        texto_resultado_raiz = new JLabel("Raiz cuadrada: --", JLabel.CENTER);

        panel_centro.add(panel_entrada);
        panel_centro.add(texto_resultado_logaritmo);
        panel_centro.add(texto_resultado_raiz);
        panel_principal.add(panel_centro, BorderLayout.CENTER);

        JPanel panel_botones = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 3));
        panel_botones.setOpaque(false);

        JButton boton_calcular = new JButton("Calcular");
        JButton boton_limpiar = new JButton("Limpiar");

        boton_calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                calcular_resultados();
            }
        });

        boton_limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                limpiar_datos();
            }
        });

        caja_valor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                calcular_resultados();
            }
        });

        panel_botones.add(boton_calcular);
        panel_botones.add(boton_limpiar);
        panel_principal.add(panel_botones, BorderLayout.SOUTH);

        setContentPane(panel_principal);
    }

    private void calcular_resultados() {
        try {
            double valor_ingresado = Double.parseDouble(caja_valor.getText().trim());
            double resultado_logaritmo = calculadora.calcular_logaritmo_neperiano(valor_ingresado);
            double resultado_raiz = calculadora.calcular_raiz_cuadrada(valor_ingresado);

            DecimalFormat formato_numero = new DecimalFormat("0.####");
            texto_resultado_logaritmo.setText(
                    "Logaritmo neperiano: " + formato_numero.format(resultado_logaritmo));
            texto_resultado_raiz.setText(
                    "Raiz cuadrada: " + formato_numero.format(resultado_raiz));

        } catch (NumberFormatException | InputMismatchException error_entrada) {
            JOptionPane.showMessageDialog(this,
                    "Debe ingresar un numero valido.",
                    "Dato incorrecto",
                    JOptionPane.WARNING_MESSAGE);
            limpiar_resultados();

        } catch (ArithmeticException error_calculo) {
            JOptionPane.showMessageDialog(this,
                    error_calculo.getMessage(),
                    "No se puede calcular",
                    JOptionPane.ERROR_MESSAGE);
            limpiar_resultados();

        } finally {
            caja_valor.requestFocusInWindow();
            caja_valor.selectAll();
        }
    }

    private void limpiar_resultados() {
        texto_resultado_logaritmo.setText("Logaritmo neperiano: --");
        texto_resultado_raiz.setText("Raiz cuadrada: --");
    }

    private void limpiar_datos() {
        caja_valor.setText("");
        limpiar_resultados();
        caja_valor.requestFocusInWindow();
    }

}
