package com.jains.canvas.service.console;

import com.jains.canvas.model.Canvas;
import com.jains.canvas.model.ComposedCanvas;
import com.jains.canvas.service.CanvasComposer;
import com.jains.canvas.service.CanvasPlotter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleCanvasServiceTest {
    @Mock
    private CanvasComposer<String> canvasComposer;
    @Mock
    private CanvasPlotter<String> canvasPlotter;
    @InjectMocks
    private ConsoleCanvasService consoleCanvasService;

    @Test
    public void shouldQuitOnUserInput() throws Exception {
        String input = "Q";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        consoleCanvasService.run();
    }

    @Test
    public void shoulNotdQuitOnOtherUserInput() throws Exception {
        String input = "C 20 4\r\nQ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        consoleCanvasService.run();
        verify(canvasComposer, Mockito.times(1)).compose(Mockito.any(Canvas.class));
        verify(canvasPlotter, Mockito.times(1)).plot(Mockito.any(ComposedCanvas.class));
    }
}
