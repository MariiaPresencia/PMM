package com.example.mariiasmiith.figurasaleatorias.Clases;

/**
 * Created by MariiaSmiith on 12/2/16.
 */
public class Figuras {
    private String nombre;
    private int imagen;
    private Figura figura;
    //constructor
    public Figuras(String nombre, int imagen, Figura figura){
        this.nombre = nombre;
        this.imagen = imagen;
        this.figura = figura;
    }
    //setters y getters
    public String getNombre(){return nombre;}

    public int getImagen(){ return imagen;}

    public Figura getFigura(){ return figura;}

    public String toString(){
        return (nombre +".");
    }
}
