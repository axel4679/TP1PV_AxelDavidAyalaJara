package ar.edu.unju.fi.ejercicio16;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] nombres = new String[5];

		System.out.println("Ingrese 5 nombres de personas:");
		for (int i = 0; i < nombres.length; i++) {
			System.out.print("Ingrese el nombre " + (i + 1) + ": ");
			nombres[i] = scanner.nextLine();
		}

		System.out.println("\nValores almacenados en el array:");
		int contador = 0;
		while (contador < nombres.length) {
			System.out.println("Posición " + contador + ": " + nombres[contador]);
			contador++;
		}

		System.out.println("\nEl tamaño del array es: " + nombres.length);

		byte indice;
		do {
			System.out.print("\nIngrese el índice (entre 0 y 4) del elemento a eliminar (ingrese -1 para finalizar): ");
			indice = scanner.nextByte();

			if (indice >= 0 && indice < nombres.length) {
				for (int i = (int) indice; i < nombres.length - 1; i++) {
					nombres[i] = nombres[i + 1];
				}
				nombres[nombres.length - 1] = "";
			} else if (indice != -1) {
				System.out.println("El índice ingresado está fuera del rango. Intente nuevamente.");
			}
		} while (indice != -1);

		System.out.println("\nArreglo después de la eliminación:");
		for (String nombre : nombres) {
			System.out.println("Nombre: " + nombre);
		}

		scanner.close();
	}
}
