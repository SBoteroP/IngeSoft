package com.example.entrega1;

public class Service {
    private String name;
    private double price;
    private String provider;

    public Service(String name, double price, String provider) {
        this.name = name;
        this.price = price;
        this.provider = provider;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getProvider() {
        return provider;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
