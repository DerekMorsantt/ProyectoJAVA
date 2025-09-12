// Main.java
import View.VentanaCalculadora;
import control.Controlador;

public class Main {
    public static void main(String[] args) {
        VentanaCalculadora vista = new VentanaCalculadora();
        Controlador controlador = new Controlador(vista);
        vista.setVisible(true);
    }
}