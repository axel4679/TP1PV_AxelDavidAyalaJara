package ar.edu.unju.fi.ejercicio14;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese un número entero en el rango [3, 10]: ");
		int tamano = scanner.nextInt();

		while (tamano < 3 || tamano > 10) {
			System.out
					.print("El número ingresado está fuera del rango. Ingrese un número entero en el rango [3, 10]: ");
			tamano = scanner.nextInt();
		}

		int[] numeros = new int[tamano];

		for (int i = 0; i < numeros.length; i++) {
			System.out.print("Ingrese un número entero para la posición " + i + ": ");
			numeros[i] = scanner.nextInt();
		}

		System.out.println("\nValores almacenados en el array:");
		int suma = 0;
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Posición " + i + ": " + numeros[i]);
			suma += numeros[i];
		}

		System.out.println("\nLa suma de todos los valores es: " + suma);

		scanner.close();
	}
}
