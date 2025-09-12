package View;

import javax.swing.*;
import java.awt.*;
import components.BotonPersonalizado;
import variables.Constantes;

public class VentanaCalculadora extends JFrame {
    private JTextField display;

    public VentanaCalculadora() {
        configurarVentana();
        initComponentes();
    }

    private void configurarVentana() {
        setTitle("Calculadora Científica");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Constantes.COLOR_FONDO);
        setLayout(new BorderLayout());
    }

    private void initComponentes() {
        // Panel de display
        display = new JTextField("0");
        display.setFont(Constantes.FUENTE_DISPLAY);
        display.setBackground(Color.DARK_GRAY);
        display.setForeground(Color.WHITE);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(display, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(Constantes.COLOR_FONDO);
        panelBotones.setLayout(new GridLayout(5, 4, 5, 5));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Botones básicos primero
        String[] botones = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "√", "x²", "±"
        };

        for (String textoBoton : botones) {
            BotonPersonalizado boton = new BotonPersonalizado(textoBoton);
            panelBotones.add(boton);
        }

        add(panelBotones, BorderLayout.CENTER);
    }

    public JTextField getDisplay() {
        return display;
    }
}