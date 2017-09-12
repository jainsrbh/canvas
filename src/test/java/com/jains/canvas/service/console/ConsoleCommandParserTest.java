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
        assertEquals("Unexpected canvas height", 10, canvas.getHeight());
        assertEquals("Unexpected canvas width", 8, canvas.getWidth());
    }

    @Test()
    public void whenLineCommandThenRetur8nCanvasObjectWithLine() throws InvalidCommandException {
        Canvas canvas = parseCommandToCanvas(new Canvas(20, 40), "L 8 10 11 12");
        assertNotNull(canvas.getLines());
        final Line line = canvas.getLines().get(0);
        assertNotNull("Line object not assigned", line);
        assertEquals("Unexpected X1 value for line", 8, line.getX1());
        assertEquals("Unexpected X2 value for line", 11, line.getX2());
        assertEquals("Unexpected Y1 value for line", 10, line.getY1());
        assertEquals("Unexpected Y2 value for line", 12, line.getY2());
    }

    @Test()
    public void whenRectangleCommandThenReturnCanvasObjectWithLine() throws InvalidCommandException {
        Canvas canvas = parseCommandToCanvas(new Canvas(20, 40), "R 8 10 11 12");
        final Rectangle rectangle = canvas.getRectangles().get(0);
        assertNotNull("Rectangle object not assigned", rectangle);
        assertEquals("Unexpected X1 value for rectangle", 8, rectangle.getX1());
        assertEquals("Unexpected X2 value for rectangle", 11, rectangle.getX2());
        assertEquals("Unexpected Y1 value for rectangle", 10, rectangle.getY1());
        assertEquals("Unexpected Y2 value for rectangle", 12, rectangle.getY2());
    }

    @Test()
    public void whenBucketCommandThenReturnCanvasObjectWithFillBucket() throws InvalidCommandException {
        Canvas canvas = parseCommandToCanvas(new Canvas(20, 40), "B 8 10 #");
        final Bucket bucket = canvas.getBuckets().get(0);
        assertNotNull("Bucket object not assigned", bucket);
        assertEquals("Unexpected X value for bucket", 8, bucket.getX());
        assertEquals("Unexpected Y value for bucket", 10, bucket.getY());
        assertEquals("Unexpected colour value for bucket", '#', bucket.getColour());
    }
}
