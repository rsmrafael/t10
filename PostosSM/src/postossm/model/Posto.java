/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postossm.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Rafa
 */

public class Posto implements Serializable{
    
    // Atributes
    private String CNPJ;
    private String RazaoSocial;
    private String NomeFantasia;
    private String Bandeira;
    private String Endereco;
    private String Bairro;
    private String CEP;
    private String ImgPath;
    private ArrayList<Preco> PriceHistory;
    
    // Contrusctor
    public Posto (){
        this.CNPJ = "";
        this.RazaoSocial = "";
        this.NomeFantasia = "";
        this.Bandeira = "";
        this.Endereco = "";
        this.Bairro = "";
        this.CEP = "";
        this.ImgPath = "";
        this.PriceHistory = new ArrayList<>();
    }
    public Posto (String CNPJ, String RS, String NF, String Band, String E, String Bairro, String CEP, String Img){
        this.CNPJ = CNPJ;
        this.RazaoSocial = RS;
        this.NomeFantasia = NF;
        this.Bandeira = Band;
        this.Endereco = E;
        this.Bairro = Bairro;
        this.CEP = CEP;
        this.ImgPath = Img;
        this.PriceHistory = new ArrayList<>();
    }
    
    public void setCNPJ(String CNPJ){
        this.CNPJ = CNPJ;
    }
    
    public void setRS(String RS){
        this.RazaoSocial = RS;
    }
    
    public void setNF(String NF){
        this.NomeFantasia = NF;
    }
    
    public void setBandeira(String Band){
        this.Bandeira = Band;
    }
    
    public void setEndereco(String E){
        this.Endereco = E;
    }
    
    public void setBairro(String Bairro){
        this.Bairro = Bairro;
    }
    
    public void setCEP(String CEP){
        this.CEP = CEP;
    }
    
    public void setImgPath(String Img){
        this.ImgPath = Img;
    }
    
    public void setPriceList(ArrayList<Preco> List){
        this.PriceHistory = List;
    }
    
    public void addPrice(Preco p){
        this.PriceHistory.add(p);
    }
    
    public String getCNPJ( ){
        return CNPJ;
    }
    
    public String getRS( ){
        return RazaoSocial;
    }
    
    public String getNF( ){
        return NomeFantasia;
    }
    
    public String getBandeira( ){
        return Bandeira;
    }
    
    public String getEndereco( ){
        return Endereco;
    }
    
    public String getBairro( ){
        return Bairro;
    }
    
    public String getCEP( ){
        return  CEP;
    }
    
    public String getImgPath( ){
        return ImgPath;
    }
    
    public ArrayList<Preco> getPriceList( ){
        return this.PriceHistory;
    }
    
    public boolean removePrice(Preco p){
        boolean remove = this.PriceHistory.remove(p);
        return remove;
    }
}
