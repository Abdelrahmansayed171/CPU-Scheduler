package src;

import java.util.LinkedList;
import java.util.Queue;

public class AG_Scheduling {
    LinkedList<Process> processes;
    LinkedList<Process> answer;
    ReadyQueue readyQueue = new ReadyQueue();
    public int timer = 0;
    public int contextSwitching = 0;


    public AG_Scheduling(LinkedList <Process> processes) {
        this.processes = processes;
        answer = new LinkedList<Process>();
        for(int i = 0;i < processes.size();i++){
            readyQueue.arrivalEnqueue(processes.get(i));
        }
    }


    public void start(){
        while (readyQueue.size() != 0){
            int quantumSplit;
            boolean priortyDone = false;
            int idx = readyQueue.getHighestPriorty(timer);
            if(idx == 0){
                quantumSplit = (int) Math.ceil((readyQueue.peek().quantum)/2.0);
                priortyDone = true;
            }
            else{
                quantumSplit = (int) Math.ceil((readyQueue.peek().quantum)/4.0);
            }

            timer += quantumSplit;
            readyQueue.peek().tempBurstTime -= quantumSplit;
            readyQueue.peek().tempQuantum -= quantumSplit;

            if(!priortyDone){
                readyQueue.peek().quantum += (int) Math.ceil((readyQueue.peek().tempQuantum)/2.0);
                readyQueue.peek().tempQuantum = readyQueue.peek().quantum;
                readyQueue.getHighestPriorty(timer);
                continue;
            }
            else{

            }
        }
    }
}
