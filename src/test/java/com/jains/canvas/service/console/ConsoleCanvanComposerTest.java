package com.jains.canvas.service.console;

import com.jains.canvas.model.Canvas;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleCanvanComposerTest {
    private ConsoleCanvasComposer consoleCanvasComposer;

    @Before
    public void setUp() {
        consoleCanvasComposer = new ConsoleCanvasComposer("-", "|");
    }

    @Test
    public void whenComposeCanvasThenReturnPlotString() {
        StringBuilder expected = new StringBuilder();
        expected
                .append("----")
                .append("\n")
                .append("|  |")
                .append("\n")
                .append("|  |")
                .append("\n")
                .append("|  |")
                .append("\n")
                .append("----");
        assertEquals(expected.toString(),
                consoleCanvasComposer.compose(new Canvas(3, 4)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCanvasIllegalValuesThenThrowException() {
        consoleCanvasComposer.compose(new Canvas(-3, -4));
    }
}
