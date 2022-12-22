package com.company;

public class Process {

    private int processId;
    private int time;
    private int memory;
    private int beggining;

    public Process(){

 }
    public Process(int processId, int time, int memory) {
        this.processId = processId;
        this.time = time;
        this.memory = memory;
    }

    public int getProcessId() {
        return processId;
    }

    public int getTime() {
        return time;
    }

    public int getMemory() {
        return memory;
    }

    @Override
    public String toString() {
        return "Process{" +
                "processId=" + processId +
                ", time=" + time +
                ", memory=" + memory +
                ", beggining=" + beggining +
                '}';
    }

    public int getBeggining() {
        return beggining;
    }

    public void setBeggining(int beginnig){
        this.beggining = beginnig;
    }


    public void decreaseTime() {
        this.time--;
    }
}
