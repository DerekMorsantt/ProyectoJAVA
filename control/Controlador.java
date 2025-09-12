package control;

import View.VentanaCalculadora;
import components.BotonPersonalizado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.JPanel;

public class Controlador implements ActionListener {
    private VentanaCalculadora vista;
    private double primerNumero = 0;
    private String operacion = "";
    private boolean esperandoSegundoNumero = false;

    public Controlador(VentanaCalculadora vista) {
        this.vista = vista;
        registrarBotones();
    }

    private void registrarBotones() {
        Component[] components = vista.getContentPane().getComponents();
        for (Component comp : components) {
            if (comp instanceof JPanel) {
                JPanel panel = (JPanel) comp;
                for (Component button : panel.getComponents()) {
                    if (button instanceof BotonPersonalizado) {
                        ((BotonPersonalizado) button).addActionListener(this);
                    }
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        switch (comando) {
            case "C":
                vista.getDisplay().setText("0");
                primerNumero = 0;
                operacion = "";
                esperandoSegundoNumero = false;
                break;
                
            case "=":
                calcularResultado();
                esperandoSegundoNumero = false;
                break;
                
            case "+":
            case "-":
            case "*":
            case "/":
                if (!esperandoSegundoNumero) {
                    primerNumero = Double.parseDouble(vista.getDisplay().getText());
                    operacion = comando;
                    esperandoSegundoNumero = true;
                } else {
                    // Si ya estábamos esperando un segundo número, calcular primero
                    calcularResultado();
                    operacion = comando;
                }
                break;
                
            case "√":
                calcularRaiz();
                break;
                
            case "x²":
                calcularCuadrado();
                break;
                
            case "±":
                cambiarSigno();
                break;
                
            default:
                // Números y punto decimal
                if (esperandoSegundoNumero) {
                    vista.getDisplay().setText(comando);
                    esperandoSegundoNumero = false;
                } else {
                    agregarAlDisplay(comando);
                }
                break;
        }
    }

    private void agregarAlDisplay(String valor) {
        String textoActual = vista.getDisplay().getText();
        if (textoActual.equals("0") && !valor.equals(".")) {
            vista.getDisplay().setText(valor);
        } else {
            vista.getDisplay().setText(textoActual + valor);
        }
    }

    private void calcularResultado() {
        if (operacion.isEmpty()) return;
        
        double segundoNumero = Double.parseDouble(vista.getDisplay().getText());
        double resultado = 0;
        
        if (operacion.equals("*") && primerNumero == 69 && segundoNumero == 69) {
            vista.getDisplay().setText("Jorge Khalifa ft.Javier Marin");
            primerNumero = 0;
            operacion = "";
            return;
        }
        
        switch (operacion) {
            case "+":
                resultado = primerNumero + segundoNumero;
                break;
            case "-":
                resultado = primerNumero - segundoNumero;
                break;
            case "*":
                resultado = primerNumero * segundoNumero;
                break;
            case "/":
                if (segundoNumero != 0) {
                    resultado = primerNumero / segundoNumero;
                } else {
                    vista.getDisplay().setText("Error");
                    return;
                }
                break;
        }
        
        if (resultado == (int) resultado) {
            vista.getDisplay().setText(String.valueOf((int) resultado));
        } else {
            vista.getDisplay().setText(String.valueOf(resultado));
        }
        
        // Preparar para la siguiente operación
        primerNumero = resultado;
    }

    private void calcularRaiz() {
        double numero = Double.parseDouble(vista.getDisplay().getText());
        if (numero >= 0) {
            double resultado = Math.sqrt(numero);
            if (resultado == (int) resultado) {
                vista.getDisplay().setText(String.valueOf((int) resultado));
            } else {
                vista.getDisplay().setText(String.valueOf(resultado));
            }
        } else {
            vista.getDisplay().setText("Error");
        }
    }

    private void calcularCuadrado() {
        double numero = Double.parseDouble(vista.getDisplay().getText());
        double resultado = numero * numero;
        if (resultado == (int) resultado) {
            vista.getDisplay().setText(String.valueOf((int) resultado));
        } else {
            vista.getDisplay().setText(String.valueOf(resultado));
        }
    }

    private void cambiarSigno() {
        double numero = Double.parseDouble(vista.getDisplay().getText());
        numero = -numero;
        if (numero == (int) numero) {
            vista.getDisplay().setText(String.valueOf((int) numero));
        } else {
            vista.getDisplay().setText(String.valueOf(numero));
        }
    }
}