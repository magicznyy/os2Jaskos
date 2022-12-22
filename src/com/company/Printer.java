package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Printer {


    public void print(ArrayList<Process> allocation, int time){
            StringBuilder sb = new StringBuilder();
            sb.append(time);
        for (Process p:allocation)
            {
                sb.append(" [" + p.getBeggining() + " p" + p.getProcessId() + " " + p.getMemory() + "] ");
            }

            System.out.println(sb.toString());

    }
}
