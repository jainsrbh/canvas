package com.jains.canvas;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleExecutor implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Select command:"+Command.printString());
		Command command = null;
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				try {
					command = Command.valueOf(scanner.nextLine());
					System.out.println(command.getDescription());
				} catch (IllegalArgumentException exception) {
					System.out.println("Invalid command, valid options are:" + Command.printString());
				}
			} while (!Command.Q.equals(command));
		}
	}

}