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

    private final ArrayList<Posto> postos;
    private final ArrayList<Posto> postosMostrados;
    private String LastSearchedBairro;
    
    public PostosTableModel() {
        postos = new ArrayList<>();
        postosMostrados = new ArrayList<>();
        LastSearchedBairro = "";
    }

    public void remove(int index) {
        postos.remove(postosMostrados.get(index));
	postosMostrados.remove(index);
	fireTableRowsDeleted(index, index);
    }

    public Posto select(int index) {
        return postosMostrados.get(index);
    }
    
    public void add(Posto p) {
        // Adds the element in the last position in the list
        postos.add(p);
        postosMostrados.add(p);
        updateTable(LastSearchedBairro);
        fireTableRowsInserted(postosMostrados.size()-1, postosMostrados.size()-1);
    }

    public void update(int index, Posto p) {
        postos.set(postos.indexOf(postosMostrados.get(index)), p);
        postosMostrados.set(index,p);
        updateTable(LastSearchedBairro);
        fireTableRowsUpdated(index, index);
    }
    
    public void updateTable(String Bairro){
        LastSearchedBairro = Bairro;
        postosMostrados.clear();
        for(Posto p : postos){
            if(p.getBairro().toLowerCase().contains(Bairro.toLowerCase())){
                postosMostrados.add(p);
            }
        }
        fireTableRowsInserted(postosMostrados.size()-1, postosMostrados.size()-1);
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
        return postosMostrados.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return postosMostrados.get(rowIndex).getNF();
            case 1: return postosMostrados.get(rowIndex).getBairro();
            case 2: return postosMostrados.get(rowIndex).getBandeira();
        }
        return null;
    }
    
}
