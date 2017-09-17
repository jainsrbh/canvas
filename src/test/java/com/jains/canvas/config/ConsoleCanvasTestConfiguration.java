package com.jains.canvas.config;

import com.jains.canvas.service.console.ConsoleCanvasComposer;
import com.jains.canvas.service.console.ConsoleCanvasPlotter;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ConsoleCanvasTestConfiguration {
    @Bean(name = "consoleCanvasComposer")
    public ConsoleCanvasComposer canvasComposer() {
        return new ConsoleCanvasComposer('-', '|', '*');
    }

    @Bean(name = "consoleCanvasPlotter")
    public ConsoleCanvasPlotter canvasPlotter() {
        return new ConsoleCanvasPlotter();
    }

}
