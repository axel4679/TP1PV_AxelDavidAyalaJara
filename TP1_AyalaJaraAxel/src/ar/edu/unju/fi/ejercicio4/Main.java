package ar.edu.unju.fi.ejercicio4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Por favor, ingrese un número entre 0 y 10:");
		int numero = scanner.nextInt();

		if (numero < 0 || numero > 10) {
			System.out.println("El número ingresado está fuera del rango permitido.");
		} else {
			int factorial = 1;
			int i = 1;
			while (i <= numero) {
				factorial *= i;
				i++;
			}

			System.out.println("El factorial de " + numero + " es: " + factorial);
		}
	scanner.close();
	}
} 
