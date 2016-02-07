package com.example.mariiasmiith.recopilatoriofinal;

/**
 * Created by MariiaSmiith on 5/2/16.
 */
public class Usuarios1 {
    private String usuario, direccion , email;

    public Usuarios1(String usuario, String direccion, String email ){
        this.usuario = usuario;
        this.direccion = direccion;
        this.email = email;

    }

    public String getUsuario() { return usuario; }
    public String getDireccion() { return direccion; }
    public String getEmail() { return email; }

}
