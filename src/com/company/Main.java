package com.company;

import java.io.File;
import java.util.ArrayList;


public class Main {

        public static void main(String[] args) {



            File file = new File("C:\\Users\\HardPc\\Desktop\\processes.txt");

            FileReader fileReader = new FileReader(file);

            ProcessesCreator processesCreator = new ProcessesCreator();
            processesCreator.createProcesses(fileReader.getTextFile());

            ArrayList<Process> procs = processesCreator.getProcesses();

            Block block = new Block(processesCreator);
            block.bestFit(procs);

  }

}
