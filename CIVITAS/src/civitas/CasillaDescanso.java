
package civitas;

import java.util.ArrayList;

public class CasillaDescanso extends Casilla{
    
    CasillaDescanso(String nombre){
        super(nombre);
    }
    
    public void recibeJugador(int iactual, ArrayList<Jugador> todos){
        informe(iactual,todos);
    }
    
    @Override
    public String toString(){
        return "[ " + super.getNombre() + " ]";
    }
    
}
