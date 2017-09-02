package com.jains.canvas.service.console;

import com.jains.canvas.model.Bucket;
import com.jains.canvas.model.Canvas;
import com.jains.canvas.model.Line;
import com.jains.canvas.model.Rectangle;
import com.jains.canvas.service.InvalidCommandException;
import org.junit.Test;

import static com.jains.canvas.service.console.ConsoleCommandParser.parseCommandToCanvas;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConsoleCommandParserTest {
    @Test(expected = InvalidCommandException.class)
    public void whenInvalidCommandThenThrowException() throws InvalidCommandException {
        parseCommandToCanvas(null, "X 8 9 0");
    }

    @Test(expected = InvalidCommandException.class)
    public void whenNoCanvasAndNoCanvasCommandThenThrowException() throws InvalidCommandException {
        parseCommandToCanvas(null, "L 8 9 8 9");
    }

    @Test(expected = InvalidCommandException.class)
    public void whenCanvasCommandAndLesserInnputsThenThrowException() throws InvalidCommandException {
        parseCommandToCanvas(null, "C 8");
    }

    @Test(expected = InvalidCommandException.class)
    public void whenLineCommandAndLesserInputsThenThrowException() throws InvalidCommandException {
        parseCommandToCanvas(new Canvas(2, 10), "L 8");
    }

    @Test(expected = InvalidCommandException.class)
    public void whenLineCommandAndIncorrectInputsThenThrowException() throws InvalidCommandException {
        parseCommandToCanvas(new Canvas(2, 10), "L 8 R T X");
    }

    @Test()
    public void whenCanvasCommandThenReturnCanvasObject() throws InvalidCommandException {
        Canvas canvas = parseCommandToCanvas(null, "C 8 10");
        assertEquals(canvas.getHeight(), 8);
        assertEquals(canvas.getWidth(), 10);
    }

    @Test()
    public void whenLineCommandThenReturnCanvasObjectWithLine() throws InvalidCommandException {
        Canvas canvas = parseCommandToCanvas(new Canvas(20, 40), "L 8 10 11 12");
        assertNotNull(canvas.getLines());
        final Line line = canvas.getLines().get(0);
        assertNotNull(line);
        assertEquals(line.getX1(), 8);
        assertEquals(line.getX2(), 11);
        assertEquals(line.getY1(), 10);
        assertEquals(line.getY2(), 12);
    }

    @Test()
    public void whenRectangleCommandThenReturnCanvasObjectWithLine() throws InvalidCommandException {
        Canvas canvas = parseCommandToCanvas(new Canvas(20, 40), "R 8 10 11 12");
        final Rectangle rectangle = canvas.getRectangles().get(0);
        assertNotNull(rectangle);
        assertEquals(rectangle.getX1(), 8);
        assertEquals(rectangle.getX2(), 11);
        assertEquals(rectangle.getY1(), 10);
        assertEquals(rectangle.getY2(), 12);
    }

    @Test()
    public void whenBucketCommandThenReturnCanvasObjectWithFillBucket() throws InvalidCommandException {
        Canvas canvas = parseCommandToCanvas(new Canvas(20, 40), "B 8 10 #");
        final Bucket bucket = canvas.getBucket();
        assertNotNull(bucket);
        assertEquals(bucket.getX(), 8);
        assertEquals(bucket.getY(), 10);
        assertEquals(bucket.getColour(), '#');
    }
}
