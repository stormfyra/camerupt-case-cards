package com.techelevator.model;

public class Card {
    private int cardId;
    private String cardName;
    private String largeImage;
    private String smallImage;

    public Card(int cardId, String cardName, String largeImage, String smallImage) {
        this.cardId = cardId;
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

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
}
