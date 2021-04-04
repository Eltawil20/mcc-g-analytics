package com.example.homework2;

public class ProductModel {
    private String name;
    private int id;
    private String image;
    private String detail;

    public ProductModel(String name, String image, String detail,int id) {
        this.name = name;
        this.id = id;
        this.image = image;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getDetail() {
        return detail;
    }
}
