package src;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList carrier = new LinkedList <Process> ();
        Process process1 = new Process("P1", 17, 0, 4, 7);
        Process process2 = new Process("P2", 6, 2, 7, 9);
        Process process3 = new Process("P3", 11, 5, 3, 4);
        Process process4 = new Process("P4", 4, 15, 6, 6);
        carrier.add(process1);
        carrier.add(process2);
        carrier.add(process3);
        carrier.add(process4);

        AG_Scheduling ag_scheduling = new AG_Scheduling(carrier);
        ag_scheduling.start();
//        ReadyQueue readyQueue = new ReadyQueue();
//        readyQueue.priortyEnqueue(process1);
//        readyQueue.priortyEnqueue(process3);
//        readyQueue.priortyEnqueue(process2);
//        readyQueue.priortyEnqueue(process4);
//        readyQueue.Print();
//        boolean contains = readyQueue.contain(process5);
//        System.out.println(contains);
//        process1.print();
    }
}
