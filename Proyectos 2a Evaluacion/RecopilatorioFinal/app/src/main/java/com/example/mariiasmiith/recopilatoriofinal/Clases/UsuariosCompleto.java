package com.example.mariiasmiith.recopilatoriofinal.Clases;

/**
 * Created by MariiaSmiith on 8/2/16.
 */
public class UsuariosCompleto {
    String nombre , direccion , correo , contraseña;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public UsuariosCompleto(){}
    public UsuariosCompleto(String nombre , String direccion , String correo , String contraseña){
        this.nombre=nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.contraseña = contraseña;
    }
}
