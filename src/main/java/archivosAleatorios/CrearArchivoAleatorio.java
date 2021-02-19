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
import java.io.*;
import javax.swing.*;

public class CrearArchivoAleatorio {

    private static final int NUMERO_REGISTROS = 100;

    // permitir al usuario seleccionar el archivo a abrir
    private void crearArchivo() {
        // mostrar cuadro de dialogo para que el usuario pueda seleccionar el
        // archivo
        JFileChooser selectorArchivo = new JFileChooser();
        selectorArchivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int resultado = selectorArchivo.showSaveDialog(null);

        // si el usuario hizo clic en el boton Cancelar del cuadro de dialogo,
        // regresar
        if (resultado == JFileChooser.CANCEL_OPTION) {
            return;
        }

        // obtener el archivo seleccionado
        File nombreArchivo = selectorArchivo.getSelectedFile();

        // mostrar error si el nombre del archivo es invalido
        if (nombreArchivo == null || nombreArchivo.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "Nombre de archivo incorrecto", "Nombre de archivo incorrecto",
                    JOptionPane.ERROR_MESSAGE);
        } else {

            // abrir el archivo
            try {
                RandomAccessFile archivo = new RandomAccessFile(nombreArchivo, "rw");

                RegistroCuentasAccesoAleatorio registroEnBlanco = new RegistroCuentasAccesoAleatorio();

                // escribir 100 registros en blanco
                for (int cuenta = 0; cuenta < NUMERO_REGISTROS; cuenta++) {
                    registroEnBlanco.escribir(archivo);
                }

                archivo.close(); // cerrar el archivo

                // mostrar mensaje indicando que el archivo se creo
                JOptionPane.showMessageDialog(null, "Se creó el archivo " + nombreArchivo, "Estado",
                        JOptionPane.INFORMATION_MESSAGE);

                System.exit(0); // terminar el programa

            } // fin del bloque try
            // procesar excepciones durante operaciones de apertura, escritura o
            // cierre del archivo
            catch (IOException excepcionES) {
                JOptionPane.showMessageDialog(null, "Error al procesar el archivo", "Error al procesar el archivo",
                        JOptionPane.ERROR_MESSAGE);

                System.exit(1);
            }

        } // fin else

    } // fin metodo

    public static void main(String args[]) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        CrearArchivoAleatorio aplicacion = new CrearArchivoAleatorio();
        aplicacion.crearArchivo();
    }

}
