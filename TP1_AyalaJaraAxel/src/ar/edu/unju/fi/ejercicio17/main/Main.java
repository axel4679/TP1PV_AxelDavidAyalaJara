package ar.edu.unju.fi.ejercicio17.main;

import ar.edu.unju.fi.ejercicio17.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Jugador> jugadores = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion;

		do {
			System.out.println("\n*** Menú de Opciones ***");
			System.out.println("1 – Alta de jugador");
			System.out.println("2 – Mostrar los datos del jugador");
			System.out.println("3 – Mostrar todos los jugadores ordenados por apellido");
			System.out.println("4 – Modificar los datos de un jugador");
			System.out.println("5 – Eliminar un jugador");
			System.out.println("6 – Mostrar la cantidad total de jugadores");
			System.out.println("7 – Mostrar la cantidad de jugadores que pertenecen a una nacionalidad");
			System.out.println("8 – Salir");
			System.out.print("Ingrese una opción: ");
			opcion = obtenerOpcion();

			switch (opcion) {
			case 1:
				altaJugador();
				break;
			case 2:
				mostrarDatosJugador();
				break;
			case 3:
				mostrarJugadoresOrdenadosPorApellido();
				break;
			case 4:
				modificarJugador();
				break;
			case 5:
				eliminarJugador();
				break;
			case 6:
				mostrarCantidadTotalJugadores();
				break;
			case 7:
				mostrarCantidadJugadoresPorNacionalidad();
				break;
			case 8:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción no válida. Inténtelo de nuevo.");
				break;
			}

		} while (opcion != 8);

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
				scanner.next(); 
			}
		} while (!entradaValida);

		return opcion;
	}

	static void altaJugador() {
		try {
			scanner.nextLine(); 
			System.out.println("\n*** Alta de Jugador ***");
			System.out.print("Nombre: ");
			String nombre = scanner.nextLine();
			System.out.print("Apellido: ");
			String apellido = scanner.nextLine();
			System.out.print("Fecha de nacimiento (dd/MM/yyyy): ");
			String fechaNacimientoStr = scanner.nextLine();
			System.out.print("Nacionalidad: ");
			String nacionalidad = scanner.nextLine();
			System.out.print("Estatura (cm): ");
			double estatura = scanner.nextDouble();
			System.out.print("Peso (kg): ");
			double peso = scanner.nextDouble();
			scanner.nextLine(); 
			System.out.print("Posición (delantero, medio, defensa, arquero): ");
			String posicion = scanner.nextLine();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			jugadores.add(new Jugador(nombre, apellido, sdf.parse(fechaNacimientoStr), nacionalidad, estatura, peso,
					posicion));
			System.out.println("Jugador agregado exitosamente.");
		} catch (ParseException e) {
			System.out.println("Formato de fecha incorrecto. Inténtelo de nuevo.");
		}
	}

	static void mostrarDatosJugador() {
		try {
			scanner.nextLine(); 
			System.out.println("\n*** Mostrar Datos del Jugador ***");
			System.out.print("Nombre: ");
			String nombre = scanner.nextLine();
			System.out.print("Apellido: ");
			String apellido = scanner.nextLine();

			for (Jugador jugador : jugadores) {
				if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
					System.out.println("Nombre: " + jugador.getNombre());
					System.out.println("Apellido: " + jugador.getApellido());
					System.out.println("Fecha de Nacimiento: "
							+ new SimpleDateFormat("dd/MM/yyyy").format(jugador.getFechaNacimiento()));
					System.out.println("Nacionalidad: " + jugador.getNacionalidad());
					System.out.println("Estatura: " + jugador.getEstatura() + " cm");
					System.out.println("Peso: " + jugador.getPeso() + " kg");
					System.out.println("Posición: " + jugador.getPosicion());
					System.out.println("Edad: " + jugador.calcularEdad() + " años");
					return;
				}
			}
			System.out.println("Jugador no encontrado.");
		} catch (Exception e) {
			System.out.println("Error al ingresar los datos del jugador. Inténtelo de nuevo.");
		}
	}

	static void mostrarJugadoresOrdenadosPorApellido() {
		System.out.println("\n*** Jugadores Ordenados por Apellido ***");
		List<Jugador> copiaJugadores = new ArrayList<>(jugadores);
		copiaJugadores.sort(Comparator.comparing(Jugador::getApellido));
		copiaJugadores.forEach(jugador -> System.out.println(jugador.getApellido() + ", " + jugador.getNombre()));
	}

	static void modificarJugador() {
		try {
			scanner.nextLine(); 
			System.out.println("\n*** Modificar Datos del Jugador ***");
			System.out.print("Nombre: ");
			String nombre = scanner.nextLine();
			System.out.print("Apellido: ");
			String apellido = scanner.nextLine();

			for (Jugador jugador : jugadores) {
				if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
					System.out.println("Modificar Datos:");
					System.out.print("Nacionalidad: ");
					jugador.setNacionalidad(scanner.nextLine());
					System.out.print("Estatura (cm): ");
					jugador.setEstatura(scanner.nextDouble());
					System.out.print("Peso (kg): ");
					jugador.setPeso(scanner.nextDouble());
					scanner.nextLine(); 
					System.out.print("Posición (delantero, medio, defensa, arquero): ");
					jugador.setPosicion(scanner.nextLine());
					System.out.println("Datos del Jugador Modificados Exitosamente.");
					return;
				}
			}
			System.out.println("Jugador no encontrado.");
		} catch (Exception e) {
			System.out.println("Error al ingresar los datos del jugador. Inténtelo de nuevo.");
		}
	}

	static void eliminarJugador() {
		try {
			scanner.nextLine(); 
			System.out.println("\n*** Eliminar Jugador ***");
			System.out.print("Nombre: ");
			String nombre = scanner.nextLine();
			System.out.print("Apellido: ");
			String apellido = scanner.nextLine();

			for (int i = 0; i < jugadores.size(); i++) {
				if (jugadores.get(i).getNombre().equalsIgnoreCase(nombre)
						&& jugadores.get(i).getApellido().equalsIgnoreCase(apellido)) {
					jugadores.remove(i);
					System.out.println("Jugador eliminado exitosamente.");
					return;
				}
			}
			System.out.println("Jugador no encontrado.");
		} catch (Exception e) {
			System.out.println("Error al ingresar los datos del jugador. Inténtelo de nuevo.");
		}
	}

	static void mostrarCantidadTotalJugadores() {
		System.out.println("\n*** Cantidad Total de Jugadores ***");
		System.out.println("Total de jugadores: " + jugadores.size());
	}

	static void mostrarCantidadJugadoresPorNacionalidad() {
		try {
			scanner.nextLine(); 
			System.out.println("\n*** Cantidad de Jugadores por Nacionalidad ***");
			System.out.print("Nacionalidad: ");
			String nacionalidad = scanner.nextLine();

			int cantidad = 0;
			for (Jugador jugador : jugadores) {
				if (jugador.getNacionalidad().equalsIgnoreCase(nacionalidad)) {
					cantidad++;
				}
			}
			System.out.println("Cantidad de jugadores de " + nacionalidad + ": " + cantidad);
		} catch (Exception e) {
			System.out.println("Error al ingresar los datos de la nacionalidad. Inténtelo de nuevo.");
		}
	}
}
