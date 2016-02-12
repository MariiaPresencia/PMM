package com.example.mariiasmiith.figurasaleatorias.Clases;

import android.graphics.*;


public class Rectangulo extends Figura{
    protected double base;
    protected double altura;

    /** Constructor por defecto: crea un rectángulo de color negro (Color.black), base 10.0 y altura 10.0   */
    public Rectangulo() {
        super(Color.BLACK, "rectángulo");
        base = 10.0;
        altura = 10.0;
    }

    public Rectangulo(int color, double base, double altura) {
        super(color, "rectángulo");
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double area(){
        return base * altura;
    }

    public String toString() {
        return "Rectángulo " + color + " de base " + base + " y altura " + altura;
    }
}
