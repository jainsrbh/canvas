package com.jains.canvas.service.console;

import com.jains.canvas.model.Canvas;
import com.jains.canvas.service.CanvasComposer;
import com.jains.canvas.service.CanvasPlotter;
import com.jains.canvas.service.CanvasService;
import com.jains.canvas.service.Command;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;
import java.util.StringTokenizer;

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

    }

    @Override
    public Canvas createCanvas() {
        System.out.println("Select command:" + Command.printString());
        Command command = null;
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                try {
                    final String input = scanner.nextLine();
                    StringTokenizer tokenizer = new StringTokenizer(input, " ", false);
                    command = Command.valueOf(tokenizer.nextToken());

                } catch (IllegalArgumentException exception) {
                    System.out.println("Invalid command, valid options are:" + Command.printString());
                }
            } while (!Command.Q.equals(command));
        }
        return null;
    }
}
