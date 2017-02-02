import java.util.ArrayList;
/**
 * Write a description of class Baza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Baza
{
    // instance variables - replace the example below with your own
    private int jugadores;
    
    private int paloQuePinta;
    
    private ArrayList<Carta> baza;
    
    private ArrayList<String> nombresJugadores;
    
    private String jugadorQueVaGanando;
    
    /**
     * Constructor for objects of class Baza
     */
    public Baza(int numeroJugadoresQueTiranCarta, int paloQuePinta)
    {
        // initialise instance variables
        jugadores = numeroJugadoresQueTiranCarta;
        this.paloQuePinta = paloQuePinta;
        baza = new ArrayList<Carta>();
        nombresJugadores = new ArrayList<String>();
        jugadorQueVaGanando = null;
    }
    
    public void addCarta(Carta cartaTirada, String nombreJugadorQueTira)
    {
        baza.add(cartaTirada);
        nombresJugadores.add(nombreJugadorQueTira);
    }
    
    public int getPaloPrimeraCartaDeLaBaza()
    {
        int paloPrimeraCarta = -1;
        if (baza.size() > 0){
            paloPrimeraCarta = baza.get(0).getPalo();
        }
        return paloPrimeraCarta;
    }
    
    public Carta cartaQueVaGanandoLaBaza()
    {
        Carta cartaADevolver = null;
        if (baza.size() > 1){
            for (int i = 0; i < (baza.size()) - 1; i++){
                if (baza.get(i).ganaA2(baza.get(i + 1), this.paloQuePinta)){
                    cartaADevolver = baza.get(i);
                    jugadorQueVaGanando = nombresJugadores.get(i);
                }
                else {
                    cartaADevolver = baza.get(i + 1);
                    jugadorQueVaGanando = nombresJugadores.get(i + 1);
                }
            }
        }
        else if (baza.size() == 1){
            cartaADevolver = baza.get(0);
            jugadorQueVaGanando = nombresJugadores.get(0);
        }
        return cartaADevolver;
    }
    
    public String nombreJugadorQueVaGanandoLaBaza()
    {
        cartaQueVaGanandoLaBaza();
        String jugadorQueVaGanando = null;
        if (baza.size() > 0){
            jugadorQueVaGanando = this.jugadorQueVaGanando;
        }
        return jugadorQueVaGanando;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
