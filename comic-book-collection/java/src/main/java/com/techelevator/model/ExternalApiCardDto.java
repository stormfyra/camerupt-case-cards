package com.techelevator.model;

public class ExternalApiCardDto {
    private ExternalApiCardImagesDto externalApiCardImagesDto;
    private String id;
    private String name;

    public ExternalApiCardDto(ExternalApiCardImagesDto externalApiCardImagesDto, String id, String name) {
        this.externalApiCardImagesDto = externalApiCardImagesDto;
        this.id = id;
        this.name = name;
    }

    public ExternalApiCardDto() {
    }

    public ExternalApiCardImagesDto getExternalApiCardImagesDto() {
        return externalApiCardImagesDto;
    }

    public void setExternalApiCardImagesDto(ExternalApiCardImagesDto externalApiCardImagesDto) {
        this.externalApiCardImagesDto = externalApiCardImagesDto;
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
