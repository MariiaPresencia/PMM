package com.example.mariiasmiith.recopilatoriofinal.Clases;

/**
 * Created by MariiaSmiith on 5/2/16.
 */
public class Usuarios1 {
    private String usuario, contraseña;
    private int id;

    public Usuarios1(int id ,String usuario, String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.id = id;

    }

    public String getUsuario() { return usuario; }
    public String getContraseña() { return contraseña; }
    public int getId() { return id; }

}
