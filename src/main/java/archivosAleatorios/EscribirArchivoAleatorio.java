package archivosAleatorios;
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
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class EscribirArchivoAleatorio extends JFrame {

    private RandomAccessFile salida;
    private IUBanco interfazUsuario;
    private JButton botonEntrar, botonAbrir;

    private static final int NUMERO_REGISTROS = 100;

    // configurar GUI
    public EscribirArchivoAleatorio() {
        super("Escribir en archivo de acceso aleatorio");

        // crear instancia de la interfaz de usuario reutilizable IUBanco
        interfazUsuario = new IUBanco(4); // cuatro campos de texto
        getContentPane().add(interfazUsuario, BorderLayout.CENTER);

        // obtener referencia al bot�n de tarea gen�rico hacerTarea1 en IUBanco
        botonAbrir = interfazUsuario.obtenerBotonHacerTarea1();
        botonAbrir.setText("Abrir...");

        // registrar componente de escucha para llamar a abrirArchivo cuando se
        // oprima el bot�n
        botonAbrir.addActionListener(
                // clase interna an�nima para manejar evento de botonAbrir
                new ActionListener() {

            // permitir al usuario seleccionar el archivo a abrir
            public void actionPerformed(ActionEvent evento) {
                abrirArchivo();
            }

        } // fin de la clase interna an�nima

        ); // fin de la llamada a addActionListener

        // registrar componente de escucha de ventana para el evento de cierre
        // de ventana
        addWindowListener(
                // clase interna an�nima para manejar evento windowClosing
                new WindowAdapter() {

            // agregar registro en la GUI, despu�s cerrar el archivo
            public void windowClosing(WindowEvent evento) {
                if (salida != null) {
                    agregarRegistro();
                }

                cerrarArchivo();
            }

        } // fin de la clase interna an�nima

        ); // fin de la llamada a addWindowListener

        // obtener referencia al bot�n de tarea gen�rico hacerTarea2 en IUBanco
        botonEntrar = interfazUsuario.obtenerBotonHacerTarea2();
        botonEntrar.setText("Introducir");
        botonEntrar.setEnabled(false);

        // registrar componente de escucha para llamar a agregarRegistro cuando
        // se oprima el bot�n
        botonEntrar.addActionListener(
                // clase interna an�nima para manejar evento de botonEntrar
                new ActionListener() {

            // agregar registro al archivo
            public void actionPerformed(ActionEvent evento) {
                agregarRegistro();
            }

        } // fin de la clase interna an�nima

        ); // fin de la llamada a addActionListener

        setSize(400, 150);
        setVisible(true);
    }

    // permitir al usuario seleccionar el archivo a abrir
    private void abrirArchivo() {
        // mostrar cuadro de di�logo para que el usuario pueda seleccionar el
        // archivo
        JFileChooser selectorArchivo = new JFileChooser();
        selectorArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int resultado = selectorArchivo.showOpenDialog(this);

        // si el usuario hizo clic en el bot�n Cancelar del cuadro de di�logo,
        // regresar
        if (resultado == JFileChooser.CANCEL_OPTION) {
            return;
        }

        // obtener el archivo seleccionado
        File nombreArchivo = selectorArchivo.getSelectedFile();

        // mostrar error si el nombre de archivo es incorrecto
        if (nombreArchivo == null || nombreArchivo.getName().equals("")) {
            JOptionPane.showMessageDialog(this, "Nombre de archivo incorrecto", "Nombre de archivo incorrecto",
                    JOptionPane.ERROR_MESSAGE);
        } else {

            // abrir el archivo
            try {
                salida = new RandomAccessFile(nombreArchivo, "rw");
                botonEntrar.setEnabled(true);
                botonAbrir.setEnabled(false);
            } // procesar excepci�n que puede ocurrir al abrir el archivo
            catch (IOException excepcionES) {
                JOptionPane.showMessageDialog(this, "El archivo no existe", "Nombre de archivo incorrecto",
                        JOptionPane.ERROR_MESSAGE);
            }

        } // fin de instrucci�n else

    } // fin del m�todo abrirArchivo

    // cerrar el archivo y terminar la aplicaci�n
    private void cerrarArchivo() {
        // cerrar el archivo y salir
        try {
            if (salida != null) {
                salida.close();
            }

            System.exit(0);
        } // procesar excepci�n que puede ocurrir al cerrar el archivo
        catch (IOException excepcionES) {
            JOptionPane.showMessageDialog(this, "Error al cerrar el archivo", "Error", JOptionPane.ERROR_MESSAGE);

            System.exit(1);
        }

    } // fin del m�todo cerrarArchivo

    // agregar un registro al archivo
    private void agregarRegistro() {
        String campos[] = interfazUsuario.obtenerValoresCampos();

        // asegurarse que el campo cuenta tenga un valor
        if (!campos[IUBanco.CUENTA].equals("")) {

            // escribir valores en el archivo
            try {
                int numeroCuenta = Integer.parseInt(campos[IUBanco.CUENTA]);

                if (numeroCuenta > 0 && numeroCuenta <= NUMERO_REGISTROS) {
                    RegistroCuentasAccesoAleatorio registro = new RegistroCuentasAccesoAleatorio();

                    registro.establecerCuenta(numeroCuenta);

                    registro.establecerPrimerNombre(campos[IUBanco.PRIMERNOMBRE]);
                    registro.establecerApellidoPaterno(campos[IUBanco.APELLIDO]);
                    registro.establecerSaldo(Double.parseDouble(campos[IUBanco.SALDO]));

                    salida.seek((numeroCuenta - 1) * RegistroCuentasAccesoAleatorio.TAMANIO);
                    registro.escribir(salida);
                } else {
                    JOptionPane.showMessageDialog(this, "El n�mero de cuenta debe ser entre 0 y 100",
                            "N�mero de cuenta incorrecto", JOptionPane.ERROR_MESSAGE);
                }

                interfazUsuario.borrarCampos(); // borrar el contenido de los
                // campos de texto

            } // fin del bloque try
            // procesar formato incorrecto de n�mero de cuenta o saldo
            catch (NumberFormatException excepcionFormato) {
                JOptionPane.showMessageDialog(this, "N�mero de cuenta o saldo incorrectos",
                        "Formato de n�mero incorrecto", JOptionPane.ERROR_MESSAGE);
            } // procesar excepciones que pueden ocurrir al escribir en el archivo
            catch (IOException excepcionES) {
                JOptionPane.showMessageDialog(this, "Error al escribir en el archivo", "Excepci�n de ES",
                        JOptionPane.ERROR_MESSAGE);
                cerrarArchivo();
            }

        } // fin de instrucci�n if

    } // fin del m�todo agregarRegistro

    public static void main(String args[]) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        new EscribirArchivoAleatorio();
    }

} // fin de la clase EscribirArchivoAleatorio
