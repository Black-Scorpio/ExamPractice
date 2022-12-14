package com.example.exampractice;

public class Car {

          private int id;
          private int  year;
          private String make;
          private double price;
          private String model;
          private String type;

    public Car(int id, int year, String make, double price, String model, String type) {
        this.id = id;
        this.year = year;
        this.make = make;
        this.price = price;
        this.model = model;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%d %s-%s $%s", year, make, model, price);
    }
}
