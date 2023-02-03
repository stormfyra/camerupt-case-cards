package com.techelevator.model;

public class ExternalApiCardDto {
    private Images images;
    private String id;
    private String name;

    public ExternalApiCardDto(Images images, String id, String name) {
        this.images = images;
        this.id = id;
        this.name = name;
    }

    public ExternalApiCardDto() {
    }

    public Images getImage() {
        return images;
    }

    public void setImage(Images images) {
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
