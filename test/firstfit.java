import java.util.*;
public class firstfit {


    public static void implementfirstFit(int [] mem,int [] proce,int m,int n){

        int [] allocated=new int[n];

        Arrays.fill(allocated, -1);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mem[j]>=proce[i]){
                    allocated[i]=j;
                    mem[j]-=proce[i];
                    break;
                }
            }
        }
        
        System.out.println("after process");
        for(int k=0;k<n;k++){
            System.out.println("process "+proce[k]+"-> " +allocated[k]);
        }

    }

    public static void main(String [] args){

        int blockSize[] = {100, 500, 200, 300, 600}; 
        int processSize[] = {212, 417, 112, 426}; 
        int m=blockSize.length;
        int n=processSize.length;

        implementfirstFit(blockSize,processSize,m,n);

    }
}


// import java.util.*;
// public class firstfit{

//     public static void perfomrFirstfit(int [] mem,int [] proce,int m,int n){
//         int [] allocate=new int [n];
        
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(mem[j]>=proce[i]){
//                     allocate[i]=j;
//                     mem[j]-=proce[i];
//                     break;
//                 }
//             }
//         }
//     }

//     public static void main(String [] args){
    
//         int blockSize[] = {100, 500, 200, 300, 600}; 
//         int processSize[] = {212, 417, 112, 426};
//         int m=blockSize.length;
//         int n=processSize.length;
        
        
//     }

// }