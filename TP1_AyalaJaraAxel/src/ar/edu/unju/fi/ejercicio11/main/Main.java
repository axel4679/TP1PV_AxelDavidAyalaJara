package ar.edu.unju.fi.ejercicio11.main;

public class Main {
	public static void main(String[] args) {
		int j = 40;
		for (int i = 2; j >= 0; i += 2, j -= 2) {
			System.out.print((j * i) + " ");
		}
		for (int i = 0; j < 0; i += 2, j -= 2) {
			System.out.print((j * i) + " ");
		}
	}
}
   