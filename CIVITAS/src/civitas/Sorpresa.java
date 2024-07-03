
package civitas;


import java.util.ArrayList;


public abstract class Sorpresa {
    private String texto;
    private int valor;
    private MazoSorpresas mazo;
    

    Sorpresa(String texto){
        this.texto = texto;
        mazo = new MazoSorpresas();
    }
    
    abstract void aplicarAJugador(int actual, ArrayList<Jugador> todos);
    
   
    /*public void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento(toString());
        if(todos.get(actual).cantidadCasasHoteles()>0 && tipo == TipoSorpresa.PORCASAHOTEL){
            Diario.getInstance().ocurreEvento("Se esta aplicando la sorpresa " + tipo + " al jugador " + todos.get(actual).getNombre());
        }else if(todos.get(actual).cantidadCasasHoteles()<=0 && tipo == TipoSorpresa.PORCASAHOTEL){
            Diario.getInstance().ocurreEvento("No se puede aplicar la sorpresa " + tipo + " al jugador porque aun no tiene casas ni hoteles");
        }else{
            Diario.getInstance().ocurreEvento("Se esta aplicando la sorpresa " + tipo + " al jugador " + todos.get(actual).getNombre());
        }
    }
    */
    
    public void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("Se esta aplicando la sorpresa al jugador " + todos.get(actual).getNombre());
    }
    
    public String getTexto(){
        return texto;
    }
    
    @Override
    public String toString(){
        String t;
        t = "Sorpresa: " + texto;
        return t;
    }
    
}
