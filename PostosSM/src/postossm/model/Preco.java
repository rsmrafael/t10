/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postossm.model;

/**
 *
 * @author Rafa
 */
public class Preco {
    
    // Atributos
    private float price;
    private String tipo;
    private Data dia;
    
    // Construtor
    public Preco(float price, String tipo, int dia, int mes, int ano){
        this.price = price;
        this.tipo = tipo;
        this.dia = new Data(dia,mes,ano);
    }
    
    public void setPrice(float price){
        this.price = price;
    }
    
    public void setTipo (String tipo){
        this.tipo = tipo;
    }
    
    public boolean setDia(int dia, int mes, int ano){
        return this.dia.setDate(dia, mes, ano);
    }
    
    public float getPrice(){
        return this.price;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public Data getDia(){
        return this.dia;
    }
    
}
