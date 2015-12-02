/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package postossm.controller;

import javax.swing.SwingUtilities;
import postossm.model.Posto;
import postossm.view.AddPostoView;
import postossm.model.PostosSimpleTableModel;

/**
 *
 * @author Rafa
 */
public class AddPostoController {
    
    private AddPostoView view;
    private PostosSimpleTableModel model;
    
  public AddPostoController(AddPostoView view, PostosSimpleTableModel model) {
        this.view = view;
        this.model = model;
    }
    
    public void add() {
        //Adiciona posto
        Posto p = newFromView();
        if (p != null) {
            model.add(p);
        }
        //Fecha janela
        view.dispose();
    }

    public void cancel() {
        //Fecha janela
        view.dispose();
    }
    
    private Posto newFromView() {
        try {
            Posto p = new Posto();
            p.setCNPJ(view.getTextCNPJ().getText());
            p.setRS(view.getTextRS().getText());
            p.setNF(view.getTextNF().getText());
            p.setBandeira(view.getTextBandeira().getText());
            p.setEndereco(view.getTextEndereco().getText());
            p.setBairro(view.getTextBairro().getText());
            p.setCEP(view.getTextCEP().getText());
            p.setImgPath(view.getTextImgPath().getText());
            return p;
        } catch (NumberFormatException e) {
            view.showError("Dado(s) de entrada invalido(s)!");
            return null;
        }
    }
}
