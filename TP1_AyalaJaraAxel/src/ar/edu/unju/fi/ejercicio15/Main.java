package ar.edu.unju.fi.ejercicio15;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese un número entero en el rango [5, 10]: ");
		int tamano = scanner.nextInt();

		while (tamano < 5 || tamano > 10) {
			System.out
					.print("El número ingresado está fuera del rango. Ingrese un número entero en el rango [5, 10]: ");
			tamano = scanner.nextInt();
		}

		String[] nombres = new String[tamano];

		for (int i = 0; i < nombres.length; i++) {
			System.out.print("Ingrese el nombre de la persona en la posición " + i + ": ");
			scanner.nextLine(); 
			nombres[i] = scanner.nextLine();
		}

		System.out.println("\nValores almacenados en el array (comenzando desde el primer índice 0):");
		for (int i = 0; i < nombres.length; i++) {
			System.out.println("Posición " + i + ": " + nombres[i]);
		}

		System.out.println("\nContenido del array (comenzando desde la última posición):");
		for (int i = nombres.length - 1; i >= 0; i--) {
			System.out.println("Posición " + i + ": " + nombres[i]);
		}

		scanner.close();
	}
}
