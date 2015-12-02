/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postossm.controller;

import javax.swing.SwingUtilities;
import postossm.model.Posto;
import postossm.model.PostosSimpleTableModel;
import postossm.view.PostossmView;
import postossm.view.AddPostoView;

/**
 *
 * @author Rafa
 */
public class PostossmController {
    
    private PostossmView view;
    private PostosSimpleTableModel model;
    
    public void insert() {
        //Chama outra janela
    }

    public PostossmController(PostossmView view, PostosSimpleTableModel model) {
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
        new AddPostoView(model).setVisible(true);
    }
    
    public void VisualizeUpdate(){
        int index = view.getPostosSimpleTable().getSelectedRow();
        if (index == -1) {
            return;
        }
        // Abrir novo frame utilizando os dados do posto com o indice index
    }
    
    public void remove() {
        int index = view.getPostosSimpleTable().getSelectedRow();
        if (index == -1) {
            return;
        }
        model.remove(index);
    }

}
