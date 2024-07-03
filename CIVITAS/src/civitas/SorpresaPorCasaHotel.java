
package civitas;

import java.util.ArrayList;

public class SorpresaPorCasaHotel extends Sorpresa {
    
    private int valor;
    
    SorpresaPorCasaHotel(String texto, int valor){
        super(texto);
        this.valor=valor;
    }
    
    
    @Override
    public void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        //todos.get(actual).tieneAlgoQueGestionar()
        if(todos.get(actual).cantidadCasasHoteles()<=0){
             Diario.getInstance().ocurreEvento("No se puede aplicar la sorpresa al jugador porque aun no tiene casas ni hoteles");
        }else{
            super.informe(actual, todos);
            int nCasasHoteles = todos.get(actual).cantidadCasasHoteles();
            Diario.getInstance().ocurreEvento("Numero total de casa y hoteles: " + nCasasHoteles);
            todos.get(actual).modificaSaldo(valor*nCasasHoteles);
            
        }     
    }
    
    @Override
    public String toString(){
        String t;
        t = "Sorpresa: " + super.getTexto();
        return t;
    }
    
}
