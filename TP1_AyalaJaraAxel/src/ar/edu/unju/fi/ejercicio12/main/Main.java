package ar.edu.unju.fi.ejercicio12.main;


import ar.edu.unju.fi.ejercicio12.model.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la persona: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la fecha de nacimiento (Formato: dd/MM/yyyy): ");
        System.out.print("Día: ");
        int dia = scanner.nextInt();
        System.out.print("Mes: ");
        int mes = scanner.nextInt();
        System.out.print("Año: ");
        int anio = scanner.nextInt();

        Calendar fechaNacimiento = new GregorianCalendar(anio, mes - 1, dia);
        Persona persona = new Persona(nombre, fechaNacimiento);

        System.out.println("\nNombre: " + persona.getNombre());
        System.out.println("Fecha de nacimiento: " + dia + "/" + mes + "/" + anio);
        System.out.println("Edad: " + persona.calcularEdad() + " años");
        System.out.println("Signo del zodiaco: " + persona.obtenerSignoZodiaco());
        System.out.println("Estación: " + persona.obtenerEstacion());

        scanner.close();
    }
}
