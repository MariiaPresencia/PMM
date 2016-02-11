package com.example.mariiasmiith.recopilatoriofinal.Clases;


public class PedidosCompleto {
    private int idPedido, idCliente;
    private String farmaco , dosis , forma ;
    private int unidad , imagen;
    private double precio;

    public PedidosCompleto(){}


    public PedidosCompleto(int idPedido,int idCliente, String farmaco,String dosis, String forma, int unidad,double precio, int imagen){
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.farmaco = farmaco;
        this.dosis = dosis;
        this.forma = forma;
        this.unidad = unidad;
        this.precio = precio;
        this.imagen = imagen;
    }
    public PedidosCompleto(int id){
        this.idPedido = id;
    }
    public int getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(int idpedido){
        idPedido= idpedido;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idcliente){
        idCliente=idcliente;
    }
    public String getFarmaco() {
        return farmaco;
    }
    public void setFarmaco(String farmaco1){farmaco=farmaco1;}
    public String getDosis() {
        return dosis;
    }
    public void setDosis(String dosi){dosis=dosi;}
    public String getForma() {
        return forma;
    }
    public void setForma(String form){forma= form;}
    public int getUnidad() {
        return unidad;
    }
    public void setUnidad(int uni){unidad= uni;}
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio1){precio = precio1;}
    public int getImagen() {
        return imagen;
    }
    public void setImagen(int ima){imagen=ima;}
}
