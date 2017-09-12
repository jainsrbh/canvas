package com.jains.canvas.model;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@EqualsAndHashCode
@Getter
public class Canvas {
    private final int height;
    private final int width;
    private List<Line> lines;
    private List<Rectangle> rectangles;
    private List<Bucket> buckets;

    @Builder
    public Canvas(int width, int height) throws IllegalArgumentException {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Less than zero width/height are not allowed");
        }
        this.height = height;
        this.width = width;
    }

    public void addLine(Line line) throws IllegalArgumentException {
        if (line.getX2() > width || line.getY2() > height) {
            throw new IllegalArgumentException("Line coordinates beyond canvas coordinates");
        }
        if (lines == null) {
            lines = Lists.newArrayList();
        }
        lines.add(line);
    }

    public void addRectangle(Rectangle rectangle) throws IllegalArgumentException {
        if (rectangle.getX2() > width || rectangle.getY2() > height) {
            throw new IllegalArgumentException("Rectangle coordinates beyond canvas coordinates");
        }
        if (rectangles == null) {
            rectangles = Lists.newArrayList();
        }
        rectangles.add(rectangle);
    }

    public void addBucket(Bucket bucket) throws IllegalArgumentException {
        if (bucket.getX() > width || bucket.getY() > height) {
            throw new IllegalArgumentException("Bucket coordinates beyond canvas coordinates");
        }
        if (buckets == null) {
            buckets = Lists.newArrayList();
        }
        this.buckets.add(bucket);
    }
}
