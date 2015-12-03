/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postossm.controller;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
    
    public void save() throws FileNotFoundException, IOException {
        Object[] options = {"Sim",
                    "Não"};
        int n = JOptionPane.showOptionDialog(view,
            "Esta opção poderá sobrescrever dados antigos.\nDeseja continuar?",
            "Confirmar operação",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,     //do not use a custom Icon
            options,  //the titles of buttons
            options[0]); //default button title);
        if(n == JOptionPane.YES_OPTION){
            //Abre arquivo
            FileOutputStream saveFile = new FileOutputStream("Data.sav");
            //Salva dados
            try ( //Salva dados
                    ObjectOutputStream save = new ObjectOutputStream(saveFile)) {
                //Salva dados
                save.writeObject(model.getList());
            }
        }
    }
    
    public void load(){
        try{
        // Open file to read from, named SavedObj.sav.
            FileInputStream saveFile = new FileInputStream("Data.sav");
            try ( // Create an ObjectInputStream to get objects from save file.
                    ObjectInputStream save = new ObjectInputStream(saveFile)) {
                model.setList((ArrayList<Posto>) save.readObject());
                view.getTextBuscaBairro().setText("");
                model.updateTable("");
            }
        }
        catch(IOException | ClassNotFoundException exc){
        }
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

    private ObjectOutputStream ObjectOutputStream(FileOutputStream saveFile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
