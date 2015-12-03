/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postossm.controller;

import javax.swing.SwingUtilities;
import postossm.model.Posto;
import postossm.model.PostosTableModel;
import postossm.view.PostossmView;
import postossm.view.AddPostoView;
import postossm.view.UpdateVisualizePostoView;

/**
 *
 * @author Rafa
 */
public class PostossmController {
    
    private final PostossmView view;
    private final PostosTableModel model;
    
    public void insert() {
        //Chama outra janela
    }

    public PostossmController(PostossmView view, PostosTableModel model) {
        this.view = view;
        this.model = model;
    }
    
    public void save() {
        //Salva dados
    }
    
    public void load(){
        //Carrega dados
    }
    
    public void add(){ 
        // Abre novo frame
        view.setVisible(false);
        new AddPostoView(view,model).setVisible(true);
    }
    
    public void VisualizeUpdate(){
        int index = view.getPostosSimpleTable().getSelectedRow();
        if (index == -1) {
            return;
        }
        // Abrir novo frame utilizando os dados do posto com o indice index
        view.setVisible(false);
        new UpdateVisualizePostoView(view,model,index).setVisible(true);
    }
    
    public void remove() {
        int index = view.getPostosSimpleTable().getSelectedRow();
        if (index == -1) {
            return;
        }
        model.remove(index);
    }

    public void buscar(){
        model.updateTable(view.getTextBuscaBairro().getText());
    }
}
