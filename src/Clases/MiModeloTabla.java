/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.LinkedList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author alan
 */
public class MiModeloTabla implements TableModel
{
    private LinkedList elementos = new LinkedList();
    
    /**
     * El JTable será un suscriptor 
     */
    private LinkedList suscriptores = new LinkedList();

    @Override
    public int getRowCount() {
        return elementos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex){
            case 0: return "Nombre";
            case 1: return "Apellido";
            case 2: return "ci";
            case 3: return "turno";
            case 4: return "sueldo";
            default: return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // devuelve la clase que hay en cada columna
        switch(columnIndex){
            case 0: return String.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return String.class;
            case 4: return Float.class;
            default: return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // permite que la celda sea editable
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Empleado aux;
        
        // Se obtiene el empleado de la fila indicada
        aux = (Empleado)(elementos.get(rowIndex));
        
        // Se obtiene el campo apropiado
        switch(columnIndex){
            case 0: return aux.getNombre();
            case 1: return aux.getApellido();
            case 2: return aux.getCi();
            case 3: return aux.getTurno();
            case 4: return aux.getSueldo();
            default: return null;
        }
    }
    
    public void borrarEmpleado(int row){
        if(this.getRowCount() <= 0) return;
        elementos.remove(row);
        
        // avisamos a los suscriptores de lo sucedido
        TableModelEvent evento = new TableModelEvent(this, row, row,
                TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
        avisaSuscriptores(evento);
        
    }
    
    public void aniadeEmpleado(Empleado emp){
        elementos.add(emp);
        
        // Avisar a los suscriptores
        TableModelEvent evento = new TableModelEvent(this, this.getRowCount()-1,
                this.getRowCount()-1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        avisaSuscriptores(evento);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         // Obtiene la persona de la fila indicada
        Empleado emp;
        emp = (Empleado)(elementos.get(rowIndex));
        
        // Cambia el campo de Persona que indica columnIndex, poniendole el 
        // aValue que se nos pasa.
        switch (columnIndex)
        {
            case 0:
                emp.setNombre((String)aValue);
                break;
            case 1:
                emp.setApellido((String)aValue);
                break;
            case 2:
                emp.setCi((String)aValue);
                break;
            case 3:
                emp.setTurno((String)aValue);
                break;
            case 4:
                emp.setSueldo((Float)aValue);
            default:
                break;
        }
        
        // Avisa a los suscriptores del cambio, creando un TableModelEvent ...
        TableModelEvent evento = new TableModelEvent (this, rowIndex, rowIndex, 
            columnIndex);

        // ... y pasándoselo a los suscriptores.
        avisaSuscriptores (evento);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        suscriptores.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        suscriptores.remove(l);
    }
    
    private void avisaSuscriptores(TableModelEvent evento){
        int i;
        for(i = 0; i < suscriptores.size(); i++)
            ((TableModelListener)suscriptores.get(i)).tableChanged(evento);
    }
    
}
