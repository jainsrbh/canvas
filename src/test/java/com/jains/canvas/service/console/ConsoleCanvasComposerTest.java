package com.jains.canvas.service.console;

import com.jains.canvas.model.Bucket;
import com.jains.canvas.model.Canvas;
import com.jains.canvas.model.Line;
import com.jains.canvas.model.Rectangle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Formatter;

import static java.lang.String.format;
import static java.lang.String.join;
import static java.util.Collections.nCopies;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleCanvasComposerTest {
    private static final String NEW_LINE = "\n";
    private ConsoleCanvasComposer consoleCanvasComposer;

    @Before
    public void setUp() {
        consoleCanvasComposer = new ConsoleCanvasComposer('-', '|', '*');
    }

    /**
     * Test a plain canvas
     */
    @Test
    public void whenComposeCanvasThenReturnPlotString() {
        int x = 20;
        int y = 4;
        StringBuilder expected = new StringBuilder();
        Formatter formatter = new Formatter(expected)
                .format(getCanvasXBorder(x))
                .format(getCanvasYBorder(x, y))
                .format(getCanvasXBorder(x));
        assertEquals(expected.toString(),
                consoleCanvasComposer.compose(new Canvas(x, y)).getComposedCanvas());
    }

    /**
     * Test a canvas with a line
     */
    @Test
    public void whenComposeCanvasWithALineThenReturnPlotStringWithALine() {
        int x = 20;
        int y = 4;
        StringBuilder expected = new StringBuilder();
        Formatter formatter = new Formatter(expected)
                .format(getCanvasXBorder(x))
                .format(getCanvasYBorder(x, 1))
                .format("|******%14s|", " ")
                .format(NEW_LINE)
                .format(getCanvasYBorder(x, 2))
                .format(getCanvasXBorder(x));
        final Canvas canvas = new Canvas(x, y);
        canvas.addLine(new Line(1, 2, 6, 2));
        assertEquals(expected.toString(),
                consoleCanvasComposer.compose(canvas).getComposedCanvas());
    }

    /**
     * Test a canvas with multiple line
     */
    @Test
    public void whenComposeCanvasWithLinesThenReturnPlotStringWithLines() {
        int x = 20;
        int y = 4;
        StringBuilder expected = new StringBuilder();
        Formatter formatter = new Formatter(expected)
                .format(getCanvasXBorder(x))
                .format(getCanvasYBorder(x, 1))
                .format("|******%14s|", " ")
                .format(NEW_LINE)
                .format("|******%14s|", " ")
                .format(NEW_LINE)
                .format(getCanvasYBorder(x, 1))
                .format(getCanvasXBorder(x));
        final Canvas canvas = new Canvas(x, y);
        canvas.addLine(new Line(1, 2, 6, 3));
        assertEquals(expected.toString(),
                consoleCanvasComposer.compose(canvas).getComposedCanvas());
    }

    /**
     * Test a canvas with multiple command lines
     */
    @Test
    public void whenComposeCanvasWithLinesThenReturnPlotStringWithMultipleLines() {
        int x = 20;
        int y = 4;
        StringBuilder expected = new StringBuilder();
        Formatter formatter = new Formatter(expected)
                .format(getCanvasXBorder(x))
                .format(getCanvasYBorder(x, 1))
                .format("|******%14s|", " ")
                .format(NEW_LINE)
                .format("|******%14s|", " ")
                .format(NEW_LINE)
                .format(getCanvasYBorder(x, 1))
                .format(getCanvasXBorder(x));
        final Canvas canvas = new Canvas(x, y);
        canvas.addLine(new Line(1, 2, 6, 2));
        canvas.addLine(new Line(1, 3, 6, 3));
        assertEquals(expected.toString(),
                consoleCanvasComposer.compose(canvas).getComposedCanvas());
    }

    /**
     * Test a canvas with multiple points
     */
    @Test
    public void whenComposeCanvasWithPointsThenReturnPlotStringWithPoints() {
        int x = 20;
        int y = 4;
        StringBuilder expected = new StringBuilder();
        Formatter formatter = new Formatter(expected)
                .format(getCanvasXBorder(x))
                .format(getCanvasYBorder(x, 2))
                .format("|%6s%14s|", "*", " ")
                .format(NEW_LINE)
                .format("|%6s%14s|", "*", " ")
                .format(NEW_LINE)
                .format(getCanvasXBorder(x));
        final Canvas canvas = new Canvas(x, y);
        canvas.addLine(new Line(6, 3, 6, 4));
        assertEquals(expected.toString(),
                consoleCanvasComposer.compose(canvas).getComposedCanvas());
    }

    /**
     * Test a canvas with a rectangle
     */
    @Test
    public void whenComposeCanvasWithRectangleThenReturnPlotStringWithRectangle() {
        int x = 20;
        int y = 4;
        StringBuilder expected = new StringBuilder();
        Formatter formatter = new Formatter(expected)
                .format(getCanvasXBorder(x))
                .format(getCanvasYBorder(x, 1))
                .format("|*****%15s|", " ")
                .format(NEW_LINE)
                .format("|*%4s%15s|", "*", " ")
                .format(NEW_LINE)
                .format("|*****%15s|", " ")
                .format(NEW_LINE)
                .format(getCanvasXBorder(x));
        final Canvas canvas = new Canvas(x, y);
        canvas.addRectangle(new Rectangle(1, 2, 5, 4));
        assertEquals(expected.toString(),
                consoleCanvasComposer.compose(canvas).getComposedCanvas());
    }

    /**
     * Test a canvas with a multiple rectangles
     */
    @Test
    public void whenComposeCanvasWithRectanglesThenReturnPlotStringWithRectangles() {
        int x = 20;
        int y = 4;
        StringBuilder expected = new StringBuilder();
        Formatter formatter = new Formatter(expected)
                .format(getCanvasXBorder(x))
                .format(getCanvasYBorder(x, 1))
                .format("|*******%13s|", " ")
                .format(NEW_LINE)
                .format("|*   * *%13s|", " ")
                .format(NEW_LINE)
                .format("|*******%13s|", " ")
                .format(NEW_LINE)
                .format(getCanvasXBorder(x));
        final Canvas canvas = new Canvas(x, y);
        canvas.addRectangle(new Rectangle(1, 2, 5, 4));
        canvas.addRectangle(new Rectangle(5, 2, 7, 4));
        assertEquals(expected.toString(),
                consoleCanvasComposer.compose(canvas).getComposedCanvas());
    }

    /**
     * Test a canvas with a rectangle and a fill bucket
     */
    @Test
    public void whenComposeCanvasWithRectangleAndBucketThenReturnPlotStringWithRectangleAndFilledColour() {
        int x = 20;
        int y = 4;
        StringBuilder expected = new StringBuilder();
        Formatter formatter = new Formatter(expected)
                .format(getCanvasXBorder(x))
                .format("|$$$$$$$$$$%10s|", " ")
                .format(NEW_LINE)
                .format("|*****$$$$$%10s|", " ")
                .format(NEW_LINE)
                .format("|*%4s$$$$$%10s|", "*", " ")
                .format(NEW_LINE)
                .format("|*****%15s|", " ")
                .format(NEW_LINE)
                .format(getCanvasXBorder(x));
        final Canvas canvas = new Canvas(20, 4);
        canvas.addRectangle(new Rectangle(1, 2, 5, 4));
        canvas.addBucket(new Bucket(10, 3, '$'));
        assertEquals(expected.toString(),
                consoleCanvasComposer.compose(canvas).getComposedCanvas());
    }

    /**
     * Test a canvas with a rectangle and a fill bucket and then refill the same bucket
     */
    @Test
    public void whenComposeCanvasWithRectangleAndReFillBucketThenReturnPlotStringWithRectangleAndReFilledColour() {
        int x = 20;
        int y = 4;
        StringBuilder expected = new StringBuilder();
        Formatter formatter = new Formatter(expected)
                .format(getCanvasXBorder(x))
                .format("|##########%10s|", " ")
                .format(NEW_LINE)
                .format("|*****#####%10s|", " ")
                .format(NEW_LINE)
                .format("|*%4s#####%10s|", "*", " ")
                .format(NEW_LINE)
                .format("|*****%15s|", " ")
                .format(NEW_LINE)
                .format(getCanvasXBorder(x));
        final Canvas canvas = new Canvas(20, 4);
        canvas.addRectangle(new Rectangle(1, 2, 5, 4));
        canvas.addBucket(new Bucket(10, 3, '$'));
        canvas.addBucket(new Bucket(10, 3, '#'));//refill
        assertEquals(expected.toString(),
                consoleCanvasComposer.compose(canvas).getComposedCanvas());
    }

    /**
     * Test a canvas with a rectangle and a fill bucket and then refill with different size bucket
     */
    @Test
    public void whenComposeCanvasWithRectangleAndReFillBucketThenReturnPlotStringWithRectangleAndReFilledSizeBucket() {
        int x = 20;
        int y = 4;
        StringBuilder expected = new StringBuilder();
        Formatter formatter = new Formatter(expected)
                .format(getCanvasXBorder(x))
                .format("|##########%10s|", " ")
                .format(NEW_LINE)
                .format("|*****#####%10s|", " ")
                .format(NEW_LINE)
                .format("|*%4s$$$$$%10s|", "*", " ")
                .format(NEW_LINE)
                .format("|*****%15s|", " ")
                .format(NEW_LINE)
                .format(getCanvasXBorder(x));
        final Canvas canvas = new Canvas(20, 4);
        canvas.addRectangle(new Rectangle(1, 2, 5, 4));
        canvas.addBucket(new Bucket(10, 3, '$'));
        canvas.addBucket(new Bucket(10, 2, '#'));//refill
        assertEquals(expected.toString(),
                consoleCanvasComposer.compose(canvas).getComposedCanvas());
    }

    private String getCanvasYBorder(int x, int y) {
        return join(NEW_LINE, nCopies(y, format("|%" + x + "s|", " "))).concat(NEW_LINE);
    }

    private String getCanvasXBorder(int x) {
        return join("", nCopies(x + 2, "-")).concat(NEW_LINE);
    }
}
