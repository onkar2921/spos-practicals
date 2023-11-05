// import java.util.LinkedList;
// import java.util.Queue;

// class Process {
//     String name;
//     int burstTime;
//     int remainingTime;

//     public Process(String name, int burstTime) {
//         this.name = name;
//         this.burstTime = burstTime;
//         this.remainingTime = burstTime;
//     }
// }

// public class RR {
//     public static void main(String[] args) {
//         Queue<Process> queue = new LinkedList<>();
//         int timeQuantum = 4; // Time quantum for each process

//         // Create a list of processes
//         Process[] processes = {
//             new Process("P1", 8),
//             new Process("P2", 6),
//             new Process("P3", 10),
//             new Process("P4", 4),
//             new Process("P5", 5)
//         };

//         for (Process process : processes) {
//             queue.add(process);
//         }

//         System.out.println("Process Execution Order:");
//         int currentTime = 0;
//         int totalWaitTime = 0;
//         int totalTurnaroundTime = 0;

//         while (!queue.isEmpty()) {
//             Process currentProcess = queue.poll();

//             if (currentProcess.remainingTime > 0) {
//                 int executionTime = Math.min(timeQuantum, currentProcess.remainingTime);
//                 System.out.print(currentProcess.name + " -> ");
//                 currentProcess.remainingTime -= executionTime;
//                 currentTime += executionTime;

//                 if (currentProcess.remainingTime > 0) {
//                     queue.add(currentProcess); // Re-add to the queue
//                 } else {
//                     totalTurnaroundTime += currentTime;
//                     totalWaitTime += currentTime - currentProcess.burstTime;
//                 }
//             }
//         }

//         System.out.println("Done");

//         int numProcesses = processes.length;
//         double avgWaitTime = (double) totalWaitTime / numProcesses;
//         double avgTurnaroundTime = (double) totalTurnaroundTime / numProcesses;

//         System.out.println("Average Waiting Time: " + avgWaitTime);
//         System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
//     }
// }

import java.util.*;

class process {
    String name;
    int brustTime;
    int remainingTime;

    process(String name, int brst) {
        this.name = name;
        this.brustTime = brst;
        this.remainingTime = brst;
    }
}

class helper {
    Scanner sc = new Scanner(System.in);

    void getInputs(process[] proce, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("enter the name of process");
            String name = sc.next();
            System.out.println("enter the brust time");
            int brst = sc.nextInt();

            proce[i] = new process(name, brst);

        }

    }

    void calculateWaitingTime(process[] proce, int[] wt, int quantum, int n) {

        int time = 0;
        int sum = 0;
        while (true) {
            boolean done = true;

            for (int i = 0; i < n; i++) {
                if (proce[i].remainingTime > 0) {
                    done = false;
                    if (proce[i].remainingTime > quantum) {
                        time += quantum;
                        proce[i].remainingTime -= quantum;
                    } else {
                        time += proce[i].remainingTime;
                        wt[i] = time - proce[i].brustTime;
                        sum += wt[i];
                        proce[i].remainingTime = 0;
                    }

                }
            }

            if (done == true) {
                break;
            }
        }

        System.out.println("average waiting time is" + (sum / n));

    }

    void calculateTurnAroundtime(process[] proce, int[] wt, int[] turn, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            turn[i] = proce[i].brustTime + wt[i];
            sum += turn[i];
        }
        System.out.println("average turna round time is" + (sum / n));

    }

}

public class RR {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter how many procecss do you want");
        int n = sc.nextInt();

        process[] prcoe = new process[n];
        int[] wait = new int[n];
        int[] turn = new int[n];

        helper h1 = new helper();
        h1.getInputs(prcoe, n);
        int quantum = 2;

        h1.calculateWaitingTime(prcoe, wait, quantum, n);
        h1.calculateTurnAroundtime(prcoe, wait, turn, n);

    }
}


