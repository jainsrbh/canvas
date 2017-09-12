package com.jains.canvas.service.console;

import com.jains.canvas.model.Bucket;
import com.jains.canvas.model.Canvas;
import com.jains.canvas.model.Line;
import com.jains.canvas.model.Rectangle;
import com.jains.canvas.service.Command;
import com.jains.canvas.service.InvalidCommandException;

import java.util.StringTokenizer;

class ConsoleCommandParser {
    static Canvas parseCommandToCanvas(Canvas canvas, String input) throws InvalidCommandException {
        StringTokenizer tokenizer = new StringTokenizer(input, " ", false);
        Command command = null;
        try {
            command = Command.valueOf(tokenizer.nextToken());
        } catch (IllegalArgumentException exception) {
            throw new InvalidCommandException("Invalid input, valid options are:" + Command.printString());
        }
        if (tokenizer.countTokens() + 1 < command.getNumberOfInputs()) {
            throw new InvalidCommandException("Invalid input, correct format " + command.getFormat());
        }
        if (canvas == null && !Command.C.equals(command)) {
            throw new InvalidCommandException("Invalid input, no canvas for " + command.getDescription());
        }
        try {
            switch (command) {
                case C: {
                    canvas = new Canvas(
                            Integer.parseInt(tokenizer.nextToken()),
                            Integer.parseInt(tokenizer.nextToken()));
                }
                break;
                case L: {
                    canvas.addLine(new Line(
                            Integer.parseInt(tokenizer.nextToken()),
                            Integer.parseInt(tokenizer.nextToken()),
                            Integer.parseInt(tokenizer.nextToken()),
                            Integer.parseInt(tokenizer.nextToken())));
                }
                break;
                case R: {
                    canvas.addRectangle(new Rectangle(
                            Integer.parseInt(tokenizer.nextToken()),
                            Integer.parseInt(tokenizer.nextToken()),
                            Integer.parseInt(tokenizer.nextToken()),
                            Integer.parseInt(tokenizer.nextToken())));
                }
                break;
                case B: {
                    canvas.addBucket(new Bucket(
                            Integer.parseInt(tokenizer.nextToken()),
                            Integer.parseInt(tokenizer.nextToken()),
                            tokenizer.nextToken().charAt(0)));
                }
                break;

            }
        } catch (Exception e) {
            throw new InvalidCommandException(e.getMessage());
        }
        return canvas;
    }
}
