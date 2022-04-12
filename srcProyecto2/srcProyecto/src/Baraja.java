/**
 * Clase que crea una baraja de cartas
 * @author Cruz Campos Eduardo
 * @author Martínez Herrera Miguel Agustín
 * @version 1.2
 */
public class Baraja{

    protected List<Carta> lista;

    /**
     * Constructor por omisión que crea una lista con 60 cartas
     */
    public Baraja(){
        lista = new List();
        for(int i=1; i<=13; i++){
            lista.add(0,(new Carta(i,"amarillo")));
            lista.add(0,(new Carta(i,"rojo")));
            lista.add(0,(new Carta(i,"azul")));
            lista.add(0,(new Carta(i,"verde")));
        }
        for(int i=14; i<=15; i++){
            lista.add(0,(new Carta(i,"bufon")));
            lista.add(0,(new Carta(i,"mago")));
        }
        for(int i=14; i<=15; i++){
            lista.add(0,(new Carta(i,"bufon")));
            lista.add(0,(new Carta(i,"mago")));
        }
    }

    /**
     * Método para tomar carta
     * @return Carta - nueva carta al azar
     */
    public Carta tomarCarta(){
        Carta nuevaCarta = lista.get(0);
        lista.remove(0);
        return nuevaCarta;
    }

    /**
     * Método que genera números aleatorios entre 0 y max.
     */
    private int random(int max) {
        return (int) Math.round(Math.random() * max + 0.5);
    }

    /**
     * Método para revolver las cartas de la baraja
     */
    public void revolver(){
        for(int i = 0; i < lista.size(); i++){
            int numRan = random(lista.size()-1);
            Carta temporal = lista.remove(numRan);
            lista.add(0,temporal);
        }
    }

    /**
     * Método para obtener el tamaño de la baraja
     * @return el tamaño de la baraja
     */
    public int size(){
        return lista.size();
    }

    /**
     * Método para quitar una carta de la baraja
     * @param i - Indice de la carta que quitaremos
     */
    public void remove(int i){
        lista.remove(i);
    }

    /**
     * Método para imprimir la baraja
     * @return String -- cadena que contiene la baraja.
     */
    public String toString() {
        return lista.toString();
    }
}

