import java.util.*;

class process{
    String name;
    int burstTime;

    process(String name,int brst){
        this.name=name;
        this.burstTime=brst;
    }


}

class helper{

    Scanner sc=new Scanner(System.in);

    void getInputs(process [] proce,int n){
        for(int i=0;i<n;i++){
            System.out.println("enter the process name");
            String name=sc.next();
            System.out.println("ente rthe burst time of process");
            int brst=sc.nextInt();

            proce[i]=new process(name,brst);
        }
    }


    void calculateWaitingTime(process[] proce,int []wt,int n){
        int sum=0;
        wt[0]=0;
        for(int i=1;i<n;i++){
            wt[i]=proce[i-1].burstTime+wt[i-1];
            sum+=wt[i];
        }

        System.out.println("average waiting time is"+(sum/n));
    }



void calculateTurnAroundTime(process []proce,int []turn,int []wt,int n){
    int sum=0;
    for(int i=0;i<n;i++){
        turn[i]=proce[i].burstTime+wt[i];
        sum+=turn[i];
    }

    System.out.println("average turn around time is : "+(sum/n));
}
}

public class fcfs {
    
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        System.out.println("how many process you want");
        int n=sc.nextInt();

        int []waiting=new int[n];
        int [] turn=new int[n];

        process []p=new process[n];
        helper h1=new helper();
        h1.getInputs(p, n);
        h1.calculateWaitingTime(p,waiting,n);
        h1.calculateTurnAroundTime(p, turn, waiting, n);


    }
}
