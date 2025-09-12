// components/BotonPersonalizado.java
package components;

import javax.swing.JButton;
import variables.Constantes;

public class BotonPersonalizado extends JButton {
    public BotonPersonalizado(String texto) {
        setText(texto);
        setBackground(Constantes.COLOR_BOTONES);
        setForeground(Constantes.COLOR_TEXTO);
        setFont(Constantes.FUENTE_BOTONES);
        setFocusPainted(false);
        setBorderPainted(false);
    }
}