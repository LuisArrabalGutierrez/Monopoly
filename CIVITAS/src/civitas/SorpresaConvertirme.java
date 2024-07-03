
package civitas;

import java.util.ArrayList;

public class SorpresaConvertirme extends Sorpresa{
    
    SorpresaConvertirme(){
        super("Te conviertes en un Jugador Especulador");
    }

    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        super.informe(actual, todos);
        Jugador j = todos.get(actual);
        todos.add(actual, j.convertir());
    }
    
}
