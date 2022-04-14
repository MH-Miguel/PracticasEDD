 /**
 * Clase que extiende a la clase Persona para Jugador
 * @author Cruz Campos Eduardo
 * @author Martínez Herrera Miguel Agustín
 * @version 1.2
 */

public class Jugador {
    protected String nombre;
    protected Lista<Carta> mano;
    protected boolean persona;
    public int puntuacion;
    public int apuesta;
    public int trucosW;

    /**
     * Constructor que crea un objeto de tipo jugador
     *
     * @param nombre - string con el nombre del jugador
     * @param persona - boolean que dice si es persona o no
     */
    public Jugador(String nombre, boolean persona, int puntuacion, int apuesta, int trucosW) {
       this.nombre = nombre;
       mano = new Lista<>();
       this.persona = persona;
       this.puntuacion=puntuacion;
       this.apuesta=apuesta;
       this.trucosW=trucosW;
    }

    /**
     * Método para obtener el nombre del jugador
     *
     * @return Cadena con el nombre del jugador
     */
    public String getNombre() {
       return this.nombre;
    }
    /**
     * Método para obtener la puntuación del jugador
     *
     * @return int con puntuacion del jugador
     */
    public int getPuntuacion() {
      return this.puntuacion;
   }

   /**
     * Método para obtener la puntuación del jugador
     *
     * @return int con la apuesta del jugador
     */
    public int getApuesta() {
      return this.apuesta;
   }

   /**
     * Método para obtener la puntuación del jugador
     *
     * @return int con trucos ganados del jugador
     */
    public int getTrucosW() {
      return this.trucosW;
   }

     /**
      * Metodo que regresa la mano del jugador
      * @return mano del jugador
      */
    public Lista<Carta> getMano() {
         return mano;
     }

   /**
     * Método para modificar el valor de la apuesta del jugador
     * @param apuesta  apuesta del jugador
     */
    public void setApuesta (int apuesta){
      this.apuesta = apuesta;
  }  

  /**
     * Método para modificar el valor de los trucos ganados del jugador
     * @param trucosW trucos que gano el jugador.
     */
    public void setTrucosW(int trucosW){
      this.trucosW = trucosW;
  }
  
  /**
     * Método para modificar la puntuacion del jugador
     * @param puntuacion puntuacion del jugador .
     */
    public void setPuntuacion(int puntuacion){
      this.puntuacion=puntuacion;
  }  

  /**
     * Método para sumar  puntuacion al jugador
     * @param puntuacion puntuacion del jugador .
     */
    public void sumarPuntuacion(int puntuacion){
      this.puntuacion=this.puntuacion+puntuacion;
  } 

  /**
   * Método para sumar 1 a los trucos ganados del jugador.
   */
  public void ganarTruco(){
     this.trucosW=this.trucosW+1;
  }

  /**
   * Método reiniciar a 0 los trucos ganados del jugador.
   */
  public void reiniciarTrucosW(){
   this.trucosW=0;
}

   /**
   * Método para reiniciar la apuesta del jugador.
   */
  public void reiniciarApuesta(){
   this.apuesta=-1;
}


     //Metodo para que el jugador tire su carta a la mesa
     public Carta jugarCarta(int indice){
        Carta carta = (Carta) mano.remove(indice);
        return carta;
     }

    /**
     * Método para agregar una carta a la mano del jugador
     *
     * @param carta - Carta que se agregará a la mano
     */
    public void agregarCarta(Carta carta) {
       mano.add(mano.size(), carta);
    }

    /**
     * Método que dice si el jugador es una persona o la computadora
     *
     * @return Si es una maquina o una persona
     */
    public Boolean isCPU() {
       return !persona;
    }

    /**
     * Método que genera números aleatorios entre 0 y max.
     */
    private int random(int max) {
        return (int) Math.round(Math.random() * max + 0.5);
    }

    public void intercambio(){
      if(mano.size() > 1){
         for(int i = 0; i < mano.size(); i++){
            int numRan = random(mano.size()-1);
            Carta temporal = mano.remove(numRan);
            mano.add(0,temporal);
        }
      }
    }

    public void swap(int i, int j){
      if(mano.size()>1){
         if(i<j){
            Carta temp = mano.remove(i);
            mano.add(i,mano.remove(j-1));
            mano.add(j,temp);
         }else{
            Carta temp = mano.remove(j);
            mano.add(j,mano.remove(i-1));
            mano.add(i,temp);
         }
      }
    }

    /**
     * Método para imprimir en consola al jugador y su puntuacion
     *
     * @return Cadena con las puntuaciones de cada jugador
     */
    public String consultarPuntuacion() {
      return "\nNombre: " + this.nombre +"\nPuntuación: "+this.puntuacion;
   }

    /**
     * Método para imprimir en consola el jugador y sus atributos
     *
     * @return Cadena con toda la información de jugador
     */
    public String toString() {
       return "\nNombre: " + this.nombre +"\nPuntuación: "+this.puntuacion + "\nTrucos ganados: "+this.trucosW+ "\nApuesta: "+this.apuesta+ "\nMano: " + this.getMano();
    }

    public String printDeck(){
       StringBuilder opc = new StringBuilder();
       for(int i = 0; i < mano.size(); i++){
          opc.append(i).append(": ").append(mano.get(i).toString()).append(" ");
       }
       return opc.toString();
    }
}