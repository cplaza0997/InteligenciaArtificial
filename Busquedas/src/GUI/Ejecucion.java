/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import busquedas.Amplitud;
import busquedas.Arista;
import busquedas.Ax;
import busquedas.Nodo;
import busquedas.Profundidad;
import java.util.HashMap;

/**
 *
 * @author Karlo
 */
public class Ejecucion extends Thread{
    AreaGrafo grafoG;
    Nodo grafo;
    HashMap<String, Arista> aristas;
    String destinos;
    int maximo;
    boolean graficar;
    boolean minimo;
    Resultados resultados;
    long retardo;
    @Override
    public void run(){
        /**
         * resultados Se mostrara los tiempos de ejecucion de un determinado algoritmo
         * grafoG Lugar donde se cambiaran de color los nodos recorridos
         * resultados Dialog donde se mostrara los resultados
         * booleano true si se desea graficar, o false para el caso contrario: false para medir la eficiencia del algoritmo
        */
        Amplitud am=new Amplitud(resultados,grafoG,retardo,graficar);
        am.buscar(grafo, aristas,destinos,maximo);
        Profundidad pr=new Profundidad(resultados,grafoG,retardo,graficar);
        pr.buscar(grafo, aristas,destinos,maximo);
        Ax a=new Ax(resultados,grafoG,retardo,graficar,minimo);
        a.buscar(grafo, aristas,destinos,maximo);
            

    }
    public Ejecucion(Resultados resultados,AreaGrafo grafoG,Nodo grafo, HashMap<String, Arista> aristas, String destinos, int maximo,long retardo, boolean graficar,boolean minimo) {
        this.grafoG=grafoG;
        this.grafo=grafo;
        this.aristas=aristas; 
        this.graficar=graficar;
        this.retardo=retardo;
        this.destinos=destinos;
        this.maximo=maximo;
        this.resultados=resultados;
        this.minimo=minimo;
    }
}
