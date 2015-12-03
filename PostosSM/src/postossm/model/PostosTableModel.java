/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postossm.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafa
 */
public class PostosTableModel extends AbstractTableModel  {
    private static final String[] columnNames = {"Posto", "Bairro", "Bandeira"};

    private ArrayList<Posto> postos;
    
    public PostosTableModel() {
        postos = new ArrayList<Posto>();
    }

    public void remove(int index) {
	postos.remove(index);
	fireTableRowsDeleted(index, index);
    }

    public Posto select(int index) {
        return postos.get(index);
    }
    
    public void add(Posto p) {
        // Adds the element in the last position in the list
        postos.add(p);
        fireTableRowsInserted(postos.size()-1, postos.size()-1);
    }

    public void update(int index, Posto p) {
        postos.set(index, p);
        fireTableRowsUpdated(index, index);
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return postos.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return postos.get(rowIndex).getNF();
            case 1: return postos.get(rowIndex).getBairro();
            case 2: return postos.get(rowIndex).getBandeira();
        }
        return null;
    }
    
}
