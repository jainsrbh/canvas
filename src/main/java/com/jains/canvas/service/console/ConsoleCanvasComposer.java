package com.jains.canvas.service.console;

import com.jains.canvas.model.Canvas;
import com.jains.canvas.service.CanvasComposer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;

@Slf4j
@AllArgsConstructor
@Getter
public class ConsoleCanvasComposer implements CanvasComposer<String> {

	private final String xComposer;
	private final String yComposer;

	@Override
	public String compose(Canvas canvas) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.join("", Collections.nCopies(canvas.getWidth(), xComposer)));
		for(int i=0;i<canvas.getHeight();i++) {
			sb.append("\n");
			sb.append(yComposer);
			sb.append(String.join("", Collections.nCopies(canvas.getWidth()-2, " ")));
			sb.append(yComposer);
		}
		sb.append("\n");
		sb.append(String.join("", Collections.nCopies(canvas.getWidth(), xComposer)));
		log.debug("\n",sb.toString());
		return sb.toString();
	}

}
