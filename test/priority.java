import java.util.*;



class process{
    String name;
    int priority;
    int bursttime;


    process(String name,int prio,int brst){
        this.name=name;
        this.priority=prio;
        this.bursttime=brst;
    }

    int getPriority(){
        return this.priority;
    }


}



class helper{

    Scanner sc=new Scanner(System.in);
    void getInputs(int n,process [] proce){

        for(int i=0;i<n;i++){
            String name=sc.next();
            int prio=sc.nextInt();
            int brst=sc.nextInt();
            proce[i]=new process(name, prio, brst);
        }

    }

    void sortProcessByPriority(process[] proce){
        Arrays.sort(proce,(a,b)->a.getPriority() - b.getPriority());
    }


    void calculateWaitingTime(process [] proce,int []wt,int n){
        wt[0]=0;
        int sum=0;
        for(int i=1;i<n;i++){
            wt[i]=proce[i-1].bursttime+wt[i-1];
            sum+=wt[i];
        }

        System.out.println("average waiting time is: "+sum/n);
    }


    void calculateTurnAroundTime(process[] proce,int []turn,int[] wt,int n){
        int sum=0;
        for(int i=0;i<n;i++){
            turn[i]=proce[i].bursttime+wt[i];
            sum+=turn[i];
        }
        System.out.println("average turn around time is "+sum/n);
    }

}

public class priority {
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

          System.out.println("enter how many process do you want:");
        
        int n=sc.nextInt();

        process [] proce=new process[n];

        int[]  waitingTime=new int [n];
        int[] turnaroundTime=new int[n];



        helper h1=new helper();

        h1.getInputs(n,proce);
        h1.sortProcessByPriority(proce);
        h1.calculateWaitingTime(proce, waitingTime, n);
        h1.calculateTurnAroundTime(proce, turnaroundTime, waitingTime, n);


    }
}
