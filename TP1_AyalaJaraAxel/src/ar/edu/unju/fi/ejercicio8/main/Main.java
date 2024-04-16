package ar.edu.unju.fi.ejercicio8.main;



import ar.edu.unju.fi.ejercicio8.model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el valor de n:");
        int n = scanner.nextInt();

        CalculadoraEspecial calculadora = new CalculadoraEspecial(n);

        double sumatoria = calculadora.calcularSumatoria();
        double productoria = calculadora.calcularProductoria();

        System.out.println("Sumatoria: " + sumatoria);
        System.out.println("Productoria: " + productoria);

        scanner.close();
    }
}
