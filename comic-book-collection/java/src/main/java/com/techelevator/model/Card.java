package com.techelevator.model;

public class Card {
    private String cardName;
    private String largeImage;
    private String smallImage;

    public Card(String cardName, String largeImage, String smallImage) {
        this.cardName = cardName;
        this.largeImage = largeImage;
        this.smallImage = smallImage;
    }

    public Card() {
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }
}
