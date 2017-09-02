package com.jains.canvas.service;

import com.jains.canvas.model.Canvas;
import com.jains.canvas.model.ComposedCanvas;

public interface CanvasService {
    default void createCanvas(CanvasComposer canvasComposer, CanvasPlotter plotter, Canvas canvas) {
        final ComposedCanvas composedCanvas = canvasComposer.compose(canvas);
        plotter.plot(composedCanvas);
    }
}