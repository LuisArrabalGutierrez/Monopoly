
package civitas;

import GUI.Dado;
import java.util.ArrayList;
import java.util.Collections;


public class CivitasJuego {
    private int indiceJugadorActual;
    private ArrayList<Jugador> jugadores;
        private MazoSorpresas mazo;
    private Tablero tablero;
    private EstadoJuego estado;
    private GestorEstados gestor;
    
    
    
    public CivitasJuego(ArrayList<String> nombres, boolean debug){

        jugadores = new ArrayList();
        for(int i=0; i<nombres.size(); i++){
            Jugador jugador = new Jugador(nombres.get(i));
            jugadores.add(jugador);
        }
        
        gestor = new GestorEstados();
        estado = gestor.estadoInicial(); 
        Dado.getInstance();
        Dado.getInstance().setDebug(debug);    
        indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());        
        mazo = new MazoSorpresas(debug);       
        tablero = new Tablero();
        inicializaTablero(mazo);
        
        inicializaMazoSorpresas();
        
    }
    
    private void avanzaJugador(){
        Jugador jugadorActual = getJugadorActual();
        int posicionActual = jugadorActual.getCasillaActual();
        int tirada = Dado.getInstance().tirar();
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada);
        Casilla casilla = tablero.getCasilla(posicionNueva);      
       contabilizarPasosPorSalida();
        
        jugadorActual.moverACasilla(posicionNueva);
        casilla.recibeJugador(indiceJugadorActual, jugadores);
    }
    
    public boolean comprar(){
        boolean res;
        Jugador jugadorActual = getJugadorActual();
        int numCasillaActual = jugadorActual.getCasillaActual();
        
        Casilla casilla = tablero.getCasilla(numCasillaActual);
        CasillaCalle calle = (CasillaCalle)casilla;
        
        res = jugadorActual.comprar(calle);
        return res;
    }
    
    
    public int getIndiceJugadorActual(){
        return indiceJugadorActual;
    }
    
    public Jugador getJugadorActual(){
        return jugadores.get(getIndiceJugadorActual());
    }
    
    public Casilla getCasillaActual(){
        return tablero.getCasilla(jugadores.get(indiceJugadorActual).getCasillaActual());
    }
    
    public ArrayList<Jugador> getJugadores(){ //Devuelve el to string
        return jugadores;
    }
    
    public Tablero getTablero(){
        return tablero;
    }
    
    private void inicializaMazoSorpresas(){
        mazo.alMazo(new SorpresaPorCasaHotel(" Pagas 50€ por cada casa/hotel de tu propiedad para reformarla", -50));
        mazo.alMazo(new SorpresaPorCasaHotel("Pagas 50€ por cada casa y hotel que hayas construido", -50));
        mazo.alMazo(new SorpresaPagarCobrar("Se ha incendiado una propiedad y tienes que pagar 200", -200));
        mazo.alMazo(new SorpresaPagarCobrar("Te has encontrado 200€ en la calle.", 200));
        mazo.alMazo(new SorpresaConvertirme());
        mazo.alMazo(new SorpresaPagarCobrar("Pagas 150€ por la factura de la luz de este mes", -150));
        mazo.alMazo(new SorpresaPorCasaHotel("Enhorabuena! Recibes 10€ por cada casa/hotel de tu propiedad", 10));
        mazo.alMazo(new SorpresaPagarCobrar("Pagas 100€ por una multa de trafico", -100));
        mazo.alMazo(new SorpresaPagarCobrar("Enhorabuena has ganado la loteria. Cobras 100€", 100));
        mazo.alMazo(new SorpresaPorCasaHotel("Recibes 20€ por cada casa/hotel que hayas construido", 20));
        mazo.alMazo(new SorpresaPagarCobrar("Te dan 100 por tu cumpleaños", 100));
        
        
    }
    
    private void inicializaTablero(MazoSorpresas mazo){ 
        tablero.añadeCasilla(new CasillaCalle("Mendez Nuñez", 700, 650, 500));
        tablero.añadeCasilla(new CasillaCalle("Camino de ronda", 50, 50, 40));
        tablero.añadeCasilla(new CasillaCalle("Recogidas", 100, 120, 100));
        tablero.añadeCasilla(new CasillaSorpresa("¡SORPRESA!",mazo));
        tablero.añadeCasilla(new CasillaCalle("Fuencarral", 150, 170, 125));
        tablero.añadeCasilla(new CasillaCalle("Reyes Católicos", 200, 220, 175));
        tablero.añadeCasilla(new CasillaCalle("Avenida de la constitución", 400, 410, 340));
        tablero.añadeCasilla(new CasillaSorpresa("¡SORPRESA!", mazo));
        tablero.añadeCasilla(new CasillaCalle("Gran Vía", 350, 260, 300));
        tablero.añadeCasilla(new CasillaCalle("Rambla", 300, 310, 250));
        tablero.añadeCasilla(new CasillaCalle("Castellana", 350, 350, 325));
        tablero.añadeCasilla(new CasillaSorpresa("¡SORPRESA!", mazo));
        tablero.añadeCasilla(new CasillaCalle("Paseo de los tristes", 450, 460, 360));
        tablero.añadeCasilla(new CasillaDescanso("PARKING"));
        tablero.añadeCasilla(new CasillaCalle("Lebrija", 500, 520, 380));    
        tablero.añadeCasilla(new CasillaCalle("Avenida Capuchinos", 550, 565, 400));
        tablero.añadeCasilla(new CasillaCalle("Pedro Antonio", 600, 600, 420));
        tablero.añadeCasilla(new CasillaCalle("Profesor Clavera", 650, 640, 450));
        tablero.añadeCasilla(new CasillaSorpresa("¡SORPRESA!", mazo));
       
    }
    public boolean construirCasa(int ip){
        return jugadores.get(indiceJugadorActual).construirCasa(ip);
    }
    
    public boolean construirHotel(int ip){
        return jugadores.get(indiceJugadorActual).construirHotel(ip);
    }
    
    private void contabilizarPasosPorSalida(){
        if(tablero.computarPasoPorSalida()){
            getJugadorActual().pasaPorSalida();
            //jugadores.get(indiceJugadorActual).pasaPorSalida();
        }
    }
    
    public boolean finalDelJuego(){
        boolean fin = false;
        for(int i=0; i < jugadores.size();i++){
            if(jugadores.get(i).enBancarrota()){
                fin = true;
            }
        }
        return fin;
    }
    private void pasarTurno(){
        indiceJugadorActual = (indiceJugadorActual + 1) % jugadores.size();
    }
    
    public ArrayList<Jugador> ranking(){
        ArrayList<Jugador>ranking = jugadores;
        for(int i = 0; i < ranking.size() - 1; i++) {
            for(int j = i + 1; j < ranking.size(); j++) {    
                if(ranking.get(i).compareTo(ranking.get(j)) < 0) {
                    Jugador aux = new Jugador(ranking.get(i));
                    ranking.set(i, ranking.get(j));
                    ranking.set(j, aux);
                }
            }
        }
        return ranking;
    }
    
    public OperacionJuego siguientePaso(){
        Jugador jugadorActual = getJugadorActual();
        OperacionJuego operacion = gestor.siguienteOperacion(jugadorActual, estado);
        
        if(operacion==OperacionJuego.PASAR_TURNO){
            pasarTurno();
            siguientePasoCompletado(operacion);
        }else if(operacion==OperacionJuego.AVANZAR){
            avanzaJugador();
            siguientePasoCompletado(operacion);
        }
        return operacion;
    }
    
    public void siguientePasoCompletado(OperacionJuego operacion){
        estado = gestor.siguienteEstado(jugadores.get(indiceJugadorActual), estado, operacion);
    }
    
    
}
