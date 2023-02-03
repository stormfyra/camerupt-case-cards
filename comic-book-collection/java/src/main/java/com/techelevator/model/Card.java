package com.techelevator.model;

public class Card {
    private String id;
    private String cardName;
    private Images images;
    private int quantity;

    public Card(String id, String cardName, Images images, int quantity) {
        this.id = id;
        this.cardName = cardName;
        this.images = images;
        this.quantity = quantity;
    }

    public Card() {
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
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
