package com.example.adminapp.CarRemoveModel;

public class ModelforImage {

    private  String capacity;
    private  String image;
    private  String model;
    private  String name;
    private  String rent;

    public ModelforImage() {

    }

    public ModelforImage(String capacity, String image, String model, String namd, String rent) {
        this.capacity = capacity;
        this.image = image;
        this.model = model;
        this.name = namd;
        this.rent = rent;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }
}
