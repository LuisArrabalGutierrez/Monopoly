
package civitas;

import java.util.ArrayList;

public class Tablero {
    
    private ArrayList<Casilla> tablero;
    private boolean porSalida;
    
   
    Tablero(){
        tablero = new ArrayList<>();
        Casilla salida = new Casilla("Salida");
        this.tablero.add(salida);       
        porSalida = false;              
    }
    
    
    private boolean correcto(int numCasilla){
        return numCasilla >= 0 && numCasilla < tablero.size();
    }
    
   
    boolean computarPasoPorSalida(){
        boolean r = porSalida;
        porSalida = false;
        return r;
    }
   
    void añadeCasilla(Casilla casilla){
        tablero.add(casilla);
    }
    
    
    public Casilla getCasilla(int numCasilla){
        if(correcto(numCasilla)){
            return tablero.get(numCasilla);
        }else{
            return null;
        }
    }
    
    
    int nuevaPosicion(int actual, int tirada){
        int pos;
        pos = tirada + actual;
        
        if(pos >= tablero.size()){
            pos = pos % tablero.size();
            porSalida = true;
        }
        return pos;
    }
    
    
    public ArrayList<Casilla> getCasillas(){
        return tablero;
    }
    
}
