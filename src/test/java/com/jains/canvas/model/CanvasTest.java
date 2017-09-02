package com.jains.canvas.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CanvasTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenCanvasIllegalValuesThenThrowException() {
        new Canvas(-3, -4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenLinesIllegalValuesThenThrowException() {
        final Canvas canvas = new Canvas(4, 20);
        canvas.addLine(new Line(-1, -2, 6, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenLinesBeyondCoordinateValuesThenThrowException() {
        final Canvas canvas = new Canvas(4, 20);
        canvas.addLine(new Line(1, 2, 6, 24));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenLineInvalidCoordinateValuesThenThrowException() {
        final Canvas canvas = new Canvas(4, 20);
        canvas.addLine(new Line(5, 12, 3, 15));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenRectangleBeyondCoordinateValuesThenThrowException() {
        final Canvas canvas = new Canvas(4, 20);
        canvas.addRectangle(new Rectangle(1, 2, 6, 24));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenRectangleNegativeCoordinateValuesThenThrowException() {
        final Canvas canvas = new Canvas(4, 20);
        canvas.addRectangle(new Rectangle(-1, -2, 6, 24));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenRectangleInvalidCoordinateValuesThenThrowException() {
        final Canvas canvas = new Canvas(4, 20);
        canvas.addRectangle(new Rectangle(5, 12, 3, 15));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenBucketIllegalValuesThenThrowException() {
        final Canvas canvas = new Canvas(4, 20);
        canvas.setFillBucket(new Bucket(-4, -5, 't'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenBucketBeyondCoordinatesValuesThenThrowException() {
        final Canvas canvas = new Canvas(4, 20);
        canvas.setFillBucket(new Bucket(3, 21, 't'));
    }
}
