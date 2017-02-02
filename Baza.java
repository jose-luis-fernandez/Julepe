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
    
    /**
     * Constructor for objects of class Baza
     */
    public Baza(int numeroJugadoresQueTiranCarta, int paloQuePinta)
    {
        // initialise instance variables
        jugadores = numeroJugadoresQueTiranCarta;
        this.paloQuePinta = paloQuePinta;
        baza = new ArrayList<Carta>();
    }
    
    public void addCarta(Carta cartaTirada, String nombreJugadorQueTira)
    {
        baza.add(cartaTirada);
    }
    
    public int getPaloPrimeraCartaDeLaBaza()
    {
        int paloPrimeraCarta = -1;
        if (baza.size() > 0){
            paloPrimeraCarta = baza.get(0).getPalo();
        }
        return paloPrimeraCarta;
    }

    
}
