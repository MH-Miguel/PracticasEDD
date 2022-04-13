/**
 * Clase que crea los palos de triunfo y lideres de la ronda
 * @author Cruz Campos Eduardo
 * @author Martínez Herrera Miguel Agustín
 * @version 1.2
 */
public class Palo{
    Carta triunfo = new Carta();
    Carta lider = new Carta();

    public Palo(){}

    /**
     * Constructor que crea un objeto de tipo Palo
     *
     * @param triunfo - carta de triunfo
     * @param lider - carta lider
     */
    public Palo(Carta triunfo, Carta lider){
        this.triunfo=triunfo;
        this.lider=lider;
    }

    /**
    * Método para obtener el palo de la carta triunfo
    * @return valor del palo
    */
    public String getValorTriunfo(){
        return this.triunfo.obtenerNombreFigura();
    }

    /**
    * Método para obtener el palo de la carta lider
    * @return valor del palo
    */
    public String getValorLider(){
        return this.lider.obtenerNombreFigura();
     }



}