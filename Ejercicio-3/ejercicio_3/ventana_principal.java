package ejercicio_3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ventana_principal extends JFrame {

    private JTextField caja_cantidad_notas;
    private JTextField[] cajas_notas;
    private JPanel panel_notas;
    private JLabel texto_promedio;
    private JLabel texto_desviacion;
    private JLabel texto_nota_mayor;
    private JLabel texto_nota_menor;

    public ventana_principal() {
        setTitle("Calculadora de notas personal");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        crear_parte_superior();
        crear_parte_notas();
        crear_parte_resultados();
    }

    private void crear_parte_superior() {
        JPanel panel_arriba = new JPanel(new GridLayout(1, 3, 10, 10));
        panel_arriba.setBorder(BorderFactory.createEmptyBorder(15, 20, 5, 20));

        caja_cantidad_notas = new JTextField();
        JButton boton_crear_notas = new JButton("Crear notas");

        boton_crear_notas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crear_cajas_de_notas();
            }
        });

        panel_arriba.add(new JLabel("Cantidad de notas:"));
        panel_arriba.add(caja_cantidad_notas);
        panel_arriba.add(boton_crear_notas);

        add(panel_arriba, BorderLayout.NORTH);
    }

    private void crear_parte_notas() {
        panel_notas = new JPanel();
        panel_notas.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JScrollPane scroll_notas = new JScrollPane(panel_notas);
        add(scroll_notas, BorderLayout.CENTER);
    }

    private void crear_parte_resultados() {
        JPanel panel_abajo = new JPanel(new GridLayout(6, 1, 5, 5));
        panel_abajo.setBorder(BorderFactory.createEmptyBorder(5, 20, 20, 20));

        JButton boton_calcular = new JButton("Calcular");
        boton_calcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular_resultados();
            }
        });

        JButton boton_limpiar = new JButton("Limpiar");
        boton_limpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiar_campos();
            }
        });

        texto_promedio = new JLabel("Promedio: ");
        texto_desviacion = new JLabel("Desviacion estandar: ");
        texto_nota_mayor = new JLabel("Nota mayor: ");
        texto_nota_menor = new JLabel("Nota menor: ");

        panel_abajo.add(boton_calcular);
        panel_abajo.add(boton_limpiar);
        panel_abajo.add(texto_promedio);
        panel_abajo.add(texto_desviacion);
        panel_abajo.add(texto_nota_mayor);
        panel_abajo.add(texto_nota_menor);

        add(panel_abajo, BorderLayout.SOUTH);
    }

    private void crear_cajas_de_notas() {
        try {
            int cantidad_notas = Integer.parseInt(caja_cantidad_notas.getText());

            if(cantidad_notas <= 0){
                JOptionPane.showMessageDialog(this, "La cantidad de notas debe ser mayor que cero.");
                return;
            }

            cajas_notas = new JTextField[cantidad_notas];
            panel_notas.removeAll();
            panel_notas.setLayout(new GridLayout(cantidad_notas, 2, 25, 12));

            for(int i = 0; i < cajas_notas.length; i++){
                panel_notas.add(new JLabel("Nota " + (i + 1) + ":"));
                cajas_notas[i] = new JTextField();
                panel_notas.add(cajas_notas[i]);
            }

            limpiar_resultados();
            panel_notas.revalidate();
            panel_notas.repaint();
        } catch(NumberFormatException error) {
            JOptionPane.showMessageDialog(this, "Ingresa una cantidad valida de notas.");
        }
    }

    private void calcular_resultados() {
        if(cajas_notas == null){
            JOptionPane.showMessageDialog(this, "Primero crea las cajas de notas.");
            return;
        }

        Notas notas = new Notas(cajas_notas.length);

        try {
            for(int i = 0; i < cajas_notas.length; i++){
                notas.lista_notas[i] = Double.parseDouble(cajas_notas[i].getText());
            }

            DecimalFormat formato = new DecimalFormat("#.##");

            texto_promedio.setText("Promedio: " + formato.format(notas.calcular_promedio()));
            texto_desviacion.setText("Desviacion estandar: " + formato.format(notas.desviacio_estandar()));
            texto_nota_mayor.setText("Nota mayor: " + formato.format(notas.mayor_nota()));
            texto_nota_menor.setText("Nota menor: " + formato.format(notas.menor_nota()));
        } catch(NumberFormatException error) {
            JOptionPane.showMessageDialog(this, "Ingresa solo numeros en las notas.");
        }
    }

    private void limpiar_resultados() {
        texto_promedio.setText("Promedio: ");
        texto_desviacion.setText("Desviacion estandar: ");
        texto_nota_mayor.setText("Nota mayor: ");
        texto_nota_menor.setText("Nota menor: ");
    }

    private void limpiar_campos() {
        caja_cantidad_notas.setText("");

        if(cajas_notas != null){
            for(int i = 0; i < cajas_notas.length; i++){
                cajas_notas[i].setText("");
            }
        }

        limpiar_resultados();
    }
}
