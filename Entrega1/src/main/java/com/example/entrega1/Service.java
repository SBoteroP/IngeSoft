package com.example.entrega1;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Service {
    private StringProperty name;
    private DoubleProperty price;
    private StringProperty provider;

    public Service(String name, double price, String provider) {
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.provider = new SimpleStringProperty(provider);
    }

    public StringProperty serviceNameProperty() {
        return name;
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public StringProperty providerProperty() {
        return provider;
    }

    public String getName() {
        return name.get();
    }

    public double getPrice() {
        return price.get();
    }

    public String getProvider() {
        return provider.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public void setProvider(String provider) {
        this.provider.set(provider);
    }
}
