package com.jains.canvas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jains.canvas.service.console.ConsoleCanvasComposer;

@Configuration
public class ConsoleCanvasConfiguration{
	@Bean
	public ConsoleCanvasComposer consoleCanvasComposer() {
		return new ConsoleCanvasComposer('-', '|','*');
	}
}
