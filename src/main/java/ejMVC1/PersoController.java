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
import java.awt.event.*;

public class PersoController {

    private PersoModel m_model;
    private PersoView m_view;

    public PersoController(PersoModel model, PersoView view) {
        m_model = model;
        m_view = view;

        // Se agregan los listeners a la vista
        view.addPersoSetNomListener(new PersoSetNomListener());

        view.addPersoSetEdadListener(new PersoSetEdadListener());

        view.addPersoGetNomListener(new PersoGetNomListener());

        view.addPersoGetEdadListener(new PersoGetEdadListener());

    }

    class PersoSetNomListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String userInput = "";

            userInput = m_view.getUserInput();

            m_model.setNombre(userInput);
            m_view.setNyA("");

        }
    }

    class PersoGetNomListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String nya = m_model.getNom();

            m_view.setNyA(nya);

        }
    }

    class PersoGetEdadListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            int edad = m_model.getEdad();

            String edadstr = String.valueOf(edad);

            m_view.setEdad(edadstr);

        }
    }

    class PersoSetEdadListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String edadstr = "";

            edadstr = m_view.getEdadInput();
            int edad = Integer.parseInt(edadstr);

            m_model.setEdad(edad);
            m_view.setEdad("");

        }
    }

    class ClearListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            m_view.reset();
        }
    }
}
