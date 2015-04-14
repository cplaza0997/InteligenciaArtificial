/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedas;

import GUI.AreaGrafo;
import GUI.Principal;
import GUI.Resultados;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Karlo
 */
public class Profundidad implements Algoritmo {

    Stack<Nodo> pila;
    AreaGrafo grafoG;
    LinkedList<String> visitados;
    boolean graficar;
    Resultados resultados;
    long retardo;
    public Profundidad(Resultados resultados,AreaGrafo grafoG,long retardo, boolean graficar) {
        this.grafoG = grafoG;
        this.graficar = graficar;
        visitados = new LinkedList<String>();
        this.resultados=resultados;
        this.retardo=retardo;
    }

    @Override
    public void buscar(Nodo grafo, HashMap<String, Arista> aristas, String destinos, int maximo) {
        pila = new Stack<Nodo>();
        pila.add(grafo);
        visitados.add(grafo.getNombre());
        int nmObj=destinos.split(",").length;int cont=0;
        long time_start, time_end;
        resultados.setNombre("Busqueda en profundidad");
        time_start = System.currentTimeMillis();
        while (cont<nmObj && visitados.size() <= maximo) {
            if (!pila.empty()) {
                imprimirPila();
                Nodo elemento = pila.pop();
                
                    if(destinos.contains(elemento.getNombre())){grafoG.setColor(Color.BLUE.darker());}else{grafoG.setColor(Color.GRAY.darker());}
                    grafoG.resaltar(elemento.getNombre(), true);
                if (graficar) {    try {
                        Thread.sleep(retardo);
                    } catch (Exception e) {
                    }
                }
                if(resultados.esPausa()){
                synchronized(resultados){
                    try{resultados.wait();}catch(Exception e){};
                }}
                if (!destinos.contains(elemento.getNombre())) {
                    ArrayList<Nodo> nodos = elemento.getNodos();
                    if (!nodos.isEmpty()) {
                        for (int i = nodos.size() - 1; i >= 0; i--) {
                            Nodo nodo = nodos.get(i);
                            if (!visitados.contains(nodo.getNombre())) {
                                //print("No contiene: "+nodo.getNombre()+"   "+visitados.toString());
                                pila.push(nodo);
                                visitados.add(nodo.getNombre());
                            }

                        }
                    }
                } else {
                    cont++;
                }
            }
        }
        time_end = System.currentTimeMillis();
        resultados.setInformacion(1,"Recorrido en Profundidad" , time_end-time_start);
    }
    public void imprimirPila(){
        String mensaje="";
        for(int i=pila.size()-1;i>=0;i--){
            mensaje=mensaje+pila.get(i).getNombre();
        }
        resultados.setElementos(mensaje);
    }
}
