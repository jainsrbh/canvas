package com.jains.canvas.service.console;

import com.jains.canvas.model.Canvas;
import com.jains.canvas.model.ComposedCanvas;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConsoleComposedCanvas implements ComposedCanvas<String> {
    private Canvas canvas;
    private String composedCanvas;
}
