package com.jains.canvas;

import com.jains.canvas.config.ConsoleCanvasTestConfiguration;
import com.jains.canvas.model.Canvas;
import com.jains.canvas.service.CanvasService;
import com.jains.canvas.service.console.ConsoleCanvasComposer;
import com.jains.canvas.service.console.ConsoleCanvasPlotter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConsoleCanvasTestConfiguration.class})
public class CanvasApplicationIntegrationTest {
    @Autowired
    private ConsoleCanvasComposer consoleCanvasComposer;
    @Autowired
    private ConsoleCanvasPlotter consoleCanvasPlotter;

    @Test
    public void whenPlotCanvasThenInvokeComposeAndPlot() {
        CanvasService<String> canvasService = new CanvasService() {
        };
        ConsoleCanvasComposer spyComposer = Mockito.spy(consoleCanvasComposer);
        ConsoleCanvasPlotter spyPlotter = Mockito.spy(consoleCanvasPlotter);
        final Canvas canvas = new Canvas(40, 100);
        canvasService.plotCanvas(spyComposer, spyPlotter, canvas);
        Mockito.verify(spyComposer, Mockito.times(1)).compose(canvas);
        Mockito.verify(spyPlotter, Mockito.times(1)).plot(consoleCanvasComposer.compose(canvas));
    }
}
