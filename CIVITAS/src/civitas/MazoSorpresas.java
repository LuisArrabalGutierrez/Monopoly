
package civitas;

import java.util.ArrayList;

public class MazoSorpresas {
    
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada;
    private int usadas;
    private boolean debug;
    
    private void init(){
        sorpresas = new ArrayList();
        barajada = false;
        usadas = 0;
    }
    
     MazoSorpresas(){
        init();
        debug = false;
    }
    
    MazoSorpresas(boolean debug){
        this.debug = debug;
        init();
        if(debug){
            Diario.getInstance().ocurreEvento("MODO DEBUG ACTIVADO.");
        }
    }
    
    
   
    
    void alMazo(Sorpresa sorpresa){
        if(!barajada){
            sorpresas.add(sorpresa);
        }
    }
    
    Sorpresa siguiente(){
        if(!barajada || usadas == sorpresas.size()){
            if(!debug){
                barajada = true;
                usadas = 0;
            } 
        }
        usadas++;
        Sorpresa s = sorpresas.get(0);
        sorpresas.add(s);
        sorpresas.remove(0);
        
        return s;
    }
    
        
     
    
}
