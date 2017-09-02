package com.jains.canvas.config;

import com.jains.canvas.service.console.ConsoleCanvasComposer;
import com.jains.canvas.service.console.ConsoleCanvasPlotter;
import com.jains.canvas.service.console.ConsoleCanvasService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsoleCanvasConfiguration {
    @Bean(name = "consoleCanvasComposer")
    public ConsoleCanvasComposer canvasComposer() {
        return new ConsoleCanvasComposer('-', '|', '*');
    }

    @Bean(name = "consoleCanvasPlotter")
    public ConsoleCanvasPlotter canvasPlotter() {
        return new ConsoleCanvasPlotter();
    }

    @Bean
    public ConsoleCanvasService canvasService(ConsoleCanvasComposer canvasComposer,
                                              ConsoleCanvasPlotter canvasPlotter) {
        return new ConsoleCanvasService(canvasComposer, canvasPlotter);
    }
}
