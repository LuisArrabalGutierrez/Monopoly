
package civitas;

import java.util.ArrayList;

public class CasillaCalle extends Casilla {
    
  
    private int numCasas, numHoteles;
      private float precioCompra, precioEdificar, precioBaseAlquiler;
    static private float FACTORALQUILERCALLE = 1.0f;
    static private float FACTORALQUILERCASA = 1.0f;
    static private float FACTORALQUILERHOTEL = 4.0f;
    private Jugador propietario;
 
    CasillaCalle(String nombre, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        super(nombre);
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
        propietario = null;
        numCasas = 0;
        numHoteles = 0;
    }
    
    public Jugador getPropietario(){
        return propietario;
    }
    
   
    public float getPrecioCompra(){
        return precioCompra;
    }
    
    public float getPrecioEdificar(){
        return precioEdificar;
    }
    
   
    float getPrecioBaseAlquiler(){
        return precioBaseAlquiler;
    }
   
    public int getNumCasas(){
        return numCasas;
    }
    
    
    public int getNumHoteles(){
        return numHoteles;
    }
  
    float getPrecioAlquilerCompleto(){
        return precioBaseAlquiler*FACTORALQUILERCALLE*(1+(numCasas*FACTORALQUILERCASA)+numHoteles*FACTORALQUILERHOTEL*4);
    }
    
   
    public int cantidadCasasHoteles(){
        return numCasas+numHoteles;
    }
    
 
    boolean construirCasa(Jugador jugador){
        boolean result = false;
        if(esEsteElPropietario(jugador) && (numCasas < 4)){
            result = true;
            jugador.paga(precioEdificar);
            numCasas++;
        }
        return result;
    }
  
    boolean construirHotel(Jugador jugador){
        boolean result = false;
        if(esEsteElPropietario(jugador) && (cantidadCasasHoteles()<8) && (numHoteles < 4 && numCasas >= 4)){
            result = true;
            derruirCasas(4, jugador);
            jugador.paga(precioEdificar);
            numHoteles++;
        }else{
            result = false;
        }
        return result;
    }
    
   
    boolean derruirCasas(int numero, Jugador jugador){
        boolean hecho;
        if(esEsteElPropietario(jugador) && numCasas >= numero){
            numCasas = numCasas-numero;
            hecho = true;
        }else{
            hecho = false;
        }
        return hecho;
    }
    
  
   
    public void tramitarAlquiler(Jugador jugador){
        if(tienePropietario() && !esEsteElPropietario(jugador)){
            jugador.pagaAlquiler(getPrecioAlquilerCompleto());
            propietario.recibe(getPrecioAlquilerCompleto());
        }
    }
    
    void actualizaPropietarioPorConversion(Jugador jugador){
        propietario = jugador;
    }
    
    boolean comprar(Jugador jugador){
        boolean result;
        if(tienePropietario()){
            result = false;
        }else{
                propietario = jugador;
                propietario.paga(this.getPrecioCompra());
                result = true;
             
        }
        return result;
    }
     
    public boolean esEsteElPropietario(Jugador jugador){
        return propietario == jugador;
    }
   
    public boolean tienePropietario(){
        boolean tiene = false;
        if(propietario != null){
            tiene = true;
        }
        return tiene;
    }
    
    @Override
    public void recibeJugador(int iactual, ArrayList<Jugador> todos){
        super.informe(iactual,todos);
        Diario.getInstance().ocurreEvento(toString());
        Jugador jugador = todos.get(iactual);
        
        if(!tienePropietario()){
            jugador.puedeComprarCasilla();
        }else{
            tramitarAlquiler(jugador);
        }
    }
   
    
    @Override
    public String toString(){
        String salida;
     
        salida = "[ " + super.getNombre() + "--> Propietario: " + propietario + " || Precio Compra: " + precioCompra + 
                " || Precio edificar: " + precioEdificar + " || Alquiler base: "
                + precioBaseAlquiler + " || CASAS: " + numCasas + " || HOTELES: " + numCasas + " ] \n"; 
        return salida;
    }
    
    
}
