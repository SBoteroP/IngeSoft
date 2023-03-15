package com.example.entrega1;

public class Prestador extends User{
    private Service servicio;

    public Service getServicio() {
        return servicio;
    }

    public void setServicio(Service servicio) {
        this.servicio = servicio;
    }
}
