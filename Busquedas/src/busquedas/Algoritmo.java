/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedas;

import java.util.HashMap;

/**
 *
 * @author Karlo
 */
public interface Algoritmo {
    /**
     * @param grafo Es un objeto de tipo Nodo el cual sera evaluado en la busqueda
     * @param aristas Contiene los pesos de las aristas
     * @param destinos Es una cadena que contiene los objetivos a ser evaluados en las busquedas
     * @param maximo Este parametro permite limitar la busqueda hasta cierto numero de iteraciones, por lo general
     *              sera la cantidad de nodos.
     */
    public void buscar(Nodo grafo,HashMap<String,Arista> aristas,String destinos, int maximo);
}
