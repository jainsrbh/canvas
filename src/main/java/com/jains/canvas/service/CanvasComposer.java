package com.jains.canvas.service;

import com.jains.canvas.model.Canvas;

public interface CanvasComposer<T> {
	T compose(Canvas canvas);
}
