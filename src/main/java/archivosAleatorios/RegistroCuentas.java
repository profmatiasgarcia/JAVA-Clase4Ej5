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
import java.io.Serializable;

public class RegistroCuentas implements Serializable {

    private int cuenta;
    private String primerNombre;
    private String apellidoPaterno;
    private double saldo;

    // el constructor sin argumentos llama al otro constructor con valores
    // predeterminados
    public RegistroCuentas() {
        this(0, "", "", 0.0);
    }

    // inicializar un registro
    public RegistroCuentas(int cta, String nombre, String apellido, double sald) {
        establecerCuenta(cta);
        establecerPrimerNombre(nombre);
        establecerApellidoPaterno(apellido);
        establecerSaldo(sald);
    }

    // establecer numero de cuenta
    public void establecerCuenta(int cta) {
        cuenta = cta;
    }

    // obtener numero de cuenta
    public int obtenerCuenta() {
        return cuenta;
    }

    // establecer primer nombre
    public void establecerPrimerNombre(String nombre) {
        primerNombre = nombre;
    }

    // obtener primer nombre
    public String obtenerPrimerNombre() {
        return primerNombre;
    }

    // establecer apellido paterno
    public void establecerApellidoPaterno(String apellido) {
        apellidoPaterno = apellido;
    }

    // obtener apellido paterno
    public String obtenerApellidoPaterno() {
        return apellidoPaterno;
    }

    // establecer saldo
    public void establecerSaldo(double sald) {
        saldo = sald;
    }

    // obtener saldo
    public double obtenerSaldo() {
        return saldo;
    }

}
