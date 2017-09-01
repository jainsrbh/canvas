package com.jains.canvas;

import com.google.common.collect.Lists;

public enum Command {
	C("CANVAS"), 
	L("LINE"),
	R("RECTANGLE"), 
	B("FILLs"), 
	Q("QUIT");
	private String description;

	private Command(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s)",this.name(),this.description);
	}
	
	public static String printString() {
		return Lists.newArrayList(values()).toString();
	}
}
