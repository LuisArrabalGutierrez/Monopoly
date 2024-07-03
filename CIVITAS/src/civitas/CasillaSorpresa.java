
package civitas;

import java.util.ArrayList;

public class CasillaSorpresa extends Casilla {
    
    private MazoSorpresas mazo;
    private Sorpresa sorpresa;
    
   
    CasillaSorpresa(String nombre, MazoSorpresas mazo){
        super(nombre);
        this.mazo = mazo;
    }
    
    @Override
    public void recibeJugador(int iactual, ArrayList<Jugador> todos){
        sorpresa = mazo.siguiente();
        super.informe(iactual,todos);
        Diario.getInstance().ocurreEvento(toString());
        sorpresa.aplicarAJugador(iactual, todos);
        
    }
    
    @Override
    public String toString(){
        return "[Sorpresa: " + sorpresa.getTexto() + " ]";
    }
    
}
