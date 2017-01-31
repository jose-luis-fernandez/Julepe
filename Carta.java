
/**
 * Write a description of class Carta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carta
{
    // Valor de la carta de 1 a 17 y de 10 a 12.
    private int valor;
    //Valor del palo: 0 es oros, 1 es copas, 2 es espadas y 3 es bastos.
    private int palo;

    /**
     * Constructor for objects of class Carta
     */
    public Carta(int valor, int palo)
    {
        // initialise instance variables
        this.valor = valor;
        this.palo = palo;
    }
    
    public String toString()
    {
        String textoPalo = "";
        String textoValor = "";
        String textoADevolver = "";

        switch (palo){
            case 0: textoPalo = "oros";break;
            case 1: textoPalo = "copas";break;
            case 2: textoPalo = "espadas";break;
            case 3: textoPalo = "bastos";break;
        }
        
        switch (valor){
            case 1: textoValor = "as";break;
            case 2: textoValor = this.valor + "";break;
            case 3: textoValor = this.valor + "";break;
            case 4: textoValor = this.valor + "";break;
            case 5: textoValor = this.valor + "";break;
            case 6: textoValor = this.valor + "";break;
            case 7: textoValor = this.valor + "";break;
            case 10: textoValor = "sota";break;
            case 11: textoValor = "caballo";break;
            case 12: textoValor = "rey";break;
        }
        
        textoADevolver = textoValor + " de " + textoPalo;
        return textoADevolver;
    }
    
    public int getValor()
    {
        return valor;
    }
    
    public int getPalo()
    {
        return palo;
    }
    
    public boolean ganaA(Carta cartaAcomparar, int paloQuePinta){
        boolean gana = false;
        if (palo == paloQuePinta){
            if (palo == paloQuePinta && cartaAcomparar.getPalo() != paloQuePinta){
                gana = true;
            }
            else if ( valor == 1){
                gana = true;
            }
            else if (valor == 3 && cartaAcomparar.getValor() != 1 && cartaAcomparar.getPalo() == paloQuePinta){
                gana = true;
            }
            else if (valor > cartaAcomparar.getValor() && cartaAcomparar.getValor() != 1 && cartaAcomparar.getValor() != 3){
                gana = true;
            }
        }
        else {
            if (palo != cartaAcomparar.getPalo() && cartaAcomparar.getPalo() != paloQuePinta){
                gana = true;
            }
            else if (valor == 1 && cartaAcomparar.getPalo() != paloQuePinta){
                gana = true;
            }
            else if (valor == 3 && cartaAcomparar.getValor() != 1 && cartaAcomparar.getPalo() != paloQuePinta){
                gana = true;
            }
            else if (cartaAcomparar.getPalo() != paloQuePinta &&valor > cartaAcomparar.getValor() && cartaAcomparar.getValor() != 1 && cartaAcomparar.getValor() != 3){
                gana = true;
            }
        }
        return gana;
    }
    
    

}
