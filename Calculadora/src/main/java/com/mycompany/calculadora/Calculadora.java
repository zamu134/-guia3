/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculadora;
import javax.swing.*;

/**
 *
 * @author thega
 */
public class Calculadora extends JFrame {

    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JTextField campoOpcion;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        campoNumero1 = new JTextField(10);
        campoNumero2 = new JTextField(10);
        campoOpcion = new JTextField(10);

        JLabel etiquetaNumero1 = new JLabel("Número 1:");
        JLabel etiquetaNumero2 = new JLabel("Número 2:");
        JLabel etiquetaOpcion = new JLabel("Opción (1-suma, 2-resta, 3-multiplicación, 4-división):");

        JPanel panel = new JPanel();
        panel.add(etiquetaNumero1);
        panel.add(campoNumero1);
        panel.add(etiquetaNumero2);
        panel.add(campoNumero2);
        panel.add(etiquetaOpcion);
        panel.add(campoOpcion);
        add(panel);

        campoOpcion.addActionListener(e -> realizarOperacion());
    }

    private void realizarOperacion() {
        try {
            double num1 = Double.parseDouble(campoNumero1.getText());
            double num2 = Double.parseDouble(campoNumero2.getText());
            int opcion = Integer.parseInt(campoOpcion.getText());

            double resultado = 0;

            switch (opcion) {
                case 1:
                    resultado = num1 + num2;
                    break;
                case 2:
                    resultado = num1 - num2;
                    break;
                case 3:
                    resultado = num1 * num2;
                    break;
                case 4:
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(this, "El divisor no puede ser cero.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }

            JOptionPane.showMessageDialog(this, "El resultado es: " + resultado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos (números reales) y una opción válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculadora().setVisible(true));
    }
}