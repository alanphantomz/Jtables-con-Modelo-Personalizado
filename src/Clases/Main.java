/*
 * Aplicación que permite adicionar, eliminar y modificar
 * elementos de una tabla, en este caso empleados
 *
 */
package Clases;

import Formularios.FrmPlanillaEmpleados;
/**
 *
 * @author alan
 */
public class Main {
    public static void main(String args[]){
        FrmPlanillaEmpleados frmPrincipal = new FrmPlanillaEmpleados();
        frmPrincipal.setLocationRelativeTo(null);
        frmPrincipal.setVisible(true);
    }
}
