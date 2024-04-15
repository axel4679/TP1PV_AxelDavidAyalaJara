package ar.edu.unju.fi.ejercicio6.main;


import ar.edu.unju.fi.ejercicio6.model.Persona;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos para la persona (constructor por defecto):");
        Persona persona1 = new Persona();
        mostrarDatosPersona(persona1);
        
        System.out.println("\nIngrese los datos para la persona (constructor parametrizado):");
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
        String fechaNacimientoStr = scanner.nextLine();
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
        System.out.print("Provincia: ");
        String provincia = scanner.nextLine();
        Persona persona2 = new Persona(dni, nombre, fechaNacimiento, provincia);
        mostrarDatosPersona(persona2);

        System.out.println("\nIngrese los datos para la persona (constructor sin provincia):");
        System.out.print("DNI: ");
        dni = scanner.nextLine();
        System.out.print("Nombre: ");
        nombre = scanner.nextLine();
        System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
        fechaNacimientoStr = scanner.nextLine();
        fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
        Persona persona3 = new Persona(dni, nombre, fechaNacimiento);
        mostrarDatosPersona(persona3);

        scanner.close();
    }

    private static void mostrarDatosPersona(Persona persona) {
        System.out.println("\nDatos de la persona:");
        persona.mostrarDatos();
    }
}
