package com.jains.canvas.service.console;

import com.jains.canvas.model.Bucket;
import com.jains.canvas.model.Canvas;
import com.jains.canvas.model.Line;
import com.jains.canvas.model.Rectangle;
import com.jains.canvas.service.CanvasComposer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@AllArgsConstructor
@Getter
public class ConsoleCanvasComposer implements CanvasComposer<String> {

    private final char xCanvasChar;
    private final char yCanvasChar;
    private final char lineChar;

    @Override
    public String compose(Canvas canvas) {
        //draw canvas
        final int height = canvas.getHeight() + 2;
        final int width = canvas.getWidth();
        char[][] canvasArray = new char[height][width];
        composeCanvas(height, width, canvasArray);
        fillBucket(canvas, canvasArray);
        composeLines(canvas, canvasArray);
        composeRectangle(canvas, canvasArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            sb.append(canvasArray[i]);
            sb.append("\n");
        }
        return sb.toString();
    }

    protected void composeCanvas(int height, int width, char[][] canvasArray) {
        Arrays.fill(canvasArray[0], xCanvasChar);//top->0
        for (int y = 1; y < height - 1; y++) {
            canvasArray[y][0] = yCanvasChar;
            for (int x = 1; x <= width - 1; x++) {
                canvasArray[y][x] = ' ';
            }
            canvasArray[y][width - 1] = yCanvasChar;
        }
        Arrays.fill(canvasArray[height - 1], xCanvasChar);//bottom
    }

    protected void fillBucket(Canvas canvas, char[][] canvasArray) {
        final Bucket bucket = canvas.getBucket();
        if (bucket != null) {
            for (int y = 1; y <= bucket.getY(); y++) {
                for (int x = 1; x <= bucket.getX(); x++) {
                    canvasArray[y][x] = bucket.getColour();
                }
            }
        }
    }

    protected void composeLines(Canvas canvas, char[][] canvasArray) {
        //fill lines
        if (canvas.getLines() != null) {
            for (Line line : canvas.getLines()) {
                for (int y = line.getY1(); y <= line.getY2(); y++) {
                    for (int x = line.getX1(); x <= line.getX2(); x++) {
                        canvasArray[y][x] = lineChar;
                    }
                }
            }
        }
    }

    protected void composeRectangle(Canvas canvas, char[][] canvasArray) {
        //fill lines
        if (canvas.getRectangles() != null) {
            for (Rectangle rectangle : canvas.getRectangles()) {
                for (int y = rectangle.getY1(); y <= rectangle.getY2(); y++) {
                    if (y == rectangle.getY1() || y == rectangle.getY2()) {
                        for (int x = rectangle.getX1(); x <= rectangle.getX2(); x++) {
                            canvasArray[y][x] = lineChar;
                        }
                    } else {
                        for (int x = rectangle.getX1(); x <= rectangle.getX2(); x++) {
                            canvasArray[y][x] = ' ';
                        }
                        canvasArray[y][rectangle.getX1()] = lineChar;
                        canvasArray[y][rectangle.getX2()] = lineChar;
                    }
                }
            }
        }
    }
}
