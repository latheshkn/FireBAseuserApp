package com.example.adminapp.CarviewModelfirebase;

public class Blog {

    private int Age;
    private String Name;
    private String  Image;

    public Blog(int age, String name, String image) {
        Age = age;
        Name = name;
        Image = image;
    }
    public Blog() {

    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
