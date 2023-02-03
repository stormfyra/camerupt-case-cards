package com.techelevator.model;

public class ExternalApiCardImagesDto {
    private String large;
    private String small;

    public ExternalApiCardImagesDto(String large, String small) {
        this.large = large;
        this.small = small;
    }

    public ExternalApiCardImagesDto() {}

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }
}
