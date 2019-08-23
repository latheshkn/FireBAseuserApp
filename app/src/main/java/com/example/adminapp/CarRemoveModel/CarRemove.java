package com.example.adminapp.CarRemoveModel;

public class CarRemove {

    private String Name;
    private  String Model;
    private  String Rent;
    private  String image;
    private String Capacity;

    public CarRemove() {
    }

    public CarRemove(String name, String model, String rent, String image, String capacity) {
        Name = name;
        Model = model;
        Rent = rent;
        this.image = image;
        Capacity = capacity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getRent() {
        return Rent;
    }

    public void setRent(String rent) {
        Rent = rent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }
}


