package com.example.mariiasmiith.figurasaleatorias.Clases;


public class Cuadrado extends Rectangulo {
    public Cuadrado() {   super();
        tipe = "cuadrado";
    }

    public Cuadrado(int color, double lado) {
        super(color,lado, lado);
        tipe = "cuadrado";
    }
    //setters y getters
    public double getLado() {
        return base;
    }

    public void setLado(double lado) {
        base = altura = lado;
    }

    public void setBase(double base) {
        this.base = this.altura = base;
    }

    public void setAltura(double altura) {
        this.base = this.altura = altura;
    }

    public String toString(){
        return "Cuadrado " + color + " lado " + getLado();
    }
}
