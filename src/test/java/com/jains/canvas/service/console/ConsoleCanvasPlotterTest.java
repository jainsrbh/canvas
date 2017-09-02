package com.jains.canvas.service.console;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleCanvasPlotterTest {
    private ConsoleCanvasPlotter plotter;

    @Before
    public void setUp() {
        plotter = new ConsoleCanvasPlotter();
    }

    @Test
    public void whenPlotThenPrintSystemOut() {
        ConsoleComposedCanvas composedCanvas = Mockito.mock(ConsoleComposedCanvas.class);
        plotter.plot(composedCanvas);
        Mockito.verify(composedCanvas, Mockito.times(1)).getComposedCanvas();
    }

}
