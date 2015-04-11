/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedas;

import java.util.ArrayList;

/**
 *
 * @author Karlo
 */
public class Nodo {
    private String nombre;
    private float valor;
    private ArrayList<Nodo> nodos;
    
    public Nodo(String nombre,float valor){
        this.nombre=nombre;
        this.valor=valor;
        nodos=new ArrayList<Nodo>();
    }
    public Nodo(String nombre){
        this.nombre=nombre;
        nodos=new ArrayList<Nodo>();
    }
    public Nodo(){
        nodos=new ArrayList<Nodo>();
    }

    public String getNombre() {
        return nombre;
    }

    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor=valor;
    }

    public ArrayList<Nodo> getNodos() {
        return nodos;
    }
    public void setNodo(Nodo nodo) {
        print(nombre+":  "+nodo.getNombre());
        this.nodos.add(nodo);
    }
    public void print(Object o){System.out.println(o);}
}
