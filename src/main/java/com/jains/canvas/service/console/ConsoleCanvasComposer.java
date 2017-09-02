package com.jains.canvas.service.console;

import com.jains.canvas.model.Canvas;
import com.jains.canvas.model.Line;
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
	private final char lineChar;

	@Override
	public String compose(Canvas canvas) {
		//draw canvas
		final int height = canvas.getHeight()+2;
		final int width = canvas.getWidth();
		char[][] canvasArray = new char[height][width];
		Arrays.fill(canvasArray[0],xCanvasChar);//top->0
		for(int y=1;y<height-1;y++){
			canvasArray[y][0]=yCanvasChar;
			for(int x=1;x<=width-1;x++){
				canvasArray[y][x]=' ';
			}
			canvasArray[y][width-1]=yCanvasChar;
		}
		Arrays.fill(canvasArray[height -1],xCanvasChar);//bottom

		//fill lines
		if(canvas.getLines()!=null) {
			for (Line line : canvas.getLines()) {
				for(int y=line.getY1();y<=line.getY2();y++){
					for(int x=line.getX1();x<=line.getX2();x++){
						canvasArray[y][x]=lineChar;
					}
				}
			}
		}

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
