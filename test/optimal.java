// import java.util.LinkedList;
// import java.util.Queue;

// public class optimal {



//   public static  int findfartehestPage(Queue<Integer> q,int [] pages,int currentIndex){
//         int farthestPage=-1;
//         int farthestDistance=-1;

//         for(int page:q){

//             int nextIndex=currentIndex;

//             for(int i=currentIndex+1;i<pages.length;i++){
//                 if(page==pages[i]){
//                     nextIndex=i;
//                     break;
//                 }
//             }

//             if(nextIndex>farthestDistance){
//                 farthestDistance=nextIndex;
//                 farthestPage=page;
//             }
//         }
//         return farthestPage;
//     }


//     public static void main(String [] args){

//         int [] pages={1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6};
//         int frames=3;
//         Queue <Integer> q=new LinkedList<>();

//         int pageFault=0;

//         for(int i=0;i<pages.length;i++){
//             int page=pages[i];
//             if(!q.contains(page)){
//                 if(q.size()>=frames){

//                     int farthestPage=findfartehestPage(q,pages,i);
//                     q.remove(farthestPage);
//                 }
                
//                 q.offer(page);
//                 pageFault++;
//             }
//         }


//         System.out.println("page faults are "+pageFault);

//     }
    
// }





import java.util.LinkedList;
import java.util.Queue;

public class optimal{

    public static int findfartehestPage(Queue<Integer>q,int [] pages,int currentIndex){
        int farthestPage=-1;
        int farthestDistance=-1;

        for(int page:q){
            int nextIndex=currentIndex;

            for(int i=0;i<pages.length;i++){
                if(page==pages[i]){
                    nextIndex=i;
                    break;
                }
            }

            if(nextIndex>farthestDistance){
                farthestDistance=nextIndex;
                farthestPage=page;
            
            }
        }

        return farthestPage;


    }

    public static void main(String [] args){

        int[] pages = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        int capacity = 3; // Number of page frames
        Queue<Integer>q=new LinkedList<>();

        int pageFault=0;

        for(int i=0;i<pages.length;i++){
            if(!q.contains(pages[i])){
                if(q.size()>=capacity){
                    int farthestPage=findfartehestPage(q, pages, i);
                    q.remove(farthestPage);
                }
                q.offer(pages[i]);
                pageFault++;
            }
        }
        System.out.println("Total Page Faults using Optimal: " + pageFault);

    }
}