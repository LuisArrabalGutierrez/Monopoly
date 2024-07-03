
package civitas;


public class GestionInmobiliaria {
    private OperacionInmobiliaria operacion;
    private int propiedad;
    
    public GestionInmobiliaria(OperacionInmobiliaria gest, int ip){
        operacion = gest;
        propiedad = ip;
    }
    
    public OperacionInmobiliaria getOperacion(){
        return operacion;
    }
    
    public int getPropiedad(){
        return propiedad;
    }
    
}
