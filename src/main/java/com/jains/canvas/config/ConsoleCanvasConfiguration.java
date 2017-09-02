package com.jains.canvas.config;

import com.jains.canvas.service.console.ConsoleCanvasComposer;
import com.jains.canvas.service.console.ConsoleCanvasPlotter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsoleCanvasConfiguration{
	@Bean(name = "canvasComposer")
	public ConsoleCanvasComposer canvasComposer() {
		return new ConsoleCanvasComposer('-', '|','*');
	}

	@Bean(name = "canvasPlotter")
	public ConsoleCanvasPlotter canvasPlotter() {
		return new ConsoleCanvasPlotter();
	}

}
