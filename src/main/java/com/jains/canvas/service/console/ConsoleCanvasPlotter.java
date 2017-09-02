package com.jains.canvas.service.console;

import com.jains.canvas.model.ComposedCanvas;
import com.jains.canvas.service.CanvasPlotter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class ConsoleCanvasPlotter implements CanvasPlotter<String> {
    @Override
    public void plot(ComposedCanvas<String> composedCanvas) {
        System.out.println(composedCanvas.getComposedCanvas());
    }
}
