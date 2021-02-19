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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vista {

    private JFrame marco;
    private JPanel panelVisor;
    private JPanel panelBotones;
    private JTextField visor;
    private JButton boton0;
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;
    private JButton boton5;
    private JButton boton6;
    private JButton boton7;
    private JButton boton8;
    private JButton boton9;
    private JButton botonC;
    private JButton botonIgual;
    private JButton botonSuma;
    private JButton botonResta;
    private JButton botonProducto;
    private JButton botonCociente;
        
    public Vista() {
        visor = new JTextField(20);
        visor.setHorizontalAlignment(JTextField.RIGHT);
        visor.setEditable(false);
        visor.setBackground(Color.white);

        panelVisor = new JPanel();
        panelVisor.setBackground(Color.CYAN);
        panelVisor.add(visor);

        boton0 = new JButton(" 0 ");
        boton1 = new JButton(" 1 ");
        boton2 = new JButton(" 2 ");
        boton3 = new JButton(" 3 ");
        boton4 = new JButton(" 4 ");
        boton5 = new JButton(" 5 ");
        boton6 = new JButton(" 6 ");
        boton7 = new JButton(" 7 ");
        boton8 = new JButton(" 8 ");
        boton9 = new JButton(" 9 ");
        botonC = new JButton(" C ");
        botonIgual = new JButton(" = ");
        botonSuma = new JButton(" + ");
        botonResta = new JButton(" - ");
        botonProducto = new JButton(" * ");
        botonCociente = new JButton(" / ");
        
        panelBotones = new JPanel();
        panelBotones.setBackground(Color.CYAN);
        panelBotones.setLayout(new GridLayout(4, 4, 2, 2));
        panelBotones.add(boton7);
        panelBotones.add(boton8);
        panelBotones.add(boton9);
        panelBotones.add(botonCociente);
        panelBotones.add(boton4);
        panelBotones.add(boton5);
        panelBotones.add(boton6);
        panelBotones.add(botonProducto);
        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);
        panelBotones.add(botonResta);
        panelBotones.add(boton0);
        panelBotones.add(botonC);
        panelBotones.add(botonIgual);
        panelBotones.add(botonSuma);

        marco = new JFrame("Calculadora");
        marco.setResizable(false);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.add(panelVisor, BorderLayout.NORTH);
        marco.add(panelBotones, BorderLayout.CENTER);
        marco.pack(); // Ajustar tamaño 
        marco.setLocationRelativeTo(null); // Centrar 
        marco.setVisible(true);
    }

    public void escribirVisor(double r) {
        String s = Double.toString(r);
        while ((s.contains(".") || s.contains(","))
                && (s.endsWith("0") || s.endsWith(".") || s.endsWith(","))) {
            s = s.substring(0, s.length() - 1);
        }
        visor.setText(s);
    }

    public double leerVisor() {
        return Double.parseDouble(visor.getText());
    }

    public void addBoton0Listener(ActionListener al) {
        boton0.addActionListener(al);
    }

    public void addBoton1Listener(ActionListener al) {
        boton1.addActionListener(al);
    }

    public void addBoton2Listener(ActionListener al) {
        boton2.addActionListener(al);
    }

    public void addBoton3Listener(ActionListener al) {
        boton3.addActionListener(al);
    }

    public void addBoton4Listener(ActionListener al) {
        boton4.addActionListener(al);
    }

    public void addBoton5Listener(ActionListener al) {
        boton5.addActionListener(al);
    }

    public void addBoton6Listener(ActionListener al) {
        boton6.addActionListener(al);
    }

    public void addBoton7Listener(ActionListener al) {
        boton7.addActionListener(al);
    }

    public void addBoton8Listener(ActionListener al) {
        boton8.addActionListener(al);
    }

    public void addBoton9Listener(ActionListener al) {
        boton9.addActionListener(al);
    }

    public void addBotonCListener(ActionListener al) {
        botonC.addActionListener(al);
    }

    public void addBotonIgualListener(ActionListener al) {
        botonIgual.addActionListener(al);
    }

    public void addBotonSumaListener(ActionListener al) {
        botonSuma.addActionListener(al);
    }

    public void addBotonRestaListener(ActionListener al) {
        botonResta.addActionListener(al);
    }

    public void addBotonProductoListener(ActionListener al) {
        botonProducto.addActionListener(al);
    }

    public void addBotonCocienteListener(ActionListener al) {
        botonCociente.addActionListener(al);
    }

}
