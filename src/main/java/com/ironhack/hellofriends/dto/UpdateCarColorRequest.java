package com.ironhack.hellofriends.dto;

public class UpdateCarColorRequest {
    private Long carId;
    private String Color;

    public UpdateCarColorRequest() {
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
