import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Mazo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mazo
{
    // ArrayList que almacena todo el mazo de cartas
    private ArrayList<Carta> mazo;

    /**
     * Constructor for objects of class Mazo
     */
    public Mazo()
    {
        mazo = new ArrayList<Carta>();
        int contadorExterior = 0;
        while (contadorExterior < 4){
            int contadorInterior = 1;
            while (contadorInterior <= 12){
                if (contadorInterior != 8 && contadorInterior != 9){
                    mazo.add(new Carta(contadorInterior, contadorExterior));
                }
                contadorInterior++;
            }
            contadorExterior++;
        }
    }
    
    public void verCartasDelMazo()
    {
        for (int i = 0; i < mazo.size(); i ++){
            System.out.println(mazo.get(i).toString());
        }
    }
    
    public void barajar()
    {
        Random aleatorio = new Random();
        Carta cartaARecolocar = null;
        for (int i = 0; i < mazo.size(); i++){
             int x = aleatorio.nextInt(mazo.size());
             cartaARecolocar = mazo.get(x);
             mazo.remove(x);
             mazo.add(cartaARecolocar);
        }
    }
    
    public Carta sacarCarta()
    {
        Carta cartaADevolver = null;
        if (mazo.size() > 0){
            cartaADevolver = mazo.remove(0);
        }
        return cartaADevolver;
    }
    
    
    
}
