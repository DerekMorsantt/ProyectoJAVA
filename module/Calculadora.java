// module/Calculadora.java
package module;

public class Calculadora {
    private double primerOperando;
    private double segundoOperando;
    private String operacion;
    private boolean nuevoNumero;

    public Calculadora() {
        reset();
    }

    public void reset() {
        primerOperando = 0;
        segundoOperando = 0;
        operacion = "";
        nuevoNumero = true;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
        nuevoNumero = true;
    }

    public void agregarNumero(String numero) {
        if (nuevoNumero) {
            setDisplay(numero);
            nuevoNumero = false;
        } else {
            setDisplay(getDisplay() + numero);
        }
    }

    public void calcular() {
        if (!operacion.isEmpty()) {
            segundoOperando = Double.parseDouble(getDisplay());
            
            switch (operacion) {
                case "+":
                    primerOperando += segundoOperando;
                    break;
                case "-":
                    primerOperando -= segundoOperando;
                    break;
                case "*":
                    primerOperando *= segundoOperando;
                    break;
                case "/":
                    if (segundoOperando != 0) {
                        primerOperando /= segundoOperando;
                    } else {
                        setDisplay("Error");
                        return;
                    }
                    break;
                case "^":
                    primerOperando = Math.pow(primerOperando, segundoOperando);
                    break;
            }
            
            setDisplay(String.valueOf(primerOperando));
            operacion = "";
        }
    }

    public void realizarOperacionEspecial(String operacion) {
        double valor = Double.parseDouble(getDisplay());
        
        switch (operacion) {
            case "√":
                if (valor >= 0) {
                    setDisplay(String.valueOf(Math.sqrt(valor)));
                } else {
                    setDisplay("Error");
                }
                break;
            case "x²":
                setDisplay(String.valueOf(valor * valor));
                break;
            case "x³":
                setDisplay(String.valueOf(valor * valor * valor));
                break;
            case "sin":
                setDisplay(String.valueOf(Math.sin(Math.toRadians(valor))));
                break;
            case "cos":
                setDisplay(String.valueOf(Math.cos(Math.toRadians(valor))));
                break;
            case "tan":
                setDisplay(String.valueOf(Math.tan(Math.toRadians(valor))));
                break;
            case "x!":
                if (valor >= 0 && valor == (int) valor) {
                    int factorial = 1;
                    for (int i = 2; i <= (int) valor; i++) {
                        factorial *= i;
                    }
                    setDisplay(String.valueOf(factorial));
                } else {
                    setDisplay("Error");
                }
                break;
            case "π":
                setDisplay(String.valueOf(Math.PI));
                break;
            case "e":
                setDisplay(String.valueOf(Math.E));
                break;
            case "±":
                setDisplay(String.valueOf(-valor));
                break;
        }
    }

    public void prepararParaNuevaOperacion() {
        if (!getDisplay().equals("Error")) {
            primerOperando = Double.parseDouble(getDisplay());
            nuevoNumero = true;
        }
    }

    private String getDisplay() {
        return "0";
    }

    private void setDisplay(String valor) {
        
    }
}