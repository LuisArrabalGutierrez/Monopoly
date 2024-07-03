
package civitas;

import java.util.ArrayList;


public class SorpresaPagarCobrar extends Sorpresa {
    
    private int valor;
    
    SorpresaPagarCobrar(String texto, int valor){
        super(texto);
        this.valor=valor;
    }
    
   
    @Override
    public void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        super.informe(actual, todos);
        todos.get(actual).modificaSaldo(valor);
    }
    
    @Override
    public String toString(){
        String t;
        t = "Sorpresa: " + super.getTexto();
        return t;
    }
    
}
