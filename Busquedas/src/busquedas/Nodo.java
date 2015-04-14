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
    private int x;
    private float acumulador;
    public Nodo(String nombre, float valor) {
        this.nombre = nombre;
        this.valor = valor;
        reiniciar();
    }

    public Nodo(String nombre) {
        this.nombre = nombre;
        reiniciar();
    }

    public Nodo() {
        reiniciar();
    }
    public void reiniciar(){
        nodos = new ArrayList<Nodo>();
        acumulador=0;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getNombre() {
        return nombre;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public ArrayList<Nodo> getNodos() {
        return nodos;
    }

    public void setNodo(Nodo nodo) {
        int tm = nodos.size();
        if (!nodos.isEmpty()) {
            int valx =nodo.getX();
            for (int c = 0; c < tm; c++) {
                //print(nodo.getNombre()+nodos.size());
                int valx2 = nodos.get(c).getX();

                if (valx < valx2) {
                    nodos.add(c, nodo);
                    break;
                } else {
                    if (c == nodos.size() - 1) {
                        nodos.add(c + 1, nodo);
                    }
                }
            }
        } else {
            //print(nombre + ":  " + nodo.getNombre());
            this.nodos.add(nodo);
        }
    }

    public float getAcumulador() {
        return acumulador;
    }

    public void setAcumulador(float acum) {
        this.acumulador = this.acumulador+acum;
    }

    public void print(Object o) {
        System.out.println(o);
    }
}
