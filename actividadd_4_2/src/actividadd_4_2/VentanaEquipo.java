package actividadd_4_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaEquipo extends JFrame {

    private JTextField campo_nombre_equipo;
    private JTextField campo_universidad;
    private JTextField campo_lenguaje;
    private JTextField[] campos_nombres;
    private JTextField[] campos_apellidos;
    private JTextArea area_resultado;

    public VentanaEquipo() {
        setTitle("Equipo para maraton de programacion");
        setSize(670, 560);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        armarVentana();
    }

    private void armarVentana() {
        JPanel panel_principal = new JPanel(new BorderLayout(12, 12));
        panel_principal.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        panel_principal.setBackground(new Color(239, 243, 246));

        JLabel titulo = new JLabel("Registro del equipo", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 21));
        panel_principal.add(titulo, BorderLayout.NORTH);

        JPanel panel_datos = new JPanel(new GridLayout(7, 3, 8, 8));
        panel_datos.setOpaque(false);
        panel_datos.setBorder(BorderFactory.createTitledBorder("Datos de la maraton"));

        campo_nombre_equipo = new JTextField();
        campo_universidad = new JTextField();
        campo_lenguaje = new JTextField();

        panel_datos.add(new JLabel("Nombre del equipo:"));
        panel_datos.add(campo_nombre_equipo);
        panel_datos.add(new JLabel(""));
        panel_datos.add(new JLabel("Universidad:"));
        panel_datos.add(campo_universidad);
        panel_datos.add(new JLabel(""));
        panel_datos.add(new JLabel("Lenguaje:"));
        panel_datos.add(campo_lenguaje);
        panel_datos.add(new JLabel(""));

        panel_datos.add(new JLabel("Integrante"));
        panel_datos.add(new JLabel("Nombre"));
        panel_datos.add(new JLabel("Apellidos"));

        campos_nombres = new JTextField[3];
        campos_apellidos = new JTextField[3];

        for (int i = 0; i < 3; i++) {
            campos_nombres[i] = new JTextField();
            campos_apellidos[i] = new JTextField();
            panel_datos.add(new JLabel("Programador " + (i + 1) + ":"));
            panel_datos.add(campos_nombres[i]);
            panel_datos.add(campos_apellidos[i]);
        }

        panel_principal.add(panel_datos, BorderLayout.CENTER);

        JPanel panel_inferior = new JPanel(new BorderLayout(8, 8));
        panel_inferior.setOpaque(false);

        area_resultado = new JTextArea(6, 45);
        area_resultado.setEditable(false);
        area_resultado.setFont(new Font("Monospaced", Font.PLAIN, 13));
        area_resultado.setText("Aqui se mostrara el equipo cuando los datos sean validos.");
        panel_inferior.add(new JScrollPane(area_resultado), BorderLayout.CENTER);

        JPanel panel_botones = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 2));
        panel_botones.setOpaque(false);
        JButton boton_registrar = new JButton("Registrar equipo");
        JButton boton_limpiar = new JButton("Limpiar");

        boton_registrar.addActionListener(evento -> registrarEquipo());
        boton_limpiar.addActionListener(evento -> limpiarFormulario());

        panel_botones.add(boton_registrar);
        panel_botones.add(boton_limpiar);
        panel_inferior.add(panel_botones, BorderLayout.SOUTH);
        panel_principal.add(panel_inferior, BorderLayout.SOUTH);

        setContentPane(panel_principal);
    }

    private void registrarEquipo() {
        try {
            EquipoMaratonProgramacion equipo = new EquipoMaratonProgramacion(
                    campo_nombre_equipo.getText(),
                    campo_universidad.getText(),
                    campo_lenguaje.getText());

            for (int i = 0; i < 3; i++) {
                String nombre_ingresado = campos_nombres[i].getText();
                String apellidos_ingresados = campos_apellidos[i].getText();

                EquipoMaratonProgramacion.validarCampo(
                        nombre_ingresado, "El nombre del programador " + (i + 1));
                EquipoMaratonProgramacion.validarCampo(
                        apellidos_ingresados, "Los apellidos del programador " + (i + 1));

                Programador nuevo_programador = new Programador(
                        nombre_ingresado.trim(), apellidos_ingresados.trim());
                equipo.anadirProgramador(nuevo_programador);
            }

            mostrarEquipo(equipo);
            JOptionPane.showMessageDialog(this,
                    "El equipo se registro correctamente.",
                    "Registro terminado",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (CampoInvalidoException | EquipoCompletoException error) {
            JOptionPane.showMessageDialog(this,
                    error.getMessage(),
                    "Revise los datos",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void mostrarEquipo(EquipoMaratonProgramacion equipo) {
        StringBuilder resumen = new StringBuilder();
        resumen.append("Equipo: ").append(equipo.getNombreEquipo()).append("\n");
        resumen.append("Universidad: ").append(equipo.getUniversidad()).append("\n");
        resumen.append("Lenguaje: ").append(equipo.getLenguajeProgramacion()).append("\n");
        resumen.append("Integrantes:\n");

        Programador[] integrantes = equipo.getProgramadores();
        for (int i = 0; i < integrantes.length; i++) {
            resumen.append("  ").append(i + 1).append(". ")
                    .append(integrantes[i]).append("\n");
        }

        area_resultado.setText(resumen.toString());
    }

    private void limpiarFormulario() {
        campo_nombre_equipo.setText("");
        campo_universidad.setText("");
        campo_lenguaje.setText("");

        for (int i = 0; i < 3; i++) {
            campos_nombres[i].setText("");
            campos_apellidos[i].setText("");
        }

        area_resultado.setText("Aqui se mostrara el equipo cuando los datos sean validos.");
        campo_nombre_equipo.requestFocusInWindow();
    }
}
