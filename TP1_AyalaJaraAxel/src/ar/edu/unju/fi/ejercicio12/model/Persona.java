package ar.edu.unju.fi.ejercicio12.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Persona {
    private String nombre;
    private Calendar fechaNacimiento;

    public Persona(String nombre, Calendar fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int calcularEdad() {
        Calendar now = new GregorianCalendar();
        int edad = now.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
        if (fechaNacimiento.get(Calendar.MONTH) > now.get(Calendar.MONTH)
                || (fechaNacimiento.get(Calendar.MONTH) == now.get(Calendar.MONTH)
                && fechaNacimiento.get(Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH))) {
            edad--;
        }
        return edad;
    }

    public String obtenerSignoZodiaco() {
        int dia = fechaNacimiento.get(Calendar.DAY_OF_MONTH);
        int mes = fechaNacimiento.get(Calendar.MONTH) + 1;

        if ((mes == 3 && dia >= 21) || (mes == 4 && dia <= 20)) {
            return "Aries";
        } else if ((mes == 4 && dia >= 21) || (mes == 5 && dia <= 20)) {
            return "Tauro";
        } else if ((mes == 5 && dia >= 21) || (mes == 6 && dia <= 20)) {
            return "Géminis";
        } else if ((mes == 6 && dia >= 21) || (mes == 7 && dia <= 22)) {
            return "Cáncer";
        } else if ((mes == 7 && dia >= 23) || (mes == 8 && dia <= 22)) {
            return "Leo";
        } else if ((mes == 8 && dia >= 23) || (mes == 9 && dia <= 22)) {
            return "Virgo";
        } else if ((mes == 9 && dia >= 23) || (mes == 10 && dia <= 22)) {
            return "Libra";
        } else if ((mes == 10 && dia >= 23) || (mes == 11 && dia <= 21)) {
            return "Escorpio";
        } else if ((mes == 11 && dia >= 22) || (mes == 12 && dia <= 21)) {
            return "Sagitario";
        } else if ((mes == 12 && dia >= 22) || (mes == 1 && dia <= 19)) {
            return "Capricornio";
        } else if ((mes == 1 && dia >= 20) || (mes == 2 && dia <= 18)) {
            return "Acuario";
        } else {
            return "Piscis";
        }
    }

    public String obtenerEstacion() {
        int mes = fechaNacimiento.get(Calendar.MONTH) + 1;

        if (mes >= 3 && mes <= 5) {
            return "Otoño";
        } else if (mes >= 6 && mes <= 8) {
            return "Invierno";
        } else if (mes >= 9 && mes <= 11) {
            return "Primavera";
        } else {
            return "Verano";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
