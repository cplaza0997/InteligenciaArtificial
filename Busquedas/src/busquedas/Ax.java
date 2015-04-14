/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedas;

import GUI.AreaGrafo;
import GUI.Resultados;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Karlo
 */
public class Ax extends Recorrido {

    AreaGrafo grafoG;
    LinkedList<String> visitados;
    boolean graficar,minimo;
    Resultados resultados;
    long retardo;
    int ic;
    public Ax(Resultados resultados,AreaGrafo grafoG, long retardo,boolean graficar,boolean minimo) {
        this.grafoG = grafoG;
        this.graficar = graficar;
        visitados = new LinkedList<String>();
        this.resultados=resultados;
        this.retardo=retardo;
        this.minimo=minimo;
    }
    LinkedList<Nodo> cola;

    @Override
    public void buscar(Nodo grafo, HashMap<String, Arista> aristas, String destinos, int max) {
        cola = new LinkedList<Nodo>();
        cola.add(grafo);
        visitados.add(grafo.getNombre());
        int nmObj=destinos.split(",").length;int cont=0;
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        resultados.setNombre("Algoritmo A*");
        while (cont<nmObj && visitados.size() <= max) {
            if (!cola.isEmpty()) {
                imprimirCola();
                Nodo elemento = getNodoMejor(cola,destinos);//Optener el nodo con mejor valor
                
                    if(destinos.contains(elemento.getNombre())){grafoG.setColor(Color.BLUE.darker());}else{grafoG.setColor(Color.GRAY.darker());}
                    grafoG.resaltar(elemento.getNombre(), true);
                if (graficar) {    
                    try {
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
                        int cr=0;
                        for (int i = 0; i < nodos.size(); i++) {
                            Nodo nodo = nodos.get(i);
                            if (!visitados.contains(nodo.getNombre())) {
                                String ar=getEnlace(elemento.getNombre(),nodo.getNombre());
                                float val=aristas.get(ar).getValor();
                                nodo.setAcumulador(val+elemento.getAcumulador());
                                cola.add(ic+cr,nodo);
                                cr++;
                                visitados.add(nodo.getNombre());
                            }
                        }
                    }

                } else {
                    cont++;;
                }
            } else {
                break;
            }
        }
        time_end = System.currentTimeMillis();
        resultados.setInformacion(5,"Algoritmo A*" , time_end-time_start);
        grafoG.setColor(Color.GREEN.brighter());
        grafoG.resaltar(null, false);
    }

    public Nodo getNodoMejor(LinkedList<Nodo> cola, String destinos) {
        int c = 0;
        float min = cola.get(c).getValor()+cola.get(c).getAcumulador();
        for (int i = 1; i < cola.size(); i++) {
            
            Nodo nodo = cola.get(i);
            // print("Evaluando "+nodo.getNombre()+"  "+nodo.getValor()+nodo.getAcumulador());
            float valorNodo;
            if (destinos.contains(nodo.getNombre())) { valorNodo=0;
            }else{valorNodo=nodo.getValor();}
                if (minimo) {
                    if (valorNodo+nodo.getAcumulador() < min) {
                        min = valorNodo+nodo.getAcumulador();c=i;
                    }
                } else {
                    if (valorNodo+nodo.getAcumulador() > min) {
                        min =valorNodo+nodo.getAcumulador(); c = i;
                    }
                }
            
        }
        ic=c;
        Nodo nodo = cola.get(c);
        cola.remove(c);
        return nodo;
    }

    public void print(Object o) {
        System.out.println(o);
    }

    public String getEnlace(String nodo1, String nodo2) {
        if (nodo1.charAt(0) < nodo2.charAt(0)) {
            return nodo2 + nodo1;
        }
        return nodo1 + nodo2;
    }

    public void imprimirCola(){
        String mensaje="";
        for(int i=0;i<cola.size();i++){
            mensaje=mensaje+" "+cola.get(i).getNombre();
        }
        resultados.setElementos(mensaje);
    }
}
