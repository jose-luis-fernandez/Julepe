
/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador
{
    // nombre del jugador
    private String nombre;
    // array que almacena las cartas que tiene el jugador
    private Carta[] cartasJugador;
    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String nombre)
    {
        this.nombre = nombre;
        cartasJugador = new Carta[5];
    }
    
    public void recibirCarta(Carta cartaARecibir)
    {
        boolean buscando = true;
        int i = 0;
        while (i < cartasJugador.length && buscando){
            if (cartasJugador[i] == null){
                cartasJugador[i] = cartaARecibir;
                buscando = false;
            }
            i++;
        }
    }
    
    public void verCartasJugador()
    {
        for (int i = 0; i < cartasJugador.length; i++){
            if (cartasJugador[i] != null){
                System.out.println(cartasJugador[i]);
            }
        }
    }
    
}
