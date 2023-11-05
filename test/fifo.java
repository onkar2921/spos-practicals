// import java.util.LinkedList;
// import java.util.Queue;
// public class fifo {

//     public static void main(String [] args){

//         int pages[]={7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
//         int frames=3;
//         Queue<Integer> q=new LinkedList<>();

//         int pageFault=0;

//         for(int page: pages){
//             if(!q.contains(page)){
//                 if(q.size()>=frames){
//                     q.poll();

//                 }
//                 q.offer(page);
//                 pageFault++;

//             }

//         }

//         System.out.println("page fault are:"+pageFault);


//     }
    
// }


import java.util.LinkedList;
import java.util.Queue;
class fifo{
    public static void main(String [] args){

        int [] pages={1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6};
        // {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        int frames=3;

        Queue <Integer> q=new LinkedList<>();

        int pageFault=0;
        for(int page :pages){

            if(!q.contains(page)){

                if(q.size()>=frames){
                    q.poll();
                }
                q.offer(page);
                pageFault++;
            }

        }


        System.out.println("page faults are"+pageFault);
    }
}