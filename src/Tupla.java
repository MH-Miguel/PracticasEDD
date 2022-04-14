public class Tupla {

    Carta carta;
    Jugador jugador;
    

    public Tupla(Carta carta, Jugador jugador){
        this.carta = carta;
        this.jugador = jugador;
    }

    public Carta fst(){
        return carta;
    }

    public Jugador snd(){
        return jugador;
    }

    public Tupla getTupla(){
        return this;
    }

    public void clear(){
        this.carta=null;
        this.jugador=null;
    }



    public int compareTo(Tupla tupla){
        if(this.fst().getValor() == 15 && tupla.fst().getValor() != 15){
            return 1;
        }

        if(this.fst().getValor() == 15 && tupla.fst().getValor() == 15){ //Cuando son 2 magos
        return 2;
            //throw new IllegalArgumentException("Acuerdate de implementar cuando se compara entre 2 magos");
        }

        if(this.fst().getValor() <= 13 && tupla.fst().getValor() <= 13){ //En el caso cuando se tiene un numero entre 0 y 13 y no hay magos ni bufones
            if(this.fst().getValor() > tupla.fst().getValor()){
                return 1;
            }else if(this.fst().getValor() < tupla.fst().getValor()){
                return -1;
            }else{
                return 0;
            }
        }

        if(this.fst().getValor() == 14 && tupla.fst().getValor() == 14){ //Cuando ambos tienen un buffon
            return 0;
        }

        return -1; //Se llega a este caso cuando el jugador que manda a llamar el metodo tiene el bufon y los otros no lo tienen
    }

    //Crear metodo para borrar todos los elementos de la lista 

    @Override
    public String toString() {
        return "(" + "carta=" + carta + ", jugador=" + jugador.getNombre() + ')';
    }
}
