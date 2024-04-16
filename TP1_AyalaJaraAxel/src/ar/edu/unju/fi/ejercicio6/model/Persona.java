package ar.edu.unju.fi.ejercicio6.model;

import java.time.LocalDate;

public class Persona {
	private String dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String provincia;

	public Persona() {
	}

	public Persona(String dni, String nombre, LocalDate fechaNacimiento, String provincia) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.provincia = provincia;
	}

	public Persona(String dni, String nombre, LocalDate fechaNacimiento) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.provincia = "Jujuy";
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;

	}

	public int calcularEdad() {
		LocalDate fechaActual = LocalDate.now();
		if (fechaNacimiento != null) {
			return fechaActual.getYear() - fechaNacimiento.getYear();
		} else {
			return 0;
		}

	}

	public String esMayorEdad() {
		String op;
		
		if (calcularEdad() >= 18) {
			op = "La persona es mayor de edad";
		} else {
			op = "La persona no es mayor de edad";
		}
		return op;
	}

	public void mostrarDatos() {
		System.out.println("DNI: " + dni);
		System.out.println("Nombre: " + nombre);
		System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
		System.out.println("Provincia: " + provincia);
		System.out.println("Edad: " + calcularEdad());
	}
}
