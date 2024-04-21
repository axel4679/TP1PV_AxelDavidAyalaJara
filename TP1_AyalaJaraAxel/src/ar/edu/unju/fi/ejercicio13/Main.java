package ar.edu.unju.fi.ejercicio13;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] numeros = new int[8];

		for (int i = 0; i < numeros.length; i++) {
			System.out.print("Ingrese el número en la posición " + i + ": ");
			numeros[i] = scanner.nextInt();
		}

		System.out.println("\nValores almacenados en el array:");
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Índice: " + i + " - Valor: " + numeros[i]);
		}

		scanner.close();
	}
}
