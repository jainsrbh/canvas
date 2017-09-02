package com.jains.canvas.model;

import lombok.Builder;
import lombok.Data;

@Data

public class Line {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    @Builder
    public Line(int x1, int y1, int x2, int y2) throws IllegalArgumentException {
        if (x1 <=0 || y1 <= 0 || x2 <= 0 || y2 <= 0) {
            throw new IllegalArgumentException("Less than zero coordinates are not allowed");
        }
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
