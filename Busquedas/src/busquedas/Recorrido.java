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
public class Recorrido implements Algoritmo{
    private Algoritmo busqueda;
    
    public void setBusqueda(Algoritmo busqueda){
        this.busqueda=busqueda;
    }

    @Override
    public void buscar(Nodo grafo, HashMap<String, Arista> aristas,  String destinos, int maximo) {
       busqueda.buscar(grafo, aristas,destinos,maximo);
    }
    
}
