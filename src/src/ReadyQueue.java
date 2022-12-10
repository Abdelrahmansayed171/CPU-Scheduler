package src;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadyQueue {
    private ArrayList<Process> queue;

    public ReadyQueue()
    {
        queue = new ArrayList<Process>();
    }

    public Process dequeue()
    {
        Process p = null;
        if (!isEmpty())
        {
            p = queue.get(0);
            queue.remove(p);
        }
        return p;
    }

    public Process peek()
    {
        if(queue.isEmpty()){
            return null;
        }
        else{
            return queue.get(0);
        }
    }

    /// This Enqueue will insert the process to a it's right position according to it's Priorty

    public void priortyEnqueue(Process process)
    {
        if (queue.isEmpty()) {
            queue.add(process);
        }
        else if(!this.contain(process)){
            int i;
            for (i = 0; i < queue.size(); i++) {
                if (queue.get(i).priority > process.priority) {
                    queue.add(i,process);
                    break;
                }
            }
            if(i == queue.size() ){
                queue.add(process);
            }
        }
    }

    /// This Enqueue will insert the process to a it's right position according to it's arrival time

    public void arrivalEnqueue(Process process)
    {
        if (queue.isEmpty()) {
            queue.add(process);
        }
        else if(!this.contain(process)){
            int i;
            for (i = 0; i < queue.size(); i++) {
                if (queue.get(i).arrivalTime > process.arrivalTime) {
                    queue.add(i,process);
                    break;
                }
            }
            if(i == queue.size() ){
                queue.add(process);
            }
        }
    }


    private boolean contain(Process process){
        for(Process p : queue){
            if(p.name == process.name)
                return true;
            return false;
        }
        return false;
    }

    public int size()
    {
        return queue.size();
    }

    public Boolean isEmpty()
    {
        return (queue.size() == 0);
    }
    public void Print(){
        for (int i = 0; i < queue.size(); i++) {
            System.out.print(queue.get(i).name + " ");
        }
    }
}