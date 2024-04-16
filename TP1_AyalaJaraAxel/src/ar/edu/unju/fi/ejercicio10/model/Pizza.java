package ar.edu.unju.fi.ejercicio10.model;


public class Pizza {
    private int diametro;
    private double precio;
    private double area;
    private boolean ingredientesEspeciales;

    public Pizza() {
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        if (diametro == 20 || diametro == 30 || diametro == 40) {
            this.diametro = diametro;
        } else {
            System.out.println("El diámetro de la pizza debe ser 20, 30 o 40.");
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public boolean isIngredientesEspeciales() {
        return ingredientesEspeciales;
    }

    public void setIngredientesEspeciales(boolean ingredientesEspeciales) {
        this.ingredientesEspeciales = ingredientesEspeciales;
    }

    public void calcularPrecio() {
        if (diametro == 20) {
            if (ingredientesEspeciales) {
                precio = 4500 + 500;
            } else {
                precio = 4500;
            }
        } else if (diametro == 30) {
            if (ingredientesEspeciales) {
                precio = 4800 + 750;
            } else {
                precio = 4800;
            }
        } else if (diametro == 40) {
            if (ingredientesEspeciales) {
                precio = 5500 + 1000;
            } else {
                precio = 5500;
            }
        }
    }

    public void calcularArea() {
        area = Math.PI * Math.pow(diametro / 2.0, 2);
    }
}

