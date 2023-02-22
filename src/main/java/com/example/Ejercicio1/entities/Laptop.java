package com.example.Ejercicio1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;
    private String model;
    private String serie;

    public Laptop() {
    }

    public Laptop(Long id, Double price, String model, String serie) {
        this.id = id;
        this.price = price;
        this.model = model;
        this.serie = serie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "LaptopEntity{" +
                "id=" + id +
                ", price=" + price +
                ", model='" + model + '\'' +
                ", serie='" + serie + '\'' +
                '}';
    }
}
