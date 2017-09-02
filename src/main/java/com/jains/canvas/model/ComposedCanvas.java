package com.jains.canvas.model;

public interface ComposedCanvas<T> {
    Canvas getCanvas();

    void setCanvas(Canvas canvas);

    T getComposedCanvas();
}
