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
public class Data{
    
    // Atributes
    private int dia;
    private int mes;
    private int ano;
    
    // Construtor
    public Data(int dia,int mes,int ano){
        if (isValid(dia,mes,ano)){
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
        else{
            this.dia = 3;
            this.mes = 12;
            this.ano = 2015;
            // melhors seria lançar exceção
        }
    }
    
    public final boolean isValid(int dia, int mes, int ano){
        
        if((mes<=0)||(mes>12)){
            System.out.println("Mes fora dos limites");
            return false;
        }
        
        if((ano<2015)||(ano>9999)){
            System.out.println("Ano fora dos limites");
            return false;
        }
        
        int diaMax;
        diaMax = 31;
        if((mes==4)||(mes==6)||(mes==9)||(mes==11)) diaMax = 3;
        else if(mes==2){
            if(Bissesto(ano)) diaMax = 29;
            else diaMax = 28;
        }
        if((dia<=0)||(dia>diaMax)){
            System.out.println("Dia fora dos limites");
            return false;
        }
        
        return true;
    }
    
    public boolean Bissesto(int ano){
        
        if (ano%400 == 0) return true;
        
        return (ano%4 == 0)&&(ano%100 != 0);
        
    }
    
    public boolean setDate(int dia, int mes, int ano){
        if (isValid(dia,mes,ano)){
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
            return true;
        }
        return false;
    }
    
    public int getDia() {
        return this.dia;
    }
    public int getMes() {
        return this.mes;
    }
    public int getAno() {
        return this.ano;
    }
}

