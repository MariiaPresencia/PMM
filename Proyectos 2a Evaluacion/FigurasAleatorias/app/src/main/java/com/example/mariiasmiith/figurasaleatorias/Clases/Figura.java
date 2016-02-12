package com.example.mariiasmiith.figurasaleatorias.Clases;


import android.graphics.Color;


public class Figura {
    protected int color;
    protected String tipe;

    // Este constructor crea una figura con color rojo  y tipo x para indicar que es indefinido"
    public Figura() {
        color = Color.RED;
        tipe = "x";
    }
    public Figura(int color, String tipo) {
        this.color = color;
        this.tipe = tipo;
    }
    //Setters y Getters
    public String getTipe() {
        return tipe;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color){
        this.color = color;
    }

    public String toString(){
        return "Figura: " + tipe + " y con el color " + color;
    }
    //Comprueba que la figura que recibe sea igual, es decir tenga mismo color y tipo.
    public boolean equals(Object y) {
        Figura f = (Figura) y;
        return (color==(f.color) && tipe.equals(f.tipe));
    }
}
