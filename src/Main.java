import java.util.Scanner;
/**
 * Clase que simula el juego solterona para jugar con demas jugadores o contra la computadora
 * @author Cruz Campos Eduardo
 * @author Martínez Herrera Miguel Agustín
 * @version 1.0
 */
public class Main{
	public static void main(String []args){

		// Colores de letra
	    String yellow="\033[33m";

	    // Reset
	    String reset="\u001B[0m";

		Lista<Jugador> jugadorList = new Lista<>();
		Baraja baraja = new Baraja();
		Scanner scanner = new Scanner(System.in);
		String historial;
		int jugadores = 0;
		int jugadoresCPU = 0;
		boolean repe = true;
		int numRondas=0;


		System.out.println("\t*** BIENVENIDO AL JUEGO 'Wizard' ***\n");
		System.out.println(baraja);

		//System.out.println(baraja);
		while(repe){
			System.out.println("\nIngresa el número de jugadores que jugarán");
			try{
				jugadores = scanner.nextInt();
				if(jugadores>2 && jugadores<7){
					repe = false;
				}else{
					System.out.println(yellow + "\tDebes ingresar un número del 3 al 6"+reset);
				}
			}catch(Exception e){
				System.out.println(yellow+"\tDebes ingresar un número"+reset);
				scanner.next();
			}
		}
		repe = true;

		
		for(int i = 0; i < jugadores; i++){
			System.out.println("Ingresa el nombre del jugador " + (i+1));
			String nombre = scanner.next();
			jugadorList.add(jugadorList.size(), new Jugador(nombre, true, 0));
		}

		// instrucción switch para revisar cuantas rondas se jugarán
        switch (jugadores) 
        {
            case 3:  numRondas = 20;
                     break;
            case 4:  numRondas = 15;
                     break;
            case 5: numRondas = 12;
                     break;
            case 6: numRondas = 10;
                     break;
        }



		//Wizard wizard = new Wizard(jugadorList, baraja, numRondas);
		


		repe = true;
		System.out.println("¿Deseas saber el historial de la partida?\tSi/No");
		while(repe){
			historial = scanner.next();
			if(historial.equalsIgnoreCase("si")){
				System.out.println("Aqui se supone que iba el historial jsjs, por lo que queda como ejercicio al jugador.");
				repe = false;
			}else if (historial.equalsIgnoreCase("no")){
				System.out.println("Ayoos :3");
				repe = false;
			}else{
				System.out.println(yellow+"Debes escribir 'si' o 'no'"+reset);
			}
		}
	}
}