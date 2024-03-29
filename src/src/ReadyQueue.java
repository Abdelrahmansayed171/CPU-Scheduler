package src;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadyQueue {
    private ArrayList <Process> queue;

    public ReadyQueue() {
        queue = new ArrayList<Process>();
    }

    public Process dequeue() {
        Process p = null;
        if (!isEmpty()) {
            p = queue.get(0);
            queue.remove(0);
        }
        return p;
    }

    public Process peek() {
        if (queue.isEmpty()) {
            return null;
        } else {
            return queue.get(0);
        }
    }

    public void enqueue(Process process) {
        if (queue.isEmpty()) {
            queue.add(process);
        }
        else if (!this.contain(process)) {
            queue.add(queue.size(), process);
        }
    }

    /// This Enqueue will insert the process to a it's right position according to it's Priorty

    public void priortyEnqueue(Process process) {
        if (queue.isEmpty()) {
            queue.add(process);
        } else if (!this.contain(process)) {
            int i;
            for (i = 0; i < queue.size(); i++) {
                if (queue.get(i).priority > process.priority) {
                    queue.add(i, process);
                    break;
                }
            }
            if (i == queue.size()) {
                queue.add(process);
            }
        }
    }

    /// This Enqueue will insert the process to a it's right position according to it's arrival time

    public void arrivalEnqueue(Process process) {
        if (queue.isEmpty()) {
            queue.add(process);
        } else if (!this.contain(process)) {
            int i;
            for (i = 0; i < queue.size(); i++) {
                if (queue.get(i).arrivalTime > process.arrivalTime) {
                    queue.add(i, process);
                    break;
                }
            }
            if (i == queue.size()) {
                queue.add(process);
            }
        }
    }


    public boolean contain(Process process) {
        for (Process p : queue) {
            if (p.name == process.name)
                return true;
        }
        return false;
    }

    public int size() {
        return queue.size();
    }

    public Boolean isEmpty() {
        return (queue.size() == 0);
    }

    /// Print the name of Processes in Ready Queue for Tracing
    public void Print() {
        for (int i = 0; i < queue.size(); i++) {
            System.out.print(queue.get(i).name + " " + queue.get(i).quantum + " >> ");
        }
            System.out.println("\n________________________________________________________________\n");
    }

    public Process get(int idx) {
        return queue.get(idx);
    }

    public void set(Process process, int idx) {
        queue.set(idx, process);
    }

    public int getHighestPriorty(int time, int newQuantum) {
        int idx = 0;

        int min = queue.get(idx).priority;

        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i).priority < min && queue.get(i).arrivalTime <= time) {
                idx = i;
                min = queue.get(i).priority;
            }
        }

        /// Here We are remove the highst Priorty Process and add it at the begining of the Queue
        if(idx != 0){
            Process temp = queue.get(idx);
            queue.remove(idx);

            Process process = this.dequeue();
            process.quantum = newQuantum;
            process.tempQuantum = newQuantum;

            this.enqueue(process);

            queue.add(0, temp);
        }

        return idx;
    }

    public int getLeastBurst(int time, int newQuantum){
        int idx = 0;

        int min = queue.get(idx).tempBurstTime;

        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i).tempBurstTime < min && queue.get(i).arrivalTime <= time) {
                idx = i;
                min = queue.get(i).tempBurstTime;
            }
        }

        /// Here We are remove the highst Priorty Process and add it at the begining of the Queue
        if(idx != 0){
            Process temp = queue.get(idx);
            queue.remove(idx);

            Process process = this.dequeue();
            process.quantum = newQuantum;
            process.tempQuantum = newQuantum;
            this.enqueue(process);

            queue.add(0, temp);
        }

        return idx;
    }
    public int getLeastArrival(){
        int idx = 0;

        int min = queue.get(idx).arrivalTime;

        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i).arrivalTime < min) {
                idx = i;
                min = queue.get(i).arrivalTime;
            }
        }

        /// Here We are remove the highst Priorty Process and add it at the begining of the Queue
        Process temp = queue.get(idx);
        queue.remove(idx);
        queue.add(0,temp);

        return idx;
    }
}