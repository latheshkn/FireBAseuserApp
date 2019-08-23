package com.example.adminapp;

public class CarOnRoadModel {

    String car_name;
    String Car_model;

    public CarOnRoadModel(String car_name, String car_model) {
        this.car_name = car_name;
        Car_model = car_model;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_model() {
        return Car_model;
    }

    public void setCar_model(String car_model) {
        Car_model = car_model;
    }
}
