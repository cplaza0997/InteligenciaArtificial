/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

/**
 *
 * @author Karlo
 */
public class Validacion {
    public static boolean validarNumero(String valor){
        if(valor!=null && !"".equals(valor)){
                try{
                    Float.valueOf(valor);
                    return true;
                }catch(Exception e){}
        }
        return false;
    }
    public static boolean validarNombre(String nombre){
        if(nombre!=null && !"".equals(nombre)){
            return true;
        }
        return false;
    }
    public static boolean validarDestinos(String nombres){
        if(nombres!=null && !"".equals(nombres)){
            if(nombres.split(",").length*2-1==nombres.length()){
                return true;
            }
        }
        return false;
    }
    public static boolean verificarNivel(String nivel){
        if(nivel!=null && !"".equals(nivel) && !"0".equals(nivel)){return true;}//requiere verificar nivel
        return false;//No se requiere verificar nivel
    }
}
