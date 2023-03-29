package exercicioRevsiao_Semana1;

import java.util.Random;

import javax.swing.JOptionPane;

public class Dados {
	private int dado1, dado2, soma, numeroAposta;
	String resultado = "";
	
	public Dados() {
		Random aleatorio = new Random();
		
		dado1 = aleatorio.nextInt(6) + 1;
		dado2 = aleatorio.nextInt(6) + 1;
		soma = dado1 + dado2;
		//System.out.println("Numero: " + soma); //Hack professor não use >:(
	}
	
	public int Logica(int numeroAposta) {
		if(soma == numeroAposta) {
			return 2;
		} else {
			resultado = "Voce errou sinto muito :((";
		}
		return 1;
	}
	
	public String toString() {
		return resultado;
	}
}
