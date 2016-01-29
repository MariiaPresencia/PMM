package com.example.mariiasmiith.pviajes;

/**
 * Created by MariiaSmiith on 8/11/15.
 */
public class Viajes {
    private String zona;
    private String Nombre;
    private double precio;

    public Viajes(String z , String n , double num){
        zona = z;
        Nombre = n;
        precio = num;
    }

    public String getZona(){
        return zona;
    }

    public String getNombre() {
        return Nombre;
    }

    public double getPrecio() {
        return precio;
    }
    public void setNombre(String nombre){
        Nombre = nombre;
    }
    public void setZona(String zona){
        this.zona = zona;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public String toString(){
        return zona+" "+Nombre+" "+precio;
    }
}
