package Heap;

import java.util.*;

public class TaskScheduler {
    //TC: :O(N log K) SC: O(K)
    public static int leastInterval(char[] tasks, int n) {
        //count freq of each tasks
        Map<Character, Integer> freq = new HashMap<>();
        for(char task: tasks){
            freq.put(task, freq.getOrDefault(task, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //max heap
        for(int count: freq.values()){
            pq.add(count);
        }
        
        // Total time required
        int time=0;

        //process tasks in cycles of size(n+1)
        while(!pq.isEmpty()){
            // Temporary list to store tasks of current cycle
            List<Integer> temp = new ArrayList<>();

            // Set cycle size as cooldown + 1
            int cycle = n+1;

            int i=0; //track number of tasks processed in current cycle

            // Run up to (n+1) tasks or until heap is empty
            while(i<cycle && !pq.isEmpty()){
                int count= pq.poll();

                //decrease freq since task is used once
                count--;
                
                // If task still remains, store it for next cycle
                if(count>0) temp.add(count);

                //count 1 unit time for this task
                time++;
                i++;
            }

            //push remaining tasks from temp back into the heap
            for(int rem: temp){
                pq.add(rem);
            }

            //if heap is not empty, add idle time[cycle-i]
            if(!pq.isEmpty()) time+=(cycle-i);
        }
        return time;
    }
    
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    
}
