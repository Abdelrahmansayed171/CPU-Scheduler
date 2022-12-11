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
            int quarter = (int) Math.ceil((readyQueue.peek().quantum)/4.0);
            int secQuarter = (int) Math.ceil((readyQueue.peek().quantum)/2.0);
            secQuarter -= quarter;


            timer += quarter;
            readyQueue.peek().tempBurstTime -= quarter;
            readyQueue.peek().tempQuantum -= quarter;


            int tmp1 = (int) Math.ceil((readyQueue.peek().tempQuantum)/2.0);
            int tmp2 = (int) readyQueue.peek().quantum;

            int idx = readyQueue.getHighestPriorty(timer, tmp2 + tmp1);
            if(idx == 0){
                timer += secQuarter;
                readyQueue.peek().tempBurstTime -= secQuarter;
                readyQueue.peek().tempQuantum -= secQuarter;
                tmp1 = (int) readyQueue.peek().tempQuantum;
                tmp2 = (int) readyQueue.peek().quantum;
                idx = readyQueue.getLeastBurst(timer, tmp2+tmp1);
                if(idx == 0){
                    readyQueue.peek().tempBurstTime -= readyQueue.peek().tempQuantum;
                    if(readyQueue.peek().tempBurstTime <= 0){
                        readyQueue.peek().quantum = 0;
                        answer.add(readyQueue.dequeue());
                    }
                    else{
                        Process tmp = readyQueue.dequeue();
                        tmp.quantum *= 2;
                        tmp.tempQuantum = tmp.quantum * 2;
                        readyQueue.enqueue(tmp);
                    }
                }
                else{
                    readyQueue.Print();
                    continue;
                }
            }
            else{
                readyQueue.Print();
                continue;
            }

        }
    }
}
