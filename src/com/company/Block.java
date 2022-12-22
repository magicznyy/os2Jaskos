package com.company;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

public class Block {

    public static int time=0;
    private Printer printer;
    private ProcessesCreator processesCreator;
    private int freeSpace;
    private ArrayList<Process> allocation;
    private ArrayList<Hole> holes;

    public Block(ProcessesCreator processesCreator) {
        this.processesCreator = processesCreator;
        freeSpace = 2000;
        holes = new ArrayList<>();
        allocation = new ArrayList<>();
        printer = new Printer();
    }

    public void bestFit(ArrayList<Process> procs) {

        int start = 0;
        ArrayList<Process> toRemove = new ArrayList<>();
        ArrayList<Process> tempProcesses = new ArrayList<>();
        int procCounter = procs.size();

        for (int i = 0; i < procCounter; i++)// until there is free space or procs to allocate
        {
            if (freeSpace >= procs.get(i).getMemory()) {
                allocation.add(procs.get(i));
                procs.get(i).setBeggining(start);
                start += procs.get(i).getMemory();
                toRemove.add(procs.get(i));
                freeSpace -= procs.get(i).getMemory();
            }
            if (freeSpace == 0)
                break;
        }

        for (int i = 0; i < toRemove.size(); i++) {
            procs.remove(toRemove.get(i));

        }
        toRemove.removeAll(toRemove);


        // program is working until all the processes are alive
        while (!allocation.isEmpty()) {

            for (Process process: allocation) {
                if(process.getTime()<=0) {
                    holes.add(new Hole(process.getBeggining(),process.getMemory()));
                    freeSpace+=process.getMemory();
                    toRemove.add(process);
                    procs.remove(process);
                }
                process.decreaseTime();
            }

            Collections.sort(holes, Comparator.comparingInt(Hole::getAddress));
            for(int i=0;i<holes.size()-1;i++)
            {
                Hole h1 = holes.get(i);
                Hole h2 = holes.get(i+1);

                if(h1.getAddress()+h1.getSize() ==h2.getAddress())
                {
                    h1.setSize(h1.getSize()+h2.getSize());
                    holes.remove(h2);
                    i--;
                }

            }

            for (Process process:
                    toRemove) {
                allocation.remove(process);
            }
            System.out.println(holes);
            Printer printer = new Printer();
            printer.print(allocation,time);

            /*line*/




            ArrayList<Pair> pairs = new ArrayList<>();
            Process best = new Process();
            if(!holes.isEmpty()){
                for (Hole hole: holes) {
                    int min = 0;
                    int diff= 0;
                    int counter = 0;
                    if(procs.isEmpty())
                        break;
                    for (Process proc: procs) {
                        diff =  hole.getSize() -proc.getMemory();
                        if(diff>=0){
                            if(counter==0){
                                if(hole.getAddress()+proc.getMemory()<=2000){
                                    min = diff;
                                    best = proc;
                                }
                            }
                            else
                            if(min<diff) {
                                if(hole.getAddress()+proc.getMemory()<=2000){
                                    min = diff;
                                    best = proc;
                                }
                            }
                        }
                        counter ++;
                    }
                    if(best.getMemory()!=0)
                    pairs.add(new Pair(hole,best));
                }

                Pair bestPair = new Pair(new Hole(1,1), new Process());
                int counter =0;
                int diff = 0;
                int min = 0;
                for (Pair pair: pairs) {
                    diff = pair.hole.getSize() - pair.process.getMemory();
                    if(counter==0){
                        min = diff;
                        bestPair = pair;
                    }
                    else
                    if(min>diff) {
                        min = diff;
                        bestPair = pair;
                    }
                    counter++;
                }

                if(bestPair.getProcess().getMemory()!=0) {
                    allocation.add(bestPair.getProcess());
                    procs.remove(bestPair.getProcess());
                    bestPair.getProcess().setBeggining(bestPair.getHole().getAddress());
                    freeSpace+=bestPair.getHole().getSize();
                    holes.remove(bestPair.getHole());
                }

            }



            toRemove.removeAll(toRemove);
            time++;
        }
    }
}