package com.jains.canvas.service.console;

import com.google.common.collect.Lists;
import com.jains.canvas.model.Canvas;
import com.jains.canvas.model.Line;
import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Formatter;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleCanvanComposerTest {
    private ConsoleCanvasComposer consoleCanvasComposer;

    @Before
    public void setUp() {
        consoleCanvasComposer = new ConsoleCanvasComposer('-', '|','*');
    }

    @Test
    public void whenComposeCanvasThenReturnPlotString() {
        StringBuilder expected = new StringBuilder();
        expected
                .append(String.join("", Collections.nCopies(20, "-")))
                .append("\n")
                .append(String.format("|%18s|"," "))
                .append("\n")
                .append(String.format("|%18s|"," "))
                .append("\n")
                .append(String.format("|%18s|"," "))
                .append("\n")
                .append(String.format("|%18s|"," "))
                .append("\n")
                .append(String.join("", Collections.nCopies(20, "-")))
                .append("\n");
        assertEquals(expected.toString(),
                consoleCanvasComposer.compose(new Canvas(4, 20)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCanvasIllegalValuesThenThrowException() {
        consoleCanvasComposer.compose(new Canvas(-3, -4));
    }

    @Test
    public void whenComposeCanvasWithLinesThenReturnPlotStringWithLines() {
        StringBuilder expected = new StringBuilder();
        Formatter formatter  = new Formatter(expected);
        formatter
                .format(String.join("", Collections.nCopies(20, "-")))
                .format("\n")
                .format("|%18s|", " ")
                .format("\n")
                .format("|******%12s|"," ")
                .format("\n")
                .format("|%18s|", " ")
                .format("\n")
                .format("|%18s|", " ")
                .format("\n")
                .format(String.join("", Collections.nCopies(20, "-")))
                .format("\n");
        final Canvas canvas = new Canvas(4, 20);
        canvas.setLines(Lists.newArrayList(new Line(1,2,6,2)));
        assertEquals(expected.toString(),
                consoleCanvasComposer.compose(canvas));
    }

    @Test
    public void whenComposeCanvasWithPointsThenReturnPlotStringWithPoints() {
        StringBuilder expected = new StringBuilder();
        Formatter formatter  = new Formatter(expected);
        formatter
                .format(String.join("", Collections.nCopies(20, "-")))
                .format("\n")
                .format("|%18s|", " ")
                .format("\n")
                .format("|%18s|"," ")
                .format("\n")
                .format("|%6s%12s|","*"," ")
                .format("\n")
                .format("|%6s%12s|","*"," ")
                .format("\n")
                .format(String.join("", Collections.nCopies(20, "-")))
                .format("\n");
        final Canvas canvas = new Canvas(4, 20);
        canvas.setLines(Lists.newArrayList(new Line(6,3,6,4)));
        assertEquals(expected.toString(),
                consoleCanvasComposer.compose(canvas));
    }
}
