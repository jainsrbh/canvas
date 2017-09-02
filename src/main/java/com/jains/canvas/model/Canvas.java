package com.jains.canvas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class Canvas {
    private final int height;
    private final int width;
    private List<Line> lines;

    @Builder
    public Canvas(int height, int width) throws IllegalArgumentException {
        if (height < 0 || width < 0) {
            throw new IllegalArgumentException("Less than zero widht/height are not allowed");
        }
        this.height = height;
        this.width = width;
    }
}
