package com.example.entrega1;

public class Agenda {
    private Cita citas;

    public Agenda(Cita citas) {
        this.citas = citas;
    }

    public Cita getCitas() {
        return citas;
    }

    public void setCitas(Cita citas) {
        this.citas = citas;
    }
}
