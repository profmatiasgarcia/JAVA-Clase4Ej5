package ejMVC2;
/**
 * @author Prof Matias Garcia.
 * <p> Copyright (C) 2017 para <a href = "https://www.profmatiasgarcia.com.ar/"> www.profmatiasgarcia.com.ar </a>
 * - con licencia GNU GPL3.
 * <p> Este programa es software libre. Puede redistribuirlo y/o modificarlo bajo los términos de la
 * Licencia Pública General de GNU según es publicada por la Free Software Foundation, 
 * bien con la versión 3 de dicha Licencia o bien (según su elección) con cualquier versión posterior. 
 * Este programa se distribuye con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA, 
 * incluso sin la garantía MERCANTIL implícita o sin garantizar la CONVENIENCIA PARA UN PROPÓSITO
 * PARTICULAR. Véase la Licencia Pública General de GNU para más detalles.
 * Debería haber recibido una copia de la Licencia Pública General junto con este programa. 
 * Si no ha sido así ingrese a <a href = "http://www.gnu.org/licenses/"> GNU org </a>
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {

    private Modelo modelo;
    private Vista vista;
    private char opPendiente;
    private boolean estaIngresando;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        opPendiente = '+';
        estaIngresando = false;
    }

    public void ejecutar() {
        vista.addBoton0Listener(new Boton0Handler());
        vista.addBoton1Listener(new Boton1Handler());
        vista.addBoton2Listener(new Boton2Handler());
        vista.addBoton3Listener(new Boton3Handler());
        vista.addBoton4Listener(new Boton4Handler());
        vista.addBoton5Listener(new Boton5Handler());
        vista.addBoton6Listener(new Boton6Handler());
        vista.addBoton7Listener(new Boton7Handler());
        vista.addBoton8Listener(new Boton8Handler());
        vista.addBoton9Listener(new Boton9Handler());
        vista.addBotonCListener(new BotonCHandler());
        vista.addBotonIgualListener(new BotonIgualHandler());
        vista.addBotonSumaListener(new BotonSumaHandler());
        vista.addBotonRestaListener(new BotonRestaHandler());
        vista.addBotonProductoListener(new BotonProductoHandler());
        vista.addBotonCocienteListener(new BotonCocienteHandler());
        vista.escribirVisor(0);
    }

    private void procesarNumero(int n) {
        if (!estaIngresando) {
            estaIngresando = true;
            vista.escribirVisor(n);
            modelo.setActual(n);
        } else {
            vista.escribirVisor(vista.leerVisor() * 10 + n);
            modelo.setActual(vista.leerVisor());
        }
    }

    private void procesarOperacion(char op) {
        switch (opPendiente) {
            case '+':
                vista.escribirVisor(modelo.getSuma());
                break;
            case '-':
                vista.escribirVisor(modelo.getResta());
                break;
            case '*':
                vista.escribirVisor(modelo.getProducto());
                break;
            case '/':
                vista.escribirVisor(modelo.getCociente());
        }
        estaIngresando = false;
        opPendiente = op;
        modelo.setAcumulador(vista.leerVisor());
    }

    class Boton0Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            procesarNumero(0);
        }
    }

    class Boton1Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            procesarNumero(1);
        }
    }

    class Boton2Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            procesarNumero(2);
        }
    }

    class Boton3Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            procesarNumero(3);
        }
    }

    class Boton4Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            procesarNumero(4);
        }
    }

    class Boton5Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            procesarNumero(5);
        }
    }

    class Boton6Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            procesarNumero(6);
        }
    }

    class Boton7Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            procesarNumero(7);
        }
    }

    class Boton8Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            procesarNumero(8);
        }
    }

    class Boton9Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            procesarNumero(9);
        }
    }

    class BotonCHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            modelo.setActual(0);
            modelo.setAcumulador(0);
            vista.escribirVisor(0);
        }
    }

    class BotonIgualHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            procesarOperacion('=');
        }
    }

    class BotonSumaHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            procesarOperacion('+');
        }
    }

    class BotonRestaHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            procesarOperacion('-');
        }
    }

    class BotonProductoHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            procesarOperacion('*');
        }
    }

    class BotonCocienteHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            procesarOperacion('/');
        }
    }
}
