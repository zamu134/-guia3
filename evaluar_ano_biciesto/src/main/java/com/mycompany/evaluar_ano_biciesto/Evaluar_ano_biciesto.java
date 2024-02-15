/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.evaluar_ano_biciesto;
import javax.swing.*;

/**
 *
 * @author thega
 */
public class Evaluar_ano_biciesto extends JFrame {

     private JTextField campoAnio;

    public Evaluar_ano_biciesto() {
        setTitle("Verificador de Año Bisiesto");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        campoAnio = new JTextField(10);

        JLabel etiquetaAnio = new JLabel("Ingresa un año:");

        JPanel panel = new JPanel();
        panel.add(etiquetaAnio);
        panel.add(campoAnio);
        add(panel);

        campoAnio.addActionListener(e -> verificarBisiesto());
    }

    private void verificarBisiesto() {
        try {
            int anio = Integer.parseInt(campoAnio.getText());
            String mensaje = esBisiesto(anio) ? " es un año bisiesto." : " no es un año bisiesto.";
            JOptionPane.showMessageDialog(this, anio + mensaje);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un año válido (número entero).", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean esBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Evaluar_ano_biciesto().setVisible(true));
    }
}