import java.util.*;


class process{
    String name;
    int burstTime;

    process(String name,int brst){
        this.name=name;
        this.burstTime=brst;
    }

    int getBurstTime(){
        return this.burstTime;
    }
}


class helper{
    Scanner sc=new Scanner(System.in);

    void getInputs(process []proce,int n){
        for(int i=0;i<n;i++){
            System.out.println("enter the name of process");
            String name=sc.next();
            System.out.println("enter the burst time");
            int brst=sc.nextInt();

            proce[i]=new process(name, brst);
        }
    }


    void executeProcess(process[]proce){
        Arrays.sort(proce,(a,b)->a.getBurstTime()-b.getBurstTime());
    }


    void calculateWaitingTime(process []proce,int []wt,int n){
        wt[0]=0;
        int sum=0;
        for(int i=1;i<n;i++){
            wt[i]=proce[i-1].burstTime+wt[i-1];
            sum+=wt[i];

        }

        System.out.println("average waiting time is "+(sum/n));
    }



    void calculateTurnAroundTime(process [] proce,int []turn, int  [] wt,int n){
        int sum=0;
        for(int i=0;i<n;i++){
            turn[i]=proce[i].burstTime+wt[i];
            sum+=turn[i];
        }

        System.out.println("average turn around time is "+(sum/n));
    }

}

public class sjf {
    
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        System.out.println("how many process you want");
        int n=sc.nextInt();

        process [] proce=new process[n];
        int [] wait=new int[n];
        int [] turn=new int[n];

        helper h1=new helper();

        h1.getInputs(proce, n);
        h1.executeProcess(proce);
        h1.calculateWaitingTime(proce, wait, n);
        h1.calculateTurnAroundTime(proce, turn, wait, n);


    }
}
