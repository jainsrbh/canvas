package com.jains.canvas.service.console;

import com.jains.canvas.service.CanvasPlotter;
import com.sun.org.apache.xpath.internal.operations.String;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class ConsoleCanvasPlotter implements CanvasPlotter<String>{
    private final ConsoleCanvasComposer consoleCanvasComposer;

    @Override
    public void plot(String string) {
        System.out.println(string);
    }
}
