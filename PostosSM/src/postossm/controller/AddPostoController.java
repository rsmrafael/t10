/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package postossm.controller;

import postossm.view.AddPostoView;
import postossm.model.PostosTableModel;
import postossm.model.PrecosTableModel;
import postossm.model.Posto;
import postossm.model.Preco;
import postossm.view.PostossmView;

/**
 *
 * @author Rafa
 */
public class AddPostoController {
    
    private final AddPostoView view;
    private final PostosTableModel model;
    private final PostossmView HomeFrame;
    private final PrecosTableModel PrecoTable;
    
  public AddPostoController(AddPostoView view,PostossmView HomeFrame, PostosTableModel model, PrecosTableModel PrecoTable) {
        this.view = view;
        this.model = model;
        this.HomeFrame = HomeFrame;
        this.PrecoTable = PrecoTable;
    }
    
    public void add() {
        //Adiciona posto
        Posto p = newFromView();
        if (p != null) {
            model.add(p);
        }
        //Retorna para frame original
        HomeFrame.setVisible(true);
        view.dispose();
    }
    
    public void addPrice(){
        Preco p = newPriceFromView();
        if (p != null) {
            PrecoTable.add(p);
        }
    }
    public void removePrice(){
        int index = view.getPriceTable().getSelectedRow();
        if (index == -1) {
            return;
        }
        PrecoTable.remove(index);
    }
    public void cancel() {
        //Retorna para frame original
        HomeFrame.setVisible(true);
        view.dispose();
    }
       
    public void updatePrice() {
        //Captura indice de preço
        int index = view.getPriceTable().getSelectedRow();
        if (index == -1) {
            view.showError("Selecione um preço para atualizar!");
            return;
        }
        //Atualiza preço
        Preco p = newPriceFromView();
        if (p != null) {
            PrecoTable.update(index,p);
        }
    }
    
    private Preco newPriceFromView() {
        try {
            Preco p = new Preco();
            p.setPrice(Float.parseFloat(view.getTextPrice().getText()));
            p.setTipo(view.getTipo());
            p.getDia().setDate(Integer.parseInt(view.getTextDia().getText()));
            p.getDia().setMonth(Integer.parseInt(view.getTextMes().getText())-1);
            p.getDia().setYear(Integer.parseInt(view.getTextAno().getText()));
            return p;
        } catch (NumberFormatException e) {
            view.showError("Dado(s) de entrada invalido(s)!");
            return null;
        }
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
            p.setPriceList(PrecoTable.getList());
            return p;
        } catch (NumberFormatException e) {
            view.showError("Dado(s) de entrada invalido(s)!");
            return null;
        }
    }
}
