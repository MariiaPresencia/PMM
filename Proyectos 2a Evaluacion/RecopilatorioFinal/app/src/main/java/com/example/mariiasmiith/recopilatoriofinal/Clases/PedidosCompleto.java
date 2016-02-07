package com.example.mariiasmiith.recopilatoriofinal.Clases;


public class PedidosCompleto {
    private int idPedido, idCliente;
    private String farmaco , dosis , forma ;
    private int unidad , precio , imagen;

    public PedidosCompleto(int idPedido,int idCliente, String farmaco,String dosis, String forma, int unidad,int precio, int imagen){
        this.idCliente = idCliente;
        this.farmaco = farmaco;
        this.dosis = dosis;
        this.forma = forma;
        this.unidad = unidad;
        this.precio = precio;
        this.imagen = imagen;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getFarmaco() {
        return farmaco;
    }

    public String getDosis() {
        return dosis;
    }

    public String getForma() {
        return forma;
    }

    public int getUnidad() {
        return unidad;
    }

    public int getPrecio() {
        return precio;
    }

    public int getImagen() {
        return imagen;
    }
}
