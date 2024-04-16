package ar.edu.unju.fi.ejercicio10.main;

import ar.edu.unju.fi.ejercicio10.model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pizza[] pizzas = new Pizza[3];

        for (int i = 0; i < pizzas.length; i++) {
            Pizza pizza = new Pizza();

            System.out.println("Ingrese los datos de la pizza " + (i + 1) + ":");

            System.out.print("Diámetro (20, 30 o 40): ");
            int diametro = scanner.nextInt();
            pizza.setDiametro(diametro);

            System.out.print("Ingredientes especiales (true o false): ");
            boolean ingredientesEspeciales = scanner.nextBoolean();
            pizza.setIngredientesEspeciales(ingredientesEspeciales);

            pizza.calcularPrecio();
            pizza.calcularArea();

            pizzas[i] = pizza;
        }

        for (int i = 0; i < pizzas.length; i++) {
            System.out.println("** Pizza " + (i + 1) + " **");
            System.out.println("Diámetro = " + pizzas[i].getDiametro());
            System.out.println("Ingredientes especiales = " + pizzas[i].isIngredientesEspeciales());
            System.out.println("Precio Pizza = " + pizzas[i].getPrecio() + "$");
            System.out.println("Área de la pizza = " + pizzas[i].getArea());
        }

        scanner.close();
    }
}
