/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedas;

/**
 *
 * @author Karlo
 */
public class Arista {
    private String nodo1;
    private String nodo2;
    private float valor;
    public Arista(String nodo1,String nodo2,float valor){this.nodo1=nodo1;this.nodo2=nodo2;this.valor=valor;}
    public String getNodo1() {
        return nodo1;
    }

    public void setNodo1(String nodo1) {
        this.nodo1 = nodo1;
    }

    public String getNodo2() {
        return nodo2;
    }

    public void setNodo2(String nodo2) {
        this.nodo2 = nodo2;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
}
