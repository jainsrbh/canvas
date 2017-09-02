package com.jains.canvas.service;

import com.jains.canvas.model.Canvas;
import com.jains.canvas.model.ComposedCanvas;

public interface CanvasService<T> {
    Canvas createCanvas();

    default void plotCanvas(CanvasComposer<T> canvasComposer, CanvasPlotter<T> plotter, Canvas canvas) {
        final ComposedCanvas composedCanvas = canvasComposer.compose(canvas);
        plotter.plot(composedCanvas);
    }


}
