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

public class RegistroCuentasAccesoAleatorio extends RegistroCuentas {

    public static final int TAMANIO = 72;

    // el constructor sin argumentos llama al otro constructor con los valores
    // predeterminados
    public RegistroCuentasAccesoAleatorio() {
        this(0, "", "", 0.0);
    }

    // inicializar un objeto RegistroCuentasAccesoAleatorio
    public RegistroCuentasAccesoAleatorio(int cuenta, String primerNombre, String apellidoPaterno, double saldo) {
        super(cuenta, primerNombre, apellidoPaterno, saldo);
    }

    // leer un registro del objeto RandomAccecssFile especificado
    public void leer(RandomAccessFile archivo) throws IOException {
        establecerCuenta(archivo.readInt());
        establecerPrimerNombre(leerNombre(archivo));
        establecerApellidoPaterno(leerNombre(archivo));
        establecerSaldo(archivo.readDouble());
    }

    // asegurarse que el nombre sea de la longitud apropiada
    private String leerNombre(RandomAccessFile archivo) throws IOException {
        char nombre[] = new char[15], temp;

        for (int cuenta = 0; cuenta < nombre.length; cuenta++) {
            temp = archivo.readChar();
            nombre[cuenta] = temp;
        }

        return new String(nombre).replace('\0', ' ');
    }

    // escribir un registro en el objeto RandomAccessFile especificado
    public void escribir(RandomAccessFile archivo) throws IOException {
        archivo.writeInt(obtenerCuenta());
        escribirNombre(archivo, obtenerPrimerNombre());
        escribirNombre(archivo, obtenerApellidoPaterno());
        archivo.writeDouble(obtenerSaldo());
    }

    // escribir un nombre en el archivo; maximo 15 caracteres
    private void escribirNombre(RandomAccessFile archivo, String nombre) throws IOException {
        StringBuffer bufer = null;

        if (nombre != null) {
            bufer = new StringBuffer(nombre);
        } else {
            bufer = new StringBuffer(15);
        }

        bufer.setLength(15);
        archivo.writeChars(bufer.toString());
    }

}
