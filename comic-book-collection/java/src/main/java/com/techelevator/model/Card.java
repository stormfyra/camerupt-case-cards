package com.techelevator.model;

public class Card {
    private String id;
    private String name;
    private Images images;
    private int quantity;

    public Card(String id, String name, Images images, int quantity) {
        this.id = id;
        this.name = name;
        this.images = images;
        this.quantity = quantity;
    }

    public Card() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
