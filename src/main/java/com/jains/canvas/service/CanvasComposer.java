package com.jains.canvas.service;

import com.jains.canvas.model.Canvas;
import com.jains.canvas.model.ComposedCanvas;

public interface CanvasComposer<T> {
	ComposedCanvas<T> compose(Canvas canvas);
}
