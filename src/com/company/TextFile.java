package com.company;

import java.util.ArrayList;

public class TextFile {

    private ArrayList<Line> lines;

    public TextFile() {
        lines = new ArrayList<>();
    }

    public void addLine(Line line){
        this.lines.add(line);
    }

    public void check(){
        for (Line line:lines
             ) {
            System.out.println(line.getLineValue());
        }
    }

    public ArrayList<Line> getLines() {
        return lines;
    }
}
