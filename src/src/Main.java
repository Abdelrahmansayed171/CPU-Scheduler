package src;

public class Main {

    public static void main(String[] args) {
        Process process1 = new Process("P1", 17, 0, 4, 7);
        Process process2 = new Process("P2", 6, 2, 7, 9);
        Process process3 = new Process("P3", 11, 5, 3, 4);
        Process process4 = new Process("P4", 4, 15, 6, 6);
        Process process5 = new Process("P5", 4, 15, 6, 6);
        ReadyQueue readyQueue = new ReadyQueue();
        readyQueue.priortyEnqueue(process1);
        readyQueue.priortyEnqueue(process3);
        readyQueue.priortyEnqueue(process2);
        readyQueue.priortyEnqueue(process4);
        readyQueue.Print();
        boolean contains = readyQueue.contain(process5);
        System.out.println(contains);
        process1.print();
    }
}
