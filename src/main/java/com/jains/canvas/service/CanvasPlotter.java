package com.jains.canvas.service;

import com.jains.canvas.model.ComposedCanvas;

public interface CanvasPlotter<T> {
    void plot(ComposedCanvas<T> t);
}
