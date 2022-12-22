package com.company;

import java.util.ArrayList;

public class ProcessesCreator {

    private ArrayList<Process> processes;

    ProcessesCreator() {
        processes = new ArrayList<>();
    }

    public void createProcesses(TextFile textFile){

        ArrayList <Line> tempLines = textFile.getLines();
        String singleLine;
        String id = null, memory = null, time = null;
        Integer counter=0;

        for (Line line : tempLines
             ) {
            singleLine = line.getLineValue();
            for (String val: singleLine.split(" ")){
                if(counter==0)
                    id = val;
                else if(counter==2)
                    memory = val;
                else  if(counter==3)
                    time = val;
                counter ++;
            }
            counter = 0;
                Process process = new Process(Integer.parseInt(id) , Integer.parseInt(time) ,Integer.parseInt(memory));
                this.addProcess(process);
        }

    }

    public void addProcess(Process process){
        this.processes.add(process);
    }

    public void check(){
        for (Process p:processes) {
            System.out.println(p.toString());
        }
    }

    public ArrayList<Process> getProcesses() {
        return processes;
    }

}
