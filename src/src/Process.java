package src;

public class Process {
    public String name;
    public int burstTime;
    public int arrivalTime;
    public int priority;
    public int quantum;
    public int endBurstTime;
    public int waitingTime;
    public int turnAroundTime;
    public boolean isFinished = false;

    public Process(String name, int burstTime, int arrivalTime, int priority, int quantum) {
        this.name = name;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.priority = priority;
        this.quantum = quantum;
    }

    public void setWaitingTime(int waitingTime) {
        if (isFinished) {
            this.waitingTime = endBurstTime - burstTime - arrivalTime;
        }
    }

    public void setTurnAroundTime(int turnAroundTime) {
        if (isFinished) {
            this.turnAroundTime = waitingTime + burstTime;
        }
    }
}