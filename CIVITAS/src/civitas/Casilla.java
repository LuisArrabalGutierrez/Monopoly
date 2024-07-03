/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

public class Casilla {
    
    private String nombre;
    
   
    Casilla(String nombre){
        //init();
        this.nombre = nombre;
    }
    
    
  
    public String getNombre(){
        return nombre;
    }

    void informe(int actual, ArrayList<Jugador>todos){
        Diario.getInstance().ocurreEvento(todos.get(actual).getNombre() + " ha caido en la casilla " +this.getNombre() + ".");
    }
   
    public void recibeJugador(int iactual, ArrayList<Jugador> todos){
        informe(iactual,todos);
    }
    
    @Override
    public String toString(){
        String salida;
     
        salida = "[ " + nombre + "] \n"; 
        return salida;
    }
    
}
