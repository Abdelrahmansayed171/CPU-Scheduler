package src;

import java.util.LinkedList;
import java.util.Queue;

public class AG_Scheduling {
    LinkedList<Process> processes;
    LinkedList<Process> answer;
    ReadyQueue readyQueue = new ReadyQueue();
    public int actualTime = 0;
    public int sumBurst = 0;

    public AG_Scheduling(LinkedList<Process> processes) {
        this.processes = processes;
        for (int i = 0; i < processes.size(); i++) {
            sumBurst += processes.get(i).burstTime;
        }
        while (sumBurst != 0){
            for (int i = 1; i < processes.size(); i++) {
                readyQueue.arrivalEnqueue(processes.get(i));
            }
            answer.add(readyQueue.peek());
            actualTime = readyQueue.peek().arrivalTime;
        }
    }
}
