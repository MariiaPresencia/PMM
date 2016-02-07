package com.example.mariiasmiith.recopilatoriofinal.Clases;

/**
 * Created by MariiaSmiith on 4/2/16.
 */
public class Farmacos {
    private String farmaco;
    private double precio;
    private int imagen;

    public Farmacos(String tipo, double precio, int imagen){
        this.farmaco = tipo;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getFarmaco() { return farmaco; }
    public double getPrecio() { return precio; }
    public int getImagen() { return imagen; }
}
