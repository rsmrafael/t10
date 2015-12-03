/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postossm.model;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author Rafa
 */
public class Preco implements Serializable{
    
    // Atributos
    private float price;
    private String tipo;
    private Date dia;
    
    public Preco(){
        this.price = 0;
        this.tipo = "";
        this.dia = new Date(){
            @Override
            public String toString() {
                return String.format("%d/%02d/%02d", getDate(), getMonth() + 1, getYear());
            }
        };
    }
    
    // Construtor
    public Preco(float price, String tipo, int dia, int mes, int ano){
        this.price = price;
        this.tipo = tipo;
        this.dia = new Date(ano,mes,dia){
            @Override
            public String toString() {
                return String.format("%d/%02d/%02d", getDate(), getMonth() + 1, getYear());
            }
        };
    }
    
    public void setPrice(float price){
        this.price = price;
    }
    
    public void setTipo (String tipo){
        this.tipo = tipo;
    }
    
    public void setDia(int dia, int mes, int ano){
        this.dia.setDate(dia);
        this.dia.setMonth(mes);
        this.dia.setYear(ano);
        
    }
    
    public float getPrice(){
        return this.price;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public Date getDia(){
        return this.dia;
    }
    
}
