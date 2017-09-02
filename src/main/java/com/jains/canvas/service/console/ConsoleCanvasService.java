package com.jains.canvas.service.console;

import com.jains.canvas.model.Canvas;
import com.jains.canvas.service.CanvasComposer;
import com.jains.canvas.service.CanvasPlotter;
import com.jains.canvas.service.CanvasService;
import com.jains.canvas.service.Command;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

public class ConsoleCanvasService implements CanvasService<String>, CommandLineRunner {
    private final CanvasComposer<String> canvasComposer;
    private final CanvasPlotter<String> canvasPlotter;
    private Canvas canvas;

    public ConsoleCanvasService(CanvasComposer<String> canvasComposer, CanvasPlotter<String> canvasPlotter) {
        this.canvasComposer = canvasComposer;
        this.canvasPlotter = canvasPlotter;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Select command:" + Command.printString());
        String input = null;
        try (Scanner scanner = new Scanner(System.in)) {
            input = scanner.nextLine();
            while (!Command.Q.name().equals(input)) {
                try {
                    canvas = ConsoleCommandParser.parseCommandToCanvas(canvas, input);
                    plotCanvas(canvasComposer, canvasPlotter, canvas);
                } catch (Exception exception) {
                    System.out.println("Exception:" + exception.getMessage());
                }
                System.out.println("Select command:" + Command.printString());
                input = scanner.nextLine();
            }
        }
    }
}
