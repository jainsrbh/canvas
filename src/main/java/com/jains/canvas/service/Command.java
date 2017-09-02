package com.jains.canvas.service;

import com.google.common.collect.Lists;

public enum Command {
    C("CANVAS", "C X Y", 3),
    L("LINE", "L X1 Y1 X2 Y2", 5),
    R("RECTANGLE", "R X1 Y1 X2 Y2", 5),
    B("FILLs", "B X Y CHAR", 4),
    Q("QUIT", "Q", 0);
    private String description;
    private String format;
    private Integer numberOfInputs;

    private Command(String description, String format, Integer numberofInputs) {
        this.description = description;
        this.format = format;
        this.numberOfInputs = numberofInputs;
    }

    public static String printString() {
        return Lists.newArrayList(values()).toString();
    }

    public String getDescription() {
        return description;
    }

    public String getFormat() {
        return format;
    }

    public Integer getNumberOfInputs() {
        return numberOfInputs;
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", this.name(), this.description);
    }
}
