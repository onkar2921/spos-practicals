// import java.util.LinkedHashSet;
// import java.util.Set;

// public class lru {
    
//     public static void main(String [] args){
//         int [] pages={7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
//         int frames=3;
//         Set<Integer> s=new LinkedHashSet<>();

//         int pageFault=0;

//         for(int page:pages){
//             if(!s.contains(page)){
//                 if(s.size()>=frames){
//                     int firstPage=s.iterator().next();
//                     s.remove(firstPage);
//                 }
//                 s.add(page);
//                 pageFault++;
//             }else{
//                 s.remove(page);
//                 s.add(page);
//             }
//         }
//         System.out.println("Total Page Faults using LRU: " + pageFault);

//     }
// }


import java.util.*;
public class lru{
    public static void main(String [] args){
         int [] pages={7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
        int frames=3;
        int pageFault=0;
        Set<Integer>s=new LinkedHashSet<>();

        for(int page:pages){

            if(!s.contains(page)){

                if(s.size()>=frames){
                    int firstPage=s.iterator().next();
                    s.remove(firstPage);  
                }
                 s.add(page);
                    pageFault++;

            }else{
                s.remove(page);
                s.add(page);
            }
        }

        System.out.println("page faults are "+pageFault);
    }
}