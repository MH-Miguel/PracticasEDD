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

    public Lista<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * Constructor para el juego Wizard.
     * @param jugadores - Lista de los que van a jugar.
     * @param baraja - Baraja con la que se jugará.
     */

    public Wizard(Lista<Jugador> jugadores, Baraja baraja, int numRondas){
        this.baraja = baraja;
        this.jugadores = jugadores;
        this.numRondas = numRondas;
        //juego();
    }


    /**
     * Método para repartirle las cartas a cada jugador.
     * @param noCartas Cuantas cartas se reparten a cada jugador. 
     */
    public void repartirBaraja(int noCartas) {
        int jugadores = this.jugadores.size();
        int j=0;
        while( j < jugadores){
            for(int k=1; k <= noCartas; k++){
                this.jugadores.get(j).agregarCarta(this.baraja.tomarCarta());
            }
            j++;
        }
    }

    /**
     * Método para hacer la apuesta
     */
    public void apuesta(int ronda){
        Lista<Jugador> lista = getJugadores();
        for(int i=0; i < jugadores.size(); i++){

            //Mostrar mano del jugador i

            //Mostrar cual es el palo de triunfo y el palo lider (hacer toString de Palo)

            System.out.println(lista.get(i) + "\n ¿Cuántas manos crees que vas a ganar?\n ");
            int n = scanner.nextInt();

            
            if(n>ronda){
                System.out.println("Ingresa un número entre 0 y "+random + "-_-"+reset);
                return;
            }
            //Guardar la apuesta en el atributo apuesta del jugador i.
        }
    }

    public void truco(int numRonda){
        Lista<Jugador> jugadores = getJugadores();
        Lista<Tupla> rondaTruco = new Lista<>();
        for(int i = 1; i <= numRonda; i++){ //Numero de trucos de la ronda en curso
            System.out.println("Truco; "+ i +  " Ronda: " + numRonda);
            for(int j = 0; j < jugadores.size(); j++){ //Cada jugador juegue su carta

                //Mostrarle la mano al jugador(j) con respectivos indices de su mano.

                System.out.println(jugadores.get(j) + "\n Ingresa el indice de la carta: \n");
                int index = scanner.nextInt();

                //if revisar si el palo.getLider es vacio, dentro de este if meter 
                // if el valor de la carta va de 1 al 13, añadir set lider al Palo.

                rondaTruco.add(0,new Tupla(jugadores.get(j).jugarCarta(index),jugadores.get(j))); //Agregará a una lista donde se mete la carta que jugó cada jugador
            }

            //Agregar el compareTo de cada elemento de la lista rondaTruco, recuerda respetar el orden.
            
            //La carta que ganó, a su dueño le vas a sumar 1 a su atributo trucosW

            //De algun modo indicar que el que gano la ronda iniciara la siguiente 

            //Borrar los elementos de  la lista Tupla rondaTruco.

        }

        

        System.out.println(rondaTruco);

        System.out.println(rondaTruco.get(0).compareTo(rondaTruco.get(1)));

        Tupla temp = rondaTruco.remove(0); // indice n
        rondaTruco.add(1,temp); // indice n+1

        System.out.println(rondaTruco);


        /*

            Carta temp = mano.remove(i);
            mano.add(i,mano.remove(j-1));
            mano.add(j,temp);

         */


        System.out.println("Termino de ronda" + numRonda);
        int x = scanner.nextInt();
    }



    /**
     * Método para la inicialización del juego.
     */
    public void juego(){
        //this.jugadores.get(0).agregarCarta(this.baraja.tomarCarta());
        for(int i=1; i<=this.numRondas; i++){
            baraja.revolver();

            //Sacar el palo de triunfo y guardarlo en Palo, Recuerda que si i=this.numRondas, ya no
            //hacemos este paso.

            repartirBaraja(i);

            apuesta(this.numRondas);

            truco(i);

            //Hacer cuentas para sumar o restar puntos a la puntuación de cada jugador con respecto
            //a si concuerda el numpero de trucosW y su apuesta. Podemos crear un método que haga ésto


            //Resetear la apuesta y trucosW de cada jugador para preparar la siguiente ronda.


            noBaza--; //Final de la ronda
            
            //System.out.println(this.jugadores.get(0).toString());
            //System.out.println("Separar la info del primer jugador/n");

            //la idea es que meter aquí el proceso de una ronda y que éste se repita
            //el número de rondas totales.
        }
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