package com.jains.canvas.service.console;

import com.jains.canvas.model.Canvas;
import com.jains.canvas.service.CanvasComposer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;

@Slf4j
@AllArgsConstructor
@Getter
public class ConsoleCanvasComposer implements CanvasComposer<String> {

	private final char xCanvasChar;
	private final char yCanvasChar;

	@Override
	public String compose(Canvas canvas) {
		final int height = canvas.getHeight()+2;
		final int width = canvas.getWidth();

		char[][] canvasArray = new char[height][width];
		Arrays.fill(canvasArray[0],xCanvasChar);//top->0
		for(int i=1;i<height-1;i++){
			canvasArray[i][0]=yCanvasChar;
			for(int j=1;j<=width-1;j++){
				canvasArray[i][j]=' ';
			}
			canvasArray[i][width-1]=yCanvasChar;
		}
		Arrays.fill(canvasArray[height -1],xCanvasChar);//bottom

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<height;i++){
			sb.append(canvasArray[i]);
			sb.append("\n");
		}
		return sb.toString();
	}

	private String composeUsingStringBuffer(Canvas canvas) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.join("", Collections.nCopies(canvas.getWidth(), String.valueOf(xCanvasChar))));
		for(int i=0;i<canvas.getHeight();i++) {
			sb.append("\n");
			sb.append(yCanvasChar);
			sb.append(String.join("", Collections.nCopies(canvas.getWidth()-2, " ")));
			sb.append(yCanvasChar);
		}
		sb.append("\n");
		sb.append(String.join("", Collections.nCopies(canvas.getWidth(), String.valueOf(xCanvasChar))));
		log.debug("\n",sb.toString());
		return sb.toString();
	}

}
