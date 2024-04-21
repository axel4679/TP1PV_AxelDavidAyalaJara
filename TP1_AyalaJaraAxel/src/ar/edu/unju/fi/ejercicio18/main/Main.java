package ar.edu.unju.fi.ejercicio18.main;


import ar.edu.unju.fi.ejercicio18.model.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<DestinoTuristico> destinosTuristicos = new ArrayList<>();
    static List<Pais> paises = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        precargarPaises();

        int opcion;

        do {
            System.out.println("\n*** Menú de Opciones ***");
            System.out.println("1 – Alta de destino turístico");
            System.out.println("2 – Mostrar todos los destinos turísticos");
            System.out.println("3 – Modificar el país de un destino turístico");
            System.out.println("4 – Limpiar el ArrayList de destino turísticos");
            System.out.println("5 – Eliminar un destino turístico");
            System.out.println("6 – Mostrar los destinos turísticos ordenados por nombre");
            System.out.println("7 – Mostrar todos los países");
            System.out.println("8 – Mostrar los destinos turísticos que pertenecen a un país");
            System.out.println("9 – Salir");
            System.out.print("Ingrese una opción: ");
            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    altaDestinoTuristico();
                    break;
                case 2:
                    mostrarTodosLosDestinosTuristicos();
                    break;
                case 3:
                    modificarPaisDeDestinoTuristico();
                    break;
                case 4:
                    limpiarArrayListDestinosTuristicos();
                    break;
                case 5:
                    eliminarDestinoTuristico();
                    break;
                case 6:
                    mostrarDestinosTuristicosOrdenadosPorNombre();
                    break;
                case 7:
                    mostrarTodosLosPaises();
                    break;
                case 8:
                    mostrarDestinosTuristicosPorPais();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }

        } while (opcion != 9);

        scanner.close();
    }

    static int obtenerOpcion() {
        int opcion = 0;
        boolean entradaValida = false;

        do {
            try {
                opcion = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número.");
                scanner.next(); // Limpia el buffer
            }
        } while (!entradaValida);

        return opcion;
    }

    static void precargarPaises() {
        paises.add(new Pais(1, "Argentina"));
        paises.add(new Pais(2, "Brasil"));
        paises.add(new Pais(3, "Chile"));
    }

    static void altaDestinoTuristico() {
        try {
            System.out.println("\n*** Alta de Destino Turístico ***");
            System.out.print("Código: ");
            int codigo = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Limpia el buffer
            System.out.print("País (Ingrese el código del país): ");
            int codigoPais = scanner.nextInt();
            Pais pais = obtenerPaisPorCodigo(codigoPais);
            if (pais == null) {
                System.out.println("Código de país inválido. Inténtelo de nuevo.");
                return;
            }
            System.out.print("Cantidad de días: ");
            int cantidadDias = scanner.nextInt();

            destinosTuristicos.add(new DestinoTuristico(codigo, nombre, precio, pais, cantidadDias));
            System.out.println("Destino Turístico agregado exitosamente.");
        } catch (InputMismatchException e) {
            System.out.println("Valor inválido. Inténtelo de nuevo.");
        }
    }

    static Pais obtenerPaisPorCodigo(int codigo) {
        for (Pais pais : paises) {
            if (pais.getCodigo() == codigo) {
                return pais;
            }
        }
        return null;
    }

    static void mostrarTodosLosDestinosTuristicos() {
        System.out.println("\n*** Mostrar todos los Destinos Turísticos ***");
        if (destinosTuristicos.isEmpty()) {
            System.out.println("No hay destinos turísticos.");
            return;
        }
        for (DestinoTuristico destino : destinosTuristicos) {
            System.out.println(destino);
        }
    }

    static void modificarPaisDeDestinoTuristico() {
        try {
            System.out.println("\n*** Modificar el país de un destino turístico ***");
            System.out.print("Código del destino turístico: ");
            int codigoDestinoTuristico = scanner.nextInt();
            System.out.print("Nuevo Código de país: ");
            int nuevoCodigoPais = scanner.nextInt();
            Pais nuevoPais = obtenerPaisPorCodigo(nuevoCodigoPais);
            if (nuevoPais == null) {
                System.out.println("Código de país inválido. Inténtelo de nuevo.");
                return;
            }

            boolean encontrado = false;
            for (DestinoTuristico destino : destinosTuristicos) {
                if (destino.getCodigo() == codigoDestinoTuristico) {
                    destino.setPais(nuevoPais);
                    encontrado = true;
                    System.out.println("País de destino turístico modificado exitosamente.");
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Destino turístico no encontrado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Valor inválido. Inténtelo de nuevo.");
        }
    }

    static void limpiarArrayListDestinosTuristicos() {
        destinosTuristicos.clear();
        System.out.println("\nArrayList de destinos turísticos limpiado correctamente.");
    }

    static void eliminarDestinoTuristico() {
        try {
            System.out.println("\n*** Eliminar un destino turístico ***");
            System.out.print("Código del destino turístico: ");
            int codigoDestinoTuristico = scanner.nextInt();

            Iterator<DestinoTuristico> iterator = destinosTuristicos.iterator();
            while (iterator.hasNext()) {
                DestinoTuristico destino = iterator.next();
                if (destino.getCodigo() == codigoDestinoTuristico) {
                    iterator.remove();
                    System.out.println("Destino turístico eliminado exitosamente.");
                    return;
                }
            }
            System.out.println("Destino turístico no encontrado.");
        } catch (InputMismatchException e) {
            System.out.println("Valor inválido. Inténtelo de nuevo.");
        }
    }

    static void mostrarDestinosTuristicosOrdenadosPorNombre() {
        destinosTuristicos.sort((a, b) -> a.getNombre().compareToIgnoreCase(b.getNombre()));
        System.out.println("\n*** Mostrar los Destinos Turísticos Ordenados por Nombre ***");
        for (DestinoTuristico destino : destinosTuristicos) {
            System.out.println(destino);
        }
    }

    static void mostrarTodosLosPaises() {
        System.out.println("\n*** Mostrar todos los Países ***");
        if (paises.isEmpty()) {
            System.out.println("No hay países.");
            return;
        }
        for (Pais pais : paises) {
            System.out.println(pais);
        }
    }

    static void mostrarDestinosTuristicosPorPais() {
        try {
            System.out.println("\n*** Mostrar los Destinos Turísticos que pertenecen a un País ***");
            System.out.print("Código del país: ");
            int codigoPais = scanner.nextInt();
            Pais pais = obtenerPaisPorCodigo(codigoPais);
            if (pais == null) {
                System.out.println("Código de país inválido. Inténtelo de nuevo.");
                return;
            }

            System.out.println("\nDestinos turísticos del país " + pais.getNombre() + ":");
            boolean encontrado = false;
            for (DestinoTuristico destino : destinosTuristicos) {
                if (destino.getPais().getCodigo() == pais.getCodigo()) {
                    System.out.println(destino);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("No se encontraron destinos turísticos para este país.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Valor inválido. Inténtelo de nuevo.");
        }
    }
}
