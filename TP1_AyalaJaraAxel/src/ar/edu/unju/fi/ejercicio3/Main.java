package ar.edu.unju.fi.ejercicio3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Por favor, ingrese un número entero:");
		int numero = scanner.nextInt();

		if (numero % 2 == 0) {
			int triple = numero * 3;
			System.out.println("El número ingresado es par. El triple del número es: " + triple);
		} else {
			int doble = numero * 2;
			System.out.println("El número ingresado es impar. El doble del número es: " + doble);
		}

		scanner.close();
	}
}
