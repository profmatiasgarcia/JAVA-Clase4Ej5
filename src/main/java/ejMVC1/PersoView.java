package ejMVC1;
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
import javax.swing.*;

import java.awt.event.*;

class PersoView extends JFrame {

    private JTextField NyA = new JTextField(30);
    private JTextField Edad = new JTextField(10);
    private JButton m_setearNom = new JButton("Setear Nombre");
    private JButton m_SetearEdad = new JButton("Setear Edad");
    private JButton m_verNombre = new JButton("Ver Nombre almacenado");
    private JButton m_verEdad = new JButton("Ver Edad almacenada");

    // private JButton m_limpiarNombre = new JButton("Limpiar Nombre almacenado");
    // private JButton m_limpiarEdad = new JButton("Limpiar Edad almacenada");
    PersoModel m_model;

    public PersoView(PersoModel model) {

        m_model = model;
        
        setTitle("Ejemplo MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel content = new JPanel();
       
        content.add(new JLabel("Esta es la vista"));
        content.add(m_setearNom);
        content.add(m_SetearEdad);
        content.add(m_verNombre);
        content.add(m_verEdad);
        // content.add(m_limpiarNombre);
        // content.add(m_limpiarEdad);

        NyA.setText("Aqui ingrese el nombre");
        Edad.setText("Y aqui la edad");
        content.add(NyA);
        content.add(Edad);

        setContentPane(content);
        pack();

    }

    void reset() {
        NyA.setText("Nombre a ingresar");
        Edad.setText("Edad a ingresar");
    }

    String getUserInput() {
        return NyA.getText();
    }

    String getEdadInput() {
        return Edad.getText();
    }

    void setNyA(String Nom) {
        NyA.setText(Nom);
    }

    void setEdad(String E) {
        Edad.setText(E);
    }

    void addPersoSetNomListener(ActionListener mal) {
        m_setearNom.addActionListener(mal);

    }

    void addPersoSetEdadListener(ActionListener mal) {
        m_SetearEdad.addActionListener(mal);

    }

    void addPersoGetNomListener(ActionListener mal) {
        m_verNombre.addActionListener(mal);

    }

    void addPersoGetEdadListener(ActionListener mal) {
        m_verEdad.addActionListener(mal);

    }

}
