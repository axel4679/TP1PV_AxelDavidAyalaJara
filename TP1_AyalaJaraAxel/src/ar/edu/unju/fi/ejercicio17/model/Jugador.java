package ar.edu.unju.fi.ejercicio17.model;
import java.util.Calendar;
import java.util.Date;

public class Jugador {
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String nacionalidad;
	private double estatura;
	private double peso;
	private String posicion;

	public Jugador(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, double estatura,
			double peso, String posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public double getEstatura() {
		return estatura;
	}

	public double getPeso() {
		return peso;
	}

	public String getPosicion() {
		return posicion;
	}
	
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }


	public int calcularEdad() {
		Calendar fechaNacimiento = Calendar.getInstance();
		fechaNacimiento.setTime(this.fechaNacimiento);
		Calendar hoy = Calendar.getInstance();

		int diffAnios = hoy.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
		if (fechaNacimiento.get(Calendar.MONTH) > hoy.get(Calendar.MONTH)
				|| (fechaNacimiento.get(Calendar.MONTH) == hoy.get(Calendar.MONTH)
						&& fechaNacimiento.get(Calendar.DAY_OF_MONTH) > hoy.get(Calendar.DAY_OF_MONTH))) {
			diffAnios--;
		}
		return diffAnios;
	}
}
