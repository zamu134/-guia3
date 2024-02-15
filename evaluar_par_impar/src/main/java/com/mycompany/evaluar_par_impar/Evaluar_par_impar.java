/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.evaluar_par_impar;
import javax.swing.*;

/**
 *
 * @author thega
 */

public class Evaluar_par_impar extends JFrame {

    private JTextField campoNumero;

    public Evaluar_par_impar() {
        setTitle("Verificador Par/Impar");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
   
        campoNumero = new JTextField(10);

        JLabel etiquetaNumero = new JLabel("Ingresa un número:");

        // Configurar el layout
        JPanel panel = new JPanel();
        panel.add(etiquetaNumero);
        panel.add(campoNumero);
        add(panel);

        campoNumero.addActionListener(e -> verificarParImpar());
    }

    private void verificarParImpar() {
        try {
            int numero = Integer.parseInt(campoNumero.getText());
            if (numero <= 50) {
                String tipo = (numero % 2 == 0) ? "par" : "impar";
                JOptionPane.showMessageDialog(this, "El número " + numero + " es " + tipo + ".");
            } else {
                JOptionPane.showMessageDialog(this, "El número debe ser menor o igual que 50.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido (entero).", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Evaluar_par_impar().setVisible(true));
    }
}