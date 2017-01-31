import java.util.Random;
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

    private int numeroCartasEnLaMano;

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String nombre)
    {
        this.nombre = nombre;
        cartasJugador = new Carta[5];
        numeroCartasEnLaMano = 0;
    }

    public void recibirCarta(Carta cartaARecibir)
    {
        if (numeroCartasEnLaMano < 5){
            cartasJugador[numeroCartasEnLaMano] = cartaARecibir;
            numeroCartasEnLaMano++;
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

    public String verNombreJugador()
    {
        return nombre;
    }

    public Carta tirarCarta(String nombreCarta)
    {
        Carta cartaTirada = null;
        boolean buscando = true;
        if (numeroCartasEnLaMano > 0){
            int i = 0;
            while (i < 5 && buscando){
                if (cartasJugador[i] != null){
                    if (nombreCarta.equals(cartasJugador[i].toString())){
                        cartaTirada = cartasJugador[i];
                        cartasJugador[i] = null;
                        numeroCartasEnLaMano--;
                        buscando = false;
                        System.out.println(nombre + " ha tirado el " + cartaTirada);
                    }
                }
                i++;
            }
        }
        return cartaTirada;
    }

    public Carta tirarCartaAleatoria()
    {
        Carta cartaTirada = null;
        Random aleatorio = new Random();
        int i = 0;
        if (numeroCartasEnLaMano > 0){
            boolean elJugadorhaTiradoUnaCarta = false;
            while (elJugadorhaTiradoUnaCarta == false){
                int x = aleatorio.nextInt(5);
                if (cartasJugador[x] != null){
                    cartaTirada = cartasJugador[x];
                    cartasJugador[x] = null;
                    numeroCartasEnLaMano--;
                    elJugadorhaTiradoUnaCarta = true;
                    System.out.println(nombre + " ha tirado el " + cartaTirada.toString());
                }
                i++;
            }
        }
        while (i < 5){
            int x = aleatorio.nextInt(5);
            if (cartasJugador[x] != null){
                cartaTirada = cartasJugador[x];
                cartasJugador[x] = null;
                numeroCartasEnLaMano--;
                System.out.println(nombre + " ha tirado el " + cartaTirada.toString());
            }
            i++;
        }
        
        return cartaTirada;
    }

}
