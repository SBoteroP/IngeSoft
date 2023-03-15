package com.example.entrega1;

public class User {
    private String nombre;
    private String username;
    private String password;
    private String correo;
    private int telefono;

    public User(String nombre, String username, String password, String correo, int telefono) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.correo = correo;
        this.telefono = telefono;
    }
    public User(){}
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
