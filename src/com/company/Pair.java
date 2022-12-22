package com.company;

public class Pair {
    Hole hole;
    Process process;


    public Pair(Hole hole,Process process) {
        this.hole = hole;
        this.process = process;
    }

    public Hole getHole() {
        return hole;
    }

    public void setHole(Hole hole) {
        this.hole = hole;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }
}
