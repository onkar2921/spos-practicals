import java.util.*;

   class process{
        String name;
        int burstTime;
        int ramainingTime;
        
        process (String name,int brst){
            this.name=name;
            this.burstTime=brst;
            this.ramainingTime=brst;
        }
    }


    class helper{

        Scanner sc=new Scanner(System.in);
        

        void getInputs(Queue<process>q,process[] proce,int n){
            for(int i=0;i<n;i++){
                System.out.println("enter the process name");
                String name=sc.next();

                System.out.println("enter the burst time");
                int brst=sc.nextInt();

                proce[i]=new process(name, brst);
                q.add(proce[i]);

            }
        }


        void execute(Queue <process> q,process []proce,int quantum){
            int currentTime=0;
            int totalWaitTime=0;
            int totalTurnAroundtime=0;

            while(!q.isEmpty()){
                process currentProcess=q.poll();
                // System.out.println();
                if(currentProcess.ramainingTime>quantum){
                    currentProcess.ramainingTime-=quantum;
                    currentTime+=quantum;
                    q.add(currentProcess);
                }
                else{
                    currentTime+=currentProcess.ramainingTime;
                    totalTurnAroundtime+=currentTime;
                    totalWaitTime+=currentTime-currentProcess.burstTime;
                    currentProcess.ramainingTime=0;
                }
            }

             int numProcesses = proce.length;
        int avgWaitTime = totalWaitTime / numProcesses;
        int avgTurnaroundTime = int totalTurnAroundtime / numProcesses;

        System.out.println("Average Waiting Time: " + avgWaitTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);

        }

    }




public class rr {

 

    public static void main(String [] args){

        Scanner sc=new Scanner(System.in);
        System.out.println("enter how many process you want");
        int n=sc.nextInt();

        process[] proce=new process[n];
        helper h1=new helper();
        Queue<process>q=new  LinkedList<>();


        h1.getInputs(q,proce, n);

        h1.execute(q, proce, 2);

    }
    
}
