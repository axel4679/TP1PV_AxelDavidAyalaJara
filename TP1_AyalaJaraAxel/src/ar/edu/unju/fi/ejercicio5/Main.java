package ar.edu.unju.fi.ejercicio5;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Por favor, ingrese un número entre 1 y 9:");
		int numero = scanner.nextInt();

		if (numero < 1 || numero > 9) {
			System.out.println("El número ingresado está fuera del rango permitido.");
		} else {
			System.out.println("Tabla de multiplicar del " + numero + ":");
			for (int i = 0; i <= 10; i++) {
				int resultado = numero * i;
				System.out.println(numero + " x " + i + " = " + resultado);
			}
		}

		scanner.close();
	}
}
