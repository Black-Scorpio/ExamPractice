package com.example.exampractice;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Dealership {

    @SerializedName("Dealership")
    private String dealership;

    @SerializedName("Inventory")
    private ArrayList<Car> inventory;

    public String getDealership() {
        return dealership;
    }

    public ArrayList<Car> getInventory() {
        return inventory;
    }


}
