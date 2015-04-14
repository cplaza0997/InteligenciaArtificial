/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedas;

import GUI.AreaGrafo;
import static GUI.AreaGrafo.print;
import GUI.Principal;
import GUI.Resultados;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Karlo
 */
public class Amplitud implements Algoritmo{
    AreaGrafo grafoG;
    LinkedList<String> visitados;
    boolean graficar;
    Resultados resultados;
    long retardo;
    
    public Amplitud(Resultados resultados,AreaGrafo grafoG,long retardo,boolean graficar){
        this.grafoG=grafoG;
        this.graficar=graficar;
        visitados=new LinkedList<String>();
        this.resultados=resultados;
        this.retardo=retardo;
        
    }
    LinkedList<Nodo> cola;
    @Override
    public void buscar(Nodo grafo, HashMap<String, Arista> aristas, String destinos, int max) {
        cola=new LinkedList<Nodo>();
        cola.add(grafo);
        visitados.add(grafo.getNombre());
        int nmObj=destinos.split(",").length;int cont=0;
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        resultados.setNombre("Busqueda en amplitud");
        while(cont<nmObj && visitados.size() <= max){
            if(!cola.isEmpty()){
            imprimirCola();
            Nodo elemento=cola.pop();
                    if(destinos.contains(elemento.getNombre())){grafoG.setColor(Color.BLUE.darker());}else{grafoG.setColor(Color.GRAY.darker());}
                    grafoG.resaltar(elemento.getNombre(), true);
            if (graficar) {        try {
                        Thread.sleep(retardo);
                    } catch (Exception e) {
                    }
                }
            if(resultados.esPausa()){
                synchronized(resultados){
                    try{resultados.wait();}catch(Exception e){};
                }}
            if(!destinos.contains(elemento.getNombre())){
                ArrayList<Nodo> nodos = elemento.getNodos();
                if(!nodos.isEmpty()){
                    for(int i=0;i<nodos.size();i++){
                        Nodo nodo = nodos.get(i);
                        if(!visitados.contains(nodo.getNombre())){
                            //print("No contiene: "+nodo.getNombre()+"   "+visitados.toString());
                            cola.add(nodo); 
                            visitados.add(nodo.getNombre());
                        }
                    }
                }
                
            }else{cont++;}
        }else{break;}
        }
        time_end = System.currentTimeMillis();
        resultados.setInformacion(0,"Recorrido en Amplitud" , time_end-time_start);
        grafoG.setColor(Color.GREEN.brighter());
        grafoG.resaltar(null,false);
    }

    public void print(Object o) {
        System.out.println(o);
    }
    public void imprimirCola(){
        String mensaje="";
        for(int i=0;i<cola.size();i++){
            mensaje=mensaje+" "+cola.get(i).getNombre();
        }
        resultados.setElementos(mensaje);
    }
}
