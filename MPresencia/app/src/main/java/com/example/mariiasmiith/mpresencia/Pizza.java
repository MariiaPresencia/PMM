package com.example.mariiasmiith.mpresencia;

/**
 * Created by MariiaSmiith on 9/11/15.
 */
public class Pizza {
   private String nombre;
    private String descripcion;
    private double precio;

    public Pizza(String nombre , String descripcion, double precio){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public double getPrecio(){
        return precio;
    }
}
