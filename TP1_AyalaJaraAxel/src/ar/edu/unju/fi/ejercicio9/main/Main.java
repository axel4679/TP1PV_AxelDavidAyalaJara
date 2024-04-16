package ar.edu.unju.fi.ejercicio9.main;

import ar.edu.unju.fi.ejercicio9.model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Producto[] productos = new Producto[3];

        for (int i = 0; i < productos.length; i++) {
            Producto producto = new Producto();

            System.out.println("Ingrese los datos del producto " + (i + 1) + ":");
            System.out.print("Nombre: ");
            producto.setNombre(scanner.nextLine());
            System.out.print("Código: ");
            producto.setCodigo(scanner.nextLine());
            System.out.print("Precio: ");
            producto.setPrecio(scanner.nextDouble());
            scanner.nextLine();
            System.out.print("Descuento (%): ");
            producto.setDescuento(scanner.nextInt());
            scanner.nextLine();

            productos[i] = producto;
        }

        System.out.println("\nDatos de los productos y precios con descuento:");
        for (Producto producto : productos) {
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Descuento: " + producto.getDescuento() + "%");
            System.out.println("Precio con descuento: " + producto.calcularDescuento());
            System.out.println();
        }

        scanner.close();
    }
}

