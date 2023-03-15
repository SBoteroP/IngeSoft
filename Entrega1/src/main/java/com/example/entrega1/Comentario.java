package com.example.entrega1;

public class Comentario {
    private Cliente cliente;
    private Prestador prestador;
    private int valoracion;
    private Service servicio;

    public Comentario(Cliente cliente, Prestador prestador, int valoracion, Service servicio) {
        this.cliente = cliente;
        this.prestador = prestador;
        this.valoracion = valoracion;
        this.servicio = servicio;
    }

    public Comentario() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public Service getServicio() {
        return servicio;
    }

    public void setServicio(Service servicio) {
        this.servicio = servicio;
    }
}
