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
public class PrecosTableModel extends AbstractTableModel  {
    private static final String[] columnNames = {"Data", "Combustível", "Preço"};

    private ArrayList<Preco> precos;
    
    public PrecosTableModel() {
        precos = new ArrayList<Preco>();
    }
    
    public PrecosTableModel(ArrayList<Preco> precos) {
        this.precos = precos;
    }

    public void remove(int index) {
	precos.remove(index);
	fireTableRowsDeleted(index, index);
    }

    public Preco select(int index) {
        return precos.get(index);
    }
    
    public void add(Preco p) {
        // Adds the element in the last position in the list
        precos.add(p);
        fireTableRowsInserted(precos.size()-1, precos.size()-1);
    }

    public void update(int index, Preco p) {
        precos.set(index, p);
        fireTableRowsUpdated(index, index);
    }
    
    public ArrayList<Preco> getList(){
        return precos;
    }
    
    public void setList(ArrayList<Preco> List){
        this.precos = List;
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
        return precos.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return precos.get(rowIndex).getDia();
            case 1: return precos.get(rowIndex).getTipo();
            case 2: return precos.get(rowIndex).getPrice();
        }
        return null;
    }
    
}
