package com.jains.canvas.model;

import lombok.Builder;
import lombok.Data;

@Data
public class Bucket {
    int x;
    int y;
    char colour;

    @Builder
    public Bucket(int x, int y, char colour) throws IllegalArgumentException {
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException("Less than zero coordinates are not allowed");
        }
        this.x = x;
        this.y = y;
        this.colour = colour;
    }
}
