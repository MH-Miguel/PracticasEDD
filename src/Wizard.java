import java.util.Random;
import java.util.Scanner;
import java.lang.NumberFormatException;
import java.lang.IndexOutOfBoundsException;
import java.lang.NullPointerException;
import java.util.InputMismatchException;

/**
 * Clase que simula el Wizard
 * @author Cruz Campos Eduardo
 * @author Martínez Herrera Miguel Agustín
 */
public class Wizard{
    // Colores de letra
    String red="\033[31m"; 
    String green="\033[32m"; 
    String yellow="\033[33m";

    // Reset
    String reset="\u001B[0m";

    Baraja baraja;
    int sizeBaraja;
    Lista<Jugador> jugadores;
    Jugador jugadorAnterior;
    Jugador jugadorActual;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);
    int numTurno;
    int numRondas;
    int noBaza=this.numRondas;

    /**
     * Constructor para el juego Wizard.
     * @param jugadores - Lista de los que van a jugar.
     * @param baraja - Baraja con la que se jugará.
     */

    public Wizard(Lista<Jugador> jugadores, Baraja baraja, int numRondas){
        this.baraja = baraja;
        this.jugadores = jugadores;
        this.numRondas = numRondas;
        //this.jugadores.get(0).agregarCarta(this.baraja.tomarCarta());
        for(int i=0; i<this.numRondas; i++){
            baraja.revolver();
            repartirBaraja(this.numRondas);
            noBaza--;
            
            //System.out.println(this.jugadores.get(0).toString());
            //System.out.println("Separar la info del primer jugador/n");

            //la idea es que meter aquí el proceso de una ronda y que éste se repita
            //el número de rondas totales.
        }
    
    }


    /**
     * Método para repartirle las cartas a cada jugador.
     */
    public void repartirBaraja(int noBaza) {
        int jugadores = this.jugadores.size();
        int j=0;
        while( j < jugadores){
            
            for(int k=this.numRondas; k>=noBaza; k--){
                this.jugadores.get(j).agregarCarta(this.baraja.tomarCarta());
            }
            j++;
        }
    }

    /**
     * Método para la inicialización del juego.
     */
    public void juego(){
        
    }

/**
     * Método para limpiar la terminal.
     */
    public void clear(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }


}